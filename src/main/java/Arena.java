import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Arena {

    //Characters
    public final static Character birdChar = 'B';
    public final static Character blockChar = 'X';
    public final static Character borderChar = '+';
    public final static Character coinChar = 'C';

    //Colors
    private final static String textColor = "#000000";
    private final static String BirdColor = "#FFFFFF";
    private final static String bgColor = "#3A656C";
    private final static String coinColor = "#FFAA11";
    private final static String blockColor = "#4B351C";
    private final static String borderColor = "#653A6C";

    //Attributes
    private final int width;
    private final int height;
    private final Bird bird;
    private final Matrix matrix;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = createMatrix(width, height, ' ');

        Position initialBirdPos = new Position(width / 2, height / 2);
        this.bird = new Bird(initialBirdPos, 'B', "#000000");
    }

    Arena(int width, int height, Bird bird) {
        this.width = width;
        this.height = height;
        this.bird = bird;
        matrix = createMatrix(width, height, ' ');
    }

    private int randInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - (min)) + 1) + (min);
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public Matrix createMatrix(int width, int height, Character defaultChar) {
        Matrix temp = new Matrix(width, height, defaultChar);

        for (int c = 0; c < width; c++) {
            temp.setPos(new Element(c, 0, borderChar, borderColor));
            temp.setPos(new Element(c, height - 1, borderChar, borderColor));
        }

        for (int r = 1; r < height - 1; r++) {
            temp.setPos(new Element(0, r, borderChar, borderColor));
            temp.setPos(new Element(width - 1, r, borderChar, borderColor));
        }

        return temp;
    }

    public void addRandomElem(int numberOfElem, Character Char) {
        String color;
        int x, y;

        if (Char == blockChar)
            color = blockColor;
        else color = coinColor;

        for (int i = 0; i < numberOfElem; i++) {
            x = randInt(1, width - 2);
            y = 2;
            matrix.setPos(new Element(x, y, Char, color));
            matrix.setPos(new Element(x, y, Char, color));
        }
    }

    public boolean canBirdMove(Position pos) {
        return false;
    }

    public boolean moveBird(Position pos) {
        if(canBirdMove(pos)){
            bird.setPos(pos);
            return true;
        } else return false;
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
        return bird.isAlive();
    }

    public void update(TextGraphics graphics) {
        applyGravity();
        matrixUpdate();

        if (isMatrixBottomRowFull())
            removeMatrixBottomRow();
    }

    private void removeMatrixBottomRow() {
        for (int y = height - 2; y > 1; y--)
            for (int x = width - 1; x > 1; x--)
                matrix.getPos(x, y).gravityMoveDown();
    }

    private boolean isMatrixBottomRowFull() {
        boolean isLineFull = true;

        for (int x = 0; x < width; x++) {
            Character c = matrix.getPos(x, height - 2).getChar();
            if (c == '.' || c == birdChar)
                isLineFull = false;
        }
        return isLineFull;
    }

    public void draw(TextGraphics graphics) {
        //Set screen
        graphics.setBackgroundColor(TextColor.Factory.fromString(bgColor));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');

        //Game Logic
        update(graphics);

        //Draw updated matrix
        matrixDraw(graphics);

        //draw picked up coins
        graphics.setForegroundColor(TextColor.Factory.fromString(textColor));
        graphics.putString(new TerminalPosition(width - 12, 1), "Score: " + bird.getCoinCount());

        //draw lifePoints
        graphics.setForegroundColor(TextColor.Factory.fromString(textColor));
        graphics.putString(new TerminalPosition(2, 1), "HP: " + bird.getHp());
    }


    public void drawLoadingScreen(TextGraphics graphics) {

    }


    public void drawDeathScreen(TextGraphics graphics) {

    }

}