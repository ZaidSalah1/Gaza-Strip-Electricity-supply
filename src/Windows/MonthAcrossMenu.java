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

//This class for the statistics month acrros all day and year
public class MonthAcrossMenu implements EventHandler<ActionEvent> {

    private Stage statisticsWindow;
    private VBox VBoxButtons;
    private Button dayAcrossBtn, monthAcrossBtn, yearAcrosseBtn, statisticsAllData;

    private ComboBox<String> monthInput;
    private HBox hBoxIbputs;

    private Label lblMain;
    private TextArea txtArea;

    private BorderPane borderPane;

    @Override
    public void handle(ActionEvent event) {
        statisticsWindow = new Stage();
        statisticsWindow.setTitle("Statistics");

        monthInput = new ComboBox<>();
        monthInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        monthInput.setPromptText("Month");
        monthInput.setMinWidth(100);
        monthInput.setMinHeight(30);
        monthInput.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        Button btnDisplay = new Button("Display");
        btnDisplay.setStyle("-fx-background-color: RED; -fx-text-fill: white");
        btnDisplay.setFont(Font.font("Arail", FontWeight.BOLD, 16));
        btnDisplay.setMinWidth(200);
        btnDisplay.setMinHeight(40);

        hBoxIbputs = new HBox(5);
        hBoxIbputs.getChildren().addAll(monthInput);
        hBoxIbputs.setAlignment(Pos.CENTER);

        lblMain = new Label("statistic for a given month across all days and years");
        lblMain.setTextFill(Color.WHITE);
        lblMain.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16
        txtArea = new TextArea();
        txtArea.setStyle("-fx-font-size: 18; -fx-font-family: 'italic'");
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(lblMain, txtArea, hBoxIbputs, monthInput, btnDisplay);

        btnDisplay.setOnAction(e -> {
            txtArea.setText("" + yearList.getMonthData(monthInput.getSelectionModel().getSelectedItem()));
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
