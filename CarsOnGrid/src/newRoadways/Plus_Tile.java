package newRoadways;

 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

class Plus_Tile extends JComponent {


public void paint(Graphics g) {
	  
	g.setColor(Color.BLACK);
	g.drawRect(0, 0, 40, 40);
	
	g.setColor(Color.GREEN);
    g.fillRect (0, 0, 40, 40);
    
    g.setColor(Color.BLACK);
    g.fillRect (13, 0, 14, 40);
    g.fillRect (0,13, 40, 14);
      
  }
}

