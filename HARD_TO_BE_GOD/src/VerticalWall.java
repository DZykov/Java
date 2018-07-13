
public class VerticalWall 
{

	Environment main;
	public int posX;
	public int posY;
	public int endY;
	
	public VerticalWall(int startX, int startY, int endingY) 
	{
		posX = startX;
		posY = startY;
		endY = endingY;
	}

	@SuppressWarnings("static-access")
	public void setRandomPosition()
	{
		posX = (int)(Math.random()*main.WIDTH);
		posY = (int)(Math.random()*main.HEIGHT);
		endY = (int)(Math.random()*main.WIDTH);
	}
	
}
