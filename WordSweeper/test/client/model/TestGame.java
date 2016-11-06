package client.model;

import java.util.LinkedList;

import junit.framework.TestCase;

/**
 * Test case of the Game entity class
 * 
 * @author Qihang
 *
 */


public class TestGame extends TestCase {
	
	public void testValidate(){
		
		Game g = new Game();
		Word  w=new Word();
    	w.cell = new LinkedList<Cell>();
    	Position p1= new Position(2,3);
        Cell  c1 = new Cell(p1);
        Position p2= new Position(2,4);
        Cell  c2 = new Cell(p2);
        Position p3= new Position(3,4);
        Cell  c3 = new Cell(p3);
        c1.letter = "Qu";
        c2.letter = "i";
        c3.letter = "t";
    	w.addCell(c1);
    	w.addCell(c2);
    	w.addCell(c3);
		
		assertTrue(g.validate(w) == true);
	}
	
	public void testPlayer(){
		
		Game g = new Game();
		String id=new String ("qihang");
        Position p= new Position(0,0);
        Player player=new Player(id,p,100);
        assertTrue(g.playerExist(player) == false);
        /**
    	 * player is not in list
    	 */
        g.addToPlayerList(player);
        /**
    	 * player is already added in list
    	 */
        assertTrue(g.playerExist(player) == true);
        g.removeFromPlayerList(player);
        /**
    	 * player is removed from the list
    	 */
        assertTrue(g.playerExist(player) == false);
        
	}
	

	
	

}
