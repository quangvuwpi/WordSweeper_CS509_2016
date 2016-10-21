/**
 * 
 */
package utility;

import client.model.Board;
import client.model.Cell;
import client.model.IGame;
import client.model.Position;
import client.model.Word;
import junit.framework.TestCase;

/**
 * @author quangvu
 *
 */
public class ScoreCalculatorTest extends TestCase {

	/**
	 * Test method for
	 * {@link utility.ScoreCalculator#getScore(client.model.Word)}.
	 */
	public void testGetScoreWord() {
		// Setup test board
		Board board = XMLParser.parseXmlBoard("ACOWEFGHIJKLWALL");

		// Setup the calculator
		IGame game = new IGame() {

			@Override
			public int countPlayer(Position p) {
				return 0;
			}
		};
		ScoreCalculator calculator = new ScoreCalculator(game);

		// Null case
		long score = calculator.getScore((Word) null);
		assertEquals(0, score);

		// Empty case
		Word word = new Word();
		score = calculator.getScore(word);
		assertEquals(0, score);

		// Short words
		Cell c0 = board.getCell(new Position(1, 0)); // C
		Cell c1 = board.getCell(new Position(2, 0)); // O
		Cell c2 = board.getCell(new Position(3, 0)); // W

		// "C" - 1 letter is invalid
		word.addCell(c0);
		score = calculator.getScore(word);
		assertEquals(0, score);

		// "CO" - 2 letters is invalid
		word.addCell(c1);
		score = calculator.getScore(word);
		assertEquals(0, score);

		// "COW" - 3 letters is valid
		// score = 2^3 * 10 * ((3 * 2^0) + (2 * 2^0) + (3 * 2^0))
		// = 8 * 10 * (3 + 2 + 3) = 640
		word.addCell(c2);
		score = calculator.getScore(word);
		assertEquals(640, score);

		// Word test 2 - WALL with bonus cell and shared cells

		// Setup the calculator version 2
		IGame game2 = new IGame() {

			@Override
			public int countPlayer(Position p) {
				return p.col;
			}
		};
		ScoreCalculator calculator2 = new ScoreCalculator(game2);

		Cell c3 = board.getCell(new Position(0, 3)); // W
		Cell c4 = board.getCell(new Position(1, 3)); // A
		Cell c5 = board.getCell(new Position(2, 3)); // L
		Cell c6 = board.getCell(new Position(3, 3)); // L

		c5.bonus = true;

		Word word2 = new Word();
		word2.addCell(c3);
		word2.addCell(c4);
		word2.addCell(c5);
		word2.addCell(c6);

		// "WALL" - 4 letters is valid
		// score = 2^4 * 10 * ((3 * 2^0) + (2 * 2^1) + (3 * 2^2) + (3 * 2^3)) * 10
		// = 16 * 10 * (3 + 4 + 12 + 24) * 10 = 68800
		score = calculator2.getScore(word2);
		assertEquals(68800, score);
	}

	/**
	 * Test method for
	 * {@link utility.ScoreCalculator#getScore(java.lang.String)}.
	 */
	public void testGetScoreString() {
		// Setup the calculator
		IGame game = new IGame() {

			@Override
			public int countPlayer(Position p) {
				return 0;
			}
		};
		ScoreCalculator calculator = new ScoreCalculator(game);

		// Null case
		int score = calculator.getScore((String) null);
		assertEquals(0, score);

		// Empty string
		score = calculator.getScore("");
		assertEquals(0, score);

		// Long strings
		score = calculator.getScore("ABC");
		assertEquals(0, score);

		// Lower case strings
		score = calculator.getScore("a");
		assertEquals(2, score);
		score = calculator.getScore("qu");
		assertEquals(11, score);

		// Normal strings
		score = calculator.getScore("A");
		assertEquals(2, score);
		score = calculator.getScore("B");
		assertEquals(4, score);
		score = calculator.getScore("QU");
		assertEquals(11, score);
	}

}
