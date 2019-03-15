package controller;

import model.entity.*;
import model.service.TrainService;


public class Controller {
    public void run (){
        TrainService trainService =new TrainService();
        Train train = trainService.buildPassengerTrain();

    }
}
