package main.entities;

import com.googlecode.lanterna.TextColor;
import engine.Txt;

public class Entity {

    private int x;
    private int y;

    private int width;
    private int height;

    private String graphics;

    public Entity(int x, int y, int width, int height, String sprite) {

        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

        this.graphics = sprite;

    }

    public void draw(TextColor.ANSI bgColor, TextColor.ANSI fgColor) {

        for (int yy = 0; yy < height; yy++) {
            for (int xx = 0; xx < width; xx++) {
                new Txt(x + xx, y + yy, String.valueOf(graphics.charAt((yy * width) + xx)), bgColor, fgColor).print();
            }
        }
    }
}
