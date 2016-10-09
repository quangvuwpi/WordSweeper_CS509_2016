package client.model;
import junit.framework.TestCase;
public class TestPlayer extends TestCase {
	 public void testConstructor()
     {
            String id=new String ("aaaa");
            Position p= new Position(0,0);
            Player player=new Player(id,p);
            assertEquals("aaaa",player.name);
           
     }
}
