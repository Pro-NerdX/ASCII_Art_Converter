package tests;

import java.util.concurrent.TimeUnit;

public class Tests {

    final String inputPath = "src/tests/resources/";
    final String outputPath = "src/tests/results/";

    public void waitForIt(final int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
            assert (false);
        }
    }
}
