/**
 * 
 */
package client.messageController;

import xml.Message;

/**
 * Dummy controller for unhandled responses
 * 
 * @author quangvu
 *
 */
public class DefaultMessageController extends ChainableMessageController {

	/* (non-Javadoc)
	 * @see client.messageController.ChainableMessageController#process(xml.Message)
	 */
	@Override
	public boolean process(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

}
