package com.project.datavisualizationproject;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.StackPane;

import java.util.List;

public class bar extends Application {

    private List<ItemData> data;

    // Constructor accepting imported data
    public bar(List<ItemData> data) {
        this.data = data;
    }

    @Override
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (ItemData item : data) {
            series.getData().add(new XYChart.Data<>(item.getItemName(), item.getItemValue()));
        }

        barChart.getData().add(series);

        StackPane root = new StackPane();
        root.getChildren().add(barChart);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Bar Chart");
        stage.setScene(scene);
        stage.show();
    }
}
