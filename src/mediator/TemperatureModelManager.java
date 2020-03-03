package mediator;

import model.Temperature;
import model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport propertyChangeSupport;

  public TemperatureModelManager()
  {
    temperatureList = new TemperatureList();
    this.propertyChangeSupport = new PropertyChangeSupport(this);
  }

  @Override public synchronized void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature(id);
    this.temperatureList.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature + " (from: " + old + ")");
      propertyChangeSupport.firePropertyChange("Temperature", old, temperature);
    }
  }

  @Override public synchronized Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public synchronized Temperature getLastInsertedTemperature(
      String id)
  {
    return temperatureList.getLastTemperature(id);
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

  // and maybe other methods...
}
