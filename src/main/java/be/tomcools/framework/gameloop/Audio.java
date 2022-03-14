package be.tomcools.framework.gameloop;

public interface Audio {
    public Music createMusic(String file);

    public Sound createSound(String file);
}
