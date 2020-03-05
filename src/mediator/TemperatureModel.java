package mediator;

import model.Temperature;
import utility.observer.subject.NamedPropertyChangeSubject;

import java.util.ArrayList;

public interface TemperatureModel extends NamedPropertyChangeSubject
{
  void addTemperature(String id, double temperature);

  Temperature getLastInsertedTemperature();

  Temperature getLastInsertedTemperature(String id);
  int heaterPosition();
  void goUp();
  void goDown();
  ArrayList<Temperature> getLastTemperatures(int number);
}
