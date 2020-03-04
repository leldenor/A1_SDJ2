package model;

public class Heat0 extends HeaterState
{
  @Override public void turnUp(Heater heater)
  {
    heater.setState(new Heat1());
  }
  @Override public String position()
  {
    return "Heating is off";
  }
}
