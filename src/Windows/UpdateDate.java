package Windows;

import static Windows.Main.monthNumberToStringName;
import static Windows.Main.yearList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//A User interface to update or change the date for the data in the linked list
public class UpdateDate implements EventHandler<ActionEvent> {

    private RadioButton changeDate, changeYear, israeliLineRadio, gazaPowerRadio, egyLineRadio, totalLineRadio, overallDemandRadio, powerCutsRadio, tempRadio;
    private ToggleGroup toggleGroup;
    private VBox vBox1, vBox2;
    private VBox vBoxIsraeliLine, vBoxGazaPower, vBoxEgyLine, vBoxTotalLine, vBoxOverallDemand, vBoxPowerCuts, vBoxTemp;
    private BorderPane borderPane;
    private GridPane gridPane;
    private Stage updateWindow;

    private ComboBox<String> monthInput, dayInput;
    private ComboBox<Integer> yearInput;
    private Button updateBtn, nextBtn;
    private Label lblOutPut, lblMsgYear, lblMsgMonth, lblMsgDay, lblMsgInput;
    private TextField txtInputIsraeliLine, txtInputGazaPower, txtInputEgyLines, txtInputDailySupply, txtInputOverallDemand, txtInputPowerCuts, txtInputTemp, txtInputNewYear;
    private Label lblChangeDate, lblChangeYear, lblYear, lblMonth, lblDay, lblIsraeliLines, lblGazaPower, lblEgyLines, lblTotalDailySupply, lblOverallDemand, lblPowerCuts, lblTemp;

    @Override
    public void handle(ActionEvent event) {
        Stage newDate = new Stage();
        newDate.setTitle("Change Date");

        lblMsgYear = new Label();
        lblMsgMonth = new Label();
        lblMsgDay = new Label();

        yearInput = new ComboBox<>();
        yearInput.getItems().addAll(yearList.getYears());
        yearInput.setPromptText("Select Year");
        yearInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        yearInput.setMinHeight(50);
        yearInput.setMinWidth(200);

        monthInput = new ComboBox<>();
        monthInput.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        monthInput.setPromptText("Select Month");
        monthInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        monthInput.setMinHeight(50);
        monthInput.setMinWidth(200);

        dayInput = new ComboBox<>();
        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        dayInput.setPromptText("Select Day");
        dayInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        dayInput.setMinHeight(50);
        dayInput.setMinWidth(200);

        updateBtn = new Button("Update");
        updateBtn.setMinWidth(200);
        updateBtn.setMinHeight(50);
        updateBtn.setStyle("-fx-background-color: #14b1e2; -fx-text-fill: white");
        updateBtn.setFont(Font.font("Arail", FontWeight.BOLD, 20));

        lblChangeDate = new Label("Change Date ");
        lblChangeDate.setTextFill(Color.WHITE);
        lblChangeDate.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(5);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(0, 70, 70, 70));
        gridPane.add(yearInput, 0, 1);
        gridPane.add(lblMsgYear, 1, 1);

        gridPane.add(monthInput, 0, 2);
        gridPane.add(lblMsgMonth, 1, 2);

        gridPane.add(dayInput, 0, 3);
        gridPane.add(lblMsgDay, 1, 3);
        gridPane.add(updateBtn, 0, 4);

        nextBtn = new Button("Next");
        nextBtn.setMinWidth(200);
        nextBtn.setMinHeight(50);
        nextBtn.setStyle("-fx-background-color: #14b1e2; -fx-text-fill: white");
        nextBtn.setFont(Font.font("Arail", FontWeight.BOLD, 20));

        gridPane.add(nextBtn, 0, 4);

        ComboBox<Integer> yearInput2 = new ComboBox<>();
        yearInput2.getItems().addAll(yearList.getYears());
        yearInput2.setPromptText("Select Year");
        yearInput2.setStyle("-fx-background-color: white; -fx-text-fill-black; -fx-font-size:15px");
        yearInput2.setMinHeight(50);
        yearInput2.setMinWidth(200);

        ComboBox<String> monthInput2 = new ComboBox<>();
        monthInput2.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        monthInput2.setPromptText("Select Month");
        monthInput2.setStyle("-fx-background-color: white; -fx-text-fill-black; -fx-font-size:15px");
        monthInput2.setMinHeight(50);
        monthInput2.setMinWidth(200);

        ComboBox<String> dayInput2 = new ComboBox<>();
        dayInput2.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        dayInput2.setPromptText("Select Day");
        dayInput2.setStyle("-fx-background-color: white; -fx-text-fill-black; -fx-font-size:15px");
        dayInput2.setMinHeight(50);
        dayInput2.setMinWidth(200);
        GridPane gridPane2 = new GridPane();
        gridPane2.setVgap(10);
        gridPane2.setHgap(5);

        gridPane2.setAlignment(Pos.CENTER);
        gridPane2.setPadding(new Insets(0, 70, 70, 70));

        gridPane2.setVisible(false);
        gridPane2.add(yearInput2, 0, 1);
        //gridPane2.add(lblMsgYear, 1, 1);

        gridPane2.add(monthInput2, 0, 2);
        // gridPane2.add(lblMsgMonth, 1, 2);

        gridPane2.add(dayInput2, 0, 3);
        //gridPane2.add(lblMsgDay, 1, 3);
        gridPane2.add(updateBtn, 0, 4);

        HBox hBox = new HBox(100);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(gridPane, gridPane2);

        nextBtn.setOnAction(event2 -> {

            if (yearInput.getSelectionModel().getSelectedItem() == null) {
                lblMsgYear.setVisible(true);
            } else {
                lblMsgYear.setVisible(false);
            }

            if (monthInput.getSelectionModel().getSelectedItem() == null) {
                lblMsgMonth.setVisible(true);
            } else {
                lblMsgMonth.setVisible(false);
            }

            if (dayInput.getSelectionModel().getSelectedItem() == null) {
                lblMsgDay.setVisible(true);
            } else {
                lblMsgDay.setVisible(false);
            }

            if (yearInput.getSelectionModel().getSelectedItem() != null && monthInput.getSelectionModel().getSelectedItem() != null
                    && dayInput.getSelectionModel().getSelectedItem() != null) {
                String dateInput = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem() + "-" + dayInput.getSelectionModel().getSelectedItem();
                if (yearList.isDateEmpty(dateInput)) {
                    gridPane2.setVisible(true);
                } else {
                    thereIsNoData();
                }
            }
        });

        // borderPane.setLeft(hBox);
        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    String dateInput = yearInput.getSelectionModel().getSelectedItem()
                            + "-" + monthInput.getSelectionModel().getSelectedItem() + "-"
                            + dayInput.getSelectionModel().getSelectedItem();
                    String fullData = "" + yearList.searchDayData(dateInput);
                    yearList.deleteMonthDay(dateInput);
                    String data[] = fullData.split(",");

                    if (data.length >= 8) {
                        String date = data[0];
                        String newDate = yearInput2.getSelectionModel().getSelectedItem() + "-" + monthInput2.getSelectionModel().getSelectedItem() + "-" + dayInput2.getSelectionModel().getSelectedItem();
                        String tmp[] = date.split("-");
                        String month = tmp[1];
                        String monthName = monthNumberToStringName(month);


                        double Israeli_Lines = Double.parseDouble(data[1]);
                        double Gaza_Power = Double.parseDouble(data[2]);
                        double Egyptian_Lines = Double.parseDouble(data[3]);
                        double daily_Supply = Double.parseDouble(data[4]);
                        double Overall_demand = Double.parseDouble(data[5]);
                        double Power_Cuts = Double.parseDouble(data[6]);
                        double Temp = Double.parseDouble(data[7]);

                        if (yearList.isDateEmpty(newDate) != true) {
                            yearList.insertDayData(yearInput2.getSelectionModel().getSelectedItem(), monthInput2.getSelectionModel().getSelectedItem(), newDate,
                                    Israeli_Lines, Gaza_Power, Egyptian_Lines, daily_Supply, Overall_demand, Power_Cuts, Temp);
                            insertedSuccssfullyAlert();
                            gridPane2.setVisible(false);
                        } else {
                            isNotEmpty();
                        }
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        });

        Image image = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/updateData%20BG.png");
        ImageView imageView = new ImageView(image);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, hBox);

        Scene scene = new Scene(stackPane, 1000, 600);
        newDate.setScene(scene);
        newDate.showAndWait();
    }

    private void insertedSuccssfullyAlert() {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("Data Updated Successfully");
        // Show the alert
        alert.showAndWait();
    }

    private void thereIsNoData() {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.WARNING);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("There is no data in this date");
        // Show the alert
        alert.showAndWait();
    }

    private void isNotEmpty() {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.WARNING);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("This date you input alrady have a data");
        // Show the alert
        alert.showAndWait();
    }

}
