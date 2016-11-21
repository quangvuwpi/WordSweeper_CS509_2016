package client.request;


import client.model.Cell;
import client.model.Position;
import client.model.Word;
import junit.framework.TestCase;
import request.FindWordRequest;

public class TestFindWordRequest extends TestCase{
	
	public void testFindWordRequest(){
		Position origin = new Position(0,0);
		
		Word  w=new Word();
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
    	
    	FindWordRequest FWR = new FindWordRequest("AAA", "1234", origin, w);
    	
    	System.out.print(FWR.toString());
    	System.out.print(FWR.word.toString());
    	
    	assertTrue(FWR.name == "AAA");
    	assertTrue(FWR.gameId == "1234");
    	assertEquals(FWR.word.toString(), "Quit");
		
	}

}
