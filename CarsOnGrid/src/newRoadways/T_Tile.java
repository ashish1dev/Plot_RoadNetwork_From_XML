package newRoadways;

 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

class T_Tile extends JComponent {

	public  int rotate;

/**
	 * @return the rotate
	 */
	public int getRotate() {
		return rotate;
	}

	/**
	 * @param rotate the rotate to set
	 */
	public void setRotate(int rotate) {
		this.rotate = rotate;
	}

public void paint(Graphics g) {
	  Graphics2D g2 = (Graphics2D) g;
	  if (rotate==90){
		    //g2.translate(40, 0);
		    g2.rotate(270.0 * Math.PI / 180.0,20,20);
		  }
	  if (rotate==180){
		   // g2.translate(40, 0);
		    g2.rotate(180.0 * Math.PI / 180.0,20,20);
		  }
	  if (rotate==270){
		    //g2.translate(40, 0);
		    g2.rotate(90.0 * Math.PI / 180.0,20,20);
		  }
	g.setColor(Color.BLACK);
	g.drawRect(0, 0, 40, 40);
	g.setColor(Color.GREEN);
    g.fillRect (0, 0, 40, 40); 
    
    g.setColor(Color.BLACK);
    g.fillRect (13, 14, 14, 27);
    g.fillRect (0, 14, 40, 14); 
  }
}

