package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author laurikin
 */
public class MainFrame extends JFrame {
    
    public MainFrame (BoardView boardView, ScoreView scoreView, NextTetriminoView blockView) {
        super("Tetris");
        setLayout(new BorderLayout(10,10));
        
        Container c = getContentPane();
        
        c.add(blockView, BorderLayout.LINE_START);
        c.add(boardView, BorderLayout.CENTER);
        c.add(scoreView, BorderLayout.LINE_END);

    }
    
}
