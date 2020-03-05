package mediator;

import model.Heater;
import model.Temperature;
import model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport propertyChangeSupport;
  private Heater heater;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    this.heater = new Heater();
    this.propertyChangeSupport = new PropertyChangeSupport(this);
  }

  @Override public synchronized void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature(id);
    this.temperatureList.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      propertyChangeSupport.firePropertyChange("Temperature", old, temperature);
    }
  }

  @Override public synchronized Temperature getLastInsertedTemperature(
      String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public int heaterPosition()
  {
    return heater.position();
  }

  @Override public void goUp()
  {
    propertyChangeSupport.firePropertyChange("Heater",heaterPosition(),heaterPosition()+1);
    heater.turnUp();
  }

  @Override public void goDown()
  {
    propertyChangeSupport.firePropertyChange("Heater",heaterPosition(),heaterPosition()-1);
    heater.turnDown();
  }

  @Override public ArrayList<Temperature> getLastTemperatures(int number)
  {
    return temperatureList.getLastTemperatures(number);
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null)
    {
      propertyChangeSupport.addPropertyChangeListener(listener);
    }
    else
    {
      propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null)
    {
      propertyChangeSupport.removePropertyChangeListener(listener);
    }
    else
    {
      propertyChangeSupport
          .removePropertyChangeListener(propertyName, listener);
    }
  }
}
