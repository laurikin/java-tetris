package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author laurikin
 */
public class MainFrame extends JFrame {
    
    public MainFrame (BoardView boardView) {
        super("Tetris");
        
        setLayout(new BorderLayout());
        
        final BoardView paintArea = boardView;
        
        Container c = getContentPane();
        
        c.add(paintArea, BorderLayout.CENTER);

    }
    
}
