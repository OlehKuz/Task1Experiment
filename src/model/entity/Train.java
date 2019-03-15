package model.entity;
import model.service.NotSameTrainFunctionException;
import model.service.TrainService;
import model.service.WrongTrackSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Train<W extends Wagon> extends RailwayVehicle{
    private List<W> wagons = new ArrayList<>();
    private Locomotive locomotive;

    public Train (TrackSize trackSize, Function function,
    Locomotive locomotive, List<W> wagons)throws NotSameTrainFunctionException,
            WrongTrackSizeException {
        super(function, trackSize);
        this.setLocomotive(locomotive);
        this.setWagons(wagons);
    }

    public void setWagons(List<W> wagons) throws
            NotSameTrainFunctionException, WrongTrackSizeException{
        Objects.requireNonNull(wagons);
        TrainService<Train, W> trainService = new TrainService<Train,W>();
        trainService.checkListCompitability(this, wagons);
        this.wagons = wagons;
    }

    public List<W> getWagons() {
        Objects.requireNonNull(wagons);
        return wagons;
    }

    public Locomotive getLocomotive() {
        Objects.requireNonNull(locomotive);
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) throws
            NotSameTrainFunctionException, WrongTrackSizeException{
        Objects.requireNonNull(locomotive);
        TrainService<Train, Locomotive> trainService = new TrainService<Train,Locomotive>();
        trainService.checkCompatibility(this, locomotive);
        this.locomotive = locomotive;
    }

    @Override
    public String toString() {
        return "Train{" +
                "\n wagons=" + wagons +
                ",\n locomotive=" + locomotive +
                '}';
    }
}
