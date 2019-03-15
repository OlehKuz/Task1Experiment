package model.service;

import model.entity.Locomotive;

import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.RailwayVehicle.Function.*;


public enum LocomotiveDB {
    PASSENGER_LOCOMOTIVE(new Locomotive(Passenger,EURO_TRACK, Locomotive.Engine.Diesel,20000, 150)),
    FREIGHT_LOCOMOTIVE(new Locomotive(Freight,EURO_TRACK, Locomotive.Engine.Electric,20000, 120));

    private Locomotive locomotive;
    LocomotiveDB(Locomotive locomotive){
        this.locomotive = locomotive;
    }
    public Locomotive get(){
        return locomotive;
    }
}
