package model.entity;

public abstract class Wagon extends RailwayVehicle{
    Wagon(Function function, TrackSize trackSize) {
        super(function, trackSize);
    }
    public abstract <T> T getType();
}
