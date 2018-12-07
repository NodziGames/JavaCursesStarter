package main.states;


import engine.Txt;

public class App extends State {

    public App() {
        super("app");
    }

    @Override
    public void render() {
        new Txt(75, 9, "|").print();
        new Txt(75, 10, "This is left aligned text").print();
        new Txt(75, 12, "This is right aligned text").print_right_aligned();
        new Txt(75, 14, "This is centered text").print_centered();
        new Txt(75, 15, "|").print();
        new Txt(75, 20, "Okay, that's all folks. You can press ESC to quit...").print_centered();

    }
}
