package main;

import engine.Colors;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //Init app
        Application app = new Application(150, 40, "ZombAscii", "menu");

        //Configures Game
        app.init();

        //Runs main app loop
        app.loop();

        //Close down terminal
        app.close();

        //Stop Application
        System.exit(0);
    }
}
