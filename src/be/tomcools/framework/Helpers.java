package be.tomcools.framework;

import be.tomcools.framework.gameloop.ARGBColor;
import be.tomcools.framework.gameloop.Graphics;
import be.tomcools.framework.physics.BoundingBox;
import be.tomcools.framework.physics.Vector2;

import java.util.Collection;

public class Helpers {
    public static BoundingBox toBoundingBox(Vector2 location, int width, int height) {
        return new BoundingBox(location.getX(), location.getY(), width, height);
    }

    public static void drawBoundingBoxes(Collection<BoundingBox> boxes, Graphics g) {
        boxes.forEach(box -> {
            g.drawRect(box.getX(), box.getY(), box.getWidth(), box.getWidth(), ARGBColor.RED);
        });
    }
}
