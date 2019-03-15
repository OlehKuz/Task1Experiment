//package model.service;
//
//import model.entity.RailwayVehicle;
//import  static model.service.DBVehicleTypes.*;
//
//
//public enum TrainBuilderScheme {
//    PASSENGER_SLEEPING_TRAIN(PASSENGER_LOCOMOTIVE.get(),CARRIAGE_LUX.get(), CARRIAGE_COMPARTMENT.get(),CARRIAGE_BERTH.get()),
//    PASSENGER_FAST_TRAIN(PASSENGER_LOCOMOTIVE.get(), CARRIAGE_SEATING1.get(),CARRIAGE_SEATING2.get()),
//    FREIGHT_TRAIN(PASSENGER_LOCOMOTIVE.get(),FREIGHT_WAGON.get());
//
//
//    private RailwayVehicle[] trainScheme;
//
//    TrainBuilderScheme(RailwayVehicle...vehicles){
//        this.trainScheme = vehicles;
//    }
//
//    public RailwayVehicle[] getTrainBuilderScheme(){
//        return trainScheme;
//    }
//}
