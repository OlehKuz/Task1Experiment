package model.service;


import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.RailwayVehicle.Function.*;
import model.entity.Locomotive;
import model.entity.RailwayVehicle;
import model.entity.Train;
import model.entity.Wagon;

import java.util.Objects;


import java.util.List;


public abstract class TrainBuilder {
    private RailwayVehicle.TrackSize trackSize = EURO_TRACK;
    private Train train;
    public void makeTrain(RailwayVehicle.Function function){
        train = new Train(trackSize, function);
    }

    public TrainBuilder buildTrackSize(RailwayVehicle.TrackSize trackSize){
        train.setTrackSize(trackSize);
        return this;
    }

    public TrainBuilder buildWagons(List<Wagon> wagons){
        Objects.requireNonNull(wagons);
        TrainService<Train, Wagon> trainService = new TrainService<Train,Wagon>();
        try{
            trainService.checkListCompitability(train, wagons);
            train.setWagons(wagons);
        }catch (NotSameTrainFunctionException | WrongTrackSizeException e){
            e.printStackTrace();
        }
        return this;
    }

    public TrainBuilder buildLocomotive(Locomotive locomotive){
        Objects.requireNonNull(locomotive);
        TrainService<Train, Locomotive> trainService = new TrainService<Train,Locomotive>();
        try{
            trainService.checkCompatibility(train, locomotive);
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