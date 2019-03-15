package model.service;

import model.entity.*;
import java.util.List;
import static model.entity.RailwayVehicle.TrackSize.*;

abstract class TrainBuilder{
    private RailwayVehicle.TrackSize trackSize = EURO_TRACK;

    private Train train;
    void makeTrain(RailwayVehicle.Function function){
        this.train = new Train(trackSize, function);
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
