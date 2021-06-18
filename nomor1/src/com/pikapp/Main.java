package com.pikapp;

import java.util.Date;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //System.out.print("hello world");
        MapAlertDAO mapAlertDAO = new MapAlertDAO();
        AlertService alertService = new AlertService(mapAlertDAO);

        System.out.print(alertService.raiseAlert());
//        System.out.print(alertService.getAlertTime());
    }
}
