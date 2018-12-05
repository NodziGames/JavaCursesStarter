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

import java.io.IOException;

import static engine.Functions.*;


public class Application {

    //Static declarations so that it can be accessed from the Engine
    public static Terminal terminal;
    public static Screen screen;
    private int width;
    private int height;

    private String border;
    private TextColor.ANSI borderColor;



    //!!!! YOU SHOULDN'T NEED TO MODIFY THESE! SCROLL DOWN TO GET TO THE SECTION YOU SHOULD BE CHANGING

    public Application(int width, int height) throws IOException {

        this.width = width;
        this.height = height;
        this.border = "#";
        this.borderColor = Colors.cyan;

        TerminalSize size = new TerminalSize(width, height);

        terminal = new DefaultTerminalFactory().setInitialTerminalSize(size).createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();

        drawBorders();
    }

    public Application(int width, int height, String border, TextColor.ANSI borderColor) throws IOException {

        this.width = width;
        this.height = height;
        this.border = border;
        this.borderColor = borderColor;

        TerminalSize size = new TerminalSize(width, height);

        terminal = new DefaultTerminalFactory().setInitialTerminalSize(size).createTerminal();
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

        new Txt(64, 4, "WELCOME TO THE EXAMPLE APP", Colors.black, Colors.cyan).print();
        screen.refresh();
    }

    public void loop() throws IOException {

        //Main application loop. Runs once upon every key press
        while (true) {

            KeyType key = getPressed();

            if (key == KeyType.Escape) {
                break ;
            }

            screen.clear();
            new Txt(60, 19,"YOU PRESSED: " + key.toString()).print();
            drawBorders();
            screen.refresh();
        }
    }

    public void close() throws IOException {

        //Remember to close all streams here to avoid memory leaks!
        terminal.close();
    }
}
