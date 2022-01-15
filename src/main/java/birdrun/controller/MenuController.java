package birdrun.controller;

import birdrun.model.Dimensions;
import birdrun.viewer.menu.Death_MenuViewer;
import birdrun.viewer.menu.Initial_MenuViewer;
import birdrun.viewer.menu.Instructions_MenuViewer;
import birdrun.viewer.menu.Pause_MenuViewer;
import com.googlecode.lanterna.graphics.TextGraphics;


public class MenuController {

    private final Initial_MenuViewer initialViewer;
    private final Instructions_MenuViewer instructionsViewer;
    private final Pause_MenuViewer pauseViewer;
    private final Death_MenuViewer deathViewer;

    private final TextGraphics graphics;


    public MenuController(Dimensions dimensions, TextGraphics graphics, String bgColor, String textColor) {
        this.graphics = graphics;

        this.initialViewer = new Initial_MenuViewer(dimensions, bgColor, textColor);
        this.deathViewer = new Death_MenuViewer(dimensions, bgColor, textColor);
        this.pauseViewer = new Pause_MenuViewer(dimensions, bgColor, textColor);
        this.instructionsViewer = new Instructions_MenuViewer(dimensions, bgColor, textColor);

    }

    public void drawState(MENU_STATE state) {
        switch (state) {
            case INITIAL:
                initialViewer.draw(graphics);
                break;
            case INSTRUCTIONS:
                instructionsViewer.draw(graphics);
                break;
            case PAUSE:
                pauseViewer.draw(graphics);
                break;
            default:
                break;
        }
    }

    public void drawState(MENU_STATE state, int score) {
        if (state == MENU_STATE.DEATH) deathViewer.draw(graphics, score);
    }

    public enum MENU_STATE {INITIAL, DEATH, INSTRUCTIONS, PAUSE, NONE}


}