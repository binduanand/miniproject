import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.geometry.Pos; // For centering the buttons

import java.io.File;
import java.io.IOException;
import java.util.List;

public class mainscreen extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException { // Declare IOException in the method signature
        primaryStage.setTitle("Data Visualization Tool");

        // Create buttons
        Button pieButton = new Button("Pie Chart");
        Button barButton = new Button("Bar Chart");
        Button lineButton = new Button("Line Chart");

        // Style the buttons
        pieButton.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 60px; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: Cambria; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0, 0, 2);");
        barButton.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 60px; -fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: Cambria; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0, 0, 2);");
        lineButton.setStyle("-fx-font-size: 20px; -fx-min-width: 200px; -fx-min-height: 60px; -fx-background-color: #FF9800; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: Cambria; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0, 0, 2);");

        // FileChooser to select the Excel file
        Button importButton = new Button("Import Data");
        importButton.setStyle("-fx-font-size: 18px; -fx-min-width: 300px; -fx-min-height: 60px; -fx-background-color: #2DD881; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-family: Cambria; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0, 0, 2);");

        importButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
            File file = fileChooser.showOpenDialog(primaryStage);

            if (file != null) {
                try {
                    List<ItemData> importedData = ExcelReader.readExcelData(file.getAbsolutePath());

                    // Now set up the button actions
                    pieButton.setOnAction(e -> {
                        pie pieChartExample = new pie(importedData); // Pass imported data
                        pieChartExample.start(new Stage()); // Show Pie Chart
                    });

                    barButton.setOnAction(e -> {
                        bar barChartExample = new bar(importedData); // Pass imported data
                        barChartExample.start(new Stage()); // Show Bar Chart
                    });

                    lineButton.setOnAction(e -> {
                        line lineChartExample = new line(importedData); // Pass imported data
                        lineChartExample.start(new Stage()); // Show Line Chart
                    });
                } catch (IOException ex) {
                    ex.printStackTrace(); // Handle the exception or show an error message
                }
            }
        });

        // Create a title label
        Label titleLabel = new Label("Data Visualization Tool");
        titleLabel.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #3F51B5; -fx-font-family: Cambria;");

        // Layout setup with VBox for vertical layout and center alignment
        VBox root = new VBox(20, titleLabel, importButton, pieButton, barButton, lineButton);
        root.setAlignment(Pos.CENTER); // Center all elements

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
