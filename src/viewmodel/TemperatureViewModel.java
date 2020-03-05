package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
  private ObservableList<XYChart.Data> t1List;
  private ObservableList<XYChart.Data> t2List;
  private ObservableList<XYChart.Data> t3List;

  private ObjectProperty<ObservableList<XYChart.Data>> t1ListProperty;
  private ObjectProperty<ObservableList<XYChart.Data>> t2ListProperty;
  private ObjectProperty<ObservableList<XYChart.Data>> t3ListProperty;

  private SimpleStringProperty thermometerID;
  private TemperatureModel model;
  private ViewModelFactory viewModelFactory;

  public TemperatureViewModel(TemperatureModel model)
  {
    this.model = model;

    this.t1List = createList();
    this.t2List = createList();
    this.t3List = createList();


    this.t1ListProperty = new SimpleObjectProperty<>();
    this.t2ListProperty = new SimpleObjectProperty<>();
    this.t3ListProperty = new SimpleObjectProperty<>();

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
    if (temperature.getId().equals("t1"))
    {
      this.t1List.add(new XYChart.Data(temperature.getTime().getSortableTime(),
          temperature.getValue()));

      t1ListProperty.setValue(this.createList());
    }
    else if (temperature.getId().equals("t2"))
    {
      this.t2List.add(new XYChart.Data(temperature.getTime().getSortableTime(),
          temperature.getValue()));

      t2ListProperty.setValue(this.createList());
    }
    else if (temperature.getId().equals("t3"))
    {
      this.t3List.add(new XYChart.Data(temperature.getTime().getSortableTime(),
          temperature.getValue()));

      t3ListProperty.setValue(this.createList());
    }
  }

  public ObservableList<XYChart.Data> getT1List()
  {
    return t1List;
  }

  public ObservableList<XYChart.Data> getT2List()
  {
    return t2List;
  }

  public ObservableList<XYChart.Data> getT3List()
  {
    return t3List;
  }

  public ObjectProperty<ObservableList<XYChart.Data>> getT1ListProperty()
  {
    return t1ListProperty;
  }

  public ObjectProperty<ObservableList<XYChart.Data>> getT2ListProperty()
  {
    return t2ListProperty;
  }

  public ObjectProperty<ObservableList<XYChart.Data>> getT3ListProperty()
  {
    return t3ListProperty;
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
