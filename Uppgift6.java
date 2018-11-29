package Labb1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Uppgift6 extends Application {
    int kvarvarande = 0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox layout = new VBox();
        layout.setPadding(new Insets(5));
        layout.setSpacing(20);
        layout.setAlignment(Pos.BASELINE_LEFT);

        HBox hb1 = new HBox();
        hb1.setSpacing(5);
        hb1.setAlignment(Pos.BASELINE_LEFT);

        Text text = new Text();
        text.setText("Ange tid: ");
        text.setFont(new Font("Times New Roman", 14));

        TextField antalTimmar = new TextField();
        Text h = new Text();
        h.setText("h");
        h.setFont(new Font("Times New Roman", 14));

        TextField antalMinuter = new TextField();
        Text m = new Text();
        m.setText("m");
        m.setFont(new Font("Times New Roman", 14));

        TextField antalSekunder = new TextField();
        Text s = new Text();
        s.setText("s");
        s.setFont(new Font("Times New Roman", 14));

        Button berakna = new Button("Beräkna");

        berakna.setOnAction(event -> {
            if (antalTimmar.getText().equals("") || antalMinuter.getText().equals("") || antalSekunder.getText().equals("")){
                Alert fel = new Alert(Alert.AlertType.ERROR);
                fel.setTitle("Meddelande");
                fel.setHeaderText("Felmeddelande");
                fel.setContentText("Du fyllde inte i alla rutor.");
                fel.showAndWait();
            }else {
                int timmar = Integer.parseInt(antalTimmar.getText());
                kvarvarande += 3600 * timmar;
                int minuter = Integer.parseInt(antalMinuter.getText());
                kvarvarande += 60 * minuter;
                int sekunder = Integer.parseInt(antalSekunder.getText());
                kvarvarande += sekunder;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ditt svar");
                alert.setHeaderText("Beräknat värde");
                alert.setContentText(kvarvarande + " sekunder");
                alert.showAndWait();
            }});

        hb1.getChildren().addAll(text, antalTimmar, h, antalMinuter, m, antalSekunder, s);

        layout.getChildren().addAll(hb1, berakna);
        Scene scene = new Scene(layout, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Beräkna tid");
        primaryStage.show();
    }
}
