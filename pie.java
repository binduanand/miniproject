

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;

import java.util.List;

public class pie extends Application {

    private List<ItemData> data;

    // Constructor accepting imported data
    public pie(List<ItemData> data) {
        this.data = data;
    }

    @Override
    public void start(Stage stage) {
        PieChart pieChart = new PieChart();

        // Populate the pie chart with data
        for (ItemData item : data) {
            PieChart.Data pieData = new PieChart.Data(item.getItemName(), item.getItemValue());
            pieChart.getData().add(pieData);
        }

        StackPane root = new StackPane();
        root.getChildren().add(pieChart);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Pie Chart");
        stage.setScene(scene);
        stage.show();
    }
}

