package idleCapitalist;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

//The initial method I used for finding the most optimal business to buy 
//in the Discord Bot game "IdleCapitalist". It drew a graph of how business
//prices would expand over time up to a certain amount of income gained.
public class IdleCapitalist extends JFrame
{
	MyPanel panel;
	
	public IdleCapitalist()
	{
		panel = new MyPanel();
		
		setTitle("Big Graphix");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	
	
	public static void main(String[] args)
	{	
		IdleCapitalist graph = new IdleCapitalist();
	}
}

class MyPanel extends JPanel
{
	MyPanel(){
		setSize(10, 10);
	}
	
	public void paint(Graphics g)
	{	
		Graphics2D g2d = (Graphics2D) g;

        // save the "old" transform
        AffineTransform old = g2d.getTransform();

        // update graphics object with the inverted y-transform
        g2d.translate(0, getHeight() - 1);
        
        //Money graph scale
        g2d.scale(0.00010, -0.000000009);
        

        //Stroke for money graph
        g2d.setStroke(new BasicStroke(1000));
        
        //Matt
        //Pizza
        paintG(g2d, 105, 1, 10.5, 68.30, Color.yellow);
        //Car wash
        paintG(g2d, 125, 3, 25, 68.30, Color.red);
        //Restaurant
        //paintG(g2d, 11250, 10, 75, 68.30, Color.cyan);
        //Bank
        paintG(g2d, 3445650, 30, 285, 68.30, Color.green);
        //Oil
        paintG(g2d, 5565000, 50, 1000, 68.30, Color.blue);
        //Airport
        paintG(g2d, 14400000, 100, 2400, 68.30, Color.ORANGE);
        //Hospital
        paintG(g2d, 23250000, 160, 5000, 68.30, Color.pink);
        //Shipyard
        paintG(g2d, 43200000, 350, 12000, 68.30, Color.MAGENTA);
        //Carfactory
        paintG(g2d, 100300000, 650, 34000, 68.30, Color.black);
        
        /*Quinn
        //Pizza
        paintG(g2d, 115, 1, 10, 8.7, Color.yellow);
        //Car wash
        paintG(g2d, 150, 3, 25, 8.7, Color.red);
        //Restaurant
        paintG(g2d, 3825, 10, 75, 8.7, Color.cyan);
        //Bank
        paintG(g2d, 970710, 30, 285, 8.7, Color.green);
        //Oil
        paintG(g2d, 175000, 50, 1000, 8.7, Color.blue);
        //Airport
        paintG(g2d, 1512000, 100, 2400, 8.7, Color.ORANGE);
        //Hospital
        paintG(g2d, 2005000, 160, 5000, 8.7, Color.pink);
        */

        // restore the old transform
        g2d.setTransform(old);
	}
	
	public void paintG(Graphics2D g, double s, double i, double rr, double m, Color n)
	{
		g.setPaint(n);
		
		double start = s;
		double income = i * m;
		double rateRate = rr;
		
		double x1 = 0;
		double y1 = 0;
		
		double x2 = i*m;
		double y2 = s;
		
		for (double a = 0; a < 100000; a = a + income)
		{
			System.out.println("PUSSY");
		}
		
		for (double a = 0; a < 15000000; a = a + income)
		{
			g.draw(new Line2D.Double(x1, y1, x2, y2));
			x1 = x2;
			y1 = y2; 
			System.out.println("(" + x2 + "," + y2 + ")");
			
			start += rateRate;
			x2 += income;
			y2 += start;
		}
	}
}
