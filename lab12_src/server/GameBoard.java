package com.company.tcp_server;

public class GameBoard {
    public final int Size = 3;
    private final char[][] m_board;
    private char m_currentMove;

    GameBoard() {
        m_board = new char[Size][Size];

        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                m_board[i][j] = '_';
            }
        }

        m_currentMove = 'x';
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                buffer.append(m_board[i][j]);
            }
        }
        return buffer.toString();
    }

    public char currentMove() {
        return m_currentMove;
    }

    private void changeActivePlayer() {
        if (m_currentMove == 'x')
            m_currentMove = 'o';
        else
            m_currentMove = 'x';
    }

    public void process(Messages.Move move) {
        if (m_board[move.x][move.y] != '_')
            return;
        m_board[move.x][move.y] = m_currentMove;
        changeActivePlayer();
    }

    public char getWinner() {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                if (checkFrom(i, j))
                    return m_board[i][j];
            }
        }
        return '_';
    }

    private boolean checkFrom(int x, int y) {
        char player = m_board[x][y];
        if (player == '_')
            return false;

        boolean xWin = true, yWin = true, xyWin = true;
        for (int i = 0; i < 3; ++i) {
            if (i + x >= Size || m_board[i + x][y] != player)
                xWin = false;
            if (i + y >= Size || m_board[x][i + y] != player)
                yWin = false;
            if (i + y >= Size || i + x >= Size || m_board[x + i][i + y] != player)
                xyWin = false;
        }

        return xyWin || xWin || yWin;
    }
}
