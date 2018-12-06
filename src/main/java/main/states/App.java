package main.states;


import engine.Txt;

public class App extends State {

    public App() {
        super("app");
    }

    @Override
    public void render() {
        new Txt(10, 10, "This is the App Screen! This is the end of the demo. Press Escape to quit").print();

    }
}
