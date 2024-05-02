/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Windows;

import static Windows.Main.yearList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//A usre interface for displaying data by given year across all month and days
public class YearAcrossMenu implements EventHandler<ActionEvent> {

    private Stage statisticsWindow;
    private VBox VBoxButtons;
    private Button dayAcrossBtn, monthAcrossBtn, yearAcrosseBtn, statisticsAllData;

    private ComboBox<Integer> yearInput;
    private HBox hBoxIbputs;

    private Label lblMain;
    private TextArea txtArea;

    @Override
    public void handle(ActionEvent event) {
        statisticsWindow = new Stage();
        statisticsWindow.setTitle("Statistics");

        yearInput = new ComboBox<>();
        yearInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        yearInput.setPromptText("Year");
        yearInput.setMinWidth(100);
        yearInput.setMinHeight(30);
        yearInput.getItems().addAll(yearList.getYears());

        Button btnDisplay = new Button("Display");
        btnDisplay.setStyle("-fx-background-color: RED; -fx-text-fill: white");
        btnDisplay.setFont(Font.font("Arail", FontWeight.BOLD, 16));
        btnDisplay.setMinWidth(200);
        btnDisplay.setMinHeight(40);

        hBoxIbputs = new HBox(5);
        hBoxIbputs.getChildren().addAll(yearInput);
        hBoxIbputs.setAlignment(Pos.CENTER);

        lblMain = new Label("statistic for a given year across all days and months ");
        lblMain.setTextFill(Color.WHITE);
        lblMain.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16
        txtArea = new TextArea();
        txtArea.setStyle("-fx-font-size: 18; -fx-font-family: 'italic'");
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(lblMain, txtArea, hBoxIbputs, yearInput, btnDisplay);

        btnDisplay.setOnAction(e -> {
            txtArea.setText("" + yearList.searchByYear(yearInput.getSelectionModel().getSelectedItem()));
        });
        Image image = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/plain-black-background.jpg");
        ImageView imageView = new ImageView(image);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, vBox);

        Scene scene = new Scene(stackPane, 700, 600);
        statisticsWindow.setScene(scene);
        statisticsWindow.showAndWait();
    }

}
