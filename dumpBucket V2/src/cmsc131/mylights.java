package cmsc131;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class mylights implements ActionListener
{
	private static volatile int succ;//number of successful trials (within circle)
	private static volatile int trials;
	private static volatile int passed = 0;//number used to regulate how often the GUI updates the values
	
	public static volatile boolean pause = true;
	public static volatile ArrayList<threaderino> list;//ArrayList to keep track of references to threads so we can use .notify on them
	
	public static JLabel actual = new JLabel("Actual Value of Pi is: " + Double.toString(Math.PI));
	public static JLabel estimate = new JLabel("Estimated Value is: 0");
	public static JLabel t = new JLabel("Number of trials is: 0");
	public static JButton b = new JButton("Runnnn!");
	
	public mylights(int thr)//constructor for mylights; initializes the GUI and starts thr amount of threads
	{		
		JFrame f = new JFrame("The peestimator");
	    f.setSize(300,300);
	    f.setVisible(true);
	    f.setLayout(new GridLayout(4, 1));
	    
	    f.add(actual);
	    f.add(estimate);
	    f.add(t);
	    
	    b.addActionListener(this);
	    f.add(b);
	    
	    list = new ArrayList<threaderino>(thr);
	    for (int i = 1; i <= thr; i++)
	    {
	    	threaderino xd = new threaderino();
	    	list.add(xd);
	    	xd.start();
	    }
	}
	
	public static class threaderino extends Thread 
	{
        @Override
        public void run()//this is what a threaderino object goes into when you use .start()!
        {	
        	while(true)//as long as the program is running, it will be moving through this while loop checking for whether the program is paused or unpaused. We don't want to fall out of this loop!
        	{
	        	synchronized(this)//for preventing thread interference and memory consistency errors
	    		{
	    			while(pause)
	        		{
	    				try {
	    					this.wait();
	    				} catch (InterruptedException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	        		}
	    			while(!pause)//infinite loop!
		        	{
		        		boolean incircle = false;
		        		
		        		double x = new Random().nextDouble();
		        		double y = new Random().nextDouble();
		        		System.out.println(this.getName() + " yielding x = " + x + ", y = " + y);
		        		double result = (x*x)+(y*y);
		        		
		        		if(result < 1)
		        			incircle = true;
		        		sendBack(incircle);
		        	}
	    		}
        	}
        }
	}
	
	synchronized private static void sendBack(boolean soc) 
    {
		passed++;
        trials++;
        if(soc)
        	succ++;
        
        if (passed == 1000)//every time passed increments up to 1000 (meaning we've gone thru 1000 trials), we reset passed and print the results
        {
        	passed = 0;
        	double p1 = (double)succ/trials;
        	
        	estimate.setText("Estimated Value is: " + (4.0*p1));
            t.setText("Number of trials is: " + trials);
        }
    }
	
	public static void main(String[] args) 
	{
	    mylights pee = new mylights(15);//creation of mylights object, with custom amount of threads you want to use
	}
	
	//Once actionlistener detects input, it calls this method to do stuff
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == b && !pause)
		{
			b.setText("Run!");
			System.out.println("Stopping!");
			pause = true;
		}
			
		else if (e.getSource() == b && pause)
		{
			b.setText("Pause!");
			System.out.println("Starting!");
			begin();
		}	
	}
	
	public void begin()
	{
		for (int i = 0; i < list.size(); i++)//seeing as we never kept track of which threads were told to wait (and neither do we really want to), we may as well go thru each thread we made and call .notify() on all of them
	    {
			synchronized(list.get(i))
			{
				pause = false;
				list.get(i).notify();
			}
	    }
	}
}