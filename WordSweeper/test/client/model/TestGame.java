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
		
		Word w1 = null;
		
		assertTrue(g.validate(w1) == false);
	}
	
	public void testPlayer(){
		
		Game g = new Game();
		
		Player Null = null;
		assertTrue(g.playerExist(Null) == false);
		
		String id=new String ("qihang");
        Position p= new Position(0,0);
        Player player=new Player(id,p,100);
        assertTrue(g.playerExist(player) == false);
        /**
    	 * player is not in list
    	 */
        g.addToPlayerList(player);
        g.updatePlayer(player);
        /**
    	 * player is already added in list
    	 */
        assertTrue(g.playerExist(player) == true);
        g.removeFromPlayerList(player);
        /**
    	 * player is removed from the list
    	 */
        assertTrue(g.playerExist(player) == false);
        assertTrue(g.removeFromPlayerList(player) == false);
        
        /**
    	 * Test Clears the player list
    	 */
        g.addToPlayerList(player);
        g.clearPlayerList();
        assertTrue(g.playerExist(player) == false);
        
	}
	
	
	public void testcountPlayer(){
		
		Game g = new Game();
		g.currentUser = "p1";
		String id1=new String ("p1");
        Position p1= new Position(0,0);
        Player player1=new Player(id1,p1,100);
        String id2=new String ("p2");
        Position p2= new Position(2,3);
        Player player2=new Player(id2,p2,100);
        String id3=new String ("p3");
        Position p3= new Position(1,2);
        Player player3=new Player(id3,p3,100);
        g.addToPlayerList(player1);
        g.addToPlayerList(player2);
        g.addToPlayerList(player3);
        
        Position ptest1= new Position(1,2);
        Position ptest2= new Position(3,3);
        g.countPlayers();
        /**
    	 * player counts:
    	 * [ 0  0  0  0 ][ 0  0  1  1 ][ 0  0  1  2 ][ 0  0  1  2 ]
    	 */
        
        
        /**
    	 * player1 & player2 share (1,2)
    	 */
        assertTrue(g.countPlayer(ptest1) == 1);
        /**
    	 * player1 & player2 & player 3 share (3,3)
    	 */
        assertTrue(g.countPlayer(ptest2) == 2);
        
        
        /**
    	 * Test offlineMode
    	 */
        Game g1 = new Game();
        g1.offlineMode = true;
        
        assertTrue(g1.countPlayer(ptest2) == 0);
		
	}
	
	public void testPlayerfunction(){
		
		Game g = new Game();
		g.currentUser = "player1";
		String id1=new String ("player1");
        Position p1= new Position(0,0);
        Player player1=new Player(id1,p1,100);
        g.addToPlayerList(player1);
        
        assertTrue(g.getScore() == 100);
        Position ptest = g.getPosition();
        assertEquals(0, ptest.col);
		assertEquals(0, ptest.row);
		g.updateScore(0);
		assertEquals(0, player1.score);
        
        g.currentUser = null;
        g.offlineScore = 200;
        g.clearPlayerList();
        assertTrue(g.getScore() == 200);
        assertTrue(g.getPosition() == null);
        assertTrue(g.updateScore(0) == false);
        
	}
	

}
