package client.messageController;

import client.IMessageHandler;
import xml.Message;

/**
 * Sample implementation of a protocol handler to respond to messages received
 * from the server. You should follow this template when designing YOUR message
 * handler.
 * 
 * Note: This one does nothing more than dump the XML message into the client
 * window. Nothing that special.
 */
public class ClientMessageHandler implements IMessageHandler {
	
	/** The chain of message controller **/
	ChainableMessageController chain = null;

	/**
	 * Add a new mesage controller to the chain
	 * 
	 * @param controller
	 *            the new controller to add
	 * @return true if the controller was added; false if not
	 */
	public boolean addController(ChainableMessageController controller) {
		if (controller != null && controller instanceof ChainableMessageController) {
			if (chain != null) {
				return chain.addController(controller);
			} else {
				chain = controller;
				return true;
			}
		}
		return false;
	}

	@Override
	public void process(Message response) {
		chain.process(response);
	}

}
