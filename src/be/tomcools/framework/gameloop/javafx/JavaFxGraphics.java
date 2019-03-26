package be.tomcools.framework.gameloop.javafx;

import be.tomcools.framework.gameloop.Graphics;
import be.tomcools.framework.gameloop.Image;
import be.tomcools.framework.gameloop.ARGBColor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class JavaFxGraphics implements Graphics {
    private final Canvas canvas;
    private final GraphicsContext g;

    public JavaFxGraphics(Canvas canvas) {
        this.canvas = canvas;
        g = canvas.getGraphicsContext2D();
    }

    @Override
    public Image newImage(String fileName, ImageFormat format) {
        return null;
    }

    @Override
    public void clearScreen(ARGBColor color) {
        g.setFill(convert(color));
        g.fillRect(0,0,getWidth(),getHeight());
    }

    @Override
    public void drawLine(int x, int y, int x2, int y2, ARGBColor color) {

    }

    @Override
    public void drawRect(int x, int y, int width, int height, ARGBColor  c) {
        g.setFill(Color.rgb(c.getRed(), c.getGreen(), c.getBlue()));
        g.fillRect(x,y,width,height);
    }

    @Override
    public void drawImage(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight) {

    }

    @Override
    public void drawImage(Image image, int x, int y) {
        javafx.scene.image.Image javaImage = ((JavaFxImage) image).getImage();
        g.drawImage(javaImage,x,y);
    }

    @Override
    public void drawString(String text, int x, int y, ARGBColor color) {
        g.setFont(Font.font ("Verdana", 30));
        g.setFill(convert(color));
        g.fillText(text,x,y);
    }

    @Override
    public int getWidth() {
        return (int)canvas.getWidth();
    }

    @Override
    public int getHeight() {
        return (int)canvas.getHeight();
    }

    @Override
    public void drawARGB(int i, int j, int k, int l) {

    }

    private Color convert(ARGBColor color) {
        return Color.rgb(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha());
    }


}
