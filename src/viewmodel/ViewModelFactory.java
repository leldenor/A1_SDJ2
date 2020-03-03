package viewmodel;

public class ViewModelFactory
{
  private TemperatureViewModel temperatureViewModel;
  private ThermometerViewModel thermometerViewModel;

  public ViewModelFactory()
  {
    this.temperatureViewModel = new TemperatureViewModel();
    this.thermometerViewModel = new ThermometerViewModel();
  }

  public TemperatureViewModel getTemperatureViewModel() {
    return this.temperatureViewModel;
  }

  public ThermometerViewModel getThermometerViewModel()
  {
    return thermometerViewModel;
  }
}
