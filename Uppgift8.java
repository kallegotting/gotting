package Labb1GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Uppgift8 extends Application {
    ArrayList<Image> tomteSpring = new ArrayList<>(567);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();


        Image bakgrund = new Image("file:images/BG.png");
        ImageView theBakgrund = new ImageView(bakgrund);

        Image igloo = new Image("file:images/Igloo.png");
        ImageView theIgloo = new ImageView(igloo);
        theIgloo.setFitHeight(100);
        theIgloo.setFitWidth(175);
        theIgloo.setX(1620);
        theIgloo.setY(650);

        Image skylt = new Image("file:images/Sign_2.png");
        ImageView theSkylt = new ImageView(skylt);
        theSkylt.setY(660);

        Image vanster = new Image("file:images/1.png");
        ImageView theVanster = new ImageView(vanster);
        theVanster.setFitWidth(625);
        theVanster.setFitHeight(150);
        theVanster.setX(0);
        theVanster.setY(749);


        Image mitten = new Image("file:images/2.png");
        ImageView theMitten = new ImageView(mitten);
        theMitten.setFitWidth(600);
        theMitten.setFitHeight(150);
        theMitten.setX(625);
        theMitten.setY(749);

        Image hoger = new Image("file:images/3.png");
        ImageView theHoger = new ImageView(hoger);
        theHoger.setFitWidth(600);
        theHoger.setFitHeight(150);
        theHoger.setX(1225);
        theHoger.setY(749);



        tomteSpring.add(new Image("file:images/Run(1).png"));
        tomteSpring.add(new Image("file:images/Run(2).png"));
        tomteSpring.add(new Image("file:images/Run(3).png"));
        tomteSpring.add(new Image("file:images/Run(4).png"));
        tomteSpring.add(new Image("file:images/Run(5).png"));
        tomteSpring.add(new Image("file:images/Run(6).png"));
        tomteSpring.add(new Image("file:images/Run(7).png"));
        tomteSpring.add(new Image("file:images/Run(8).png"));
        tomteSpring.add(new Image("file:images/Run(9).png"));
        tomteSpring.add(new Image("file:images/Run(10).png"));
        tomteSpring.add(new Image("file:images/Run(11).png"));





        root.getChildren().addAll(theBakgrund, theIgloo, theSkylt, theVanster, theMitten, theHoger);

        Scene scene = new Scene(root,1800, 893);
        primaryStage.setTitle("Tomten");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

//root.setBackground(new Background(new BackgroundImage(new Image("file:images/BG.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
//                BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
//        root.setAlignment(Pos.TOP_LEFT);