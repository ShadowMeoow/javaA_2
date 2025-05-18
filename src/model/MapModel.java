package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is to record the map of one game. For example:
 */
public class MapModel{
    int[][] matrix;
    ArrayList<int[][]> history=new ArrayList<>();

    public ArrayList<int[][]> getHistory() {
        return history;
    }

    public MapModel(int[][] matrix) {
        this.matrix = matrix;
        int[][] initial=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            initial[i]=Arrays.copyOf(matrix[i],matrix[i].length);
        }
        history.add(initial);
    }

    public int getWidth() {
        return this.matrix[0].length;
    }

    public void setHistory(ArrayList<int[][]> history) {
        this.history = history;
    }

    public int getHeight() {
        return this.matrix.length;
    }

    public int getId(int row, int col) {
        return matrix[row][col];
    }
    public void record(){
        int[][] current=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            current[i]=Arrays.copyOf(matrix[i],matrix[i].length);
        }
        history.add(current);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public boolean checkInWidthSize(int col) {
        return col >= 0 && col < matrix[0].length;
    }

    public boolean checkInHeightSize(int row) {
        return row >= 0 && row < matrix.length;
    }
    public void reset(){
        matrix= history.getFirst();
    }
    public  void rollback(){
        matrix= history.get(history.size()-2);
    }
}
