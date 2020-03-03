package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.TemperatureModel;
import model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometerViewModel implements PropertyChangeListener
{
  private DoubleProperty t1;
  private DoubleProperty t2;
  private DoubleProperty t3;
  private StringProperty h4;
  private TemperatureModel model;

  public ThermometerViewModel(TemperatureModel model)
  {
    this.model = model;
    this.t1 = new SimpleDoubleProperty();
    this.t2 = new SimpleDoubleProperty();
    this.t3 = new SimpleDoubleProperty();
    this.h4 = new SimpleStringProperty();
    model.addListener("Temperature", this);
  }

  public StringProperty geth4()
  {
    return h4;
  }

  public DoubleProperty gett3()
  {
    return t3;
  }

  public DoubleProperty gett2()
  {
    return t2;
  }

  public DoubleProperty gett1()
  {
    return t1;
  }

  public void goUp()
  {

  }

  public void goDown()
  {

  }

  public void clear()
  {
    //    CLEAR STUFF
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      switch (evt.getPropertyName())
      {
        case "Temperature":
          Temperature incomingTemperature = (Temperature) evt.getNewValue();
          switch (incomingTemperature.getId())
          {
            case "t1":
              t1.set(incomingTemperature.getValue());
              break;
            case "t2":
              t2.set(incomingTemperature.getValue());
              break;
            case "t3":
             t3.set(incomingTemperature.getValue());
             break;
          }
      }
    });
  }
}
