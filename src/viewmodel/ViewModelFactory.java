package viewmodel;

import mediator.TemperatureModel;

public class ViewModelFactory
{
  private TemperatureViewModel temperatureViewModel;
  private ThermometerViewModel thermometerViewModel;

  public ViewModelFactory(TemperatureModel model)
  {
    this.temperatureViewModel = new TemperatureViewModel();
    this.thermometerViewModel = new ThermometerViewModel(model);
  }

  public TemperatureViewModel getTemperatureViewModel()
  {
    return this.temperatureViewModel;
  }

  public ThermometerViewModel getThermometerViewModel()
  {
    return thermometerViewModel;
  }
}
