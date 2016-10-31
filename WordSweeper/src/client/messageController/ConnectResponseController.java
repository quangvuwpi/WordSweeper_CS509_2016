/**
 * 
 */
package client.messageController;

import xml.Message;

/**
 * @author quangvu
 *
 */
public class ConnectResponseController extends ChainableMessageController {

	/* (non-Javadoc)
	 * @see client.controller.ChainableMessageController#process(xml.Message)
	 */
	@Override
	public boolean process(Message message) {
		String type = message.contents.getFirstChild().getLocalName();
		if (!type.equals("connectResponse")) {
			return next.process(message);
		}
		
		/** Consumes the message **/
		System.out.print(message.toString() + "\n");
		
		return true;
	}

}
