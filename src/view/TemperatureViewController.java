package view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Region;
import viewmodel.TemperatureViewModel;

public class TemperatureViewController
{
  @FXML private LineChart TemperatureChart;
//  @FXML private CategoryAxis TemperatureChartX;
//  @FXML private NumberAxis TemperatureChartY;

  private Region root;
  private TemperatureViewModel viewModel;
  private ViewHandler viewHandler;

  public TemperatureViewController() {}

  public void init(ViewHandler viewHandler, TemperatureViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;

    TemperatureChart.setTitle("HAI SA VADEM");
    XYChart.Series series1 = new XYChart.Series();
    series1.setName("Portfolio 1");

    ObservableList<XYChart.Data> list = viewModel.getList();

    for(int i = 0; i < list.size(); i++) {
      series1.getData().add(list.get(i));
    }

    TemperatureChart.getData().add(series1);
  }

  public void reset()
  {
    // viewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void goBackButton() {
    viewHandler.openView("thermometer");
  }
}
