package model.entity;

public class FreightWagon extends Wagon {
    public enum FreightType {Coal, Metal}
    private final FreightType freightType;
    private int volumeCapacity;
    public FreightWagon(TrackSize trackSize, FreightType freightType, int volumeCapacity){
        super(Function.Freight, trackSize);
        this.freightType = freightType;
        this.volumeCapacity = volumeCapacity;
    }

    public FreightType getType() {
        return freightType;
    }

    public int getVolumeCapacity() {
        return volumeCapacity;
    }

    public void setVolumeCapacity(int volumeCapacity) {
        this.volumeCapacity = volumeCapacity;
    }

    @Override
    public String toString() {
        return "FreightWagon{" +
                "freight type = '" + freightType +
                "', volume capacity m3 = '" + getVolumeCapacity()+
                "', "+ super.toString() + "}";
    }

}
