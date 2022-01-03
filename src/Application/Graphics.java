package Application;
import Application.Page.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Graphics extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tommy Converter");
        stage.setResizable(true);
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setX(600);
        stage.setY(50);

        //set Buttons
        Label chooseLB = new Label("Choose one Buttons");
        chooseLB.setStyle("-fx-font-family: 'Impact';\n" +
                "-fx-font-size: 40px;\n" +
                "-fx-font-weight: bold;\n" +
                "-fx-text-fill: rgba(0,0,0,.9);\n" +
                "-fx-background-color: white;\n" +
                "-fx-border-color: black;\n" +
                "-fx-border-width: 7;\n" +
                "-fx-alignment: center;\n" +
                "-fx-text-alignment: center;\n" +
                "-fx-effect: dropshadow(gaussian, #b4b4b4, 6,0,0,2);");

        Button inf2pos = new Button("Infix To Postfix");
        inf2pos.setTextFill(Color.web("#222224"));
        inf2pos.setStyle(" -fx-background-color: #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 15px;");

        Button post2inf = new Button("Postfix To Infix");
        post2inf.setTextFill(Color.web("#222224"));
        post2inf.setStyle(" -fx-background-color: #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 15px;");

        Button inf2pre = new Button("Infix To Prefix");
        inf2pre.setTextFill(Color.web("#222224"));
        inf2pre.setStyle(" -fx-background-color: #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 15px;");

        Button pre2inf = new Button("Prefix To Infix");
        pre2inf.setTextFill(Color.web("#222224"));
        pre2inf.setStyle(" -fx-background-color: #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 15px;");

        Button post2pre = new Button("Postfix To Prefix");
        post2pre.setTextFill(Color.web("#222224"));
        post2pre.setStyle(" -fx-background-color: #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 15px;");

        Button pre2post = new Button("Prefix To Postfix");
        pre2post.setTextFill(Color.web("#222224"));
        pre2post.setStyle(" -fx-background-color: #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 15px;");

        Button showH = new Button("Show History");
        showH.setTextFill(Color.web("#222224"));
        showH.setStyle(" -fx-background-color: \n" +
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

        Button sortBtn = new Button("Sort");
        sortBtn.setTextFill(Color.web("#222224"));
        sortBtn.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 12px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        Button aboutMeBtn = new Button("About me");
        aboutMeBtn.setTextFill(Color.web("#222224"));
        aboutMeBtn.setStyle("-fx-background-color: #090a0c,\n" +
                "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                "        linear-gradient(#20262b, #191d22),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 5,4,3,5;\n" +
                "    -fx-background-insets: 0,1,2,0;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-font-family: \"A Iranian Sans\";\n" +
                "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                "    -fx-font-size: 12px;\n" +
                "    -fx-padding: 10 20 10 20;");

        Button exitBtn = new Button("Exit");
        exitBtn.setTextFill(Color.web("#222224"));
        exitBtn.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                "    -fx-background-radius: 20;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;\n" +
                "     -fx-font-size: 14px;");

        //set Scene, Pane, ...
        Pane root = new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        vbox.setLayoutX((primaryScreenBounds.getMaxX()/2)-(primaryScreenBounds.getMaxX()/8));
        vbox.setLayoutY(15);
        vbox.getChildren().addAll(chooseLB, inf2pos, post2inf, inf2pre, pre2inf, pre2post, post2pre, showH, sortBtn, aboutMeBtn, exitBtn);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 500, 300);
        stage.setScene(scene1);
        stage.setResizable(true);
        stage.setFullScreen(true);
        stage.alwaysOnTopProperty();
        stage.show();




//set Action for botton
        inf2pos.setOnAction(actionEvent -> {
            ConvertResultPage convertResultPage = new ConvertResultPage();
            try {
                ConvertResultPage.type = 0;
                ConvertResultPage.typeStr = "Infix To Postfix";
                convertResultPage.start(stage);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
//            Program program = new Program();

        });
        post2inf.setOnAction(actionEvent -> {
            ConvertResultPage convertResultPage = new ConvertResultPage();
            try {
                ConvertResultPage.type = 1;
                ConvertResultPage.typeStr = "Postfix To Infix";

                convertResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        inf2pre.setOnAction(actionEvent -> {
            ConvertResultPage convertResultPage = new ConvertResultPage();
            try {
                ConvertResultPage.type = 2;
                ConvertResultPage.typeStr = "Infix To Prefix";
                convertResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        pre2inf.setOnAction(actionEvent -> {
            ConvertResultPage convertResultPage = new ConvertResultPage();
            try {
                ConvertResultPage.type = 3;
                ConvertResultPage.typeStr = "Prefix To Infix";
                convertResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        pre2post.setOnAction(actionEvent -> {
            ConvertResultPage convertResultPage = new ConvertResultPage();
            try {
                ConvertResultPage.type = 4;
                ConvertResultPage.typeStr = "Prefix To Postfix";
                convertResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        post2pre.setOnAction(actionEvent -> {
            ConvertResultPage convertResultPage = new ConvertResultPage();
            try {
                ConvertResultPage.type = 5;
                ConvertResultPage.typeStr = "Postfix To Prefix";
                convertResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        showH.setOnAction(actionEvent -> {
            ConvertResultPage convertResultPage = new ConvertResultPage();
            try {
                ConvertResultPage.type = 6;
                ConvertResultPage.typeStr = "Show History";
                convertResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        sortBtn.setOnAction(actionEvent -> {
            ConvertResultPage convertResultPage = new ConvertResultPage();
            try {
                ConvertResultPage.type = 6;
                ConvertResultPage.typeStr = "Sorting";
                convertResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        aboutMeBtn.setOnAction(actionEvent -> {
            ConvertResultPage convertResultPage = new ConvertResultPage();
            try {
                ConvertResultPage.type = 7;
                ConvertResultPage.typeStr = "About Me";
                convertResultPage.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        exitBtn.setOnAction(actionEvent -> {
            stage.close();
            return;
        });
    }
}
