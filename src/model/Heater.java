public class Heater
{
  private HeaterState state;

  public Heater()
  {
    state=new Heat0();
  }
  public void turnDown()
  {
    state.turnDown(this);
  }
  public void turnUp()
  {
    state.turnUp(this);
  }
  public void setState(HeaterState state)
  {
    this.state=state;
  }
  public String position()
  {
    return state.position();
  }
}
