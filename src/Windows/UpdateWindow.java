package Windows;

import Windows.UpdateDate;
import static Windows.Main.monthNumberToStringName;
import static Windows.Main.yearList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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

//A user interface for updating data in the linked list 
public class UpdateWindow implements EventHandler<ActionEvent> {

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
    private MenuBar MenuBar;
    private Menu menu;
    private MenuItem clareInputs;

    @Override
    public void handle(ActionEvent event) {
        updateWindow = new Stage();
        updateWindow.setTitle("Update");

        MenuBar = new MenuBar();
        menu = new Menu("More");
        MenuBar.getMenus().add(menu);
        // MenuBar.setPadding(new Insets(20, 0, 0, 0));
        MenuBar.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:13px");
        clareInputs = new MenuItem("Clear Inputs");
        clareInputs.setOnAction(insrt -> clearInputs());
        menu.getItems().addAll(clareInputs);

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

        changeYear = new RadioButton("Change Year");
        changeYear.setTextFill(Color.WHITE);
        changeYear.setFont(Font.font("Arail", FontWeight.BOLD, 18));
        changeYear.setToggleGroup(toggleGroup);

        vBox1 = new VBox(5);
        vBox1.getChildren().addAll(israeliLineRadio, gazaPowerRadio, egyLineRadio, changeYear);

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

        changeDate = new RadioButton("Change Date");
        changeDate.setTextFill(Color.WHITE);
        changeDate.setFont(Font.font("Arail", FontWeight.BOLD, 18));
        changeDate.setToggleGroup(toggleGroup);

        vBox2 = new VBox(5);
        vBox2.getChildren().addAll(overallDemandRadio, powerCutsRadio, tempRadio, changeDate);

        HBox hBox = new HBox(35);
        hBox.getChildren().addAll(vBox1, vBox2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(270, 10, 10, 10));
        Image outputImg = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/update%20reaio%20buttons.png");
        ImageView img = new ImageView(outputImg);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

        lblOutPut = new Label("OUT PUT");
        lblOutPut.setText("Data deleted successfully.");
        lblOutPut.setTextFill(Color.RED);
        lblOutPut.setFont(Font.font("Arail", FontWeight.BOLD, 30));//set Font weight to bold and size 16
        lblOutPut.setAlignment(Pos.CENTER);

        lblMsgYear = new Label("*");
        lblMsgYear.setTextFill(Color.RED);
        lblMsgYear.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16
        lblMsgYear.setVisible(false);

        lblMsgMonth = new Label("*");
        lblMsgMonth.setTextFill(Color.RED);
        lblMsgMonth.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16
        lblMsgMonth.setVisible(false);

        lblMsgDay = new Label("*");
        lblMsgDay.setTextFill(Color.RED);
        lblMsgDay.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16
        lblMsgDay.setVisible(false);

        lblMsgInput = new Label("*");
        lblMsgInput.setTextFill(Color.RED);
        lblMsgInput.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16
        lblMsgInput.setVisible(false);

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

        gridPane.add(lblMsgInput, 1, 4);

        gridPane.add(updateBtn, 0, 5);

        StackPane stackPane = new StackPane();
        // stackPane.setPadding(new Insets(250, 10, 10, 10));
        stackPane.getChildren().addAll(img, hBox);

        VBox vBoxRight = new VBox(10);
        vBoxRight.getChildren().addAll(lblOutPut, stackPane);

        borderPane = new BorderPane();
        borderPane.setRight(stackPane);
        borderPane.setLeft(gridPane);
        borderPane.setTop(MenuBar);

        Image image = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/updateTest1.png");
        ImageView imageView = new ImageView(image);

        StackPane stackPane2 = new StackPane();
        stackPane2.getChildren().addAll(imageView, borderPane);

        try {
            israeliLineRadio.setOnAction(event1 -> {
                israeliLine();
            });

            gazaPowerRadio.setOnAction(event2 -> {
                gazaLine();
            });

            egyLineRadio.setOnAction(event3 -> egyptionLine());

            overallDemandRadio.setOnAction(event5 -> overallDemand());

            powerCutsRadio.setOnAction(event6 -> powerCuts());

            tempRadio.setOnAction(event7 -> temp());

            changeYear.setOnAction(event8 -> {
                changeYear();
            });

            changeDate.setOnAction(new UpdateDate());
        } catch (Exception ex) {
            errorAlert();
        }

        Scene scene = new Scene(stackPane2, 1000, 600);
        updateWindow.setScene(scene);
        updateWindow.showAndWait();
    }

    public void israeliLine() {
        txtInputIsraeliLine = new TextField();
        txtInputIsraeliLine.setPromptText("Enter new Israeli line Data");
        txtInputIsraeliLine.setPrefHeight(50); // Set preferred height
        txtInputIsraeliLine.setPrefWidth(200);

        lblIsraeliLines = new Label("Israeli Line: ");
        lblIsraeliLines.setTextFill(Color.WHITE);
        lblIsraeliLines.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16

        gridPane.getChildren().clear();

        gridPane.add(yearInput, 0, 1);
        gridPane.add(lblMsgYear, 1, 1);

        gridPane.add(monthInput, 0, 2);
        gridPane.add(lblMsgMonth, 1, 2);

        gridPane.add(dayInput, 0, 3);
        gridPane.add(lblMsgDay, 1, 3);

        gridPane.add(lblMsgInput, 1, 4);

        gridPane.add(lblIsraeliLines, 0, 0);
        gridPane.add(txtInputIsraeliLine, 0, 4);

        gridPane.add(updateBtn, 0, 5);

        borderPane.setLeft(gridPane);

        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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

                if (txtInputIsraeliLine.getText().isEmpty()) {
                    lblMsgInput.setVisible(true);
                } else {
                    lblMsgInput.setVisible(false);
                }

                if (yearInput.getSelectionModel().getSelectedItem() != null && monthInput.getSelectionModel().getSelectedItem() != null
                        && dayInput.getSelectionModel().getSelectedItem() != null && !txtInputIsraeliLine.getText().isEmpty()) {
                    String date = yearInput.getSelectionModel().getSelectedItem() + "-"
                            + monthInput.getSelectionModel().getSelectedItem() + "-" + dayInput.getSelectionModel().getSelectedItem();
                    if (yearList.isDateEmpty(date)) {
                        if (areYouSureAlert() == true) {
                            yearList.updateIsraeliLine(date, Integer.parseInt(txtInputIsraeliLine.getText()));
                            updatedSuccssfully();
                        }
                    } else {
                        noDataInThisDateAlert();
                    }
                }

            }
        });
    }

    public void gazaLine() {
        txtInputGazaPower = new TextField();
        txtInputGazaPower.setPrefHeight(50); // Set preferred height
        txtInputGazaPower.setPrefWidth(200);
        txtInputGazaPower.setPromptText("Enter new Gaza Power Data");

        lblGazaPower = new Label("Gaza Power");
        lblGazaPower.setTextFill(Color.WHITE);
        lblGazaPower.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16

        gridPane.getChildren().clear();

        gridPane.add(yearInput, 0, 1);
        gridPane.add(lblMsgYear, 1, 1);

        gridPane.add(monthInput, 0, 2);
        gridPane.add(lblMsgMonth, 1, 2);

        gridPane.add(dayInput, 0, 3);
        gridPane.add(lblMsgDay, 1, 3);

        gridPane.add(lblMsgInput, 1, 4);

        gridPane.add(updateBtn, 0, 5);

        gridPane.add(lblGazaPower, 0, 0);
        gridPane.add(txtInputGazaPower, 0, 4);

        borderPane.setLeft(gridPane);

        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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

                if (txtInputGazaPower.getText().isEmpty()) {
                    lblMsgInput.setVisible(true);
                } else {
                    lblMsgInput.setVisible(false);
                }

                if (yearInput.getSelectionModel().getSelectedItem() != null && monthInput.getSelectionModel().getSelectedItem() != null
                        && dayInput.getSelectionModel().getSelectedItem() != null && !txtInputGazaPower.getText().isEmpty()) {
                    String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem() + "-" + dayInput.getSelectionModel().getSelectedItem();
                    if (yearList.isDateEmpty(date)) {
                        if (areYouSureAlert() == true) {
                            yearList.updateGazaPower(date, Integer.parseInt(txtInputGazaPower.getText()));
                            updatedSuccssfully();
                        }
                    } else {
                        noDataInThisDateAlert();
                    }

                }

            }
        });

    }

    public void egyptionLine() {
        lblEgyLines = new Label("Egyption Line");
        lblEgyLines.setTextFill(Color.WHITE);
        lblEgyLines.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16

        txtInputEgyLines = new TextField();
        txtInputEgyLines.setPromptText("Enter new Egyption Line data");
        txtInputEgyLines.setPrefHeight(50); // Set preferred height
        txtInputEgyLines.setPrefWidth(200);

        gridPane.getChildren().clear();

        gridPane.add(yearInput, 0, 1);
        gridPane.add(lblMsgYear, 1, 1);

        gridPane.add(monthInput, 0, 2);
        gridPane.add(lblMsgMonth, 1, 2);

        gridPane.add(dayInput, 0, 3);
        gridPane.add(lblMsgDay, 1, 3);

        gridPane.add(lblMsgInput, 1, 4);

        gridPane.add(updateBtn, 0, 5);

        gridPane.add(lblEgyLines, 0, 0);
        gridPane.add(txtInputEgyLines, 0, 4);

        borderPane.setLeft(gridPane);

        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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

                if (txtInputEgyLines.getText().isEmpty()) {
                    lblMsgInput.setVisible(true);
                } else {
                    lblMsgInput.setVisible(false);
                }

                if (yearInput.getSelectionModel().getSelectedItem() != null && monthInput.getSelectionModel().getSelectedItem() != null
                        && dayInput.getSelectionModel().getSelectedItem() != null && !txtInputEgyLines.getText().isEmpty()) {
                    String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem() + "-" + dayInput.getSelectionModel().getSelectedItem();
                    if (yearList.isDateEmpty(date)) {
                        if (areYouSureAlert() == true) {
                            yearList.updateEgyptianLine(date, Integer.parseInt(txtInputEgyLines.getText()));
                            updatedSuccssfully();
                        }
                    } else {
                        noDataInThisDateAlert();
                    }
                }

            }
        });
    }

    public void overallDemand() {
        lblOverallDemand = new Label("Overall demand: ");
        lblOverallDemand.setTextFill(Color.WHITE);
        lblOverallDemand.setFont(Font.font("Arail", FontWeight.BOLD, 18));//set Font weight to bold and size 16

        txtInputOverallDemand = new TextField();
        txtInputOverallDemand.setPromptText("Enter new Overall Demand data");
        txtInputOverallDemand.setPrefHeight(50); // Set preferred height
        txtInputOverallDemand.setPrefWidth(200);

        gridPane.getChildren().clear();

        gridPane.add(yearInput, 0, 1);
        gridPane.add(lblMsgYear, 1, 1);

        gridPane.add(monthInput, 0, 2);
        gridPane.add(lblMsgMonth, 1, 2);

        gridPane.add(dayInput, 0, 3);
        gridPane.add(lblMsgDay, 1, 3);

        gridPane.add(lblMsgInput, 1, 4);

        gridPane.add(lblOverallDemand, 0, 0);
        gridPane.add(txtInputOverallDemand, 0, 4);
        gridPane.add(updateBtn, 0, 5);

        borderPane.setLeft(gridPane);

        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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

                if (txtInputOverallDemand.getText().isEmpty()) {
                    lblMsgInput.setVisible(true);
                } else {
                    lblMsgInput.setVisible(false);
                }

                if (yearInput.getSelectionModel().getSelectedItem() != null && monthInput.getSelectionModel().getSelectedItem() != null
                        && dayInput.getSelectionModel().getSelectedItem() != null && !txtInputOverallDemand.getText().isEmpty()) {
                    String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem() + "-" + dayInput.getSelectionModel().getSelectedItem();
                    if (yearList.isDateEmpty(date)) {
                        if (areYouSureAlert() == true) {
                            yearList.updateOverallDemand(date, Integer.parseInt(txtInputOverallDemand.getText()));
                            updatedSuccssfully();
                        }
                    } else {
                        noDataInThisDateAlert();
                    }
                }
            }
        });
    }

    public void powerCuts() {
        lblPowerCuts = new Label("Power Cuts: ");
        lblPowerCuts.setTextFill(Color.WHITE);
        lblPowerCuts.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        txtInputPowerCuts = new TextField();
        txtInputPowerCuts.setPromptText("Enter new Power cuts data");
        txtInputPowerCuts.setPrefHeight(50);
        txtInputPowerCuts.setPrefWidth(200);

        gridPane.getChildren().clear();

        gridPane.add(yearInput, 0, 1);
        gridPane.add(lblMsgYear, 1, 1);

        gridPane.add(monthInput, 0, 2);
        gridPane.add(lblMsgMonth, 1, 2);

        gridPane.add(dayInput, 0, 3);
        gridPane.add(lblMsgDay, 1, 3);

        gridPane.add(lblMsgInput, 1, 4);

        gridPane.add(updateBtn, 0, 5);

        gridPane.add(lblPowerCuts, 0, 0);
        gridPane.add(txtInputPowerCuts, 0, 4);

        borderPane.setLeft(gridPane);

        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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

                if (txtInputPowerCuts.getText().isEmpty()) {
                    lblMsgInput.setVisible(true);
                } else {
                    lblMsgInput.setVisible(false);
                }

                if (yearInput.getSelectionModel().getSelectedItem() != null && monthInput.getSelectionModel().getSelectedItem() != null
                        && dayInput.getSelectionModel().getSelectedItem() != null && !txtInputPowerCuts.getText().isEmpty()) {
                    String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem() + "-" + dayInput.getSelectionModel().getSelectedItem();
                    if (yearList.isDateEmpty(date)) {
                        if (areYouSureAlert() == true) {
                            yearList.updatePowerCuts(date, Integer.parseInt(txtInputPowerCuts.getText()));
                            updatedSuccssfully();
                        }
                    } else {
                        noDataInThisDateAlert();
                    }
                }
            }
        });
    }

    public void temp() {
        lblTemp = new Label("Temp: ");
        lblTemp.setTextFill(Color.WHITE);
        lblTemp.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        txtInputTemp = new TextField();
        txtInputTemp.setPromptText("Enter new Temperature data");
        txtInputTemp.setPrefHeight(50);
        txtInputTemp.setPrefWidth(200);

        gridPane.getChildren().clear();

        gridPane.add(yearInput, 0, 1);
        gridPane.add(lblMsgYear, 1, 1);

        gridPane.add(monthInput, 0, 2);
        gridPane.add(lblMsgMonth, 1, 2);

        gridPane.add(dayInput, 0, 3);
        gridPane.add(lblMsgDay, 1, 3);

        gridPane.add(lblMsgInput, 1, 4);

        gridPane.add(updateBtn, 0, 5);

        gridPane.add(lblTemp, 0, 0);
        gridPane.add(txtInputTemp, 0, 4);

        borderPane.setLeft(gridPane);

        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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

                if (txtInputTemp.getText().isEmpty()) {
                    lblMsgInput.setVisible(true);
                } else {
                    lblMsgInput.setVisible(false);
                }

                if (yearInput.getSelectionModel().getSelectedItem() != null && monthInput.getSelectionModel().getSelectedItem() != null
                        && dayInput.getSelectionModel().getSelectedItem() != null && !txtInputTemp.getText().isEmpty()) {
                    String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem() + "-" + dayInput.getSelectionModel().getSelectedItem();
                    if (yearList.isDateEmpty(date)) {
                        if (areYouSureAlert() == true) {
                            yearList.updateTemp(date, Integer.parseInt(txtInputTemp.getText()));
                            updatedSuccssfully();
                        }
                    } else {
                        noDataInThisDateAlert();
                    }
                }
            }
        });
    }

    public void changeYear() {
        lblChangeYear = new Label("Change Year: ");
        lblChangeYear.setTextFill(Color.WHITE);
        lblChangeYear.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        txtInputNewYear = new TextField();
        txtInputNewYear.setPromptText("Enter Year to change to it");
        txtInputNewYear.setPrefHeight(50);
        txtInputNewYear.setPrefWidth(200);

        gridPane.getChildren().clear();

        gridPane.add(yearInput, 0, 1);
        gridPane.add(lblMsgYear, 1, 1);
        gridPane.add(lblChangeYear, 0, 0);
        gridPane.add(txtInputNewYear, 0, 2);
        gridPane.add(lblMsgInput, 1, 2);
        gridPane.add(updateBtn, 0, 3);

        borderPane.setLeft(gridPane);

        updateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (yearInput.getSelectionModel().getSelectedItem() == null) {
                    lblMsgYear.setVisible(true);
                } else {
                    lblMsgYear.setVisible(false);
                }

                if (txtInputNewYear.getText().isEmpty()) {
                    lblMsgInput.setVisible(true);
                } else {
                    lblMsgInput.setVisible(false);
                }

                if (yearInput.getSelectionModel().getSelectedItem() != null && !txtInputNewYear.getText().isEmpty()) {
                    if (areYouSureAlert() == true) {
                        if (yearList.isYearExist(Integer.parseInt(txtInputNewYear.getText()))) {
                            yearIsAlreadyExist();
                        } else {
                            yearList.updateYear(yearInput.getSelectionModel().getSelectedItem(), Integer.parseInt(txtInputNewYear.getText()));
                            updatedSuccssfully();
                        }
                    }
                }
            }
        });
    }

    public boolean areYouSureAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to update this data");

        // Show the alert and wait for the user's response
        Optional<ButtonType> result = alert.showAndWait();

        // Check if the OK button is pressed
        if (result.isPresent() && result.get() == ButtonType.OK) {
            return true; // User pressed OK
        } else {
            return false; // User pressed Cancel or closed the dialog
        }
    }

    public void noDataInThisDateAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText("No Data Found in This Date");
        alert.showAndWait();

    }

    public void yearIsAlreadyExist() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText("This year is already exists");
        alert.showAndWait();

    }

    public void updatedSuccssfully() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Data Updated Succssfully");
        alert.showAndWait();

    }

    public void clearInputs() {
        yearInput.setValue(null);
        monthInput.setValue(null);
        dayInput.setValue(null);

        // Clear the selected toggle in the radio buttons
        toggleGroup.selectToggle(null);
    }

    private void errorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("          Oops! Something went wrong with the inputs. "
                + "Please double-check and make sure all fields are filled correctly.");

        // Show the alert and wait for the user's response
        alert.showAndWait();
    }
}
