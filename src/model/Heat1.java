package model;

public class Heat1 extends HeaterState
{
  @Override public void turnDown(Heater heater)
  {
    heater.setState(new Heat0());
  }

  @Override public void turnUp(Heater heater)
  {
    heater.setState(new Heat2());
  }
  @Override public int position()
  {
    return 1;
  }
}
