package findtheway;


import findtheway.controller.ApplicationController;


public class Main {

    public static void main(String[] args) {
        ApplicationController applicationController = new ApplicationController();
        applicationController.initApplication();
        applicationController.calculatePath();
    }
}
