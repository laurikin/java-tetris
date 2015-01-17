/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloop;

import laurikinnunen.javatetris.gameLogic.Board;
import ui.UI;

/**
 *
 * @author laurikin
 */
public class Main {
    
    public static void main(String[] args) {
        Board board = new Board(10,20);
        UI ui = new UI(board);
        Game game = new Game(ui, board);
        game.start();
    }
}
