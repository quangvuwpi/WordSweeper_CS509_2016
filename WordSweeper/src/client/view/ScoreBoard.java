package client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import client.model.Game;

public class ScoreBoard extends JPanel implements IBoundary {

	final Game game;
	JTable table;
	
	String[] columnNames = {"Name", "Score"};
	String[][] data ={
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""},
			{"", ""}
	};

	public ScoreBoard(Game game) {
		this.game = game;
		setup();
	}
	
	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		this.removeAll();
		if (game.players.size() > 0) {
			data = new String[game.players.size()][2];
			int i = 0;
			for (String player : game.players.keySet()) {
				data[i][0] = player;
				data[i++][1] = Long.toString(game.players.get(player).score);
			}
		} else {
			data = new String[][]{
					{"", ""},
					{"", ""},
					{"", ""},
					{"", ""},
					{"", ""}
			};
		}
		table = new JTable(data, columnNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		JScrollPane pane = new JScrollPane(table);
		Dimension d = new Dimension(300, 250);
		pane.setPreferredSize(d);
		add(pane, BorderLayout.NORTH);
		this.validate();
		this.repaint();
	}

	@Override
	public boolean setup() {
		// TODO Auto-generated method stub
		refresh();
		return true;
	}

	@Override
	public boolean teardown() {
		// TODO Auto-generated method stub
		return false;
	}

}
