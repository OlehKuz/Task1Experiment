package model.service;

import model.entity.*;

import java.util.Arrays;
import java.util.List;

import static model.entity.RailwayVehicle.Function.Freight;
import static model.entity.RailwayVehicle.Function.Passenger;
import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.CarriageType.*;
public enum WagonDB {
    FREIGHT_WAGON(new FreightWagon(EURO_TRACK, FreightWagon.FreightType.Coal,80)),
    CARRIAGE_SEATING2(new Carriage(EURO_TRACK, Seating2Class)),
    CARRIAGE_SEATING1(new Carriage(EASTERN_TRACK, Seating1Class)),
    CARRIAGE_BERTH(new Carriage(EURO_TRACK, Berth)),
    CARRIAGE_COMPARTMENT(new Carriage(EASTERN_TRACK, Compartment)),
    CARRIAGE_LUX(new Carriage(EURO_TRACK, DeLuxe)),


    PASSENGER_LOCOMOTIVE(new Locomotive(Passenger,EURO_TRACK, Locomotive.Engine.Diesel,20000, 150)),
    FREIGHT_LOCOMOTIVE(new Locomotive(Freight,EURO_TRACK, Locomotive.Engine.Electric,20000, 120));

    PASSENGER_TRAIN(PASSENGER_LOCOMOTIVE,);


    private Wagon carriage;
    private Locomotive locomotive;
    private RailwayVehicle[] trainScheme;

    WagonDB(Wagon carriage) {
        this.carriage = carriage;
    }

    WagonDB(Locomotive locomotive){
        this.locomotive = locomotive;
    }
    WagonDB(RailwayVehicle ... vehicles){
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