package model.service;
import model.entity.*;

import model.entity.RailwayVehicle;

public class FreightTrainBuilder extends TrainBuilder{
    public FreightTrainBuilder (){
        super();
        makeTrain(RailwayVehicle.Function.Freight);
    }
}
