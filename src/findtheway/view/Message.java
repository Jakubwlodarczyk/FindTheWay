package findtheway.view;

import findtheway.model.CitySet;

import java.util.List;

public class Message {

    public static void displaySimpleMessage(String message) {
        System.out.println(message);
    }

    public static void displayStartMenu() {
        System.out.println("....::: Find your way :::....\n\n\n");
        System.out.println("Choose option:");
        System.out.println("1. Set up cities and costs");
        System.out.println("\n0. Exit program");
    }

    public static void displaySetupCitySetOptions(List<CitySet> tripList) {
        System.out.println("....::: Find your way :::....\n\n\n");
        System.out.println("Your trip list:");
        if (tripList.size() == 0) {
            System.out.println("empty");
        } else {
            for (CitySet citySet : tripList) {
                System.out.println(citySet);
            }
        }
        System.out.println("\n1. Add new city set");
        System.out.println("2. Calculate the shortest path");
        System.out.println("\n0. Exit program");
    }

    public static void cleanScrean() {
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
    }
}
