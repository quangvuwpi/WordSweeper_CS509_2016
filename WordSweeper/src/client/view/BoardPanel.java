package client.view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import client.controller.BoardController;
import client.model.Board;
import client.model.Cell;
import client.model.Position;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements IBoundary {

	public static int COL_COUNT = 4;
	public static int ROW_COUNT = 4;
	public static int CELL_SIZE = 50;

	CellPanel cellPanels[][] = new CellPanel[ROW_COUNT][COL_COUNT];

	final Board board;
	final BoardController controller;

	/**
	 * Create the panel and bound to a Board.
	 */
	public BoardPanel(Board board, BoardController controller) {
		this.board = board;
		this.controller = controller;

		setup();
	}

	/**
	 * Initialize the board panel
	 */
	public boolean setup() {
		setLayout(null);
		setBorder(BorderFactory.createEmptyBorder());
		setPreferredSize(new Dimension(ROW_COUNT * CELL_SIZE, COL_COUNT * CELL_SIZE));

		for (int x = 0; x < COL_COUNT; x++) {
			for (int y = 0; y < ROW_COUNT; y++) {
				Cell cell = board.getCell(new Position(x, y));
				CellPanel c = new CellPanel(cell);

				c.setBounds(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);

				add(c);
				cellPanels[x][y] = c;
			}
		}

		addMouseListener(controller);
		addMouseMotionListener(controller);

		return true;
	}

	/**
	 * Teardown the board panel
	 */
	public boolean teardown() {
		removeMouseListener(controller);
		removeMouseMotionListener(controller);

		removeAll();

		return true;
	}

	public static Position pointToPosition(Point p) {
		return new Position(p.x / CELL_SIZE, p.y / CELL_SIZE);
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		for (int x = 0; x < COL_COUNT; x++) {
			for (int y = 0; y < ROW_COUNT; y++) {
				cellPanels[x][y].repaint();
			}
		}
	}

	/**
	 * Private cell panel class
	 */
	public class CellPanel extends JPanel {
		final Cell cell;

		public CellPanel(Cell cell) {
			this.cell = cell;
		}

		public Cell getCell() {
			return cell;
		}

		void refresh(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			int h = getHeight();
			int w = getWidth();

			if (cell.selected) {
				g2.setColor(Color.YELLOW);
			} else {
				g2.setColor(new Color(0, 255, 0, 15 * cell.multiplier));
			}
			g2.fillRect(0, 0, w, h);

			g2.setColor(Color.BLACK);
			g2.drawRect(0, 0, w, h);

			g2.setColor(Color.BLACK);
			g2.drawString(String.valueOf(cell.letter), w / 2 - 3, h / 2 + 5);
			g2.drawString(String.valueOf(cell.point), w / 2 + 13, h / 2 + 20);
			// g2.drawString(String.valueOf(cell.point), w / 2 + 13, h / 2 -
			// 10);
			// g2.drawString('x' + String.valueOf(cell.multiplier), w / 2 + 8, h
			// / 2 + 20);
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			refresh(g);
		}

	}

}
