package external;

import mediator.TemperatureModel;

import java.util.concurrent.ThreadLocalRandom;

public class OutsideThermometer implements Runnable
{
  private String id;
  private double outsideT;
  private int sleepTime;
  private TemperatureModel model;

  public OutsideThermometer(String id, double outsideT, int sleepTime,
      TemperatureModel model)
  {
    this.id = id;
    this.outsideT = outsideT;
    this.model = model;
    this.sleepTime = sleepTime;
  }

  /*** Calculating the external temperature.
   * Values are only valid if the temperature is being measured
   * approximately every 10th second.
   * @param t0  the last measured external temperature
   * @param min a lower limit (may temporally be deceeded)
   * @param max an upper limit (may temporally be exceeded)
   * @return an updated external temperature*/
  public double externalTemperature(double t0, double min, double max)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    return t0;
  }

  @Override public void run()
  {
    model.addTemperature(id, outsideT);
    while (true)
    {
      try
      {
        outsideT = externalTemperature(outsideT, -20, 20);
        model.addTemperature(id, outsideT);
        Thread.sleep(sleepTime * 1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
