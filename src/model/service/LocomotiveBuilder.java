package model.service;

import model.entity.Locomotive;
import model.entity.RailwayVehicle;

public class LocomotiveBuilder {
    private TrackSize trackSize = TrackSize.EASTERN_TRACK;
    private RailwayVehicle.Function function = RailwayVehicle.Function.Passenger;
    private Locomotive.Engine engine = Locomotive.Engine.Diesel;
    private int pullPower = 10000;
    private int maxSpeed = 80;

    public LocomotiveBuilder buildTrackSize(TrackSize trackSize){
        this.trackSize = trackSize;
        return this;
    }

    public LocomotiveBuilder buildVehicleFunction(RailwayVehicle.Function function){
        this.function = function;
        return this;
    }

    public LocomotiveBuilder buildLocomotiveEngine(Locomotive.Engine engine){
        this.engine = engine;
        return this;
    }

    public LocomotiveBuilder buildPullPower(int pullPower){
        this.pullPower = pullPower;
        return this;
    }

    public LocomotiveBuilder buildMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Locomotive getBuiltLocomotive(){
        return new Locomotive(function,trackSize,engine,
                pullPower,maxSpeed);
    }
}
