package controller;

import model.entity.*;
import model.service.NotEnoughDetailsException;
import model.service.TrainService;
import model.service.VehicleDB;
import java.util.Optional;
import static view.TextConstant.*;
import static view.View.bundle;

import view.View;


public class Controller {
    private View view;
    public Controller(View view){
        this.view = view;
    }
    public void run (){
        TrainService trainService = new TrainService();
        Optional<Train> train = constructTrain(trainService);
        view.printMessage(bundle.getString(LETS_CONSTRUCT) + train);
        view.printMessage(bundle.getString(NUMBER_PASSENGERS) + trainService.getNumberPassengers(train.get())+
                bundle.getString(NUMBER_LUGGAGE) + trainService.getNumberLuggage(train.get()));
        sortByComfort(trainService, train.get());
        filterByPassengers(trainService, train.get());

    }

    private void sortByComfort(TrainService trainService, Train train){
        trainService.sortWagonsByComfort(train);
        view.printMessage(bundle.getString(FILTER_WAGONS_COMFORT) + train);

    }

    private void filterByPassengers(TrainService trainService, Train train){
        trainService.filterByNumberPassengers(train, 50);
        view.printMessage(bundle.getString(FILTER_WAGONS_PASSENGERS) +train);
    }

    private Optional<Train> constructTrain(TrainService trainService){
        try{
            return Optional.of(trainService.constructTrain(VehicleDB.PASSENGER_TRAIN));
        }catch (NotEnoughDetailsException e){
           e.printStackTrace();
        }
        return Optional.empty();
    }
}
