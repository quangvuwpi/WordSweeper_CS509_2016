/**
 * 
 */
package client.messageController;

import utility.Debug;
import xml.Message;

/**
 * Controller to process ConnectResponse
 * 
 * @author quangvu
 *
 */
public class ConnectResponseController extends ChainableMessageController {

	/** (non-Javadoc)
	 * @see client.controller.ChainableMessageController#process(xml.Message)
	 */
	@Override
	public boolean process(Message message) {
		String type = message.contents.getFirstChild().getLocalName();
		if (!type.equals("connectResponse")) {
			return next.process(message);
		}
		
		/** Consumes the message **/
		Debug.print(message.toString() + "\n");
		
		return true;
	}

}
