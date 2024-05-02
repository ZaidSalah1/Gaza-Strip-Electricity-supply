package Windows;

import static Windows.Main.yearList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


//A User interface for seach for data in linked list 
public class SearchWindow implements EventHandler<ActionEvent> {

    private ComboBox<String> monthInput, dayInput;
    private ComboBox<Integer> yearInput;
    private TextArea txtArea;
    private Button searchBtn;

    private Stage searchWindow;

    private MenuBar MenuBar;
    private Menu menu;
    private MenuItem clareInputs;

    @Override
    public void handle(ActionEvent event) {
        searchWindow = new Stage();
        searchWindow.setTitle("Search");

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
        yearInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        yearInput.setMinHeight(70);
        yearInput.setMinWidth(200);

        monthInput = new ComboBox<>();
        monthInput.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        monthInput.setPromptText("Select Month");
        monthInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        monthInput.setMinHeight(70);
        monthInput.setMinWidth(200);

        dayInput = new ComboBox<>();
        dayInput.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        dayInput.setPromptText("Select Day");
        dayInput.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size:15px");
        dayInput.setMinHeight(70);
        dayInput.setMinWidth(200);

        VBox vBoxInputs = new VBox(10);
        vBoxInputs.getChildren().addAll(yearInput, monthInput, dayInput);
        vBoxInputs.setAlignment(Pos.CENTER);
        vBoxInputs.setPadding(new Insets(50, 50, 50, 100));

        txtArea = new TextArea();
        txtArea.setPrefHeight(350); // Set preferred height
        txtArea.setPrefWidth(450);  // Set preferred width
        txtArea.setStyle("-fx-font-size: 18; -fx-font-family: 'italic'");

        searchBtn = new Button("Search");
        searchBtn.setStyle("-fx-background-color: #0661d2; -fx-text-fill: white");
        searchBtn.setFont(Font.font("Arail", FontWeight.BOLD, 20));
        searchBtn.setMinWidth(170);

        VBox vBoxRight = new VBox(2);
        vBoxRight.setPadding(new Insets(0, 50, 0, 0));
        vBoxRight.getChildren().addAll(txtArea, searchBtn);
        vBoxRight.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vBoxInputs);
        borderPane.setRight(vBoxRight);
        //borderPane.setPadding(new Insets(70, 50, 50, 50));
        borderPane.setTop(MenuBar);
        
        
        Image image = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/searchTest1.png");
        ImageView imageView = new ImageView(image);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, borderPane);

        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    txtArea.setText("");
                    String year = "" + yearInput.getSelectionModel().getSelectedItem();
                    int yearInteger = Integer.parseInt(year);
                    String day = dayInput.getSelectionModel().getSelectedItem();
                    if (monthInput.getSelectionModel().getSelectedItem() == null && dayInput.getSelectionModel().getSelectedItem() == null) {
                        txtArea.appendText("" + yearList.searchByYear(yearInput.getSelectionModel().getSelectedItem()));
                    } else if (dayInput.getSelectionModel().getSelectedItem() == null) {
                        txtArea.appendText("" + yearList.searchYearMonth(yearInteger, monthInput.getSelectionModel().getSelectedItem()));
                    } else {
                        txtArea.appendText("" + yearList.searchDayData(year + "-" + monthInput.getSelectionModel().getSelectedItem() + "-" + day));
                    }

                    if (txtArea.getText().isEmpty()) {
                        nothingFound();
                    }
                } catch (Exception ex) {
                    emptyAlert();
                }

            }
        });
        Scene scene = new Scene(stackPane, 1000, 600);
        searchWindow.setScene(scene);
        searchWindow.showAndWait();

    }

    public String monthStringToNumber(String month) {
        String monthNumber = "";
        switch (month) {
            case "Jan":
                monthNumber = "01";
                break;

            case "Feb":
                monthNumber = "02";
                break;

            case "Mar":
                monthNumber = "03";
                break;

            case "Apr":
                monthNumber = "04";
                break;

            case "May":
                monthNumber = "05";
                break;

            case "Jun":
                monthNumber = "06";
                break;

            case "Jul":
                monthNumber = "07";
                break;

            case "Aug":
                monthNumber = "08";
                break;

            case "Sep":
                monthNumber = "09";
                break;

            case "Oct":
                monthNumber = "10";
                break;

            case "Nov":
                monthNumber = "11";
                break;

            case "Dec":
                monthNumber = "12";
                break;

        }
        return monthNumber;
    }

    private void emptyAlert() {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("Please select at least one option before initiating the search.");

        // Show the alert
        alert.showAndWait();
    }

    private void nothingFound() {
        // Create an alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("Nothing Found in this date");

        // Show the alert
        alert.showAndWait();
    }

    public void clearInputs() {
        yearInput.setValue(null);
        monthInput.setValue(null);
        dayInput.setValue(null);
        txtArea.setText("");
    }
}
