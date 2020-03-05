package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;

  private TemperatureViewController temperatureViewController;
  private ThermometerViewController thermometerViewController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("thermometer");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "thermometer":
        root = loadThermometerView("ThermometerView.fxml");
        break;
      case "temperature":
        root = loadTemperatureView("TemperatureView.fxml");
        break;
    }

    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  private Region loadThermometerView(String fxmlFile)
  {
    if (thermometerViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        thermometerViewController = loader.getController();
        thermometerViewController
            .init(this, viewModelFactory.getThermometerViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      thermometerViewController.reset();
    }
    return thermometerViewController.getRoot();
  }

  private Region loadTemperatureView(String fxmlFile)
  {
    if (temperatureViewController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        temperatureViewController = loader.getController();
        temperatureViewController
            .init(this, viewModelFactory.getTemperatureViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      temperatureViewController.reset();
    }
    return temperatureViewController.getRoot();
  }
}
