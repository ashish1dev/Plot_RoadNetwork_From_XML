package newRoadways;

 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

class BlankTile extends JComponent {

  private int rotate;

public void paint(Graphics g) {
	 Graphics2D g2 = (Graphics2D) g;
	  if (rotate==90){
		    g2.translate(40, 0);
		    g2.rotate(90.0 * Math.PI / 180.0);
		  }
	g.setColor(Color.BLACK);
	g.drawRect(0, 0, 40, 40);
	g.setColor(Color.GREEN);

    g.fillRect (0, 0, 40, 40);  
  
  }
}

