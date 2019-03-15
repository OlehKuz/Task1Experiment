package model.service;

import model.entity.*;

import static model.entity.RailwayVehicle.Function.Freight;
import static model.entity.RailwayVehicle.Function.Passenger;
import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.CarriageType.*;

public enum VehicleDB {
    FREIGHT_WAGON(new FreightWagon(EURO_TRACK, FreightWagon.FreightType.Coal,80)),
    CARRIAGE_SEATING2(new Carriage(EURO_TRACK, Seating2Class)),
    CARRIAGE_SEATING1(new Carriage(EASTERN_TRACK, Seating1Class)),
    CARRIAGE_BERTH(new Carriage(EURO_TRACK, Berth)),
    CARRIAGE_COMPARTMENT(new Carriage(EASTERN_TRACK, Compartment)),
    CARRIAGE_LUX(new Carriage(EURO_TRACK, DeLuxe)),


    PASSENGER_LOCOMOTIVE(new Locomotive(Passenger,EURO_TRACK, Locomotive.Engine.Diesel,20000, 150)),
    FREIGHT_LOCOMOTIVE(new Locomotive(Freight,EURO_TRACK, Locomotive.Engine.Electric,20000, 120)),

    PASSENGER_TRAIN(PASSENGER_LOCOMOTIVE.getLocomotive(),CARRIAGE_LUX.getCarriage(),CARRIAGE_COMPARTMENT.getCarriage(),
            CARRIAGE_BERTH.getCarriage(), CARRIAGE_SEATING2.getCarriage(), CARRIAGE_SEATING1.getCarriage());


    private Wagon carriage;
    private Locomotive locomotive;
    private RailwayVehicle[] trainScheme;

    VehicleDB(Wagon carriage) {
        this.carriage = carriage;
    }

    VehicleDB(Locomotive locomotive){
        this.locomotive = locomotive;
    }
    VehicleDB(RailwayVehicle ... vehicles){
        this.trainScheme = vehicles;
    }

    public Wagon getCarriage() {
        return carriage;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public RailwayVehicle[] getTrainScheme() {
        return trainScheme;
    }
}