package birdrun.controller.arena;

import birdrun.controller.MatrixFactory;
import birdrun.model.*;

import static birdrun.controller.arena.ArenaController.*;

public class ArenaUpdater {

    private final ArenaModel arenaModel;
    private final int width;
    private final int height;

    public ArenaUpdater(ArenaModel arenaModel) {

        this.arenaModel = arenaModel;
        this.width = arenaModel.getDimensions().getWidth();
        this.height = arenaModel.getDimensions().getHeight();

    }

    public boolean isMatrixBottomRowFull() {
        Matrix matrix = arenaModel.getMatrix();

        for (int x = 1; x < width - 1; x++) {
            Character c = matrix.getPos(x, height - 2).getChar();
            if (!c.equals(blockChar)) return false;
        }

        return true;
    }

    public String updateBirdColor() {

        int stamina = arenaModel.getBirdStamina();

        if (stamina < 50) {
            birdColor = "#C51663";
        } else if (stamina < 100) {
            birdColor = "#BEC516";
        } else {
            birdColor = "#FFFFFF";
        }

        arenaModel.setBirdColor(birdColor);

        return birdColor;
    }

    public void matrixUpdate() {

        Matrix matrix = arenaModel.getMatrix();
        Bird bird = arenaModel.getBird();

        Matrix newMatrix = new MatrixFactory().getMatrix(new Dimensions(width, height), borderChar, borderColor);
        newMatrix.setPos(bird);

        Element b = null;

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                Element e = matrix.getPos(x, y);
                if (e.getChar().equals(birdChar)) b = e;
                else if (e.getChar() != ' ') newMatrix.setPos(e);
            }

        newMatrix.setPos(b);

        arenaModel.setBird(bird);
        arenaModel.setMatrix(newMatrix);

    }

    public boolean updateArena() {
        updateBirdColor();
        matrixUpdate();

        if (isMatrixBottomRowFull()) arenaModel.removeMatrixBottomRow();

        return arenaModel.getPlayerHp() > 0;
    }


}

