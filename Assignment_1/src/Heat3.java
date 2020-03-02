public class Heat3 extends HeaterState
{
  private Thread timer;
  private boolean complete;

  public Heat3(Heater heater)
  {
    complete=false;
    timer=new Thread(()->{
      try
      {
        Thread.sleep(5000);
        timeout(heater);
      }
      catch (InterruptedException e)
      {
      }
    });
  }
  private void timeout(Heater heater)
  {
    if(!complete)
    {
      heater.setState(new Heat2());
      complete=true;
    }
  }

  @Override public void turnDown(Heater heater)
  {
    if(!complete)
    {
      timer.interrupt();
      heater.setState(new Heat2());
      complete=true;
    }
  }
}
