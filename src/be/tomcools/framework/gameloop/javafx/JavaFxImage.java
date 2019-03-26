package be.tomcools.framework.gameloop.javafx;

import be.tomcools.framework.gameloop.Graphics;
import be.tomcools.framework.gameloop.Image;

public class JavaFxImage implements Image {
    private javafx.scene.image.Image image;

    public JavaFxImage(String url) {
        this.image = new javafx.scene.image.Image(url);
    }

    @Override
    public int getWidth() {
        return Double.valueOf(image.getWidth()).intValue();
    }

    @Override
    public int getHeight() {
        return Double.valueOf(image.getHeight()).intValue();
    }

    @Override
    public Graphics.ImageFormat getFormat() {
        return Graphics.ImageFormat.RGB565;
    }

    @Override
    public void dispose() {

    }

    public javafx.scene.image.Image getImage() {
        return image;
    }
}
