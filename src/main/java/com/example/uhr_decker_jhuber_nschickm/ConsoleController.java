package com.example.uhr_decker_jhuber_nschickm;
import Model.*;
import View.*;

import java.sql.Time;
import java.util.Scanner;
import java.util.TimeZone;


public class ConsoleController {
    public static void main(String[] args) throws InterruptedException {
        start();
    }

    protected static Timer timer = new Timer();
    protected static Wecker wecker = new Wecker();
    protected static Zeitzone zeitzone;
    protected static Stoppuhr stoppuhr = new Stoppuhr();
    protected static DigitalViewConsole digitalvc = new DigitalViewConsole();
    protected static DateViewConsole datevc = new DateViewConsole();
    protected static WeatherVIewConsole wvc = new WeatherVIewConsole();
    protected static TemperatureViewConsole tvc = new TemperatureViewConsole();
    protected static MenuViewConsole mvc = new MenuViewConsole();
    static final String MENU = "Menu";
    static final String TIMER = "Timer";
    static final String WECKER = "Wecker";
    static final String STOPPUHR = "Stoppuhr";



    public static void start() throws InterruptedException {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        int choose;
        int chooseTimer;
        int chooseStoppuhr;
        int chooseWecker;
        do {
            mvc.display(MENU);
            choose = Integer.parseInt(sc.nextLine());

            switch (choose){
                case 1:
                    digitalvc.display();
                    break;
                case 2:
                    mvc.display(TIMER);
                    chooseTimer = Integer.parseInt(sc.nextLine());
                    if (chooseTimer == 0){

                    } else if(chooseTimer > 0){
                        timer.timerstart(new Time(chooseTimer* 60000L));
                    }
                    break;
                case 3:
                    mvc.display(STOPPUHR);
                    chooseStoppuhr = Integer.parseInt(sc.nextLine());
                    if (chooseStoppuhr == 0){

                    }
                    break;
                case 4:
                    mvc.display(WECKER);
                    chooseWecker = Integer.parseInt(sc.nextLine());
                    if (chooseWecker == 0){

                    }
                    break;
                case 5:
                    wvc.display();
                    break;
                case 6:
                    exit = true;
                    break;

            }


        }while(!exit);
    }

}

