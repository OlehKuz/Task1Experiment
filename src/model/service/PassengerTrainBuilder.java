package model.service;
import model.entity.*;

public class PassengerTrainBuilder extends TrainBuilder{
    public PassengerTrainBuilder (){
        super();
        makeTrain(RailwayVehicle.Function.Passenger);
    }

}
