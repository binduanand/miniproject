package com.project.datavisualizationproject;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.CategoryAxis; // Use CategoryAxis for the X-Axis to handle string values
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;

import java.util.List;

public class line extends Application {

    private List<ItemData> data;

    // Constructor accepting imported data
    public line(List<ItemData> data) {
        this.data = data;
    }

    @Override
    public void start(Stage stage) {
        // Create CategoryAxis for the X-Axis to handle string values (itemName)
        CategoryAxis xAxis = new CategoryAxis();
         

        NumberAxis yAxis = new NumberAxis();
    

        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Line Chart");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Data Series");

        // Populate the series with data from the imported Excel data
        for (ItemData item : data) {
            // Use itemName as the X value and itemValue as the Y value
            series.getData().add(new XYChart.Data<>(item.getItemName(), item.getItemValue()));
        }

        lineChart.getData().add(series);

        StackPane root = new StackPane();
        root.getChildren().add(lineChart);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Line Chart");
        stage.setScene(scene);
        stage.show();
    }
}

