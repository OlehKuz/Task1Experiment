package model.service;

public class CarriageWagonBuilder{
    private TrackSize trackSize = TrackSize.EASTERN_TRACK;
    private Carriage.CarriageType carriageType = Carriage.CarriageType.Seating2Class;
    private int passengerCapacity;

    public CarriageWagonBuilder buildTrackSize(TrackSize trackSize){
        this.trackSize = trackSize;
        return this;
    }

    public CarriageWagonBuilder buildCarriageType(Carriage.CarriageType carriageType){
        this.carriageType = carriageType;
        return this;
    }

    public CarriageWagonBuilder buildPassengerCapacity(int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
        return this;
    }

    public Carriage getBuiltWagon(){
        Carriage wagon = new Carriage(trackSize,carriageType);
        //wagon.setCapacity(passengerCapacity);
        return  wagon;
    }


}
