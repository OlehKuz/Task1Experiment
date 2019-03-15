package model.service;

import model.entity.*;

import static model.entity.RailwayVehicle.Function.Freight;
import static model.entity.RailwayVehicle.Function.Passenger;
import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.CarriageType.*;
import static model.service.LocomotiveDB.*;

public enum VehicleDB {
    FREIGHT_WAGON(new FreightWagon(EURO_TRACK, FreightWagon.FreightType.Coal,80)),
    CARRIAGE_SEATING2(new Carriage(EURO_TRACK, Seating2Class)),
    CARRIAGE_SEATING1(new Carriage(EASTERN_TRACK, Seating1Class)),
    CARRIAGE_BERTH(new Carriage(EURO_TRACK, Berth)),
    CARRIAGE_COMPARTMENT(new Carriage(EASTERN_TRACK, Compartment)),
    CARRIAGE_LUX(new Carriage(EURO_TRACK, DeLuxe)),


    //PASSENGER_LOCOMOTIVE(new Locomotive(Passenger,EURO_TRACK, Locomotive.Engine.Diesel,20000, 150)),
    //FREIGHT_LOCOMOTIVE(new Locomotive(Freight,EURO_TRACK, Locomotive.Engine.Electric,20000, 120)),

    PASSENGER_TRAIN(CARRIAGE_LUX.getWagon(),CARRIAGE_COMPARTMENT.getWagon(),
            CARRIAGE_BERTH.getWagon(), CARRIAGE_SEATING2.getWagon(), CARRIAGE_SEATING1.getWagon());


    private Wagon wagon;
    //private Locomotive locomotive;
    private Wagon[] trainScheme;

    VehicleDB(Wagon wagon){
        this.wagon = wagon;
    }
    VehicleDB(Wagon ... vehicles){
        this.trainScheme = vehicles;
    }

    public Wagon getWagon() {
        return wagon;
    }

    public Wagon[] getTrainScheme() {
        return trainScheme;
    }


}