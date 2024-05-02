package Windows;

import LinkedList.Days.OperationType;
import static Windows.Main.yearList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
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

//A user interface for showing the Statistics data (total, average, max, min...) in the linked list
public class StatisticDataScreen implements EventHandler<ActionEvent> {

    private ComboBox<String> monthInput, dayInput;
    private ComboBox<Integer> yearInput;
    private TextArea txtArea;
    private Button btnDisplay;
    private Stage searchWindow;
    private Label lblOutPut;
    private RadioButton israeliLineRadio, gazaPowerRadio, egyLineRadio, totalLineRadio, overallDemandRadio, powerCutsRadio, tempRadio;
    private ToggleGroup toggleGroup;
    private VBox vBox1, vBox2;
    private Label lblTotal, lblAverage, lblMax, lblMin, lbl, lblGap;
    private BorderPane borderPane;
    private MenuBar MenuBar;
    private Menu menu;
    private MenuItem reversData, clareInputs;
    private VBox vBoxLbls;

    @Override
    public void handle(ActionEvent event) {
        searchWindow = new Stage();
        searchWindow.setTitle("Statistics");

        MenuBar = new MenuBar();
        menu = new Menu("More");
        MenuBar.getMenus().add(menu);
        // MenuBar.setPadding(new Insets(20, 0, 0, 0));
        MenuBar.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:13px");
        clareInputs = new MenuItem("Clear Inputs");
        reversData = new MenuItem("Revers Data");
        reversData.setOnAction(revers -> printRevers());
        clareInputs.setOnAction(insrt -> clearInputs());
        menu.getItems().addAll(reversData, clareInputs);

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

        Label lbl1 = new Label("*");
        Label lbl2 = new Label("*");
        Label lbl3 = new Label("*");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(lbl1, lbl2, lbl3);

        btnDisplay = new Button("Display");
        btnDisplay.setMinWidth(200);
        btnDisplay.setMinHeight(50);
        btnDisplay.setStyle("-fx-background-color: #184ea9; -fx-text-fill: white");
        btnDisplay.setFont(Font.font("Arail", FontWeight.BOLD, 20));

        VBox vBoxInputs = new VBox(10);
        vBoxInputs.getChildren().addAll(yearInput, monthInput, btnDisplay);
        vBoxInputs.setAlignment(Pos.CENTER);
        vBoxInputs.setPadding(new Insets(50, 50, 50, 100));

        lblOutPut = new Label();
        lblOutPut.setTextFill(Color.WHITE);
        lblOutPut.setFont(Font.font("Arail", FontWeight.BOLD, 20));//set Font weight to bold and size 16
        lblOutPut.setAlignment(Pos.CENTER);

        toggleGroup = new ToggleGroup();

        israeliLineRadio = new RadioButton("Israeli Line");
        israeliLineRadio.setTextFill(Color.WHITE);
        israeliLineRadio.setFont(Font.font("Arail", FontWeight.BOLD, 18));
        israeliLineRadio.setToggleGroup(toggleGroup);

        gazaPowerRadio = new RadioButton("Gaza Power");
        gazaPowerRadio.setTextFill(Color.WHITE);
        gazaPowerRadio.setFont(Font.font("Arail", FontWeight.BOLD, 18));
        gazaPowerRadio.setToggleGroup(toggleGroup);

        egyLineRadio = new RadioButton("Egyption Line");
        egyLineRadio.setTextFill(Color.WHITE);
        egyLineRadio.setFont(Font.font("Arail", FontWeight.BOLD, 18));
        egyLineRadio.setToggleGroup(toggleGroup);

        vBox1 = new VBox(5);
        vBox1.getChildren().addAll(israeliLineRadio, gazaPowerRadio, egyLineRadio);

        overallDemandRadio = new RadioButton("Overall demad");
        overallDemandRadio.setTextFill(Color.WHITE);
        overallDemandRadio.setFont(Font.font("Arail", FontWeight.BOLD, 18));
        overallDemandRadio.setToggleGroup(toggleGroup);

        powerCutsRadio = new RadioButton("Power Cuts");
        powerCutsRadio.setTextFill(Color.WHITE);
        powerCutsRadio.setFont(Font.font("Arail", FontWeight.BOLD, 18));
        powerCutsRadio.setToggleGroup(toggleGroup);

        tempRadio = new RadioButton("Temp");
        tempRadio.setTextFill(Color.WHITE);
        tempRadio.setFont(Font.font("Arail", FontWeight.BOLD, 18));
        tempRadio.setToggleGroup(toggleGroup);

        vBox2 = new VBox(5);
        vBox2.getChildren().addAll(overallDemandRadio, powerCutsRadio, tempRadio);

        HBox hBox = new HBox(35);
        hBox.setPadding(new Insets(0, 0, 30, 30));
        hBox.getChildren().addAll(vBox1, vBox2);
        hBox.setAlignment(Pos.BASELINE_LEFT);
        //hBox.setPadding(new Insets(0, 0, 0, 120));

        Image outputImg = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/deleteOutOut_%20TEst2.png");
        ImageView Img = new ImageView(outputImg);

        lblTotal = new Label();
        lblTotal.setTextFill(Color.WHITE);
        lblTotal.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16

        lblAverage = new Label();
        lblAverage.setTextFill(Color.WHITE);
        lblAverage.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16

        lblMax = new Label();
        lblMax.setTextFill(Color.WHITE);
        lblMax.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16

        lblMin = new Label();
        lblMin.setTextFill(Color.WHITE);
        lblMin.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16

        lbl = new Label();
        lbl.setAlignment(Pos.CENTER);
        lbl.setTextFill(Color.RED);
        lbl.setFont(Font.font("Arail", FontWeight.BOLD, 22));//set Font weight to bold and size 16

        lblGap = new Label();
        lblGap.setTextFill(Color.WHITE);
        lblGap.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16

        vBoxLbls = new VBox(5);
        vBoxLbls.getChildren().addAll(lbl, lblTotal, lblAverage, lblMax, lblMin, lblGap);
        vBoxLbls.setAlignment(Pos.BASELINE_LEFT);
        vBoxLbls.setPadding(new Insets(50, 50, 50, 50));

        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().addAll(Img, vBoxLbls);
        stackPane1.setPadding(new Insets(50, 50, 50, 50));
        stackPane1.setAlignment(Pos.CENTER);

        borderPane = new BorderPane();
        borderPane.setLeft(vBoxInputs);
        borderPane.setRight(stackPane1);
        //borderPane.setPadding(new Insets(50, 50, 50, 50));
        borderPane.setBottom(hBox);
        borderPane.setTop(MenuBar);

        StackPane stackPane = new StackPane();
        Image image = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/insertTest1.png");
        ImageView imageView = new ImageView(image);

        stackPane.getChildren().addAll(imageView, borderPane);

        israeliLineRadio.setOnAction(e1 -> {
            israliLineData();
        });

        gazaPowerRadio.setOnAction(e2 -> {
            gazaPowerData();
        });

        egyLineRadio.setOnAction(e3 -> {
            egyptianData();
        });

        overallDemandRadio.setOnAction(e4 -> {
            overallDemandData();
        });

        powerCutsRadio.setOnAction(e5 -> {
            powerCuts();
        });

        tempRadio.setOnAction(e6 -> {
            temp();
        });

        Scene scene = new Scene(stackPane, 1000, 600);
        searchWindow.setScene(scene);
        searchWindow.showAndWait();
    }

    public void israliLineData() {
        lblGap.setVisible(false);

        lbl.setText("                    Israeli Line\n");
        lbl.setAlignment(Pos.CENTER);
        lbl.setTextFill(Color.RED);
        lbl.setFont(Font.font("Arail", FontWeight.BOLD, 22));//set Font weight to bold and size 16
        lblAverage.setText("AVerage: ");
        lblTotal.setText("Total: ");
        lblMax.setText("Max: ");
        lblMin.setText("Min: ");
        btnDisplay.setOnAction(display -> {

            if (monthInput.getSelectionModel().getSelectedItem() == null) {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + "nun";
                lblTotal.setText("Total: " + yearList.calculateOperationOnIsraeliLine(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnIsraeliLine(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnIsraeliLine(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnIsraeliLine(date, OperationType.MINIMUM));

            } else {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem();
                lblTotal.setText("Total: " + yearList.calculateOperationOnIsraeliLine(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnIsraeliLine(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnIsraeliLine(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnIsraeliLine(date, OperationType.MINIMUM));
            }
        });
    }

    public void gazaPowerData() {
        lblGap.setVisible(false);

        lbl.setText("                    Gaza Power\n");
        lbl.setAlignment(Pos.CENTER);
        lbl.setTextFill(Color.RED);
        lbl.setFont(Font.font("Arail", FontWeight.BOLD, 22));//set Font weight to bold and size 16
        lblAverage.setText("AVerage: ");
        lblTotal.setText("Total: ");
        lblMax.setText("Max: ");
        lblMin.setText("Min: ");
        btnDisplay.setOnAction(display -> {

            if (monthInput.getSelectionModel().getSelectedItem() == null) {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + "nun";
                lblTotal.setText("Total: " + yearList.calculateOperationOnGazaPowerLine(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnGazaPowerLine(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnGazaPowerLine(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnGazaPowerLine(date, OperationType.MINIMUM));
            } else {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem()
                        + "-" + dayInput.getSelectionModel().getSelectedItem();
                lblTotal.setText("Total: " + yearList.calculateOperationOnGazaPowerLine(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnGazaPowerLine(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnGazaPowerLine(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnGazaPowerLine(date, OperationType.MINIMUM));
            }

        });

    }

    public void egyptianData() {
        lblGap.setVisible(false);

        lbl.setText("                    Egyptian Line\n");
        lbl.setAlignment(Pos.CENTER);
        lbl.setTextFill(Color.RED);
        lbl.setFont(Font.font("Arail", FontWeight.BOLD, 22));//set Font weight to bold and size 16
        lblAverage.setText("AVerage: ");
        lblTotal.setText("Total: ");
        lblMax.setText("Max: ");
        lblMin.setText("Min: ");
        btnDisplay.setOnAction(display -> {

            if (monthInput.getSelectionModel().getSelectedItem() == null) {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + "nun";
                lblTotal.setText("Total: " + yearList.calculateOperationOnEgyptianLine(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnEgyptianLine(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnEgyptianLine(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnEgyptianLine(date, OperationType.MINIMUM));
            } else {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem()
                        + "-" + dayInput.getSelectionModel().getSelectedItem();
                lblTotal.setText("Total: " + yearList.calculateOperationOnEgyptianLine(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnEgyptianLine(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnEgyptianLine(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnEgyptianLine(date, OperationType.MINIMUM));
            }

        });

    }

    public void overallDemandData() {

        lbl.setText("                    Overall Demand\n");
        lbl.setAlignment(Pos.CENTER);
        lbl.setTextFill(Color.RED);
        lbl.setFont(Font.font("Arail", FontWeight.BOLD, 22));//set Font weight to bold and size 16
        lblAverage.setText("AVerage: ");
        lblTotal.setText("Total: ");
        lblMax.setText("Max: ");
        lblMin.setText("Min: ");
        btnDisplay.setOnAction(display -> {

            if (monthInput.getSelectionModel().getSelectedItem() == null) {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + "nun";
                lblTotal.setText("Total: " + yearList.calculateOperationOnOverallDemand(date, OperationType.TOTAL));
                double ovaerAllAvg = yearList.calculateOperationOnOverallDemand(date, OperationType.AVERAGE);
                lblAverage.setText("Average: " + ovaerAllAvg);

                lblMax.setText("Max: " + yearList.calculateOperationOnOverallDemand(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnOverallDemand(date, OperationType.MINIMUM));

                double israelAVG = yearList.calculateOperationOnIsraeliLine(date, OperationType.AVERAGE);
                double gazaPowerAvg = yearList.calculateOperationOnGazaPowerLine(date, OperationType.AVERAGE);
                double egyAvg = yearList.calculateOperationOnEgyptianLine(date, OperationType.AVERAGE);

                double gap = ovaerAllAvg - (israelAVG + gazaPowerAvg + egyAvg);
                lblGap.setText("Gap : " + gap);

            } else {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem()
                        + "-" + dayInput.getSelectionModel().getSelectedItem();
                lblTotal.setText("Total: " + yearList.calculateOperationOnOverallDemand(date, OperationType.TOTAL));
                double ovaerAllAvg = yearList.calculateOperationOnOverallDemand(date, OperationType.AVERAGE);
                lblAverage.setText("AVerage: " + ovaerAllAvg);
                lblMax.setText("Max: " + yearList.calculateOperationOnOverallDemand(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnOverallDemand(date, OperationType.MINIMUM));

                double israelAVG = yearList.calculateOperationOnIsraeliLine(date, OperationType.AVERAGE);
                double gazaPowerAvg = yearList.calculateOperationOnGazaPowerLine(date, OperationType.AVERAGE);
                double egyAvg = yearList.calculateOperationOnEgyptianLine(date, OperationType.AVERAGE);

                double gap = ovaerAllAvg - (israelAVG + gazaPowerAvg + egyAvg);
                lblGap.setText("Gap : " + gap);
                lblGap.setVisible(true);
            }

        });

    }

    public void powerCuts() {
        lblGap.setVisible(false);

        lbl.setText("                    Power Cuts\n");
        lbl.setAlignment(Pos.CENTER);
        lbl.setTextFill(Color.RED);
        lbl.setFont(Font.font("Arail", FontWeight.BOLD, 22));//set Font weight to bold and size 16
        lblAverage.setText("AVerage: ");
        lblTotal.setText("Total: ");
        lblMax.setText("Max: ");
        lblMin.setText("Min: ");
        btnDisplay.setOnAction(display -> {

            if (monthInput.getSelectionModel().getSelectedItem() == null) {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + "nun";
                lblTotal.setText("Total: " + yearList.calculateOperationOnPowerCuts(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnPowerCuts(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnPowerCuts(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnPowerCuts(date, OperationType.MINIMUM));
            } else {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem()
                        + "-" + dayInput.getSelectionModel().getSelectedItem();
                lblTotal.setText("Total: " + yearList.calculateOperationOnPowerCuts(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnPowerCuts(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnPowerCuts(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnPowerCuts(date, OperationType.MINIMUM));
            }
        });

    }

    public void temp() {
        lblGap.setVisible(false);

        lbl.setText("                    Temperature\n");
        lbl.setAlignment(Pos.CENTER);
        lbl.setTextFill(Color.RED);
        lbl.setFont(Font.font("Arail", FontWeight.BOLD, 22));//set Font weight to bold and size 16
        lblAverage.setText("AVerage: ");
        lblTotal.setText("Total: ");
        lblMax.setText("Max: ");
        lblMin.setText("Min: ");
        btnDisplay.setOnAction(display -> {

            if (monthInput.getSelectionModel().getSelectedItem() == null) {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + "nun";
                lblTotal.setText("Total: " + yearList.calculateOperationOnPowerCuts(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnPowerCuts(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnPowerCuts(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnPowerCuts(date, OperationType.MINIMUM));
            } else {
                String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem()
                        + "-" + dayInput.getSelectionModel().getSelectedItem();

                lblTotal.setText("Total: " + yearList.calculateOperationOnTemp(date, OperationType.TOTAL));
                lblAverage.setText("AVerage: " + yearList.calculateOperationOnTemp(date, OperationType.AVERAGE));
                lblMax.setText("Max: " + yearList.calculateOperationOnTemp(date, OperationType.MAXIMUM));
                lblMin.setText("Min: " + yearList.calculateOperationOnTemp(date, OperationType.MINIMUM));
            }

        });

    }
    
    public void printRevers(){
        Stage stage = new Stage();
        stage.setTitle("Revered data");
        
        TextArea txtArea = new TextArea();
        txtArea.setMinWidth(400);
        txtArea.setMinHeight(400);
        Button btnReverse = new Button("Reverse");
        
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(txtArea,btnReverse);
        vBox.setAlignment(Pos.CENTER);
        
        btnReverse.setOnAction(event ->{
            txtArea.setText("");
            yearList.reverseData();
            txtArea.appendText(""+yearList.display());
        });
        
        Scene scene = new Scene(vBox,450,450);
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    public void clearInputs() {
        yearInput.setValue(null);
        monthInput.setValue(null);
        dayInput.setValue(null);
        lblOutPut.setText(""); // Clear any previous output text
        toggleGroup.selectToggle(null); // Clear the selected toggle in the radio buttons

        // Clear labels
        lblTotal.setText("");
        lblAverage.setText("");
        lblMax.setText("");
        lblMin.setText("");
        lbl.setText("");

    }

}
