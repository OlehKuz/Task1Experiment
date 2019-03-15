package model.service;

import model.entity.*;
import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.RailwayVehicle.Function.*;
import static model.service.VehicleDB.*;

import java.util.*;
import java.util.stream.Collectors;


public class TrainService <T extends RailwayVehicle, W extends RailwayVehicle>{
    private T t;
    private W w;

        public Wagon[] getTrainBuildingScheme(VehicleDB type){
            return type.getTrainScheme();
        }

        private boolean possibleToConstructTrain(List <Wagon> trainConstructionScheme) {
            Set<Wagon> trainParts = new HashSet<>(trainConstructionScheme);
            //List <Wagon> parts = new ArrayList(trainConstructionScheme.size());

            Arrays.asList(VehicleDB.values()).forEach(vehicleType->{
                if(trainParts.contains(vehicleType.getWagon())){
                    //parts.set(trainConstructionScheme.indexOf(vehicleType.getWagon()),vehicleType.getWagon()) ;
                    trainParts.remove(vehicleType.getWagon());
                }
            });
            return trainParts.isEmpty();
        }

    public Train constructTrain(VehicleDB trainConstructionScheme) throws NotEnoughDetailsException{
            List <Wagon> list = new ArrayList<>(Arrays.asList(trainConstructionScheme.getTrainScheme()));
        if(possibleToConstructTrain(list)){
            try{
                return new Train<>(EURO_TRACK, Passenger,new Locomotive(Passenger,EURO_TRACK, Locomotive.Engine.Diesel, 20000, 170 ), list);
            }catch (NotSameTrainFunctionException | WrongTrackSizeException e){
                e.printStackTrace();
            }
        }
        throw new NotEnoughDetailsException("We dont have necessary vehicles to build this train " + trainConstructionScheme.name());

    }

    public int getNumberPassengers(Train<Carriage> carriageTrain){
        return  carriageTrain.getWagons()
                .stream()
                .mapToInt(carriage ->(carriage.getType().getPassengerCapacity()))
                .sum();

    }

    public int getNumberLuggage(Train<Carriage> carriageTrain){
        return carriageTrain.getWagons()
                .stream()
                .mapToInt(carriage ->(carriage.getType().getLuggageCapacity()))
                .sum();
    }

    public void filterByNumberPassengers(Train<Carriage> carriageTrain, int number){
        List<Carriage> filtered = carriageTrain.getWagons()
                .stream()
                .filter(carriage -> (carriage.getType().getPassengerCapacity()>=number))
                .collect(Collectors.toList());
        try{
            carriageTrain.setWagons(filtered);
        }catch (NotSameTrainFunctionException | WrongTrackSizeException e){
            e.printStackTrace();
        }
    }

    public void sortWagonsByComfort(Train<Carriage> carriageTrain){
        List<Carriage> comfort = carriageTrain.getWagons()
                .stream()
                .sorted(Comparator.comparing(carriage -> carriage.getType()))
                .collect(Collectors.toList());
        try{
            carriageTrain.setWagons(comfort);
        }catch (NotSameTrainFunctionException | WrongTrackSizeException e){
            e.printStackTrace();
        }
    }



    private boolean isCompatibleTrack(RailwayVehicle vehicle1,RailwayVehicle vehicle2) {
        return vehicle1.getTrackSize() == vehicle2.getTrackSize();
    }

    private boolean isCompatibleFunction(RailwayVehicle vehicle1,RailwayVehicle vehicle2) {
        return vehicle1.getFunction()== vehicle2.getFunction();
    }

    public void checkListCompitability(T vehicle1, List<W> listVehicles) throws
            NotSameTrainFunctionException, WrongTrackSizeException{
        for(W vehicle:listVehicles) {
            checkCompatibility(vehicle1, vehicle);
        }

    }

    public void checkCompatibility(RailwayVehicle vehicle1, RailwayVehicle vehicle2) throws
            NotSameTrainFunctionException, WrongTrackSizeException {
        if(!isCompatibleFunction(vehicle1,vehicle2)){
            throw new NotSameTrainFunctionException(vehicle1.getClass() + " function "+
                    vehicle1.getFunction()+" differ from this vehicle : " +
                    vehicle2.getClass()+ " " + vehicle2.getFunction());
        }
        if(!isCompatibleTrack(vehicle1,vehicle2)){
            throw new WrongTrackSizeException(vehicle1.getClass() + " track dimensions "+
                    vehicle1.getTrackSize()+" differ from this vehicle : " +
                    vehicle2.getClass()+ " track dimensions "+ vehicle2.getTrackSize());
        }
    }

}
