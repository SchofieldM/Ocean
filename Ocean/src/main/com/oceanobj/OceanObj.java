package main.com.oceanobj;

import main.com.ocean.*;

public abstract class OceanObj {

	private String code;
	protected String direction;
	protected int x;
	protected int y;
	protected Ocean ocean;
	
	public OceanObj(String code, Ocean ocean)
	{
		this.code = code;
		this.direction = "";
		this.ocean = ocean;
	}
	
	public void setCoords(int x, int y)
	{
		this.x = x;
		this.y =y;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public abstract void makeDirectionChoice();
	
	public String getDirection()
	{
		return direction;
	}
	
	public void setDirection(String dir)
	{
		direction = dir;
	}
}
