package model.entity;

import java.util.List;

public class PassengerTrain extends Train<Carriage>{
    public PassengerTrain(TrackSize trackSize, Function function,
                          Locomotive locomotive, List<Carriage> wagons)
            throws NotSameTrainFunctionException, WrongTrackSizeException {
        super(trackSize, function, locomotive, wagons);
    }
}
