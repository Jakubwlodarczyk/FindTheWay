package findtheway.controller;

import findtheway.model.Application;
import findtheway.ui.UserInput;
import findtheway.view.Message;

public class ApplicationController {

    private Application application;

    public void initApplication() {
        application = new Application();
    }

    public void runApp() {
        boolean applicationOn = true;
        boolean tripListIsNotSet = true;

        while (applicationOn) {
            Message.cleanScrean();
            Message.displayStartMenu();
            Integer option = UserInput.getUserIntegerInput();
            switch (option) {
                case 1:
                    while (tripListIsNotSet) {
                        Message.cleanScrean();
                        Message.displaySetupCitySetOptions(application.getTripList());
                        Integer optionInCitySetMenu = UserInput.getUserIntegerInput();
                        switch (optionInCitySetMenu) {
                            case 1:
                                Message.cleanScrean();
                                application.createCitySet();
                                break;
                            case 2:
                                System.out.println("jeszcze nie obliczam");
                                break;
                            case 0:
                                System.exit(0);
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
