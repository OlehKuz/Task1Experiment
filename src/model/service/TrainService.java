package model.service;

import model.entity.*;

import static model.entity.RailwayVehicle.Function.Passenger;
import static model.entity.RailwayVehicle.TrackSize.EASTERN_TRACK;
import static model.entity.RailwayVehicle.TrackSize.EURO_TRACK;
import static model.service.WagonDB.*;

import java.util.Arrays;
import java.util.List;


public class TrainService <T extends RailwayVehicle, W extends RailwayVehicle>{
    private T t;
    private W w;

    public Train buildPassengerTrain(){
        TrainBuilder trainBuilder = new PassengerTrainBuilder();
        return trainBuilder
                .buildTrackSize(EASTERN_TRACK)
                .buildLocomotive((Locomotive)DBVehicleTypes.PASSENGER_LOCOMOTIVE.get())
                .buildWagons(Arrays.asList(CARRIAGE_COMPARTMENT.get(),CARRIAGE_SEATING1.get()))
                .getBuiltTrain();
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
