package Application.Page;
import Application.Graphics;
import Application.Converter;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class ConvertResultPage {
    static TextArea input = new TextArea();
    public static TextArea output = new TextArea();
    public static TextArea result = new TextArea();
    public static int type;
    public static String typeStr;

    public void start(Stage stage) throws Exception {
        input.setEditable(true);
        Label convertType = new Label(typeStr);
        convertType.setTextFill(Color.web("#c22d0c"));
        convertType.setStyle("-fx-font-family: 'Arial Narrow';\n" +
                "-fx-font-size: 40px;\n" +
                "-fx-font-weight: bold;\n" +
                "-fx-text-fill: rgba(0,0,0,.9);\n" +
                "-fx-background-color: white;\n" +
                "-fx-border-color: black;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-alignment: center;\n" +
                "-fx-text-alignment: center;\n" +
                "-fx-effect: dropshadow(gaussian, #b4b4b4, 6,0,0,2);");


        Label inputLb = new Label("Enter the input Expression:");
        inputLb.setTextFill(Color.web("#c22d0c"));
        inputLb.setStyle("-fx-font-size:20px");

        input.setDisable(false);
        input.setMaxSize(400, 40);
        input.setMinSize(400, 40);

        Label outputLb = new Label("Step of Converting:");
        outputLb.setTextFill(Color.web("#595556"));
        outputLb.setStyle("-fx-font-size:20px");

        output.setDisable(false);
        output.setEditable(false);
        output.setMaxSize(400, 300);
        output.setMinSize(400, 300);

        Label resultLb = new Label("Result:");
        resultLb.setTextFill(Color.web("#595556"));
        resultLb.setStyle("-fx-font-size:20px");

        result.setDisable(true);
        result.setEditable(false);
        result.setMaxSize(400, 40);
        result.setMinSize(400, 40);

        Button convertBtn = new Button("Convert");

        Button backBtn = new Button("back");
        //*******

        convertBtn.setOnAction(actionEvent -> {
            Converter converter = new Converter(type, input.getText());
            input.setEditable(false);
        });

        backBtn.setOnAction(actionEvent -> {
            result.clear();
            input.clear();
            output.clear();
            Graphics graphics = new Graphics();
            try {
                graphics.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Pane root=new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(30);

        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(600);
        vbox.setLayoutY(50);
        vbox.getChildren().addAll(convertType, inputLb, input, outputLb, output, resultLb, result,
                convertBtn, backBtn);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 750, 800);
        stage.setScene(scene1);
        stage.setResizable(true);
        stage.setFullScreen(true);
        stage.alwaysOnTopProperty();
        stage.show();
    }
}
