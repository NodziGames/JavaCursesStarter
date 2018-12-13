package main.controllers;

import engine.Colors;
import engine.Mafs;
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

        //Draw Health
        if (health < 20)
            new Txt(4, 2, "\u2665 " + String.valueOf(health) + "/" + String.valueOf(maxhealth), Colors.black, Colors.red).print();
        else if (health < 40)
            new Txt(4, 2, "\u2665 " + String.valueOf(health) + "/" + String.valueOf(maxhealth), Colors.black, Colors.yellow).print();
        else
            new Txt(4, 2, "\u2665 " + String.valueOf(health) + "/" + String.valueOf(maxhealth), Colors.black, Colors.white).print();

        //Draw Thirst
        if (thirst < 10)
            new Txt(20, 2, "THIRST: " + String.valueOf(thirst) + "/" + String.valueOf(maxthirst), Colors.black, Colors.red).print();
        else if (thirst < 20)
            new Txt(20, 2, "THIRST: " + String.valueOf(thirst) + "/" + String.valueOf(maxthirst), Colors.black, Colors.yellow).print();
        else
            new Txt(20, 2, "THIRST: " + String.valueOf(thirst) + "/" + String.valueOf(maxthirst), Colors.black, Colors.white).print();

        //Draw Hunger
        if (hunger < 10)
            new Txt(40, 2, "HUNGER: " + String.valueOf(hunger) + "/" + String.valueOf(maxhunger), Colors.black, Colors.red).print();
        else if (hunger < 20)
            new Txt(40, 2, "HUNGER: " + String.valueOf(hunger) + "/" + String.valueOf(maxhunger), Colors.black, Colors.yellow).print();
        else
            new Txt(40, 2, "HUNGER: " + String.valueOf(hunger) + "/" + String.valueOf(maxhunger), Colors.black, Colors.white).print();

        //Draw Day and rest of UI
        new Txt(145, 2, "DAY: " + String.valueOf(day)).print_right_aligned();
        new Txt(1, 4, "====================================================================================================================================================", Colors.black, Colors.cyan).print();
    }

    //Tax the body
    public void tax() {
        day += 1;
        hunger -= Mafs.random_range_int(1, 3);
        thirst -= Mafs.random_range_int(1, 3);

        if (hunger < 0) {
            health += hunger; //Take damage equivalent to missing hunger
            hunger = 0;
        }

        if (thirst < 0) {
            health += thirst;
            thirst = 0;
        }
    }
}
