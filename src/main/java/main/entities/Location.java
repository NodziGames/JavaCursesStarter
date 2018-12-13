package main.entities;

import engine.Colors;
import engine.Txt;

public class Location extends Entity {

    public String name;
    public int risk;

    public Location(int x, int y, int width, int height, String sprite, String name, int risk) {
        super(x, y, width, height, sprite);
        this.name = name;
        this.risk = risk;
    }

    @Override
    public void draw() {
        for (int yy = 0; yy < height; yy++) {
            for (int xx = 0; xx < width; xx++) {
                new Txt(x + xx, y + yy, String.valueOf(graphics.charAt((yy * width) + xx)), Colors.black, Colors.white).print();
            }
        }
        new Txt(x + (int)Math.floor(width / 2), y - 2, "[" + name + "]").print_centered();

        if (risk <= 25) {
            new Txt(x + (int)Math.floor(width / 2), y + height + 2, "Risk: " + String.valueOf(risk) + "%", Colors.black, Colors.white).print_centered();
        }
        else if (risk <= 40) {
            new Txt(x + (int)Math.floor(width / 2), y + height + 2, "Risk: " + String.valueOf(risk) + "%", Colors.black, Colors.yellow).print_centered();
        }
        else {
            new Txt(x + (int)Math.floor(width / 2), y + height + 2, "Risk: " + String.valueOf(risk) + "%", Colors.black, Colors.red).print_centered();
        }

    }

    public void drawHighlighted() {
        for (int yy = 0; yy < height; yy++) {
            for (int xx = 0; xx < width; xx++) {
                new Txt(x + xx, y + yy, String.valueOf(graphics.charAt((yy * width) + xx)), Colors.black, Colors.white).print();
            }
        }
        new Txt(x + (int)Math.floor(width / 2), y - 2, "[" + name + "]", Colors.white, Colors.black).print_centered();

        if (risk <= 25) {
            new Txt(x + (int)Math.floor(width / 2), y + height + 2, "Risk: " + String.valueOf(risk) + "%", Colors.black, Colors.white).print_centered();
        }
        else if (risk <= 40) {
            new Txt(x + (int)Math.floor(width / 2), y + height + 2, "Risk: " + String.valueOf(risk) + "%", Colors.black, Colors.yellow).print_centered();
        }
        else {
            new Txt(x + (int)Math.floor(width / 2), y + height + 2, "Risk: " + String.valueOf(risk) + "%", Colors.black, Colors.red).print_centered();
        }
    }
}
