/**
 * 
 */
package client.messageController;

import xml.Message;

/**
 * Chainable message controller abstract class
 * 
 * @author quangvu
 *
 */
public abstract class ChainableMessageController {

	/**
	 * Next link in the chain
	 */
	ChainableMessageController next = null;

	/**
	 * Add a new controller to the chain
	 * 
	 * @param controller
	 *            the new controller link to add
	 * @return true if the controller was added; false if not
	 */
	public boolean addController(ChainableMessageController controller) {
		if (controller != null && controller instanceof ChainableMessageController) {
			if (next != null) {
				return next.addController(controller);
			} else {
				next = controller;
				return true;
			}
		}
		return false;
	}

	/**
	 * Process the incoming Message
	 * 
	 * @param message
	 *            the Message to process
	 * @return true if Message is consumed; false if not;
	 */
	abstract public boolean process(Message message);

}
