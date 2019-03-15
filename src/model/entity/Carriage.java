package model.entity;

public class Carriage extends Wagon{
    private final CarriageType carriageType;

    public Carriage(RailwayVehicle.TrackSize trackSize, CarriageType carriageType) {
        super(Function.Passenger, trackSize);
        this.carriageType = carriageType;
    }

    public CarriageType getType() {
        return carriageType;
    }


    @Override
    public String toString() {
        return "\n Carriage{" +
                 carriageType +
                '}';
    }
}
