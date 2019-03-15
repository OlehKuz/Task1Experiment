package model.service;

import model.entity.*;
import java.util.List;

public abstract class TrainBuilder {
    private TrackSize trackSize = TrackSize.EASTERN_TRACK;
    Train train;
    public void makeTrain(RailwayVehicle.Function function){
        train = new Train(trackSize, function);
    }

    public TrainBuilder buildTrackSize(TrackSize trackSize){
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
    public TrainBuilder buildWagons(Wagon wagon){
        try{
            train.addWagon(wagon);
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
