package app0614;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test{
    
    public static void main(String[] args) {
        
        Dimension dimension = new Dimension(500, 500);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 900);
        frame.setPreferredSize(dimension);

        Panel mainPanel = new Panel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel upPanel = new JPanel();
        upPanel.setBackground(Color.WHITE);
        upPanel.setSize(900, 900);

        JPanel downPanel = new JPanel();
        downPanel.setSize(900,900);

        Color[] colors = new Color[] { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA};
        
        for(Color color : colors) {
            JPanel target = new JPanel();
            target.addMouseListener(new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                    upPanel.setBackground(color);
                    frame.repaint();
                }
                public void mousePressed(MouseEvent e) {}
                public void mouseReleased(MouseEvent e) {}
                public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
            });
            target.setBackground(color);
            target.setSize(800, 800);
            downPanel.add(target);    
        }
        mainPanel.add(upPanel);
        mainPanel.add(downPanel);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
