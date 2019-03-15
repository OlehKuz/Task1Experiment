package model.service;

import model.entity.*;
import java.util.List;
import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.RailwayVehicle.Function.*;

public abstract class TrainBuilder {
    private RailwayVehicle.TrackSize trackSize = EASTERN_TRACK;
    Train train;
    public void makeTrain(RailwayVehicle.Function function){
        train = new Train(trackSize, function);
    }

    public TrainBuilder buildTrackSize(RailwayVehicle.TrackSize trackSize){
        train.setTrackSize(trackSize);
        return this;
    }

    public TrainBuilder buildWagons(List<Wagon> wagons){
        try{
            train.setWagons(wagons);
        }catch (NotSameTrainFunctionException | WrongTrackSizeException e){
           e.printStackTrace();
        }
        return this;
    }

    public TrainBuilder buildLocomotive(Locomotive locomotive){
        try{
            train.setLocomotive(locomotive);
        }catch (NotSameTrainFunctionException | WrongTrackSizeException e){
            e.printStackTrace();
        }
        return this;
    }

    public Train getBuiltTrain(){
        return train;
    }

}
