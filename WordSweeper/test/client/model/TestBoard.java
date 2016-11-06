package client.model;

import junit.framework.TestCase;


/**
 * Test case of the Board entity class
 * 
 * @author Qihang
 *
 */

public class TestBoard extends TestCase {
	
	public static int COL_COUNT = 4;
	public static int ROW_COUNT = 4;
	
	public void testValidPosition(){
		Board b = new Board();
		Position p = new Position(3,3);
		/**
		 * p.col < COL_COUNT && p.row < ROW_COUNT
		 */
		assertTrue(b.isValidPosition(p) == true);
	}
	
	
	public void testgetCell(){
		Board b = new Board();
		Position p = new Position(5,5);
		assertTrue(b.getCell(p) == null);
	}
	
	public void testSelected(){
		Board b = new Board();
		Position p = new Position(3,3);
		/**
		 * c.selected = false for now (Test in TestCell)
		 */
		assertTrue(b.selectCell(p) == true);
	}
	
	public void testDeselected(){
		Board b = new Board();
		Position p = new Position(3,3);
		b.selectCell(p);
		assertTrue(b.deselectLastCell() == true);
		/**
		 * Selected is empty now
		 */
		assertTrue(b.deselectLastCell() == false);
	}
	
	public void testClearSelection(){
		Board b = new Board();
		Position p = new Position(3,3);
		b.selectCell(p);
		b.selectCell(p);
		b.selectCell(p);
		b.clearSelection();
		/**
		 * Selected is empty now
		 */
		assertTrue(b.deselectLastCell() == false);
	}
	
	public void testSelectiontoWord(){
		
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
		Word w = b.selectionToWord();
		assertEquals("Quit",w.toString());
	}

}
