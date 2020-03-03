package view;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.util.converter.NumberStringConverter;
import viewmodel.ThermometerViewModel;

public class ThermometerViewController
{
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
    Bindings.bindBidirectional(t1Label.textProperty(), viewModel.gett1(), new NumberStringConverter());
    Bindings.bindBidirectional(t2Label.textProperty(), viewModel.gett2(), new NumberStringConverter());
    Bindings.bindBidirectional(t3Label.textProperty(), viewModel.gett3(), new NumberStringConverter());
    h1Label.textProperty().bindBidirectional(viewModel.geth4());
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
  }

  @FXML public void goDownButton()
  {
  }

  @FXML public void detailsButton()
  {
    viewHandler.openView("temperature");
  }
}
