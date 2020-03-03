package view;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Region;
import viewmodel.TemperatureViewModel;

public class TemperatureViewController
{
  @FXML private LineChart TemperatureChart;
  @FXML private CategoryAxis TemperatureChartX;
  @FXML private NumberAxis TemperatureChartY;

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
