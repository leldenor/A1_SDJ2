import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import mediator.TemperatureModel;
import mediator.TemperatureModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    TemperatureModel model = new TemperatureModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);

    Thermometer t1 = new Thermometer("t1", 15, 1, model);
    Thermometer t2 = new Thermometer("t2", 15, 7, model);

    Thread ThermometerThread = new Thread(t1);
    Thread ThermometerThread2 = new Thread(t2);
    ThermometerThread.start();
    ThermometerThread2.start();

    view.start(primaryStage);
  }
}
