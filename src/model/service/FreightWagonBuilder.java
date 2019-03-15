package model.service;

import model.entity.FreightWagon;

public class FreightWagonBuilder{
    private TrackSize trackSize = TrackSize.EASTERN_TRACK;
    private FreightWagon.FreightType freightType = FreightWagon.FreightType.Coal;
    private int volumeCapacity = 80;

    public FreightWagonBuilder buildTrackSize(TrackSize trackSize){
        this.trackSize = trackSize;
        return this;
    }

    public FreightWagonBuilder buildFreightType(FreightWagon.FreightType freightType){
        this.freightType = freightType;
        return this;
    }

    public FreightWagon getBuiltWagon(){
        FreightWagon wagon = new FreightWagon(trackSize,freightType, volumeCapacity);
        wagon.setTrackSize(trackSize);
        //wagon.setCapacity(volumeCapacity);
        return wagon;
    }
}
