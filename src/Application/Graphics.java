package Application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Graphics extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tommy Converter");
        stage.setResizable(false);
        stage.setWidth(1100);
        stage.setHeight(700);
        stage.setX(100);
        stage.setY(20);

        //set Buttons
        Label chooseLB = new Label("Choose one Buttons");
        chooseLB.setTextFill(Color.web("#595556"));
        chooseLB.setStyle("-fx-font-size:20px");

        Button inf2pos = new Button("Infix To Postfix");
        inf2pos.setTextFill(Color.web("#222224"));

        Button post2inf = new Button("Postfix To Infix");
        inf2pos.setTextFill(Color.web("#222224"));


        Button inf2pre = new Button("Infix To Prefix");
        inf2pos.setTextFill(Color.web("#222224"));

        Button pre2inf = new Button("Prefix To Infix");
        inf2pos.setTextFill(Color.web("#222224"));

        Button pre2post = new Button("Prefix To Postfix");
        inf2pos.setTextFill(Color.web("#222224"));

        Button post2pre = new Button("Postfix To Prefix");
        inf2pos.setTextFill(Color.web("#222224"));

        Button showH = new Button("Show History");
        inf2pos.setTextFill(Color.web("#222224"));


        Button exitBtn = new Button("Exit");
        exitBtn.setTextFill(Color.web("#222224"));

        //set Action for botton
        inf2pos.setOnAction(actionEvent -> {
            Result result = new Result();
            try {
                result.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Converter converter = new Converter(0, "A / B - C + D * E - A * C");
            Program program = new Program();

        });

        exitBtn.setOnAction(actionEvent -> {
            stage.close();
            return;
        });
        //set Scene, Pane, ...
        Pane root = new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(280);
        vbox.setLayoutY(180);
        vbox.getChildren().addAll(inf2pos, post2inf, inf2pre, pre2inf, pre2post, post2pre, showH, exitBtn);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 500, 300);
        stage.setScene(scene1);
        stage.alwaysOnTopProperty();
        stage.show();
    }
}
