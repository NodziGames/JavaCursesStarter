package main.states;

import com.googlecode.lanterna.input.KeyType;
import engine.Colors;
import engine.Txt;
import main.Application;
import sun.awt.X11.Screen;

import java.util.ArrayList;
import java.util.List;


public class Menu extends State {

    private List<String> options = new ArrayList<>();
    private int selection;
    private int steps;

    public Menu() {
        super("menu");

        //populate menu options
        options.add("New Game");
        options.add("Continue");
        options.add("Exit");

        selection = 0;

        steps = 0;
    }

    @Override
    public void logic(KeyType key) {

        if (key == KeyType.ArrowUp) {
            if (selection == 0) {
                selection = options.size() - 1;
            }
            else {
                selection -= 1;
            }
        }

        if (key == KeyType.ArrowDown) {
            if (selection == options.size() - 1) {
                selection = 0;
            }
            else {
                selection += 1;
            }
        }

        if (key == KeyType.Enter && steps != 0) {
            switch (selection) {
                case 0:
                    Application.state = "app";
                    break ;
                case 2:
                    System.exit(0);
                    break ;
            }
        }

        steps += 1;
    }

    @Override
    public void render() {
        new Txt(75, 4,  "=================================================================").print_centered();
        new Txt(75, 6,  "| #####  #####  #   #  ####   #####  #####  #####  #####  ##### |").print_centered();
        new Txt(75, 7,  "|    #   #   #  ## ##  #   #  #   #  #      #        #      #   |").print_centered();
        new Txt(75, 8,  "|  ##    #   #  # # #  ####   #####  #####  #        #      #   |").print_centered();
        new Txt(75, 9,  "| #      #   #  #   #  #   #  #   #      #  #        #      #   |").print_centered();
        new Txt(75, 10, "| #####  #####  #   #  ####   #   #  #####  #####  #####  ##### |").print_centered();
        new Txt(75, 12, "=================================================================").print_centered();


        new Txt(75, 20, "--------------------").print_centered();
        if (selection == 0)
            new Txt(75, 22, options.get(0), Colors.white, Colors.black).print_centered();
        else
            new Txt(75, 22, options.get(0)).print_centered();

        if (selection == 1)
            new Txt(75, 24, options.get(1), Colors.white, Colors.black).print_centered();
        else
            new Txt(75, 24, options.get(1)).print_centered();

        if (selection == 2)
            new Txt(75, 26, options.get(2), Colors.white, Colors.black).print_centered();
        else
            new Txt(75, 26, options.get(2)).print_centered();

        new Txt(75, 28, "--------------------").print_centered();
    }
}
