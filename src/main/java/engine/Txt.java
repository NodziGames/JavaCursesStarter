package engine;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import main.Application;

public class Txt {

    private int x;
    private int y;
    private String text;
    private TextColor.ANSI bgColor;
    private TextColor.ANSI fgColor;

    //Only  text (Draws at cursor pos)
    public Txt(String text) {
        this.x = Application.screen.getCursorPosition().getColumn();
        this.y = Application.screen.getCursorPosition().getRow();
        this.text = text;
        bgColor = TextColor.ANSI.BLACK;
        fgColor = TextColor.ANSI.WHITE;
    }

    //Only coords and text
    public Txt(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
        bgColor = TextColor.ANSI.BLACK;
        fgColor = TextColor.ANSI.WHITE;
    }

    //Only  text and COLORS (Draws at cursor pos)
    public Txt(String text, TextColor.ANSI bgColor, TextColor.ANSI fgColor) {
        this.x = Application.screen.getCursorPosition().getColumn();
        this.y = Application.screen.getCursorPosition().getRow();
        this.text = text;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
    }

    //Full Constructor
    public Txt(int x, int y, String text, TextColor.ANSI bgColor, TextColor.ANSI fgColor) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
    }

    public void print() {
        TextGraphics finalText = Application.screen.newTextGraphics();
        finalText.setBackgroundColor(bgColor);
        finalText.setForegroundColor(fgColor);
        finalText.putString(x, y, text);
    }
}
