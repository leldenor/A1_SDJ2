package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import model.ThermometerViewModel;

public class ThermometerViewController
{
  @FXML private Label t1Label;
  @FXML private Label t2Label;
  @FXML private Label t3Label;
  @FXML private Label h1Label;

  private Region root;
  private ThermometerViewModel viewModel;
  private ViewHandler viewHandler;

  public ThermometerViewController()
  {
  }

  public void init(ViewHandler viewHandler, ThermometerViewModel viewModel,
      Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
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
    System.out.println("clicked");
    viewHandler.openView("temperature");
  }
}
