/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import laurikinnunen.javatetris.gameLogic.EventQueue;
import laurikinnunen.javatetris.gameLogic.MoveDownAction;

/**
 *
 * @author laurikin
 */

public class ArrowKeyListener implements KeyListener {

    private final EventQueue eq;

    public ArrowKeyListener (EventQueue eq) {
        this.eq = eq;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                break;
            case 38:
                break;
            case 39:
                break;
            case 40:
                this.eq.queue(new MoveDownAction());
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}