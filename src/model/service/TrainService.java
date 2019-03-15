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

        private List<Wagon> possibleToConstructTrain(VehicleDB trainConstructionScheme) {
            Set<Wagon> trainParts = new HashSet<>(Arrays.asList(trainConstructionScheme.getTrainScheme()));
            List <Wagon> parts = new ArrayList(trainParts.size());

            Arrays.asList(VehicleDB.values()).forEach(vehicleType->{
                if(trainParts.contains(vehicleType.getWagon())){
                    parts.set(trainConstructionScheme.indexOf(vehicleType.getWagon()),vehicleType.getWagon()) ;
                }
            });
            return parts;
        }

    public Train constructTrain(VehicleDB trainConstructionScheme){
        List <Wagon> list = possibleToConstructTrain(trainConstructionScheme);
        if(list.size() == trainConstructionScheme.size()){
            try{
                return new Train<Carriage>(EURO_TRACK, Passenger,(Locomotive) list.get(0),
                        list.subList(1,trainConstructionScheme.size()));
            }catch (NotSameTrainFunctionException | WrongTrackSizeException e){
                e.printStackTrace();
            }

        }
        return null;
        //throw new NotEnoughDetailsInDB Exception;

    }
    public Train buildPassengerTrain(){
        TrainBuilder trainBuilder = new PassengerTrainBuilder();
        return trainBuilder
                .buildTrackSize(EASTERN_TRACK)
                .buildLocomotive(PASSENGER_LOCOMOTIVE.get())
                .buildWagons(Arrays.asList(CARRIAGE_COMPARTMENT.get(),CARRIAGE_SEATING1.get()))
                .getBuiltTrain();
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

}
