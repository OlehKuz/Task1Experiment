package model.service;
import model.entity.*;

import model.entity.RailwayVehicle;

public class FreightTrainBuilder extends TrainBuilder{
    private RailwayVehicle.Function function = RailwayVehicle.Function.Passenger;
    public FreightTrainBuilder (){
        super();
        makeTrain(function);
    }
}
