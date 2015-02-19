package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author laurikin
 */
public class MainFrame extends JFrame {
    
    public MainFrame (BoardView boardView, ScoreView scoreView) {
        super("Tetris");
        
        setLayout(new BorderLayout(0,0));
        
        Container c = getContentPane();
        
        c.add(boardView, BorderLayout.CENTER);
        c.add(scoreView, BorderLayout.LINE_END);

    }
    
}
