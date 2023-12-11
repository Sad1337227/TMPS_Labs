package interfaces;

import conf.ConfigManager;
import java.util.TimerTask;

import MVP.Model;
import MVP.View;
import obj.Customer;
import obj.CustomerContainer;
import obj.Product;
import obj.Robber;

public interface PresenterInterface {

void StartSimulation(final View mainView, final Model model,
                              final ConfigManager configManager);

}
