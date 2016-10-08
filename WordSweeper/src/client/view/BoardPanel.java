package client.view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import client.controller.BoardController;
import client.model.Board;
import client.model.Cell;
import client.model.Position;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements IBoundary {

	public static int COL_COUNT = Board.COL_COUNT;
	public static int ROW_COUNT = Board.ROW_COUNT;
	
	public static int CELL_WIDTH = 65;
	public static int CELL_HEIGHT = 55;
	public static int CELL_GAP = 12;

	final Board board;
	final BoardController controller;

	public final Dimension size;

	CellPanel cellPanels[][] = new CellPanel[ROW_COUNT][COL_COUNT];
	Font font = new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 29);

	/**
	 * Create the panel and bound to a Board.
	 */
	public BoardPanel(Board board, BoardInfoPanel i) {
		this.board = board;
		this.controller = new BoardController(board, this, i);
		
		int w = COL_COUNT * (CELL_WIDTH + CELL_GAP);
		int h = ROW_COUNT * (CELL_HEIGHT + CELL_GAP);
		this.size = new Dimension(w, h);

		setup();
	}

	/**
	 * Initialize the board panel
	 */
	public boolean setup() {
		setLayout(null);
		setBorder(BorderFactory.createEmptyBorder());
		setPreferredSize(size);

		int x = CELL_GAP;
		int y = CELL_GAP;
		for (int col = 0; col < COL_COUNT; col++) {
			for (int row = 0; row < ROW_COUNT; y += CELL_GAP, row++) {
				Cell cell = board.getCell(new Position(col, row));
				CellPanel c = new CellPanel(cell);

				c.setBounds(x, y, CELL_WIDTH, CELL_HEIGHT);
				y += CELL_HEIGHT;

				add(c);
				cellPanels[col][row] = c;
			}

			y = CELL_GAP;
			x += CELL_WIDTH + CELL_GAP;
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
		/**
		 * If click on the right or bottom edge, return null
		 */
		if ((p.x >= COL_COUNT * (CELL_WIDTH + CELL_GAP)) || (p.y >= ROW_COUNT * (CELL_HEIGHT + CELL_GAP))) {
			return null;
		} else {
			int col = p.x / (CELL_WIDTH + CELL_GAP);
			int row = p.y / (CELL_HEIGHT + CELL_GAP);

			if ((p.x - col * (CELL_WIDTH + CELL_GAP) > CELL_GAP) && (p.y - row * (CELL_HEIGHT + CELL_GAP) > CELL_GAP)) {
				return new Position(col, row);
			}
		}
		return null;
	}

	public void cancel(){
		controller.sb.delete(0, controller.sb.length());
		controller.infoPanel.refreshWord("");
		controller.infoPanel.invalidate();
		controller.infoPanel.repaint();
		board.cancel();
		validate();
		repaint();
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

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;

			int h = getHeight();
			int w = getWidth();

			if (cell.selected) {
				g2.setColor(Color.YELLOW);
			} else {
				g2.setColor(new Color(0, 255, 0, 15 * cell.multiplier));
			}
			g2.fillRect(0, 0, w, h);

			g2.setFont(font);
			FontMetrics fm = g2.getFontMetrics();

			g2.setColor(Color.BLACK);
			g2.drawString(cell.letter, w/2 - fm.stringWidth(cell.letter)/2, h/2 + fm.getHeight()/4);

			g2.setColor(Color.BLACK);
			g2.drawRect(0, 0, w - 1, h - 1);
		}

	}

}
