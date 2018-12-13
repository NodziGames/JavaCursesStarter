package main.states;


import com.googlecode.lanterna.input.KeyType;
import engine.Colors;
import main.assets.Sprites;
import main.controllers.Player;
import main.entities.Entity;
import main.entities.Location;

import java.util.ArrayList;
import java.util.List;

public class Game extends State {

   public List<Location> locations = new ArrayList<>();
   public Player player = new Player();
   private int selection = 0;

    public Game() {
        super("game");

        locations.add(new Location(20, 10, 8, 5, Sprites.spr_house1, "Residence 1"));
        locations.add(new Location(40, 10, 8, 5, Sprites.spr_house1, "Residence 2"));
        locations.add(new Location(30, 20, 8, 5, Sprites.spr_house1, "Residence 3"));
    }

    @Override
    public void logic(KeyType key) {

        if (key == KeyType.ArrowRight) {
            if (selection == locations.size() - 1) {
                selection = 0;
            }
            else {
                selection += 1;
            }
        }

        if (key == KeyType.ArrowLeft) {
            if (selection == 0) {
                selection = locations.size() - 1;
            }
            else {
                selection -= 1;
            }
        }
    }

    @Override
    public void render() {
        for (int i = 0; i < locations.size(); i++) {
            if (i == selection) {
                locations.get(i).drawHighlighted();
            }
            else {
                locations.get(i).draw();
            }
        }
        player.draw();
    }
}
