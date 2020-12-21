package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteManagerTest {

    @Test
    void findAllOneElement() {

        RouteManager manager = new RouteManager();
        Route moscow = new Route(123, 1000, "ALG", "DME", 350);
        Route krasnodar = new Route(124, 1500,"DME", "KRR", 120);
        manager.add(moscow);
        manager.add(krasnodar);
        Route[] actual = manager.findAll("ALG", "DME");

        Route[] expected = new Route[1];
        expected[0] = moscow;

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllTwoElementWithSort() {

        RouteManager manager = new RouteManager();
        Route moscow = new Route(123, 1600, "ALG", "DME", 350);
        Route krasnodar = new Route(124, 1500,"ALG", "DME", 120);
        manager.add(moscow);
        manager.add(krasnodar);
        Route[] actual = manager.findAll("ALG", "DME");

        Route[] expected = new Route[2];
        expected[0] = krasnodar;
        expected[1] = moscow;

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllThreeElementWithEqualCost() {

        RouteManager manager = new RouteManager();
        Route moscow = new Route(123, 1500, "ALG", "DME", 350);
        Route krasnodar = new Route(124, 1500,"ALG", "DME", 120);
        Route spb = new Route(124, 1500,"ALG", "DME", 120);
        manager.add(moscow);
        manager.add(krasnodar);
        manager.add(spb);
        Route[] actual = manager.findAll("ALG", "DME");

        Route[] expected = new Route[3];
        expected[0] = moscow;
        expected[1] = krasnodar;
        expected[2] = spb;

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllNotFound() {

        RouteManager manager = new RouteManager();
        Route moscow = new Route(123, 1500, "ALG", "DME", 350);
        Route krasnodar = new Route(124, 1500,"ALG", "DME", 120);
        Route spb = new Route(124, 1500,"ALG", "DME", 120);
        manager.add(moscow);
        manager.add(krasnodar);
        manager.add(spb);
        Route[] actual = manager.findAll("ALG", "KRR");

        Route[] expected = new Route[0];

        assertArrayEquals(expected, actual);
    }
}