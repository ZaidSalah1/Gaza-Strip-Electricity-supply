package Windows;

import Windows.UpdateWindow;
import LinkedList.Years;
import Windows.SearchWindow;
import Windows.InsertionWindow;
import Windows.YearAcrossMenu;
import Windows.DeleteWindow;
import Windows.MonthAcrossMenu;
import Windows.StatisticDataScreen;
import Windows.DayAcrossMenu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

    public static Years yearList = new Years();
    private File openedFile;
    private boolean isOpened = false;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1280, 720);
        Button btnInsert = new Button("Insertion");
        btnInsert.setPrefHeight(40);//set Height to 40
        btnInsert.setPrefWidth(90);//set Width to 80
        btnInsert.setStyle("-fx-background-color: #4b77f0; -fx-text-fill: white");//Change Back ground color and text color for button
        btnInsert.setFont(Font.font("Arail", FontWeight.BOLD, 16));//set Font weight to bold and size 16
        btnInsert.setOnAction(new InsertionWindow());//Open Insert Window

        Button btnDelete = new Button("Deletion");
        btnDelete.setPrefHeight(40);//set Height to 40
        btnDelete.setPrefWidth(90);//set Width to 80
        btnDelete.setStyle("-fx-background-color: #4b77f0; -fx-text-fill: white");//Change Back ground color and text color for button
        btnDelete.setFont(Font.font("Arail", FontWeight.BOLD, 16));//set Font weight to bold and size 16
        btnDelete.setOnAction(new DeleteWindow());//Open Delete Window

        Button btnSearch = new Button("Search");
        btnSearch.setPrefHeight(40);//set Height to 40
        btnSearch.setPrefWidth(90);//set Width to 80
        btnSearch.setStyle("-fx-background-color: #4b77f0; -fx-text-fill: white");//Change Back ground color and text color for button
        btnSearch.setFont(Font.font("Arail", FontWeight.BOLD, 16));//set Font weight to bold and size 16
        btnSearch.setOnAction(new SearchWindow());//Open SearchWindow Window

        Button btnRate = new Button("Statistics");
        btnRate.setPrefHeight(40);//set Height to 40
        btnRate.setPrefWidth(90);//set Width to 80
        btnRate.setStyle("-fx-background-color: #4b77f0; -fx-text-fill: white");//Change Back ground color and text color for button
        btnRate.setFont(Font.font("Arail", FontWeight.BOLD, 16));//set Font weight to bold and size 16
        btnRate.setOnAction(new StatisticDataScreen());//Open Table Window

        Button btnUpdate = new Button("Update");
        btnUpdate.setPrefHeight(40);//set Height to 40
        btnUpdate.setPrefWidth(90);//set Width to 80
        btnUpdate.setStyle("-fx-background-color: #4b77f0; -fx-text-fill: white");//Change Back ground color and text color for button
        btnUpdate.setFont(Font.font("Arail", FontWeight.BOLD, 16));//set Font weight to bold and size 16
        btnUpdate.setOnAction(event -> new UpdateWindow().handle(event));

        HBox hBox = new HBox(10);// H Gab = 10
        hBox.getChildren().addAll(btnInsert, btnDelete, btnUpdate, btnSearch, btnRate);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setPadding(new Insets(140, 140, 140, 140));

        Image image = new Image("file:///C:/Users/zaid7/OneDrive/سطح%20المكتب/Gaza%20projct/Main%20image.png");
        ImageView imageView = new ImageView(image);
        imageView.fitWidthProperty().bind(scene.widthProperty());//fit Width
        imageView.fitHeightProperty().bind(scene.heightProperty());//fit Height      
        root.setCenter(imageView);//set the image in the center

        // Create menu bar
        MenuBar menuBar = new MenuBar();//Menu Bar
        //menuBar.setStyle("-fx-background-color: #607378;");
        menuBar.setStyle("-fx-text-fill: white; -fx-font-family: 'Arial'; -fx-font-size: 14px;");
        Menu mangementMenu = new Menu("Mangement");// Mneu
        Menu statisticsMenu = new Menu("Statistics");// Mneu
        Menu fileMenu = new Menu("File");// Mneu

        //fileMenu.setStyle("-fx-background-color: #d43d4a;");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        saveMenuItem.setOnAction(event -> SaveToFile(primaryStage));

        MenuItem saveBackMenuItem = new MenuItem("Save Back");
        saveBackMenuItem.setOnAction(event -> saveBack());

        openMenuItem.setOnAction(e -> openFile(primaryStage));

        MenuItem insertMenuItem = new MenuItem("Insertion");
        insertMenuItem.setOnAction(new InsertionWindow());

        MenuItem deleteMenuItem = new MenuItem("Deletion");
        deleteMenuItem.setOnAction(new DeleteWindow());

        MenuItem searchMenuItem = new MenuItem("Search");
        searchMenuItem.setOnAction(new SearchWindow());

        MenuItem displayMenuItem = new MenuItem("Update");
        displayMenuItem.setOnAction(new UpdateWindow());

        // saveMenuItem.setOnAction(event -> SaveToFile(primaryStage));
        mangementMenu.getItems().addAll(insertMenuItem, deleteMenuItem, searchMenuItem, displayMenuItem);

        MenuItem dayAcross = new MenuItem("statistic for a given day across all months and years");
        dayAcross.setOnAction(new DayAcrossMenu());

        MenuItem monthAcross = new MenuItem("statistic for a given month across all days and years ");
        monthAcross.setOnAction(new MonthAcrossMenu());

        MenuItem yearAcross = new MenuItem("statistic for a given year across all days and months ");
        yearAcross.setOnAction(new YearAcrossMenu());

        MenuItem m4 = new MenuItem("Statistic for all data");
        m4.setOnAction(event -> new StatisticDataScreen().handle(event));

        statisticsMenu.getItems().addAll(dayAcross, monthAcross, yearAcross, m4);
        fileMenu.getItems().addAll(openMenuItem, saveMenuItem, saveBackMenuItem);
        menuBar.getMenus().addAll(fileMenu, mangementMenu, statisticsMenu);

        root.setTop(menuBar);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(imageView, hBox);
        root.setCenter(stackPane);

        primaryStage.setTitle("Internet Usage Records");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openFile(Stage primaryStage) {//This Method to open and read the file and insert the data in the array

        if (isOpened == true) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            // alert.setTitle("Information Dialog");
            alert.setHeaderText(null); // No header text
            alert.setContentText("Opening a new file will automatically save the current data. Are you sure?");

            // Show the alert and wait for the user's response
            Optional<ButtonType> result = alert.showAndWait();

            // Check if the OK button is pressed
            if (result.isPresent() && result.get() == ButtonType.OK) {
                saveBack();
                yearList.deleteAllData();
            } else {
                // User clicked Cancel, stop the method
                return;
            }
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(primaryStage);

        try ( Scanner reader = new Scanner(file);) {
            isOpened = true;
            boolean firstLine = true;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (firstLine == true) {
                    firstLine = false;
                    continue;
                }

                String data[] = line.split(",");

                String date = data[0];
                String tmp[] = date.split("-");
                int year = Integer.parseInt(tmp[0]);
                String month = tmp[1];
                String monthName = monthNumberToStringName(month);

                double Israeli_Lines = Double.parseDouble(data[1]);
                double Gaza_Power = Double.parseDouble(data[2]);
                double Egyptian_Lines = Double.parseDouble(data[3]);
                double daily_Supply = Double.parseDouble(data[4]);
                double Overall_demand = Double.parseDouble(data[5]);
                double Power_Cuts = Double.parseDouble(data[6]);
                double Temp = Double.parseDouble(data[7]);

                if (yearList.isYearExist(year) == true) {
                    yearList.insertDayData(year, monthName, date, Israeli_Lines, Gaza_Power, Egyptian_Lines, daily_Supply, Overall_demand, Power_Cuts, Temp);
                } else {
                    yearList.insertYear(year);
                    yearList.insertDayData(year, monthName, date, Israeli_Lines, Gaza_Power, Egyptian_Lines, daily_Supply, Overall_demand, Power_Cuts, Temp);
                }
            }
            showAlertAfterReadingFile();
            reader.close();
            openedFile = file;
        } catch (Exception ex) {
            showAlertWrning();
        }
    }

    public void saveBack() {
        if (openedFile != null) {
            try ( BufferedWriter writer = new BufferedWriter(new FileWriter(openedFile))) {
                writer.write("Date,Israeli_Lines_MWs,Gaza_Power_Plant_MWs,Egyptian_Lines_MWs,Total_daily_Supply_available_in_MWs,Overall_demand_in_MWs,Power_Cuts_hours_day_400mg,Temp\n");
                writer.write("" + yearList.display());
                showAlertSave();
            } catch (Exception ex) {
                showAlertWrning();
            }
        }
    }

    private void showAlertAfterReadingFile() {
        // Create an alert
        Alert alert = new Alert(AlertType.INFORMATION);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("File Readed Succssfully!");

        // Show the alert
        alert.showAndWait();
    }

    public void SaveToFile(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            try ( BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                writer.write("Date,Israeli_Lines_MWs,Gaza_Power_Plant_MWs,Egyptian_Lines_MWs,Total_daily_Supply_available_in_MWs,Overall_demand_in_MWs,Power_Cuts_hours_day_400mg,Temp");
                writer.write("" + yearList.display());
                showAlertSave();
            } catch (Exception e) {
                showAlertWrning();
            }
        }
    }

    private void showAlertSave() {
        // Create an alert
        Alert alert = new Alert(AlertType.INFORMATION);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("File Saved Succssfully!");
        // Show the alert
        alert.showAndWait();
    }

    private void showAlertWrning() {
        // Create an alert
        Alert alert = new Alert(AlertType.ERROR);
        // alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header text
        alert.setContentText("        Somthing went wrong\n"
                + "make sure you opend the corect file");

        // Show the alert
        alert.showAndWait();
    }

    public static String monthNumberToStringName(String monthNumber) {
        String month;

        if (monthNumber.equals("01")) {
            month = "Jan";
        } else if (monthNumber.equals("02")) {
            month = "Feb";
        } else if (monthNumber.equals("03")) {
            month = "Mar";
        } else if (monthNumber.equals("04")) {
            month = "Apr";
        } else if (monthNumber.equals("05")) {
            month = "May";
        } else if (monthNumber.equals("06")) {
            month = "Jun";
        } else if (monthNumber.equals("07")) {
            month = "Jul";
        } else if (monthNumber.equals("08")) {
            month = "Aug";
        } else if (monthNumber.equals("09")) {
            month = "Sep";
        } else if (monthNumber.equals("10")) {
            month = "Oct";
        } else if (monthNumber.equals("11")) {
            month = "Nov";
        } else if (monthNumber.equals("12")) {
            month = "Dec";
        } else {
            month = "";
        }

        return month;
    }

    public static void main(String[] args) {

        launch(args);
    }

}
/*
 private void openFile(Stage primaryStage) {//This Method to open and read the file and insert the data in the array

        if (isOpened == true) {
            Stage alert = new Stage();
            alert.setTitle("Warning");

            Label lbl = new Label("Opening a new file will automatically save the current data. Are you sure?");

            Button btnOk = new Button("OK");
            btnOk.setOnAction(event -> {
                saveBack();
                yearList.deleteAllData();
                alert.close();
            });

            Button btnCancel = new Button("Cancel");
            btnCancel.setOnAction(event -> {
                return;
            });

            HBox hBoxTwoBtn = new HBox(5);
            hBoxTwoBtn.getChildren().addAll(btnOk, btnCancel);
            hBoxTwoBtn.setAlignment(Pos.CENTER);

            VBox vBox = new VBox(10);
            vBox.getChildren().addAll(lbl, hBoxTwoBtn);
            vBox.setAlignment(Pos.CENTER);

            btnCancel.setOnAction(event -> alert.close());

            Scene scene = new Scene(vBox, 400, 200);
            alert.setScene(scene);
            alert.showAndWait();
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(primaryStage);
        openedFile = file;
        try ( Scanner reader = new Scanner(file);) {
            isOpened = true;
            boolean firstLine = true;
            while (reader.hasNextLine()) {
                if (firstLine == true) {
                    firstLine = false;
                    continue;
                }
                String line = reader.nextLine();
                String data[] = line.split(",");

                String date = data[0];
                String tmp[] = date.split("-");
                int year = Integer.parseInt(tmp[0]);
                String month = tmp[1];
                String monthName = monthNumberToStringName(month);

                double Israeli_Lines = Double.parseDouble(data[1]);
                double Gaza_Power = Double.parseDouble(data[2]);
                double Egyptian_Lines = Double.parseDouble(data[3]);
                double daily_Supply = Double.parseDouble(data[4]);
                double Overall_demand = Double.parseDouble(data[5]);
                double Power_Cuts = Double.parseDouble(data[6]);
                double Temp = Double.parseDouble(data[7]);

                if (yearList.isYearExist(year) == true) {
                    yearList.insertDayData(year, monthName, date, Israeli_Lines, Gaza_Power, Egyptian_Lines, daily_Supply, Overall_demand, Power_Cuts, Temp);
                } else {
                    yearList.insertYear(year);
                    yearList.insertDayData(year, monthName, date, Israeli_Lines, Gaza_Power, Egyptian_Lines, daily_Supply, Overall_demand, Power_Cuts, Temp);
                }
            }

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 */
