package birdrun.controller;

import birdrun.controller.arena.ArenaController;
import birdrun.model.Dimensions;
import birdrun.state.Command;
import birdrun.state.KeyboardObserver;
import birdrun.state.states.DeathMenuState;
import birdrun.state.states.InstructionsMenuState;
import birdrun.state.states.PauseMenuState;
import birdrun.state.states.StartMenuState;
import birdrun.viewer.GameViewer;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


@SuppressWarnings("CatchAndPrintStackTrace")

public class GameController {

    private final ArenaController arena;
    private final PauseMenuState pauseMenuState;
    private final StartMenuState startMenuState;
    private final DeathMenuState deathMenuState;
    private final InstructionsMenuState instructionsMenuState;
    private final Screen screen;
    private final TextGraphics graphics;
    private final KeyboardObserver keyboardObserver;
    private final long fps = 30;
    private STATE state = STATE.START;
    private int gameLoopInt = 0;
    private int resetCountGameLoop = 1;
    private boolean runGame = true;
    private boolean isMusicPlaying = false;


    public GameController(Dimensions dimensions) throws IOException, URISyntaxException, FontFormatException {

        this.screen = new ScreenFactory().getScreen(dimensions, 35);
        this.graphics = screen.newTextGraphics();
        this.arena = new ArenaController(dimensions);
        MenuController menuController = new MenuController(dimensions, graphics, ArenaController.bgColor, ArenaController.textColor);


        this.pauseMenuState = new PauseMenuState(screen, menuController);
        this.startMenuState = new StartMenuState(screen, menuController);
        this.deathMenuState = new DeathMenuState(screen, menuController);
        this.instructionsMenuState = new InstructionsMenuState(screen, menuController);

        this.keyboardObserver = new KeyboardObserver(screen);
    }

    public GameController.STATE gameState() throws InterruptedException, IOException {

        if (!isMusicPlaying) {
            arena.startBgMusic();
            isMusicPlaying = true;
        } else {
            arena.resumeBgMusic();
        }

        long frameTime = 1000 / fps;

        while (arena.playerAlive()) {
            long startTime = System.currentTimeMillis();

            drawGameView();

            if (!runGame) {
                arena.pauseBgMusic();
                return GameController.STATE.PAUSE;
            }

            gameTick();

            arena.updateArena();
            if (!arena.playerAlive()) return GameController.STATE.DEATH;

            long sleepTime = frameTime - (System.currentTimeMillis() - startTime);

            if (sleepTime > 0) Thread.sleep(sleepTime);

        }
        return null;
    }

    private void gameTick() {
        if (gameLoopInt % 6== 0) {
            arena.addRandomElem(ArenaController.FallingElem.BLOCK, 1);
        }
        if (gameLoopInt % 5 == 0) {
            arena.applyGravity();
        }
        if (gameLoopInt == 170) {
            arena.addRandomElem(ArenaController.FallingElem.COIN, 1);
            gameLoopInt = 0;
            resetCountGameLoop++;
        }
        if (resetCountGameLoop % 20 == 0) {
            arena.addRandomElem(ArenaController.FallingElem.LIFE, 1);
            gameLoopInt = 0;
            resetCountGameLoop++;
        }

        gameLoopInt++;
    }

    private void drawGameView() throws IOException {
        screen.clear();
        new GameViewer().draw(screen, graphics, arena.getArenaModel(), arena.getArenaViewer());
        screen.refresh();

        Command.COMMAND command = keyboardObserver.listenPoll();
        runGame = arena.executeCommand(command);
    }

    public void run() throws IOException, InterruptedException {

        while (true) {

            int score = arena.getPlayerScore();
            if (this.state == STATE.DEATH) {
                arena.reloadArena();
                arena.resetBgMusic();
            }

            switch (this.state) {
                case START:
                    this.state = startMenuState.start();
                    break;
                case PAUSE:
                    this.state = pauseMenuState.start();
                    break;
                case GAME:
                    this.state = gameState();
                    break;
                case INSTRUCTIONS:
                    this.state = instructionsMenuState.start();
                    break;
                case DEATH:
                    this.state = deathMenuState.start(score);
                    break;
                case NONE:
                    System.exit(0);
            }
        }
    }

    public enum STATE {START, INSTRUCTIONS, GAME, DEATH, PAUSE, NONE}

}

