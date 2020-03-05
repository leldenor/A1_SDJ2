package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import mediator.TemperatureModel;
import model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class TemperatureViewModel implements PropertyChangeListener
{
  private ObservableList<XYChart.Data> list;
  private SimpleStringProperty thermometerID;
  private TemperatureModel model;
  private ViewModelFactory viewModelFactory;

  public TemperatureViewModel(TemperatureModel model)
  {
    this.model = model;
    this.list = createList();
    model.addListener("Temperature", this);
  }

  public SimpleStringProperty getThermometerID()
  {
    return thermometerID;
  }

  private synchronized ObservableList<XYChart.Data> createList()
  {
    ObservableList<XYChart.Data> obsList = FXCollections.observableArrayList();
    ArrayList<Temperature> lastTemperatures = model.getLastTemperatures(20);

    for (int i = 0; i < lastTemperatures.size(); i++)
    {
      obsList.add(
          new XYChart.Data(lastTemperatures.get(i).getTime().getSortableTime(),
              lastTemperatures.get(i).getValue()));
    }

    return obsList;
  }

  private void addToTheList(Temperature temperature)
  {
    this.list.add(new XYChart.Data(temperature.getTime().getSortableTime(),
        temperature.getValue()));
  }

  public ObservableList<XYChart.Data> getList()
  {
    return list;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      switch (evt.getPropertyName())
      {
        case "Temperature":
          this.addToTheList((Temperature) evt.getNewValue());
          break;
        default:
          break;
      }
    });
  }
  //  public  gettemperatureChart()
  //  {
  //    return temperatureChart;
  //  }
  //  public  gettemperatureChartX()
  //  {
  //    return temperatureChartX;
  //  }
  //  public   gettemperatureChartY()
  //  {
  //    return temperatureChartY;
  //  }
}
