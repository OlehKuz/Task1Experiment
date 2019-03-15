package model.entity;

public class Locomotive extends RailwayVehicle{

    public enum Engine {Electric,Diesel }
    private final Engine engine;
    private int pullPower;
    private int maxSpeed;

    public Locomotive(RailwayVehicle.Function function,TrackSize trackSize, Engine engine,
                      int pullPower, int maxSpeed){
        super(function, trackSize);
        this.maxSpeed = maxSpeed;
        this.pullPower = pullPower;
        this.engine = engine;

    }


    public Engine getEngine() {
        return engine;
    }

    public int getPullPower(){
        return pullPower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setPullPower(int pullPower) {
        this.pullPower = pullPower;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "\nLocomotive{" +
                "engine = '" + engine +
                "', pull power = '" + pullPower +
                "', max speed = '" + maxSpeed +
                "', "+ super.toString() +"}";
    }
}
