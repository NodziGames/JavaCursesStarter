package engine;

import com.googlecode.lanterna.input.KeyType;
import main.Application;

import java.io.IOException;

public class Functions {

    //Class consisting of static functions that simplify your development process

    public static KeyType getPressed() throws IOException {
        return Application.terminal.readInput().getKeyType();
    }
}
