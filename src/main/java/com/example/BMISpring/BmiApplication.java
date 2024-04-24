package com.example.BMISpring;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

public class BmiApplication extends Application {

   private ConfigurableApplicationContext applicationContext;

   public void init() throws Exception{
      applicationContext=new SpringApplicationBuilder(BmiSpringApplication.class).run();
   }

   public void start(Stage stage) throws Exception{
      applicationContext.publishEvent(new StageReadyEvent(stage));
    stage.setTitle("BMI Application");
      stage.setHeight(500);
      stage.setWidth(400);
      Label label1 = new Label("Body Mass Index");
      label1.setPadding(new Insets(15));

      label1.setFont(new Font("Arial", 25));
      TextFlow flow1 = new TextFlow();
      Text text1 = new Text("Body Mass Index(BMI)");
      text1.setStyle("-fx-font-weight:bold");
      text1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      Text text2 = new Text(" is a measure of ");
      text2.setStyle("-fx-font-weight:regular");
      text2.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR,14));

      flow1.getChildren().addAll(text1, text2);
      flow1.setTextAlignment(TextAlignment.CENTER);

      Label label2 = new Label(WORDS1);
      label2.setFont(new Font("Arial",14));

      Text textOne=new Text();
      textOne.setText("Underweight");
      textOne.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      Text textTwo=new Text();
      textTwo.setText("Less than 18");
      textTwo.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      Text textThree=new Text();
      textThree.setText("Normal");
      textThree.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      Text textFour=new Text();
      textFour.setText("18-25");
      textFour.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      Text textFive=new Text();
      textFive.setText("Overweight");
      textFive.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      Text textSix=new Text();
      textSix.setText("25-30");
      textSix.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      Text textSeven=new Text();
      textSeven.setText("Obese");
      textSeven.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      Text textEight=new Text();
      textEight.setText("More than 30");
      textEight.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));


      GridPane gridPane=new GridPane();
      gridPane.setHgap(75);
      gridPane.setAlignment(Pos.CENTER);
      gridPane.add(textOne,0,0);
      gridPane.add(textTwo,1,0);
      gridPane.add(textThree,0,1);
      gridPane.add(textFour,1,1);
      gridPane.add(textFive,0,2);
      gridPane.add(textSix,1,2);
      gridPane.add(textSeven,0,3);
      gridPane.add(textEight,1,3);


      Label label3=new Label(WORDS2);
      label3.setFont(new Font("Arial",14));

      Text textNine=new Text();
      textNine.setText("Height");
      textNine.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      TextField heightField=new TextField();

      Text textTen=new Text();
      textTen.setText("Weight");
      textTen.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR,14));

      TextField weightField=new TextField();

      Button calculateButton=new Button("Calculate");
      calculateButton.setStyle("-fx-background-color:LightBlue");



      ComboBox<String> comboBox1=new ComboBox();
      comboBox1.getItems().add("cm");
      comboBox1.getItems().add("inch");
      comboBox1.setValue("cm");

      ComboBox<String> comboBox2=new ComboBox();
      comboBox2.getItems().add("kg");
      comboBox2.getItems().add("g");
      comboBox2.setValue("kg");

      GridPane gridPane1=new GridPane();
      gridPane1.setVgap(10);

      gridPane1.setAlignment(Pos.BOTTOM_CENTER);

      gridPane1.add(textNine,0,0);
      gridPane1.add(heightField,0,1);
      gridPane1.add(comboBox1,1,1);
      gridPane1.add(textTen,0,2);
      gridPane1.add(weightField,0,3);
      gridPane1.add(comboBox2,1,3);
      gridPane1.add(calculateButton,0,4);



      Label label=new Label();
      label.setFont(new Font("Arial", 12));

      Label label_Caption=new Label();
      label_Caption.setFont(new Font("Arial",24));

      VBox vBox = new VBox();

      vBox.getChildren().addAll(label1, flow1,label2,gridPane,label3,gridPane1,label);
      vBox.setAlignment(Pos.CENTER);

      vBox.setSpacing(5);
      vBox.setStyle("-fx-padding:10;"+"-fx-border-style:solid inside;"+"-fx-border-width:2;"+"-fx-border-insets:5;"+"-fx-background-color:white;");

      Scene scene = new Scene(vBox, 300, 300);
      stage.setScene(scene);
      stage.show();



      

   }
   private static final String WORDS1 =
           "the amount of fat in a human body . It is a \n" +
                   "single numeric value with the following\n" +
                   "interpretation:\n" ;


   private static final String WORDS2=
           "Use the calculator below to calculate your \n"+
                   "BMI."+"\n\n";


   public void stop() throws  Exception{
      applicationContext.close();
      Platform.exit();
   }

static class StageReadyEvent extends ApplicationEvent {
      public StageReadyEvent(Stage stage) {
         super(stage);
      }

      public Stage getStage() {
         return (Stage)getSource();
      }
   }




}
