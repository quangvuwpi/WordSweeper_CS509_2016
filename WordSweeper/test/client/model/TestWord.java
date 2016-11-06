package client.model;

import java.util.LinkedList;
import java.util.Stack;
import junit.framework.TestCase;

public class TestWord extends TestCase{
	
	public void testword()
    {
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
        c3.letter = "z";
    	w.addCell(c1);
    	w.addCell(c2);
    	w.addCell(c3);
    	assertEquals("Quiz",w.toString());
          
          
    }
	

 
}
