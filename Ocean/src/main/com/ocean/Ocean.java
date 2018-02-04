package main.com.ocean;

import main.com.oceanobj.OceanObj;

public class Ocean {

	private OceanObj[][] board;
	private int height;
	private int width;
	
	public Ocean()
	{
		board = new OceanObj[height][width];
	}
	
	public OceanObj[][] getBoard()
	{
		return board;
	}
	
	public void setCell(int y, int x, OceanObj obj)
	{
		board[y][x] = obj;
	}
	
	public OceanObj getCell(int x, int y)
	{
		return board[y][x];
	}
	
}
