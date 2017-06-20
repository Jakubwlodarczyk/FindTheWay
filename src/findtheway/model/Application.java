package findtheway.model;

import findtheway.ui.UserInput;
import findtheway.view.Message;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private List<CitySet> tripList;

    public Application() {
        this.tripList = new ArrayList<>();
    }

    public List<CitySet> getTripList() {
        return tripList;
    }

    public void createCitySet() {
        String firstCity = "";
        String secondCity = "";
        Integer cost = 0;
        boolean setCollected = false;
        while (!setCollected) {
            firstCity = getFirstCityFromUser();
            secondCity = getSecondCityFromUser();
            cost = getCostOfTravelBetweenCitiesFromUser();
            if (firstCity.isEmpty() || secondCity.isEmpty() || cost < 0) {
                Message.displaySimpleMessage("Wrong input");
            } else {
                setCollected = true;
            }
        }
        addToTripList(new CitySet(firstCity, secondCity, cost));
    }

    private String getFirstCityFromUser() {
        Message.displaySimpleMessage("Type the first name of city:");
        return UserInput.getUserStringInput();
    }

    private String getSecondCityFromUser() {
        Message.displaySimpleMessage("Type the second name of city:");
        return UserInput.getUserStringInput();
    }

    private Integer getCostOfTravelBetweenCitiesFromUser() {
        Message.displaySimpleMessage("Type the cost of travel:");
        return UserInput.getUserIntegerInput();
    }

    private void addToTripList(CitySet citySet) {
        tripList.add(citySet);
    }


}
