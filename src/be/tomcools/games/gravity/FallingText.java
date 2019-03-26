package be.tomcools.games.gravity;

import be.tomcools.framework.DrawableItem;
import be.tomcools.framework.gameloop.ARGBColor;
import be.tomcools.framework.gameloop.Graphics;
import be.tomcools.framework.physics.Item;
import be.tomcools.framework.physics.Vector2;

public class FallingText extends DrawableItem {

    private final ARGBColor color;
    private String character;

    public FallingText(Vector2 location, String character, ARGBColor color) {
        super(location);
        this.character = character;
        this.color = color;
    }

    public String getCharacter() {
        return character;
    }

    @Override
    public void draw(Graphics g) {
        g.drawString(character,location.getX(),location.getY(),color);
    }
}
