package Application.Pages;

import Application.Graphics;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AboutMePage {
    public static TextArea aboutMe = new TextArea();

    public void start(Stage stage) throws Exception {
        aboutMe.setEditable(false);
        Label label = new Label("About Me");
        label.setTextFill(Color.web("#c22d0c"));
        label.setStyle("-fx-font-family: 'Arial Narrow';\n" +
                "-fx-font-size: 40px;\n" +
                "-fx-font-weight: bold;\n" +
                "-fx-text-fill: rgba(0,0,0,.9);\n" +
                "-fx-background-color: white;\n" +
                "-fx-border-color: black;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-alignment: center;\n" +
                "-fx-text-alignment: center;\n" +
                "-fx-effect: dropshadow(gaussian, #b4b4b4, 6,0,0,2);");


        Button backBtn = new Button("back");
        backBtn.setOnAction(actionEvent -> {
            Graphics graphics = new Graphics();
            try {
                graphics.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        String str = "Hello, Welcome to my DS Midterm Project !\n\n" +
                "This application does several things, which are:\n" +
                "    - convert Infix Expression to Postfix\n" +
                "    - convert Infix Expression to Postfix\n" +
                "    - convert Infix Expression to Postfix\n" +
                "    - convert Infix Expression to Postfix\n" +
                "    - convert Infix Expression to Postfix\n" +
                "    - convert Infix Expression to Postfix\n" +
                "    - Conversions with Trigonometric Functions\n" +
                "    - Displays a history of conversions Ordered by the user\n" +
                "    - This program has some of the sorting algorithms that we have been taught in the data structure lesson\n" +
                "    - This application have a Graphic interface with a beautiful background\n" +
                "    *** (NOTE: The background can only be displayed if the user is connected to the Internet) ***\n" +
                "\nMy name is \"Ali Hamidzadeh\" with a student number \"9912762529\"\n" +
                "GOOD LUCK :)";

        aboutMe.setText(str);

        aboutMe.setStyle("-fx-font-family: 'Arial Narrow';\n" +
                "-fx-font-size: 23px;\n" +
                "-fx-text-fill: rgba(71 , 74 , 83,.9);\n" +
                "-fx-background-color: black;\n" +
                "-fx-border-color: blue;\n" +
                "-fx-border-width: 3;\n" +
                "-fx-alignment: center;\n" +
                "-fx-text-alignment: center;\n" +
                "-fx-effect: dropshadow(gaussian, #b4b4b4, 6,0,0,2);");

        aboutMe.setMaxWidth(2000);
        aboutMe.setMaxHeight(1800);
        aboutMe.setMinWidth(1200);
        aboutMe.setMinHeight(500);

        Pane root = new Pane();
        aboutMe.setEditable(false);

//        aboutMe.setDisable(true);
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");
        VBox vbox = new VBox(30);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(100);
//        vbox.setLayoutX(400); //for Monitor
        vbox.setLayoutY(50);
        vbox.getChildren().addAll(label, aboutMe, backBtn);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 750, 800);
        stage.setScene(scene1);
        stage.setResizable(true);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.alwaysOnTopProperty();
        stage.show();


    }

}
