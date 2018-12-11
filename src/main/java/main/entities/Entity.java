package main.entities;

import com.googlecode.lanterna.TextColor;
import engine.Colors;
import engine.Txt;

public class Entity {

    public int x;
    public int y;

    public int width;
    public int height;

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

    public void draw() {
        for (int yy = 0; yy < height; yy++) {
            for (int xx = 0; xx < width; xx++) {
                new Txt(x + xx, y + yy, String.valueOf(graphics.charAt((yy * width) + xx)), Colors.black, Colors.white).print();
            }
        }
    }

    public void move(int xspeed, int yspeed) {
        this.x += xspeed;
        this.y += yspeed;
    }

    public void setPos(int xpos, int ypos) {
        this.x = xpos;
        this.y = ypos;
    }

    public boolean collisionWith(Entity entity) {

        if (x + width - 1 < entity.x || x > entity.x + entity.width - 1 || y + height - 1 < entity.y || y > entity.x + entity.height - 1)
            return false;
        else
            return true;
    }
}
