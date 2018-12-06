package main.states;

import com.googlecode.lanterna.input.KeyType;
import engine.Txt;
import main.Application;


public class Menu extends State {

    public Menu() {
        super("menu");
    }

    @Override
    public void logic(KeyType key) {
        if (key == KeyType.Enter) {
            Application.state = "app";
        }
    }

    @Override
    public void render() {
        new Txt(10, 10, "This is the menu! Press Enter To Continue").print();

    }
}
