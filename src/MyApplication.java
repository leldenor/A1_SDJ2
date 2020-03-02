import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    ViewModelFactory viewModelFactory = new ViewModelFactory();
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
  }
}
