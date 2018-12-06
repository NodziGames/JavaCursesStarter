package main.states;

import com.googlecode.lanterna.input.KeyType;

public class State {

    public String name;

    public State(String name) {
        this.name = name;
    }

    public void loop(KeyType key) {
        logic(key);
        render();
    }


    public void logic(KeyType key) {

    }

    public void render() {

    }

}
