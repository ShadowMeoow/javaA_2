package controller;

import model.Direction;
import model.MapModel;
import view.game.BoxComponent;
import view.game.GamePanel;

/**
 * It is a bridge to combine GamePanel(view) and MapMatrix(model) in one game.
 * You can design several methods about the game logic in this class.
 */
public class GameController {
    private final GamePanel view;
    private final MapModel model;

    public GameController(GamePanel view, MapModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
    }

    public void restartGame() {
        System.out.println("Do restart game here");
        model.reset();
        view.restart();
    }
    public void rollbackGame(){
        System.out.println("Do rollback game here");
        model.rollback();
        view.rollback();
    }

    public boolean doMove(int row, int col, Direction direction) {
        if (model.getId(row, col) == 1) {
            int nextRow = row + direction.getRow();
            int nextCol = col + direction.getCol();
            if (model.checkInHeightSize(nextRow) && model.checkInWidthSize(nextCol)) {
                if (model.getId(nextRow, nextCol) == 0) {
                    model.getMatrix()[row][col] = 0;
                    model.getMatrix()[nextRow][nextCol] = 1;
                    model.record();
                    BoxComponent box = view.getSelectedBox();
                    box.setRow(nextRow);
                    box.setCol(nextCol);
                    box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                    box.repaint();
                    return true;
                }
            }
        }
        if (model.getId(row, col) == 2) {
            int nextRow = row + direction.getRow();
            int nextCol = col + direction.getCol();
                if (direction.getRow()==0&&direction.getCol()==-1){
                    if (model.checkInWidthSize(nextCol)) {
                        if (model.getId(nextRow, nextCol) == 0) {
                            model.getMatrix()[row][col+1] = 0;
                            model.getMatrix()[nextRow][nextCol] = 2;
                            model.record();
                            BoxComponent box = view.getSelectedBox();
                            box.setRow(nextRow);
                            box.setCol(nextCol);
                            box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                            box.repaint();
                            return true;
                        }
                    }
                }
                else if (direction.getRow()==0&&direction.getCol()==1){
                    if (model.checkInWidthSize(nextCol+1)) {
                        if (model.getId(nextRow, nextCol+1) == 0) {
                            model.getMatrix()[row][col] = 0;
                            model.getMatrix()[nextRow][nextCol+1] = 2;
                            model.record();
                            BoxComponent box = view.getSelectedBox();
                            box.setRow(nextRow);
                            box.setCol(nextCol);
                            box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                            box.repaint();
                            return true;
                        }
                    }
                }
                else if (direction.getRow()==-1&&direction.getCol()==0){
                    if (model.checkInHeightSize(nextRow)){
                        if (model.getId(nextRow, nextCol) == 0&&model.getId(nextRow, nextCol+1) == 0) {
                            model.getMatrix()[row][col] = 0;
                            model.getMatrix()[row][col+1] = 0;
                            model.getMatrix()[nextRow][nextCol] = 2;
                            model.getMatrix()[nextRow][nextCol+1] = 2;
                            model.record();
                            BoxComponent box = view.getSelectedBox();
                            box.setRow(nextRow);
                            box.setCol(nextCol);
                            box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                            box.repaint();
                            return true;
                        }
                    }
                }
                else if (direction.getRow()==1&&direction.getCol()==0){
                    if (model.checkInHeightSize(nextRow)){
                        if (model.getId(nextRow, nextCol) == 0&&model.getId(nextRow, nextCol+1) == 0) {
                            model.getMatrix()[row][col] = 0;
                            model.getMatrix()[row][col+1] = 0;
                            model.getMatrix()[nextRow][nextCol] = 2;
                            model.getMatrix()[nextRow][nextCol+1] = 2;
                            model.record();
                            BoxComponent box = view.getSelectedBox();
                            box.setRow(nextRow);
                            box.setCol(nextCol);
                            box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                            box.repaint();
                            return true;
                        }
                    }
                }
            }
        if (model.getId(row, col) == 3) {
            int nextRow = row + direction.getRow();
            int nextCol = col + direction.getCol();
            if (direction.getRow()==0&&direction.getCol()==-1){
                if (model.checkInWidthSize(nextCol)) {
                    if (model.getId(nextRow, nextCol) == 0&&model.getId(nextRow+1, nextCol) == 0) {
                        model.getMatrix()[row][col] = 0;
                        model.getMatrix()[row+1][col] = 0;
                        model.getMatrix()[nextRow][nextCol] = 3;
                        model.getMatrix()[nextRow+1][nextCol] = 3;
                        model.record();
                        BoxComponent box = view.getSelectedBox();
                        box.setRow(nextRow);
                        box.setCol(nextCol);
                        box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                        box.repaint();
                        return true;
                    }
                }
            }
            else if (direction.getRow()==0&&direction.getCol()==1){
                if (model.checkInWidthSize(nextCol+1)) {
                    if (model.getId(nextRow, nextCol) == 0&&model.getId(nextRow+1, nextCol) == 0) {
                        model.getMatrix()[row][col] = 0;
                        model.getMatrix()[row+1][col] = 0;
                        model.getMatrix()[nextRow][nextCol] = 3;
                        model.getMatrix()[nextRow+1][nextCol] = 3;
                        model.record();
                        BoxComponent box = view.getSelectedBox();
                        box.setRow(nextRow);
                        box.setCol(nextCol);
                        box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                        box.repaint();
                        return true;
                    }
                }
            }
            else if (direction.getRow()==-1&&direction.getCol()==0){
                if (model.checkInHeightSize(nextRow)){
                    if (model.getId(nextRow, nextCol) == 0) {
                        model.getMatrix()[row+1][col] = 0;
                        model.getMatrix()[nextRow][nextCol] = 3;
                        model.record();
                        BoxComponent box = view.getSelectedBox();
                        box.setRow(nextRow);
                        box.setCol(nextCol);
                        box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                        box.repaint();
                        return true;
                    }
                }
            }
            else if (direction.getRow()==1&&direction.getCol()==0){
                if (model.checkInHeightSize(nextRow+1)){
                    if (model.getId(nextRow+1, nextCol) == 0) {
                        model.getMatrix()[row][col] = 0;
                        model.getMatrix()[nextRow+1][nextCol] = 3;
                        model.record();
                        BoxComponent box = view.getSelectedBox();
                        box.setRow(nextRow);
                        box.setCol(nextCol);
                        box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                        box.repaint();
                        return true;
                    }
                }
            }
        }
        if (model.getId(row, col) == 4) {
            int nextRow = row + direction.getRow();
            int nextCol = col + direction.getCol();
            if (direction.getRow()==0&&direction.getCol()==-1){
                if (model.checkInWidthSize(nextCol)) {
                    if (model.getId(nextRow, nextCol) == 0&&model.getId(nextRow+1, nextCol) == 0) {
                        model.getMatrix()[row][col+1] = 0;
                        model.getMatrix()[row+1][col+1] = 0;
                        model.getMatrix()[nextRow][nextCol] = 4;
                        model.getMatrix()[nextRow+1][nextCol] = 4;
                        model.record();
                        BoxComponent box = view.getSelectedBox();
                        box.setRow(nextRow);
                        box.setCol(nextCol);
                        box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                        box.repaint();
                        return true;
                    }
                }
            }
            else if (direction.getRow()==0&&direction.getCol()==1){
                if (model.checkInWidthSize(nextCol+1)) {
                    if (model.getId(nextRow, nextCol+1) == 0&&model.getId(nextRow+1, nextCol+1) == 0) {
                        model.getMatrix()[row][col] = 0;
                        model.getMatrix()[row+1][col] = 0;
                        model.getMatrix()[nextRow][nextCol+1] = 4;
                        model.getMatrix()[nextRow+1][nextCol+1] = 4;
                        model.record();
                        BoxComponent box = view.getSelectedBox();
                        box.setRow(nextRow);
                        box.setCol(nextCol);
                        box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                        box.repaint();
                        return true;
                    }
                }
            }
            else if (direction.getRow()==-1&&direction.getCol()==0){
                if (model.checkInHeightSize(nextRow)){
                    if (model.getId(nextRow, nextCol) == 0&&model.getId(nextRow, nextCol+1) == 0) {
                        model.getMatrix()[row+1][col] = 0;
                        model.getMatrix()[row+1][col+1] = 0;
                        model.getMatrix()[nextRow][nextCol] = 4;
                        model.getMatrix()[nextRow][nextCol+1] = 4;
                        model.record();
                        BoxComponent box = view.getSelectedBox();
                        box.setRow(nextRow);
                        box.setCol(nextCol);
                        box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                        box.repaint();
                        return true;
                    }
                }
            }
            else if (direction.getRow()==1&&direction.getCol()==0){
                if (model.checkInHeightSize(nextRow)){
                    if (model.getId(nextRow+1, nextCol) == 0&&model.getId(nextRow+1, nextCol+1) == 0) {
                        model.getMatrix()[row][col] = 0;
                        model.getMatrix()[row][col+1] = 0;
                        model.getMatrix()[nextRow+1][nextCol] = 4;
                        model.getMatrix()[nextRow+1][nextCol+1] = 4;
                        model.record();
                        BoxComponent box = view.getSelectedBox();
                        box.setRow(nextRow);
                        box.setCol(nextCol);
                        box.setLocation(box.getCol() * view.getGRID_SIZE() + 2, box.getRow() * view.getGRID_SIZE() + 2);
                        box.repaint();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //todo: add other methods such as loadGame, saveGame...

}
