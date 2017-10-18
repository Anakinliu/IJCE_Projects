package com.anakinliu.demo;

import java.io.PrintStream;

/**
 * Created by Anakinliu on 17.10.13.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Embarking on quest to" +
                "slay the dragon! ");
    }
}
