package model.service;

import static model.entity.RailwayVehicle.Function.*;

public class PassengerTrainBuilder extends TrainBuilder{
    public PassengerTrainBuilder (){
        super();
        makeTrain(Passenger);
    }

}