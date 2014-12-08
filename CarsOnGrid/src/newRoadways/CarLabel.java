package newRoadways;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;


class CarLabel extends JComponent {

	String alreadyShape="";
	float rotate;
	String txt;
	Object color;

	public void paint(Graphics g) {
	
		Graphics2D g2 = (Graphics2D) g;
		if (alreadyShape.equals("l") || alreadyShape.equals("t")){
			
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
		}
		if (alreadyShape.equals("i") ){
		
		  if (rotate==90){
			    //g2.translate(40, 0);
			    g2.rotate(90.0 * Math.PI / 180.0,20,20);
			  }
		  if (rotate==180){
			   // g2.translate(40, 0);
			    g2.rotate(180.0 * Math.PI / 180.0,20,20);
			  }
		  if (rotate==270){
			    //g2.translate(40, 0);
			    g2.rotate(270.0 * Math.PI / 180.0,20,20);
			  }
	}
		
		if (alreadyShape.equals("l")){
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, 40, 40);
			g.setColor(Color.GREEN);

			g.fillRect (0, 0, 40, 40);  
			g.setColor(Color.BLACK);
			g.fillRect (13, 0, 14, 20);
			g.fillRect (13, 14, 28, 14); 

		}else 	if (alreadyShape.equals("t")){
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, 40, 40);
			g.setColor(Color.GREEN);
		    g.fillRect (0, 0, 40, 40); 
		    
		    g.setColor(Color.BLACK);
		    g.fillRect (13, 14, 14, 27);
		    g.fillRect (0, 14, 40, 14); 

		}else 	if (alreadyShape.equals("i")){
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, 40, 40);
			g.setColor(Color.GREEN);
		    g.fillRect (0, 0, 40, 40);  
		    g.setColor(Color.BLACK);
		    g.fillRect (13, 0, 14, 40); 

		}else 	if (alreadyShape.equals("+")){
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, 40, 40);
			g.setColor(Color.GREEN);
		    g.fillRect (0, 0, 40, 40);
		    g.setColor(Color.BLACK);
		    g.fillRect (13, 0, 14, 40);
		    g.fillRect (0,13, 40, 14);
		}else 	if (alreadyShape.equals("blank")){
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, 40, 40);
			g.setColor(Color.GREEN);
		    g.fillRect (0, 0, 40, 40); 
		}
	
		if (color.equals("blue")){
			g.setColor(Color.BLUE);
		}else if(color.equals("red")){
			g.setColor(Color.RED);
		}else if(color.equals("yellow")){
			g.setColor(Color.YELLOW);
		}else if(color.equals("orange")){
			g.setColor(Color.ORANGE);
		}else if(color.equals("green")){
			g.setColor(new Color(0,75,0));
		}
		
		g.fillOval(10,10,20,20);
		
		String text=txt;
		Font myFont = new Font("Serif",Font.BOLD,20);
        g.setFont(myFont);
		g.setColor(Color.BLACK);
        g.drawString(text, 15,25);
        
	}
}