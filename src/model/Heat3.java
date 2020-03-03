package model;

public class Heat3 extends HeaterState
{
  private Thread time;
  private boolean completed;

  public Heat3(Heater heater)
  {
    completed = false;
    time = new Thread(() -> {
      try
      {
        Thread.sleep(5000);
        timeout(heater);
      }
      catch (InterruptedException e)
      {

      }
    });
    time.start();
  }
  private void timeout(Heater heater)
  {
    if (!completed)
    {
      heater.setState(new Heat2());
      completed = true;
    }
  }

  @Override public void turnDown(Heater heater)
  {
    if (!completed)
    {
      time.interrupt();
      heater.setState(new Heat2());
      completed = true;
    }
  }
  @Override public String position()
  {
    return "Heating is on highest";
  }
}
