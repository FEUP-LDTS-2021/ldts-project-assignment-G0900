import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Arena {

    private final int width;
    private final int height;
    private final Bird bird;
    private Matrix matrix;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new Matrix(width,height,' ') ;
        this.bird = new Bird(new Position(width/2, height/2), 'B', "#000000");
    }

    Arena(int width, int height, Bird bird) {
        this.width = width;
        this.height = height;
        this.bird = bird;
    }

    private int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - (min)) + 1) + (min);
    }


    private Matrix createMatrix() {
        return null;
    }

    public void addRandomElem(int numberOfElem, Character Char) {

    }


    private boolean canBirdMove(Position pos) {
        return false;
    }

    private void moveBird(Position pos) {

    }

    private boolean detectCollision(Matrix newM, Element b) {
        return false;
    }

    public void applyGravity() {

    }

    private boolean canApplyGravity(Element e) {
        return false;
    }


    private void matrixDraw(TextGraphics graphics) {

    }


    private void matrixUpdate() {

    }

    public boolean playerAlive() {
        return false;
    }

    public void draw(TextGraphics graphics) {

    }


    public void drawLoadingScreen(TextGraphics graphics) {

    }


    public void drawDeathScreen(TextGraphics graphics) {

    }

}