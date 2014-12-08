package newRoadways;

 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

class GridLabel_Top_Left extends JComponent {

  private int rotate;
String str;

public void paint(Graphics g) {
	 Graphics2D g2 = (Graphics2D) g;
	  if (rotate==90){
		    g2.translate(40, 0);
		    g2.rotate(90.0 * Math.PI / 180.0);
		  }
	 
	g.setColor(Color.YELLOW);
	g.fillRect(0, 0, 40, 40);
	
	g.setColor(Color.BLUE);
	Font myFont = new Font("Serif",Font.BOLD,20);
    g.setFont(myFont);
    g.drawString(str, 20,20);
  
  }
}

