package be.tomcools.framework.gameloop;


/**
 * Created by tomco on 6/12/2016.
 */
public interface Graphics {
    public static enum ImageFormat {
        ARGB8888, ARGB4444, RGB565
    }

    Image newImage(String fileName, ImageFormat format);

    void clearScreen(ARGBColor color);

    void drawLine(int x, int y, int x2, int y2, ARGBColor color);

    void drawRect(int x, int y, int width, int height, ARGBColor color);

    void drawImage(Image image, int x, int y, int srcX, int srcY,
                   int srcWidth, int srcHeight);

    void drawImage(Image Image, int x, int y);

    void drawString(String text, int x, int y, ARGBColor color);

    int getWidth();

    int getHeight();

    void drawARGB(int i, int j, int k, int l);

}
