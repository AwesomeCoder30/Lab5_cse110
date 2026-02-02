package edu.ucsd.spendingtracker.view.charts;

import edu.ucsd.spendingtracker.model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;

import java.util.Map;

public class PieChartProvider implements IChartProvider {
    @Override
    public Node createChart(Map<Category, Double> data) {
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
        data.forEach((cat, sum) -> pieData.add(new PieChart.Data(cat.name(), sum)));

        PieChart chart = new PieChart(pieData);
        chart.applyCss();
        chart.layout();

        for (PieChart.Data entry : pieData) {
            Node slice = entry.getNode();
            if (slice != null) {
                String color = Category.valueOf(entry.getName()).color;
                slice.setStyle("-fx-pie-color: " + color + ";");
            }
        }

        return chart;
    }

    @Override
    public String getDisplayName() {
        return "Pie Chart";
    }
}
