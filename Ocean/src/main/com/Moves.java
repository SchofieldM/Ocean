package main.com;

public enum Moves {

	UP ("UP", 0, 1),
	UPLEFT("UPLEFT", -1, 1),
	UPRIGHT("UPRIGHT", 1,1),
	LEFT("LEFT", -1, 0),
	RIGHT("RIGHT", 1, 0),
	DOWN("DOWN", 0, -1),
	DOWNLEFT("DOWNLEFT", -1, -1),
	DOWNRIGHT("DOWNRIGHT", 1, -1)
	;
	
	
	private String name;
	private int xChange;
	private int yChange;
	
	Moves(String name, int xChange, int yChange){
		this.name = name;
		this.xChange = xChange;
		this.yChange = yChange;
	}
	
	public int[] getChangeArray()
	{
		return new int[] {xChange, yChange};
	}
	
	public int getXChange()
	{
		return xChange;
	}
	
	public int getYChange()
	{
		return yChange;
	}
	
	public String getChoiceName()
	{
		return name;
	}
	
}
