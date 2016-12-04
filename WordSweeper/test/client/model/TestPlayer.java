package client.model;
import junit.framework.TestCase;

/**
 * Test case of the Player entity class
 * 
 * @author Qihang
 *
 */

public class TestPlayer extends TestCase {
	
	
	 public void testConstructor()
	 
     {
		 
            String id=new String ("aaaa");
            Position p= new Position(0,0);
            Player player=new Player(id,p,100);
            assertEquals("aaaa",player.name);
            assertEquals(100,player.score);
           
     }
	 
	 public void testEquals()
	 
     {
		 
            String id1=new String ("aaaa");
            Position p1= new Position(0,0);
            Player player1=new Player(id1,p1,100);
            String id2=new String ("bbbb");
            Position p2= new Position(1,1);
            Player player2=new Player(id2,p2,100);
            
            player2.equals(player1);
            
            assertEquals("bbbb",player2.name);
            
            Object obj = null;
            
            assertTrue(player2.equals(obj)==false);
            
           
     }
	 
	 public void testUpdate()
	 
     {
		 
            String id1=new String ("aaaa");
            Position p1= new Position(0,0);
            Player player1=new Player(id1,p1,100);
            String id2=new String ("bbbb");
            Position p2= new Position(1,1);
            Player player2=new Player(id2,p2,0);
            
            player2.update(player1);
            
            assertEquals(100,player2.score);
            
           
     }
	 
}
