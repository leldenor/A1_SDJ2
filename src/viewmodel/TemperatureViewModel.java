package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import model.HeaterState;

public class TemperatureViewModel
{
//  private "What properties?" temperatureChart;
//  private "What properties?" temperatureChartX;
//  private "What properties?" temperatureChartY;
  private SimpleStringProperty thermometerID;
  private HeaterState model;
  private ViewModelFactory viewModelFactory;

  public TemperatureViewModel()
//      HeaterState heaterState
  {
//    this.model=heaterState;
//    this.viewModelFactory = new ViewModelFactory();
//    this.thermometerID = new SimpleStringProperty();
  }

  public SimpleStringProperty getThermometerID()
  {
    return thermometerID;
  }
//  public  gettemperatureChart()
//  {
//    return temperatureChart;
//  }
//  public  gettemperatureChartX()
//  {
//    return temperatureChartX;
//  }
//  public   gettemperatureChartY()
//  {
//    return temperatureChartY;
//  }
}
