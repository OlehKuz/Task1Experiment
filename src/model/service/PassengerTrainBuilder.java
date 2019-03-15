package model.service;
import model.entity.*;

public class PassengerTrainBuilder extends TrainBuilder{
    private RailwayVehicle.Function function = RailwayVehicle.Function.Passenger;
    public PassengerTrainBuilder (){
        super();
        makeTrain(function);
    }

}
