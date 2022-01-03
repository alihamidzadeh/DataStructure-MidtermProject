package Application.Sort;

import Application.Graphics;
import Application.Pages.SortResultPage;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ChooseSortAlgorithm {
    public static void start(Stage stage) throws Exception {
        Label convertType = new Label("Choose Sort Algorithm");
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

        //********************************** Buttons *********************************************************

        Button bubbleBtn = new Button("Bubble Sort");
        bubbleBtn.setTextFill(Color.web("#222224"));
        bubbleBtn.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 15px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        Button recursiveBubbleBtn = new Button("Recursive Bubble Sort");
        recursiveBubbleBtn.setTextFill(Color.web("#222224"));
        recursiveBubbleBtn.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 15px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        Button selectionBtn = new Button("Selection Sort");
        selectionBtn.setTextFill(Color.web("#222224"));
        selectionBtn.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 15px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        Button insertionBtn = new Button("Insertion Sort");
        insertionBtn.setTextFill(Color.web("#222224"));
        insertionBtn.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 15px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        Button insertionReverseBtn = new Button("Insertion Sort Reverse");
        insertionReverseBtn.setTextFill(Color.web("#222224"));
        insertionReverseBtn.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 15px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        Button recursiveInsertionBtn = new Button("Recursive Insertion Sort");
        recursiveInsertionBtn.setTextFill(Color.web("#222224"));
        recursiveInsertionBtn.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 15px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");


        Button backBtn = new Button("back");
        backBtn.setStyle(" -fx-background-color: #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 17px;");

        backBtn.setOnAction(actionEvent -> {
            Graphics graphics = new Graphics();
            try {
                graphics.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        //********************************************* Windows ********************************************************
        Pane root = new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        vbox.setLayoutX((primaryScreenBounds.getMaxX() / 2) - (primaryScreenBounds.getMaxX() / 8));
        vbox.setLayoutY(150);
        vbox.getChildren().addAll(bubbleBtn, recursiveBubbleBtn, selectionBtn, insertionBtn, insertionReverseBtn, recursiveInsertionBtn, backBtn);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 500, 300);
        stage.setScene(scene1);
        stage.setResizable(true);
        stage.setFullScreen(true);
        stage.alwaysOnTopProperty();
        stage.show();

        //******************************************* Button`s function ***************************************

        bubbleBtn.setOnAction(actionEvent -> {
            SortResultPage sortResultPage = new SortResultPage();
            try {
                SortResultPage.typeStr = "Bubble Sort";
                SortResultPage.type = 0;
                sortResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        recursiveBubbleBtn.setOnAction(actionEvent -> {
            SortResultPage sortResultPage = new SortResultPage();
            try {
                SortResultPage.typeStr = "Recursive Bubble Sort";
                SortResultPage.type = 1;
                sortResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        selectionBtn.setOnAction(actionEvent -> {
            SortResultPage sortResultPage = new SortResultPage();
            try {
                SortResultPage.typeStr = "Selection Sort";
                SortResultPage.type = 2;
                sortResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        insertionBtn.setOnAction(actionEvent -> {
            SortResultPage sortResultPage = new SortResultPage();
            try {
                SortResultPage.typeStr = "Insertion Sort";
                SortResultPage.type = 3;
                sortResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        insertionReverseBtn.setOnAction(actionEvent -> {
            SortResultPage sortResultPage = new SortResultPage();
            try {
                SortResultPage.typeStr = "Insertion Sort Reverse";
                SortResultPage.type = 4;
                sortResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        recursiveInsertionBtn.setOnAction(actionEvent -> {
            SortResultPage sortResultPage = new SortResultPage();
            try {
                SortResultPage.typeStr = "Recursive Insertion Sort";
                SortResultPage.type = 5;
                sortResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


    }
}

