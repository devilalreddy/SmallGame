package game;

public class Time {
    private int updateSinceStart;

    public Time() {
        this.updateSinceStart = 0;
    }

    public int getUpdateFromSeconds(int seconds) {
        return seconds * GameLoop.UPDATES_PER_SECOND;
    }
}
