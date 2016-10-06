package client.view;

import javax.swing.JPanel;

public class WordHistory extends JPanel implements IBoundary {

	@Override
	public boolean setup() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean teardown() {
		// TODO Auto-generated method stub
		removeAll();
		return true;
	}

}
