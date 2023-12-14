package org.serverdeltas.tictactoe;

import org.serverdeltas.UpdatableState;

public class GameState extends UpdatableState {
    int[][] board = new int[3][3]; // 0 will be nothing, 1 will be X, 2 will be O
    boolean playerTurnID; // true will be X, false will be O

    GameState() {
        playerTurnID = true;
    }

    public void doMove(int x, int y) {
        if (board[x][y] != 0) return;

        board[x][y] = playerTurnID ? 1 : 2;
        setField("board", board);

        playerTurnID = !playerTurnID;
    }
}
