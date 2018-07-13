
public class HorizontalWall 
{

	Environment main;
	public int posX;
	public int posY;
	public int endX;
	
	public HorizontalWall(int startX, int startY, int endingX) 
	{
		posX = startX;
		posY = startY;
		endX = endingX;
	}

	@SuppressWarnings("static-access")
	public void setRandomPosition()
	{
		posX = (int)(Math.random()*main.WIDTH);
		posY = (int)(Math.random()*main.HEIGHT);
		endX = (int)(Math.random()*main.WIDTH);
	}
	
}
