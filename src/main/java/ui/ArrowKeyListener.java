/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author laurikin
 */

public class ArrowKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                System.out.println("pressed left");
                break;
            case 38:
                System.out.println("pressed up");
                break;
            case 39:
                System.out.println("pressed right");
                break;
            case 40:
                System.out.println("pressed down");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}