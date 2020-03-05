package view;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import javafx.util.converter.NumberStringConverter;
import viewmodel.ThermometerViewModel;

public class ThermometerViewController
{
  @FXML private Slider minSlider;
  @FXML private Slider maxSlider;
  @FXML private Label t1Label;
  @FXML private Label t2Label;
  @FXML private Label t3Label;
  @FXML private Label h1Label;

  private Region root;
  private ThermometerViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, ThermometerViewModel viewModel,
      Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
    Bindings.bindBidirectional(t1Label.textProperty(), viewModel.gett1(),
        new NumberStringConverter());
    Bindings.bindBidirectional(t2Label.textProperty(), viewModel.gett2(),
        new NumberStringConverter());
    Bindings.bindBidirectional(t3Label.textProperty(), viewModel.gett3(),
        new NumberStringConverter());
    h1Label.textProperty().bindBidirectional(viewModel.geth4());

    viewModel.gett1().addListener((obs, olB, newB) -> {
      setT1LabelStyle();
    });

    viewModel.gett2().addListener((obs, olB, newB) -> {
      setT2LabelStyle();
    });

    this.minSlider.valueProperty().addListener(new ChangeListener<Number>()
    {
      @Override public void changed(
          ObservableValue<? extends Number> observableValue, Number oldValue,
          Number newValue)
      {
        viewModel.setLowValue(newValue.doubleValue());
        setT1LabelStyle();
        setT2LabelStyle();
      }
    });

    this.maxSlider.valueProperty().addListener(new ChangeListener<Number>()
    {
      @Override public void changed(
          ObservableValue<? extends Number> observableValue, Number oldValue,
          Number newValue)
      {
        viewModel.setHighValue(newValue.doubleValue());
        setT1LabelStyle();
        setT2LabelStyle();
      }
    });

  }

  public void reset()
  {
    // viewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }

  public void setT1LabelStyle()
  {
    if (viewModel.gett1().get() > viewModel.getHighValue() || viewModel.gett1().get() < viewModel.getLowValue())
    {
      t1Label.setStyle("-fx-text-fill: RED");
    }
    else
    {
      t1Label.setStyle("-fx-text-fill: BLACK");
    }
  }

  public void setT2LabelStyle()
  {
    if (viewModel.gett2().get() > viewModel.getHighValue() || viewModel.gett2().get() < viewModel.getLowValue())
    {
      t2Label.setStyle("-fx-text-fill: RED");
    }
    else
    {
      t2Label.setStyle("-fx-text-fill: BLACK");
    }

  }

  @FXML public void goUpButton()
  {
    viewModel.goUp();
  }

  @FXML public void goDownButton()
  {
    viewModel.goDown();
  }

  @FXML public void detailsButton()
  {
    viewHandler.openView("temperature");
  }
}
