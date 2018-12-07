package main;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import engine.Colors;
import engine.Txt;
import main.states.*;

import java.io.IOException;

import static engine.Functions.*;


public class Application {

    //Static declarations so that it can be accessed from the Engine
    public static Terminal terminal;
    public static Screen screen;
    private int width;
    private int height;

    public static String state;

    private String border;
    private TextColor.ANSI borderColor;


    //Set up states
    State menu = new Menu();
    State app = new App();



    //!!!! YOU SHOULDN'T NEED TO MODIFY THESE! SCROLL DOWN TO GET TO THE SECTION YOU SHOULD BE CHANGING

    public Application(int width, int height, String name, String state) throws IOException {

        this.width = width;
        this.height = height;
        this.border = "#";
        this.borderColor = Colors.cyan;

        TerminalSize size = new TerminalSize(width, height);

        this.state = state;

        terminal = new DefaultTerminalFactory().setInitialTerminalSize(size).setTerminalEmulatorTitle(name).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();

        drawBorders();
    }

    public Application(int width, int height, String name, String state, String border, TextColor.ANSI borderColor) throws IOException {

        this.width = width;
        this.height = height;
        this.border = border;
        this.borderColor = borderColor;

        this.state = state;

        TerminalSize size = new TerminalSize(width, height);

        terminal = new DefaultTerminalFactory().setInitialTerminalSize(size).setTerminalEmulatorTitle(name).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();

        drawBorders();
    }

    public void drawBorders() throws IOException {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height - 1 || x == 0 || x == width - 1) {
                    new Txt(x, y, border, Colors.black, borderColor).print();
                }
            }
        }
    }






    /*####################################################################################*/
    /*                                                                                    */
    /*                   THIS IS WHERE YOU START BUILDING YOUR APP!                       */
    /*                                                                                    */
    /*####################################################################################*/

    public void init() throws IOException {

        //Hides the cursor
        screen.setCursorPosition(null);

        new Txt(75, 5, "=============================================", Colors.black, Colors.cyan).print_centered();
        new Txt(75, 6, "WELCOME TO ZOMBASCII. PRESS ENTER TO CONTINUE", Colors.black, Colors.cyan).print_centered();
        new Txt(75, 7, "=============================================", Colors.black, Colors.cyan).print_centered();
        new Txt(5, 36, "2018 @NodziGames").print();
        new Txt(145, 36, "www.nodzigames.com").print_right_aligned();
        screen.refresh();
    }

    public void loop() throws IOException {

        //Main application loop. Runs once upon every key press
        while (true ) {

            KeyType key = getPressed();

            if (key == KeyType.Escape) {
                break ;
            }
            screen.clear();

            drawBorders();

            //State handler;
            switch (state) {

                case "menu":
                    menu.loop(key);
                    break ;
                case "app":
                    app.loop(key);
                    break ;
            }

            screen.refresh();
        }
    }

    public void close() throws IOException {

        //Remember to close all streams here to avoid memory leaks!
        terminal.close();
    }
}
