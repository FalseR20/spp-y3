package com.company;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;

public class GameButton extends JButton {
    private final int m_x;
    private final int m_y;
    private final OutputStream m_socketOut;

    public GameButton(int x, int y, OutputStream socketOut) {
        super("");
        m_x = x;
        m_y = y;
        m_socketOut = socketOut;
        setMargin(new Insets(0, 0, 0, 0));
        setEnabled(false);
        setFont(new Font("Arial", Font.PLAIN, 150));

        addActionListener(new MoveActionListener());
    }

    public class MoveActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Gson gson = new Gson();

            Messages.Move moveMessage = new Messages.Move();
            moveMessage.x = m_x;
            moveMessage.y = m_y;

            Common.writeBytes(m_socketOut, gson.toJson(moveMessage));
        }
    }
}

