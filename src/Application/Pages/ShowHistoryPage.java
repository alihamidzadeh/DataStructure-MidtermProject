package Application.Pages;

import Application.Convert.Converter;
import Application.Graphics;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ShowHistoryPage {

    public static TextArea showHistory = new TextArea();

    public void start(Stage stage) throws Exception {
        showHistory.setEditable(false);

        Label label = new Label("Show History of converts");
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

        Button ascendingBtn = new Button("Ascending");
        ascendingBtn.setStyle(" -fx-background-color: #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 15px;");

        Button descendingBtn = new Button("Descending");
        descendingBtn.setStyle(" -fx-background-color: #000000,\n" +
                "        linear-gradient(#7ebcea, #2f4b8f),\n" +
                "        linear-gradient(#426ab7, #263e75),\n" +
                "        linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 15px;");


        Button backBtn = new Button("back");
        backBtn.setOnAction(actionEvent -> {
            Graphics graphics = new Graphics();
            try {
                showHistory.clear();
                graphics.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        ascendingBtn.setOnAction(actionEvent -> {
            Converter converter = new Converter(6, "1");
            ascendingBtn.setDisable(true);
            descendingBtn.setDisable(true);
        });

        descendingBtn.setOnAction(actionEvent -> {
            Converter converter = new Converter(6, "2");
            ascendingBtn.setDisable(true);
            descendingBtn.setDisable(true);
        });

        //set Scene, Pane, ...
        Pane root = new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");

        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        vbox.setLayoutX((primaryScreenBounds.getMaxX() / 2) - (primaryScreenBounds.getMaxX() / 8));
        vbox.setLayoutY(15);
        vbox.getChildren().addAll(label, showHistory, ascendingBtn, descendingBtn, backBtn);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 500, 300);
        stage.setScene(scene1);
        stage.setResizable(true);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.alwaysOnTopProperty();
        stage.show();


    }
}
