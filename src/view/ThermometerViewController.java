package view;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Region;
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

    minSlider.setValue(-20);
    maxSlider.setValue(20);

    this.minSlider.valueProperty().addListener(new ChangeListener<Number>()
    {
      @Override public void changed(
          ObservableValue<? extends Number> observableValue, Number oldValue,
          Number newValue)
      {
        System.out.println(newValue.intValue());
      }
    });

    this.maxSlider.valueProperty().addListener(new ChangeListener<Number>()
    {
      @Override public void changed(
          ObservableValue<? extends Number> observableValue, Number oldValue,
          Number newValue)
      {
        System.out.println(newValue.intValue());
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
