package view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Region;
import viewmodel.TemperatureViewModel;

public class TemperatureViewController
{
  @FXML private LineChart TemperatureChart;

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

    TemperatureChart.setTitle("Temperature Chart");

    XYChart.Series series1 = new XYChart.Series();
    XYChart.Series series2 = new XYChart.Series();
    XYChart.Series series3 = new XYChart.Series();

    series1.setName("T 1");
    series2.setName("T 2");
    series3.setName("T 3");

    ObservableList<XYChart.Data> t1list = viewModel.getT1List();
    ObservableList<XYChart.Data> t2list = viewModel.getT2List();
    ObservableList<XYChart.Data> t3list = viewModel.getT3List();

    for(int i = 0; i < t1list.size(); i++) {
      series1.getData().add(t1list.get(i));
    }

    for(int i = 0; i < t2list.size(); i++) {
      series2.getData().add(t2list.get(i));
    }

    for(int i = 0; i < t3list.size(); i++) {
      series3.getData().add(t3list.get(i));
    }

    viewModel.getT1ListProperty().addListener((obs, olV, newV) -> {
      series1.getData().add(t1list.get(t1list.size() - 1));
    });

    viewModel.getT2ListProperty().addListener((obs, olV, newV) -> {
      series2.getData().add(t2list.get(t2list.size() - 1));
    });

    viewModel.getT3ListProperty().addListener((obs, olV, newV) -> {
      series3.getData().add(t3list.get(t3list.size() - 1));
    });


    TemperatureChart.getData().add(series1);
    TemperatureChart.getData().add(series2);
    TemperatureChart.getData().add(series3);

  }

  public void reset()
  {
//     viewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void goBackButton() {
    viewHandler.openView("thermometer");
  }
}
