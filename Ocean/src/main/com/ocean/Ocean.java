package main.com.ocean;

// Internal Imports
	import main.com.oceanobj.OceanObj;

/**
 * 
 * @author Matthew Schofield
 * @version 2.4.18
 */
public class Ocean {

	private OceanObj[][] board;
	private int height;
	private int width;
	
	public Ocean(int height, int width)
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
		if(obj != null)
			obj.setCoords(x, y);
	}
	
	public OceanObj getCell(int x, int y)
	{
		return board[y][x];
	}
	
	public void movePieces()
	{
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				OceanObj oo = board[i][j];
				if(oo != null) {
					oo.makeDirectionChoice();
					
				}
			}
		}
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				OceanObj oo = board[i][j];
				if(oo != null) {
					if(oo.getDirection().equals("UP")) {
						setCell(i-1,j,oo);
						setCell(i, j, null);
						oo.setDirection("DONE");
					}else if(oo.getDirection().equals("LEFT")) {
						setCell(i,j-1,oo);
						setCell(i, j, null);
						oo.setDirection("DONE");
					}else if(oo.getDirection().equals("DOWN")) {
						setCell(i+1,j,oo);
						setCell(i, j, null);
						oo.setDirection("DONE");
					}
				}
			}
		}
		
		
	}
	
}
