package client.view;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import junit.framework.TestCase;

public class MouseEventTestCase extends TestCase {
	
	/**
	 * Generate a dummy MouseEvent to test MouseListeners
	 * 
	 * @param listener
	 * @param component
	 */
	void testMouseClicked(MouseListener listener, Component component) {
		MouseEvent e = new MouseEvent(component,0,0,0,0,0,0,0,1,false,0);
		listener.mouseClicked(e);
	}
	
	/**
	 * Generate a dummy click on a dummy button
	 * 
	 * @param listener
	 */
	void testMouseClicked(MouseListener listener) {
		MouseEvent e = new MouseEvent(new JButton(),0,0,0,0,0,0,0,1,false,0);
		listener.mouseClicked(e);
	}

}
