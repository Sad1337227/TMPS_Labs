package MVP;

import MVP.Model;
import MVP.Presenter;
import MVP.PresenterProxy;
import MVP.View;
import conf.ConfigManager;
import interfaces.PresenterInterface;

public class MVPFacade {
  private ConfigManager configManager;
  private Model model;
  private PresenterInterface presenter;
  private View view;
  public MVPFacade() {
    configManager = new ConfigManager();
    try {
      configManager.Load();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    model = new Model(configManager);
    presenter = new PresenterProxy();
    
  }

  public void StartSimulation() { presenter.StartSimulation(View.getInstance(), model, configManager); }
}
