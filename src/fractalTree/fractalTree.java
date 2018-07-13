package fractalTree;

import java.awt.BasicStroke;
import java.awt.Canvas; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.Timer;

public class fractalTree extends Canvas implements ActionListener
{

  private static final long serialVersionUID = 97135621537793080L;
  private JFrame frame;
  private final int WINDOW_WIDTH = 1280;
  private final int WINDOW_HEIGHT = 720;
  public int times = 0;
  public int COUNTS = 0;
  Timer timer = new Timer(1000, this);

  public fractalTree() 
  {
	//timer.start();
    frame = new JFrame("Fractal Tree");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.setResizable(true);
    frame.add(this);
    frame.setVisible(true);
  }

  public static void main(String[] args) 
  {
    fractalTree ft = new fractalTree();
    ft.setVisible(true);
    ft.setBackground(Color.black);
  }

  @Override
  public void paint(Graphics g) 
  {
    drawFractalTree(g, WINDOW_WIDTH / 2, WINDOW_HEIGHT - 75, -90, 10);
  }

  public void drawFractalTree(Graphics g, int x1, int y1, double angle, int depth) 
  {
    if (depth == 0) 
    {
    } 
    else 
    {
    	
   		int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
   		int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
   		
    	Graphics2D g2d = (Graphics2D) g;
    	
    	if(times<=255)
    	{
    	g2d.setColor(new Color(255,times,0));
    	}
    	if(times>255 && times<=510)
    	{
    		g2d.setColor(new Color(510-times,255,0));
    	}
    	if(times>510 && times<=765)
    	{
    		g2d.setColor(new Color(0,255,765-times));
    	}
    	if(times>765 && times<=1020)
    	{
    		g2d.setColor(new Color(0,1020-times,255));
    	}
    	if(times>1275 && times<=1530)
    	{
    		g2d.setColor(new Color(1530-times,0,255));
    	}
    	if(times>1530 && times<=1785)
    	{
    		g2d.setColor(new Color(255,0,1785-times));
    	}
    	if(times>1785) {times=0;} 
    	
   		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   		
    	g2d.setStroke(new BasicStroke(0.5f * depth));
    	
    	g2d.drawLine(x1, y1, x2, y2);
   		try 
   		{
    		TimeUnit.MILLISECONDS.sleep(10);
		} 
    	catch (InterruptedException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   			times++;
   			Random r = new Random();
   			int Low = 5;
   			int High = 40;
   			int Result = r.nextInt(High-Low) + Low;
   			
   			Random r1 = new Random();
   			int Low1 = 5;
   			int High1 = 40;
   			int Result1 = r1.nextInt(High1-Low1) + Low1;
   			
   			
    		drawFractalTree(g, x2, y2, angle + Result, depth - 1);
    		drawFractalTree(g, x2, y2, angle - Result1, depth - 1);
    	}
    
  }

  public int changeAngle(int a)
  {
	int ang = 1;
	return ang;
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0) 
  {
	COUNTS++;
	repaint();
  } 
}