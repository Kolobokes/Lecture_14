package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.Route;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteRepository {
    private Route[] routes = new Route[0];

    public void save(Route route) {
        int length = routes.length + 1;
        Route[] tmp = new Route[length];
        System.arraycopy(routes, 0, tmp, 0, routes.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = route;
        routes = tmp;
    }

    public Route[] findAll() {

        return routes;
    }

    public Route findByID(int id) {
        for (Route route : findAll()) {
            int productID = route.getId();
            if (productID == id) {
                return route;
            }
        }

        return null;
    }

    public void removeById(int id) {

        if (findByID(id) == null){
            new NotFoundException("Element with id: \" + id + \" not found");
        }

        int length = routes.length - 1;
        Route[] tmp = new Route[length];
        int index = 0;
        for (Route item : routes) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        routes = tmp;
    }
}
