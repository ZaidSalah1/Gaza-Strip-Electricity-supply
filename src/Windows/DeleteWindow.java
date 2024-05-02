package Windows;

import static Windows.Main.yearList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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

//A User interface for delete data in the linked list
public class DeleteWindow implements EventHandler<ActionEvent> {

    private ComboBox<String> monthInput, dayInput;
    private ComboBox<Integer> yearInput;
    private Button btnDelete;
    private Stage searchWindow;
    private Label lblOutPut;

    private MenuBar MenuBar;
    private Menu menu;
    private MenuItem clareInputs;

    @Override
    public void handle(ActionEvent event) {
        searchWindow = new Stage();
        searchWindow.setTitle("Delete");

        MenuBar = new MenuBar();
        menu = new Menu("More");
        MenuBar.getMenus().add(menu);
        // MenuBar.setPadding(new Insets(20, 0, 0, 0));
        MenuBar.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:13px");
        clareInputs = new MenuItem("Clear Inputs");
        clareInputs.setOnAction(insrt -> clearInputs());
        menu.getItems().addAll(clareInputs);

        yearInput = new ComboBox<>();
        yearInput.getItems().addAll(yearList.getYears());
        yearInput.setPromptText("Select Year");
        yearInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px;");

        yearInput.setMinHeight(50);
        yearInput.setMinWidth(200);

        monthInput = new ComboBox<>();
        monthInput.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        monthInput.setPromptText("Select Month");
        monthInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px;");
        monthInput.setMinHeight(50);
        monthInput.setMinWidth(200);

        dayInput = new ComboBox<>();
        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        dayInput.setPromptText("Select Day");
        dayInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px;");
        dayInput.setMinHeight(50);
        dayInput.setMinWidth(200);

        Label lbl1 = new Label("*");
        Label lbl2 = new Label("*");
        Label lbl3 = new Label("*");
        VBox vBox = new VBox();
        vBox.getChildren().addAll(lbl1, lbl2, lbl3);

        btnDelete = new Button("Delete");
        btnDelete.setMinWidth(200);
        btnDelete.setMinHeight(50);
        btnDelete.setStyle("-fx-background-color: #14b1e2; -fx-text-fill: white");
        btnDelete.setFont(Font.font("Arail", FontWeight.BOLD, 20));

        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (yearInput.getSelectionModel().getSelectedItem() != null) {
                    areYouSureToDeleteAlert();
                }
            }
        });

        VBox vBoxInputs = new VBox(10);
        vBoxInputs.getChildren().addAll(yearInput, monthInput, dayInput, btnDelete);
        vBoxInputs.setAlignment(Pos.CENTER);
        vBoxInputs.setPadding(new Insets(50, 50, 50, 100));

        lblOutPut = new Label();
        lblOutPut.setTextFill(Color.WHITE);
        lblOutPut.setFont(Font.font("Arail", FontWeight.BOLD, 20));//set Font weight to bold and size 16
        lblOutPut.setAlignment(Pos.CENTER);

        Image outputImg = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/deleteOutOut_%20TEst2.png");
        ImageView Img = new ImageView(outputImg);

        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().addAll(Img, lblOutPut);
        stackPane1.setPadding(new Insets(50, 50, 50, 50));
        stackPane1.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vBoxInputs);
        borderPane.setRight(stackPane1);
        borderPane.setTop(MenuBar);
        
        
        StackPane stackPane = new StackPane();
        Image image = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/deleteTest2.png");
        ImageView imageView = new ImageView(image);

        stackPane.getChildren().addAll(imageView, borderPane);

        monthInput.setOnAction(e -> {

            try {
                String selectedMonth = monthInput.getValue();
                int year = yearInput.getValue();
                dayInput.getItems().clear();
                if (selectedMonth.equals("Feb") && isLeapYear(year) == true) {
                    dayInput.getItems().clear(); // Clear previous items
                    dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29");
                } else {
                    if (selectedMonth.equals("Jan")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                    } else if (selectedMonth.equals("Feb")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28");
                    } else if (selectedMonth.equals("Mar")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                    } else if (selectedMonth.equals("Apr")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                    } else if (selectedMonth.equals("May")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                    } else if (selectedMonth.equals("Jun")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                    } else if (selectedMonth.equals("Jul")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                    } else if (selectedMonth.equals("Aug")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                    } else if (selectedMonth.equals("Sep")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                    } else if (selectedMonth.equals("Oct")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                    } else if (selectedMonth.equals("Nov")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30");
                    } else if (selectedMonth.equals("Dec")) {
                        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        });

        Scene scene = new Scene(stackPane, 1000, 600);
        searchWindow.setScene(scene);
        searchWindow.showAndWait();

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

    private void areYouSureToDeleteAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("This action will permanently delete the selected data. Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        // Check if the OK button is pressed

        String date = yearInput.getSelectionModel().getSelectedItem() + "-" + monthInput.getSelectionModel().getSelectedItem()
                + "-" + dayInput.getSelectionModel().getSelectedItem();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (monthInput.getSelectionModel().getSelectedItem() == null && dayInput.getSelectionModel().getSelectedItem() == null) {
                if (yearList.deleteYear(yearInput.getSelectionModel().getSelectedItem()) == true) {
                    lblOutPut.setText("Data deleted successfully.");
                } else {
                    lblOutPut.setText("Data deletion failed or data does not exist.");
                }
            } else if (dayInput.getSelectionModel().getSelectedItem() == null) {
                if (yearList.deleteMonthData(yearInput.getSelectionModel().getSelectedItem(), monthInput.getSelectionModel().getSelectedItem()) == true) {
                    lblOutPut.setText("Data deleted successfully.");
                } else {
                    lblOutPut.setText("Data deletion failed or data does not exist.");
                }
            } else {
                if (yearList.deleteMonthDay(date) == true) {
                    lblOutPut.setText("Data deleted successfully.");
                } else {
                    lblOutPut.setText("Data deletion failed or data does not exist.");
                }

            }
        }
    }
    
     public void clearInputs() {
        yearInput.setValue(null);
        monthInput.setValue(null);
        dayInput.setValue(null);
        lblOutPut.setText(""); // Clear any previous output text
        
    }

}
