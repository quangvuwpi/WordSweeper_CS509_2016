package client.model;


import junit.framework.TestCase;

public class TestCell extends TestCase{
	
	public void testselected()
	{
		Position p= new Position(2,3);
		Cell cell=new Cell(p);
		assertTrue(cell.bonus == false);
		assertTrue(cell.selected == false);
		assertEquals(2,cell.position.col);
		assertEquals(3,cell.position.row);
	}
	
	
	
}
