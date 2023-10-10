package net.elypsaclient.utils;

public class TimerUtil {
    public long lastMilliSecond = System.currentTimeMillis();
    public void resetTimer() {
        lastMilliSecond = System.currentTimeMillis();
    }

    public boolean hasTimePassed(long time, boolean reset) {
        if (System.currentTimeMillis() - lastMilliSecond > time) {
            if (reset) resetTimer();
            return true;
        }
        return false;
    }
}
