package ru.netology;

import ru.netology.RouteRepository;

import java.util.Arrays;

public class RouteManager {

    RouteRepository repository = new RouteRepository();

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void add(Route route) {
        repository.save(route);
    }

    public Route[] findAll(String from, String to) {
        Route[] result = new Route[repository.findAll().length];
        int counter = -1;
        for (Route route: repository.findAll()) {
            if (matches(route, from, to)) {
                counter = counter + 1;
                Route[] tmp = new Route[1];
                tmp[0] = route;
                System.arraycopy(tmp, 0, result, counter, tmp.length);
            }
        }

        int amountNotNullElements = counter + 1;
        Route[] resultWithoutNull = new Route[amountNotNullElements];
        int newCounter;
        for(newCounter = 1; newCounter <= amountNotNullElements; newCounter++){
            resultWithoutNull[newCounter-1] = result[newCounter-1];
        }

        if (resultWithoutNull.length > 1) {
            Arrays.sort(resultWithoutNull);
        }

        return resultWithoutNull;
    }

    public boolean matches(Route route, String from, String to) {

        if (route.getDepartureAirport().equalsIgnoreCase(from) && route.getArrivalAirport().equalsIgnoreCase(to)) {
            return true;
        }

        return false;
    }
}
