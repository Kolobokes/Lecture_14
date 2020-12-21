package ru.netology;

import java.util.Comparator;

public class RouteByTravelTimeAscComparator implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        return o1.getTravelTime() - o2.getTravelTime() ;
    }
}
