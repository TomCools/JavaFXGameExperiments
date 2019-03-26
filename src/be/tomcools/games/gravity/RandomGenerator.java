package be.tomcools.games.gravity;

import javafx.scene.input.KeyCode;

import java.util.Random;

public class RandomGenerator {
    private static final String letters = "abcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();

    public static KeyCode character() {
        return KeyCode.valueOf(Character.toString(letters.charAt(random.nextInt(letters.length()))).toUpperCase());
    }

    public static int integer(int max) {
        return random.nextInt(max);
    }
}
