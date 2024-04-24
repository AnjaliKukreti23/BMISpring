package com.example.BMISpring;

import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<BmiApplication.StageReadyEvent> {
    public void onApplicationEvent(BmiApplication.StageReadyEvent event){
        Stage stage=event.getStage();


    }
}
