package main.states;


import engine.Colors;
import engine.Txt;
import main.assets.Sprites;
import main.entities.Entity;

public class Game extends State {

    Entity box;
    Entity gun;

    public Game() {
        super("game");
        box = new Entity(5, 5, 5, 3, Sprites.spr_box);
        gun = new Entity(100, 5, 8, 2, Sprites.spr_blaster);
    }

    @Override
    public void render() {
        new Txt(10, 10, "This is the Game Screen! This is the end of the demo. Press Escape to quit").print();
        box.draw(Colors.black, Colors.white);
        gun.draw(Colors.red, Colors.white);

    }
}
