package client.controller;

import client.model.*;
import client.view.*;
import junit.framework.TestCase;

/**
 * Test case of the Board Controller class
 * 
 * @author Qihang
 *
 */



public class TestBoardController extends TestCase{
	
	Model model;
	Application app;
	public static int COL_COUNT = 4;
	public static int ROW_COUNT = 4;
	
	public void testSelected()
    {
		
		Position p1= new Position(2,3);
        Position p2= new Position(1,2);
        Position p3= new Position(1,3);
        Cell c[][] = new Cell[COL_COUNT][ROW_COUNT]; 
        c[2][3] = new Cell(p1);
        c[1][2] = new Cell(p2);
        c[1][3] = new Cell(p3);
        c[2][3].letter = "Qu";
        c[1][2].letter = "i";
        c[1][3].letter = "t";
        Board b = new Board(c);
		b.selectCell(p1);
		b.selectCell(p2);
		b.selectCell(p3);
		
		BoardController BC = new BoardController(app,b);
		
		Position testp1= new Position(0,0);
		Position testp2= new Position(2,3);
		assertTrue(BC.canSelect(testp1) == false);
		assertTrue(BC.canSelect(testp2) == true);
		
    }
	
	

}