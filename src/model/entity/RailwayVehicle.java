package model.entity;

public abstract class RailwayVehicle {
    public enum Function{Freight, Passenger, Service}
    public enum TrackSize{EURO_TRACK, EASTERN_TRACK};
    private final Function function;
    private TrackSize trackSize;

    RailwayVehicle(Function function, TrackSize trackSize) {
        this.function = function;
        this.trackSize = trackSize;
    }

    public void move(){
        System.out.println("I move on a railway ... CHuch, chuch");
    }

    public TrackSize getTrackSize() {
        return trackSize;
    }

    public void setTrackSize(TrackSize trackSize) {
        this.trackSize = trackSize;
    }

    public Function getFunction() {
        return function;
    }


    public String toString() {
        return "RailwayVehicle {"+
                "track size = '" + trackSize  +
                "', function = '" + function +"'}";
    }
}
