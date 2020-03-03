package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ThermometerViewModel
{
  private StringProperty t1;
  private StringProperty t2;
  private StringProperty t3;
  private StringProperty h4;
  private ViewModelFactory viewModelFactory;
  public ThermometerViewModel()
  {
//    this.t1=new SimpleStringProperty();
//    this.t2=new SimpleStringProperty();
//    this.t3=new SimpleStringProperty();
//    this.h4=new SimpleStringProperty();
//    this.viewModelFactory = new ViewModelFactory();
  }

  public StringProperty geth4()
  {
    return h4;
  }
  public StringProperty gett3()
  {
    return t3;
  }
  public StringProperty gett2()
  {
    return t2;
  }
  public StringProperty gett1()
  {
    return t1;
  }
  public ViewModelFactory getViewModelFactory()
  {
    return viewModelFactory;
  }
}
