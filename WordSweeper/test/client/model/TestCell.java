package client.model;


import junit.framework.TestCase;

public class TestCell extends TestCase{
	
	public void testselected(){
		Position p= new Position(0,0);
		Cell cell=new Cell(p);
		assertTrue(cell.selected== false);
		
	}
	
	
	
}
