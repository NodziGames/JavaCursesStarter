package main.states;


import com.googlecode.lanterna.input.KeyType;
import engine.Colors;
import engine.Txt;
import main.assets.Sprites;
import main.entities.Entity;
import main.entities.Player;

public class Game extends State {

   public Entity player;
   public Entity box;

    public Game() {
        super("game");
        player = new Player(5, 5, 3, 3, Sprites.spr_player);
        box = new Entity(20, 20, 5, 3, Sprites.spr_box);
    }

    @Override
    public void logic(KeyType key) {

        if (key == KeyType.ArrowUp && player.y > 1)
            player.move(0, -1);
        if (key == KeyType.ArrowDown && player.y < 149)
            player.move(0, 1);
        if (key == KeyType.ArrowLeft && player.x > 1)
            player.move(-1, 0);
        if (key == KeyType.ArrowRight && player.x < 149)
            player.move(1, 0);
    }

    @Override
    public void render() {
        player.draw();
        box.draw();
    }
}
