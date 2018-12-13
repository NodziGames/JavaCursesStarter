package main.controllers;

import engine.Txt;

public class Player {

    public int day;
    public int health;
    public int maxhealth;

    public int hunger;
    public int maxhunger;

    public int thirst;
    public int maxthirst;

    public Player() {
        day = 1;
        health = 100;
        maxhealth = 100;
        hunger = 50;
        maxhunger = 50;
        thirst = 50;
        maxthirst = 50;
    }

    public void draw() {
        new Txt(4, 2, "\u2665 " + String.valueOf(health) + "/" + String.valueOf(maxhealth)).print();
        new Txt(20, 2, "THIRST: " + String.valueOf(thirst) + "/" + String.valueOf(maxthirst)).print();
        new Txt(40, 2, "HUNGER: " + String.valueOf(hunger) + "/" + String.valueOf(maxhunger)).print();
        new Txt(145, 2, "DAY: " + String.valueOf(day)).print_right_aligned();
        new Txt(1, 4, "====================================================================================================================================================").print();
    }
}
