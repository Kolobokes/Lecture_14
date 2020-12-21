package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Route implements Comparable<Route> {
    private int id;
    private  int cost;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    @Override
    public int compareTo(Route o) {

        return this.getCost() - o.getCost();
    }
}
