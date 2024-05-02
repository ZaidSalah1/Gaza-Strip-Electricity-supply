package Windows;

import static Windows.Main.yearList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
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

//A User interface class for insert data in the linked list 
public class InsertionWindow implements EventHandler<ActionEvent> {

    private Label insertMsg, lblYearMsg, lblMonthMsg, lblDayMsg, lblIsraeliMsg, lblGazaMsg, lblEgyMsg, blTotolMsg, lblOverMsg, lblPowerMsg, lblTempMsg;
    private boolean yearCheck, monthCheck, dayCheck, israeliCheck, gazaCheck, egyCheck, overallCheck, powerCheck, tempCheck;
    private ComboBox<String> txtInputMonth, txtInputDay;
    private ComboBox<Integer> txtInputYear, powerCuts;
    private TextField txtInputIsraeliLine, txtInputGazaPower, txtInputEgyLines, txtInputOverallDemand, txtInputPowerCuts, txtInputTemp;
    private Button btnInsert, BtnClear;
    private GridPane gridPane;
    private StackPane StackPane, rightStackPane;
    private Stage insertWindow;
    private BorderPane borderPane;
    private MenuBar MenuBar;
    private Menu menu;
    private MenuItem insertYearItem;

    @Override
    public void handle(ActionEvent event) {
        insertWindow = new Stage();
        insertWindow.setTitle("Insert Records");

        MenuBar = new MenuBar();
        menu = new Menu("More");
        MenuBar.getMenus().add(menu);
        MenuBar.setPadding(new Insets(20, 0, 0, 0));
        MenuBar.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:13px");
        insertYearItem = new MenuItem("Insert Year");
        insertYearItem.setOnAction(insrt -> insertYear());
        menu.getItems().add(insertYearItem);

        txtInputYear = new ComboBox<>();
        txtInputYear.setEditable(true);
        txtInputYear.setMinHeight(40);
        txtInputYear.setMinWidth(200);
        txtInputYear.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");

        txtInputYear.getItems().addAll(yearList.getYears());//******************************************
        txtInputYear.setPromptText("Year                                                           ");

        txtInputMonth = new ComboBox<>();
        txtInputMonth.setMinHeight(40);
        txtInputMonth.setMinWidth(200);
        txtInputMonth.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        txtInputMonth.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        txtInputMonth.setPromptText("Month                                   ");

        txtInputDay = new ComboBox<>();
        txtInputDay.setMinHeight(40);
        txtInputDay.setMinWidth(200);
        txtInputDay.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        txtInputDay.setPromptText("Day                                       ");

        txtInputIsraeliLine = customTextField("Enter Israeli Line in 'MWs'");

        txtInputGazaPower = customTextField("Enter Gaza Power in 'MWs'");

        txtInputEgyLines = customTextField("Enter Egyptian Line in 'MWs'");

        txtInputOverallDemand = customTextField("Enter ovaerall Demand in 'MWs'");

        txtInputPowerCuts = customTextField("Enter Power Cuts hours     ");

        txtInputTemp = customTextField("Enter Tempereture");

        powerCuts = new ComboBox<>();
        powerCuts.setMinHeight(40);
        powerCuts.setMinWidth(200);
        powerCuts.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        powerCuts.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        powerCuts.setPromptText("Enter Power Cuts Hours");

        btnInsert = new Button("Insert");
        btnInsert.setStyle("-fx-background-color: #264d97; -fx-text-fill: white");
        btnInsert.setFont(Font.font("Arail", FontWeight.BOLD, 16));

        BtnClear = new Button("Clear");
        BtnClear.setStyle("-fx-background-color: #264d97; -fx-text-fill: white");
        BtnClear.setFont(Font.font("Arail", FontWeight.BOLD, 16));

        HBox hBoxBtns = new HBox(7);
        hBoxBtns.getChildren().addAll(BtnClear, btnInsert);

        gridPane = new GridPane();
        gridPane.setHgap(7);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(90, 70, 70, 70));

        gridPane.add(txtInputYear, 1, 0);
        gridPane.add(txtInputMonth, 1, 1);
        gridPane.add(txtInputDay, 1, 2);
        gridPane.add(txtInputIsraeliLine, 1, 3);
        gridPane.add(txtInputGazaPower, 1, 4);
        gridPane.add(txtInputEgyLines, 1, 5);
        gridPane.add(txtInputOverallDemand, 1, 6);
        gridPane.add(powerCuts, 1, 7);
        gridPane.add(txtInputTemp, 1, 8);
        gridPane.add(hBoxBtns, 1, 9);

        wrningLabels();

        Image rightImage = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/insetOutPut.png");
        ImageView imageViewRight = new ImageView(rightImage);
        rightStackPane = new StackPane();
        rightStackPane.getChildren().addAll(imageViewRight);
        rightStackPane.setPadding(new Insets(50, 50, 50, 50));
        borderPane = new BorderPane();
        borderPane.setLeft(gridPane);
        borderPane.setRight(rightStackPane);
        borderPane.setTop(MenuBar);

        Image image = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/insertTest4.png");
        ImageView imageView = new ImageView(image);

        StackPane = new StackPane();
        StackPane.getChildren().addAll(imageView, borderPane);

        Scene scene = new Scene(StackPane, 1050, 650);
        imageView.fitWidthProperty().bind(scene.widthProperty());//fit Width
        imageView.fitHeightProperty().bind(scene.heightProperty());//fit Height   

        txtInputMonth.setOnAction(e -> {
            getMonthDayCount();
        });

        btnInsert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkInputs();
                try {
                    int yearInput = Integer.parseInt(txtInputYear.getEditor().getText());
                    String month = txtInputMonth.getSelectionModel().getSelectedItem();
                    // String monthNumber = monthStringToNumber(month) + "";
                    String date = yearInput + "-" + month + "-" + txtInputDay.getSelectionModel().getSelectedItem();
                    double israeli_Line = Double.parseDouble(txtInputIsraeliLine.getText());
                    double gaza_Power = Double.parseDouble(txtInputGazaPower.getText());
                    double egy_line = Double.parseDouble(txtInputEgyLines.getText());
                    double overall_demand = Double.parseDouble(txtInputOverallDemand.getText());
                    int powercuts = powerCuts.getSelectionModel().getSelectedItem();
                    double temp = Double.parseDouble(txtInputTemp.getText());

                    double total = israeli_Line + gaza_Power + egy_line;

                    if (isVaildDate(date) == false) {
                        dateIsInvalidAlert();
                        return;
                    }
                    if (yearCheck == true && monthCheck == true && dayCheck == true && israeliCheck == true
                            && gazaCheck == true && egyCheck == true && overallCheck == true
                            && powerCheck == true && tempCheck == true) {
                        if (yearList.isYearExist(yearInput) == true) {
                            if (yearList.isDateEmpty(date) != true) {
                                yearList.insertDayData(yearInput, month, date, israeli_Line,
                                        gaza_Power, egy_line, total, overall_demand, powercuts, temp);
                                insertMsg.setText("Record Inserted.");
                                rightStackPane.getChildren().add(insertMsg);
                            } else {
                                insertMsg.setText("\nThere's already information \n"
                                        + "     recorded for this date.");
                                rightStackPane.getChildren().add(insertMsg);
                            }
                        } else {
                            if (yearIsNotExist() == true) {
                                yearList.insertYear(Integer.parseInt(txtInputYear.getEditor().getText()));
                                yearList.insertDayData(yearInput, month, date, israeli_Line,
                                        gaza_Power, egy_line, total, overall_demand, powercuts, temp);
                                insertMsg.setText("Record Inserted.");
                                rightStackPane.getChildren().add(insertMsg);
                            }
                        }
                    }
                } catch (Exception e) {
                    // System.out.println(e);
                }

            }
        });

        BtnClear.setOnAction(e -> clear());
        insertWindow.setScene(scene);
        insertWindow.showAndWait();
    }

    public void insertYear() {
        Stage yearStege = new Stage();
        yearStege.setTitle("insert Year");

        TextField yearInput = new TextField();
        Button btnAdd = new Button("Insert");

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(yearInput, btnAdd);

        btnAdd.setOnAction(event -> {
            try {
                int year = Integer.parseInt(yearInput.getText());
                if (yearList.isYearExist(year) == false) {
                    yearList.insertYear(year);
                    insertedSuccssfullyAlert();
                } else {
                    thisYearIsExist();
                }
            } catch (NumberFormatException ex) {
                errorAlert();
            }

        });
        Scene scene = new Scene(hBox, 300, 100);
        yearStege.setScene(scene);
        yearStege.showAndWait();
    }

    private void wrningLabels() {
        lblYearMsg = customLabel();
        lblMonthMsg = customLabel();
        lblDayMsg = customLabel();
        lblIsraeliMsg = customLabel();
        lblGazaMsg = customLabel();
        lblEgyMsg = customLabel();
        blTotolMsg = customLabel();
        lblOverMsg = customLabel();
        lblPowerMsg = customLabel();
        lblTempMsg = customLabel();

        insertMsg = new Label("Record Inserted!!");

    }

    public void clear() {
        // Clear all text fields
        txtInputYear.getEditor().clear();
        txtInputMonth.getSelectionModel().clearSelection();
        txtInputDay.getSelectionModel().clearSelection();
        txtInputIsraeliLine.clear();
        txtInputGazaPower.clear();
        txtInputEgyLines.clear();
        txtInputOverallDemand.clear();
        txtInputPowerCuts.clear();
        txtInputTemp.clear();

        // Clear the "Name" label
        insertMsg.setText("");

        // Clear warning labels
        lblYearMsg.setText("");
        lblMonthMsg.setText("");
        lblDayMsg.setText("");
        lblIsraeliMsg.setText("");
        lblGazaMsg.setText("");
        lblEgyMsg.setText("");
        blTotolMsg.setText("");
        lblOverMsg.setText("");
        lblPowerMsg.setText("");
        lblTempMsg.setText("");
    }

    public void checkInputs() {
        gridPane.getChildren().removeAll(lblYearMsg, lblMonthMsg, lblDayMsg, lblIsraeliMsg,
                lblGazaMsg, lblEgyMsg, blTotolMsg, lblOverMsg, lblPowerMsg, lblTempMsg);
        try{
            //----------------------
            if (txtInputIsraeliLine.getText().isEmpty()) {
                gridPane.add(lblIsraeliMsg, 2, 3);
                lblIsraeliMsg.setText("This is Empty");
                lblIsraeliMsg.setVisible(true);
                israeliCheck = false;
            } else if (txtInputIsraeliLine.getText().matches("[a-zA-Z]+")) {
                gridPane.add(lblIsraeliMsg, 2, 3);
                lblIsraeliMsg.setText("Letters not allowed");
                lblIsraeliMsg.setVisible(true);
                israeliCheck = false;
            } else if (Integer.parseInt(txtInputIsraeliLine.getText()) < 0) {
                gridPane.add(lblIsraeliMsg, 2, 3);
                lblIsraeliMsg.setText("No Negative Number");
                lblIsraeliMsg.setVisible(true);
                israeliCheck = false;
            } else {
                israeliCheck = true;
            }
            //----------------------
            if (txtInputGazaPower.getText().isEmpty()) {
                gridPane.add(lblGazaMsg, 2, 4);
                lblGazaMsg.setText("This is Empty");
                lblGazaMsg.setVisible(true);
                gazaCheck = false;
            } else if (txtInputGazaPower.getText().matches("[a-zA-Z]+")) {
                gridPane.add(lblGazaMsg, 2, 4);
                lblGazaMsg.setText("Letters not allowed");
                lblGazaMsg.setVisible(true);
                gazaCheck = false;
            } else if (Integer.parseInt(txtInputGazaPower.getText()) < 0) {
                gridPane.add(lblGazaMsg, 2, 4);
                lblGazaMsg.setText("No Negative Number");
                lblGazaMsg.setVisible(true);
                gazaCheck = false;
            } else {
                gazaCheck = true;
            }
            //----------------------
            if (txtInputEgyLines.getText().isEmpty()) {
                gridPane.add(lblEgyMsg, 2, 5);
                lblEgyMsg.setText("This is Empty");
                lblEgyMsg.setVisible(true);
                egyCheck = false;
            } else if (txtInputEgyLines.getText().matches("[a-zA-Z]+")) {
                gridPane.add(lblEgyMsg, 2, 5);
                lblEgyMsg.setText("Letters not allowed");
                lblEgyMsg.setVisible(true);
                egyCheck = false;
            } else if (Integer.parseInt(txtInputEgyLines.getText()) < 0) {
                gridPane.add(lblEgyMsg, 2, 5);
                lblEgyMsg.setText("No Negative Number");
                lblEgyMsg.setVisible(true);
                egyCheck = false;
            } else {
                egyCheck = true;
            }
            //----------------------
            if (txtInputOverallDemand.getText().isEmpty()) {
                gridPane.add(lblOverMsg, 2, 6);
                lblOverMsg.setText("This is Empty");
                lblOverMsg.setVisible(true);
                overallCheck = false;
            } else if (txtInputOverallDemand.getText().matches("[a-zA-Z]+")) {
                gridPane.add(lblOverMsg, 2, 6);
                lblOverMsg.setText("Letters not allowed");
                lblOverMsg.setVisible(true);
                overallCheck = false;
            } else if (Integer.parseInt(txtInputOverallDemand.getText()) < 0) {
                gridPane.add(lblOverMsg, 2, 6);
                lblOverMsg.setText("No Negative Number");
                lblOverMsg.setVisible(true);
                overallCheck = false;
            } else {
                overallCheck = true;
            }
            //----------------------
            if (powerCuts.getSelectionModel().getSelectedItem() == null) {
                gridPane.add(lblPowerMsg, 2, 7);
                lblPowerMsg.setText("This is Empty");
                lblPowerMsg.setVisible(true);
                powerCheck = false;
            } else if (powerCuts.getSelectionModel().getSelectedItem() < 0) {
                gridPane.add(lblPowerMsg, 2, 7);
                lblPowerMsg.setText("No Negative Number");
                lblPowerMsg.setVisible(true);
                powerCheck = false;
            } else {
                powerCheck = true;
            }
            //----------------------
            if (txtInputTemp.getText().isEmpty()) {
                gridPane.add(lblTempMsg, 2, 8);
                lblTempMsg.setText("This is Empty");
                lblTempMsg.setVisible(true);
                tempCheck = false;
            } else if (txtInputTemp.getText().matches("[a-zA-Z]+")) {
                gridPane.add(lblTempMsg, 2, 8);
                lblTempMsg.setText("Letters not allowed");
                lblTempMsg.setVisible(true);
                tempCheck = false;
            } //            else if (Integer.parseInt(txtInputTemp.getText()) < 0) {
            //                gridPane.add(lblTempMsg, 2, 8);
            //                lblTempMsg.setText("No Negative Number");
            //                lblTempMsg.setVisible(true);
            //                tempCheck = false;
            //            }
            else {
                tempCheck = true;
            }
        } catch (Exception ex) {
//            Alerts.errorAlert();
        }

    }

    //Metho to check if the year input is a leap year ot not
    //if yes then put the Feb month to 29 days
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isVaildDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        LocalDate inputDate = LocalDate.parse(date, formatter);

        LocalDate currDate = LocalDate.now();
        return !inputDate.isAfter(currDate);
    }

    public TextField customTextField(String promotText) {
        TextField txt = new TextField();
        txt = new TextField();
        txt.setMinHeight(40);
        txt.setMinWidth(200);
        txt.setPromptText(promotText);
        return txt;
    }

    public Label customLabel() {

        Label lbl = new Label();
        lbl.setTextFill(Color.RED);
        lbl.setFont(Font.font("Arail", FontWeight.BOLD, 16));
        return lbl;

    }

    public void getMonthDayCount() {
        try {
            String selectedMonth = txtInputMonth.getValue();
            int yearInput = Integer.parseInt(txtInputYear.getEditor().getText());
            txtInputDay.getItems().clear();

            if (selectedMonth.equals("Feb") && isLeapYear(yearInput) == true) {
                txtInputDay.getItems().clear(); // Clear previous items
                txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                        "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29");
            } else {
                if (selectedMonth.equals("Jan")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                } else if (selectedMonth.equals("Feb")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28");
                } else if (selectedMonth.equals("Mar")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                } else if (selectedMonth.equals("Apr")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                } else if (selectedMonth.equals("May")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                } else if (selectedMonth.equals("Jun")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                } else if (selectedMonth.equals("Jul")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                } else if (selectedMonth.equals("Aug")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                } else if (selectedMonth.equals("Sep")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                } else if (selectedMonth.equals("Oct")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                } else if (selectedMonth.equals("Nov")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                } else if (selectedMonth.equals("Dec")) {
                    txtInputDay.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    //--------------------Alerts------------------------\\
    private void dateIsInvalidAlert() {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.WARNING);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("Please dont enter a date that in the future");

        // Show the alert
        alert.showAndWait();
    }

    private boolean yearIsNotExist() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("The year '" + txtInputYear.getEditor().getText() + "' does not exist.\n"
                + "Would you like to auto-create this year and insert your data?");
        // Show the alert and wait for the user's response
        Optional<ButtonType> result = alert.showAndWait();
        // Check if the OK button is pressed
        if (result.isPresent() && result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    private void insertedSuccssfullyAlert() {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("Year Inserted Succssfully");

        // Show the alert
        alert.showAndWait();
    }

    private void thisYearIsExist() {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.WARNING);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("Year is Already exists");

        // Show the alert
        alert.showAndWait();
    }

    private void errorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("          Oops! Something went wrong with the inputs. "
                + "Please double-check and make sure all fields are filled correctly.");

        // Show the alert and wait for the user's response
        alert.showAndWait();
        clear();
    }

}
