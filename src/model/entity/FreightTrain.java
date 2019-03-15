package model.entity;

import java.util.List;

public class FreightTrain extends Train<FreightWagon>{
    public FreightTrain(RailwayVehicle.TrackSize trackSize, RailwayVehicle.Function function,
                          Locomotive locomotive, List<FreightWagon> wagons)
            throws NotSameTrainFunctionException, WrongTrackSizeException {
        super(trackSize, function, locomotive, wagons);
    }
}
