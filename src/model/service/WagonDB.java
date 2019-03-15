package model.service;

import model.entity.Carriage;
import model.entity.FreightWagon;
import model.entity.Wagon;

import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.CarriageType.*;
public enum WagonDB {
    FREIGHT_WAGON(new FreightWagon(EURO_TRACK, FreightWagon.FreightType.Coal,80)),
    CARRIAGE_SEATING2(new Carriage(EURO_TRACK, Seating2Class)),
    CARRIAGE_SEATING1(new Carriage(EASTERN_TRACK, Seating1Class)),
    CARRIAGE_BERTH(new Carriage(EURO_TRACK, Berth)),
    CARRIAGE_COMPARTMENT(new Carriage(EASTERN_TRACK, Compartment)),
    CARRIAGE_LUX(new Carriage(EURO_TRACK, DeLuxe));

    private Wagon carriage;

    WagonDB(Wagon carriage) {
        this.carriage = carriage;
    }

    public Wagon get() {
        return carriage;
    }
}