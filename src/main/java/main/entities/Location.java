package main.entities;

import engine.Colors;
import engine.Txt;

public class Location extends Entity {

    public String name;

    public Location(int x, int y, int width, int height, String sprite, String name) {
        super(x, y, width, height, sprite);
        this.name = name;
    }

    @Override
    public void draw() {
        for (int yy = 0; yy < height; yy++) {
            for (int xx = 0; xx < width; xx++) {
                new Txt(x + xx, y + yy, String.valueOf(graphics.charAt((yy * width) + xx)), Colors.black, Colors.white).print();
            }
        }
        new Txt(x + (int)Math.floor(width / 2), y - 2, "[" + name + "]").print_centered();
    }

    public void drawHighlighted() {
        for (int yy = 0; yy < height; yy++) {
            for (int xx = 0; xx < width; xx++) {
                new Txt(x + xx, y + yy, String.valueOf(graphics.charAt((yy * width) + xx)), Colors.black, Colors.white).print();
            }
        }
        new Txt(x + (int)Math.floor(width / 2), y - 2, "[" + name + "]", Colors.white, Colors.black).print_centered();
    }
}
