package com.anakinliu.demo;

/**
 * Created by Anakinliu on 17.10.13.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class BraveKnight implements Knight {
    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
