package Application.Sort;

import Application.Graphics;
import Application.Sort.Sort;
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

public class SortResultPage {
    static TextArea input = new TextArea();
    public static TextArea output = new TextArea();
    public static TextArea result = new TextArea();
    public static String typeStr;
    public static int type;

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


        Label inputLb = new Label("Enter the array:\nNOTE (Enter the element separately with space).");
        inputLb.setTextFill(Color.web("#c22d0c"));
        inputLb.setStyle("-fx-font-size:20px");

        input.setDisable(false);
        input.setMaxSize(400, 40);
        input.setMinSize(400, 40);

        Label outputLb = new Label("Step of Sorting:");
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

        Button sortBtn = new Button("Sort");

        Button backBtn = new Button("back");

        sortBtn.setOnAction(actionEvent -> {
            String[] strArr = input.getText().trim().split(" ");
            int[] array = new int[strArr.length];
            String str = "";
            for (int i = 0; i < strArr.length; i++){
                try {
                    array[i] = Integer.parseInt(strArr[i]);
                }catch (NumberFormatException ex){
                    str += "Input is Inccorect!\nMaybe there is a character that is not a number.\n<<< ";
                    str += ex.getMessage();
                    str += " >>>\n \"Press Back button\" to get back to menu.";
                    output.setText(str);
                    input.setEditable(false);
                    return;
                }
            }
            Sort sort = new Sort(type, array);
            input.setEditable(false);
        });

        backBtn.setOnAction(actionEvent -> {
            SortResultPage.output.clear();
            SortResultPage.input.clear();
            SortResultPage.result.clear();
            ChooseSortAlgorithm chooseSortAlgorithm = new ChooseSortAlgorithm();
            try {
                ChooseSortAlgorithm.start(stage);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        //********************************************* Windows ********************************************************
        Pane root = new Pane();
        root.setStyle("-fx-background-image: url('https://i.pinimg.com/originals/cf/4e/7e/cf4e7ef82f683fcc564d78e786511559.gif'); -fx-background-size: 100% 100%");

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        vbox.setLayoutX((primaryScreenBounds.getMaxX() / 2) - (primaryScreenBounds.getMaxX() / 8));
        vbox.setLayoutY(5);
        vbox.getChildren().addAll(convertType, inputLb,input, outputLb, output, resultLb, result, sortBtn, backBtn);
        root.getChildren().add(vbox);
        Scene scene1 = new Scene(root, 500, 300);
        stage.setScene(scene1);
        stage.setResizable(true);
        stage.setFullScreen(true);
        stage.alwaysOnTopProperty();
        stage.show();
    }
}
