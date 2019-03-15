package controller;
import model.entity.*;
import model.service.TrainService;

import java.util.ArrayList;

public class Controller {
    public void run (){
        TrainService trainService =new TrainService();
        Train train = trainService.buildPassengerTrain();
    }
}
