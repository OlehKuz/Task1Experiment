//package controller;
//import model.entity.*;
//
//import java.util.ArrayList;
//
//public class MakeTrain {
//    public void runTrain (){
//        Train train = new Train(200, RailwayVehicle.Function.Freight);
//        RailwayVehicle locomotive = new Locomotive(300, RailwayVehicle.Function.Freight,
//                Locomotive.Engine.Diesel, 1000, 100);
//        RailwayVehicle wagon = new FreightWagon(210, FreightWagon.FreightType.Cars);
//        ArrayList<Wagon> wag = new ArrayList<>();
//
//
//        try{
//            train.setWagons(wag);
//
//        }catch (NotSameTrainFunctionException | WrongTrackSizeException e){
//            e.printStackTrace();
//        }
//    }
//}
