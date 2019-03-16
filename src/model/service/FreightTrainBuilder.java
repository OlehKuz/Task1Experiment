package model.service;

import static model.entity.RailwayVehicle.Function.*;

public class FreightTrainBuilder extends TrainBuilder{
    public FreightTrainBuilder (){
        super();
        makeTrain(Freight);
    }
}