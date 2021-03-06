/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ukos.logics;

/**
 *
 * @author Ukita
 */
public class ScoreCounter implements IRowListener{
    
    private int totalScore = 0;
    private int removedRows = 0;
    
    public static final int POINTS_1_ROW = 40;
    public static final int POINTS_2_ROWS = 100;
    public static final int POINTS_3_ROWS = 300;
    public static final int POINTS_4_ROWS = 1200;
    
    private final int[] scoreSys = new int[]{        
                                            0,
                                            POINTS_1_ROW,
                                            POINTS_2_ROWS,
                                            POINTS_3_ROWS,
                                            POINTS_4_ROWS };
    

    @Override
    public void onRowsRemoved(int rows) {
        removedRows += rows;
        totalScore += scoreSys[rows];
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getRemovedRows() {
        return removedRows;
    }
}
