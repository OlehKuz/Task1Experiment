package model.service;

import model.entity.Carriage;

import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.CarriageType.*;
public enum CarriagesDB {
    CARRIAGE_SEATING2(new Carriage(EURO_TRACK, Seating2Class)),
    CARRIAGE_SEATING1(new Carriage(EURO_TRACK, Seating1Class)),
    CARRIAGE_BERTH(new Carriage(EURO_TRACK, Berth)),
    CARRIAGE_COMPARTMENT(new Carriage(EASTERN_TRACK, Compartment)),
    CARRIAGE_LUX(new Carriage(EURO_TRACK, DeLuxe));

    private Carriage carriage;

    CarriagesDB(Carriage carriage) {
        this.carriage = carriage;
    }

    public Carriage get() {
        return carriage;
    }
}