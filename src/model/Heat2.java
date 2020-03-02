public class Heat2 extends HeaterState
{
  @Override public void turnUp(Heater heater)
  {
    heater.setState(new Heat3(heater));
  }

  @Override public void turnDown(Heater heater)
  {
    heater.setState(new Heat1());
  }
}
