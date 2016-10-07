/**
 * 
 */
package request;

import external.xml.Message;

/**
 * @author quangvu
 *
 */
public class ConnectRequest implements IRequest {
	
	@Override
	public String toString() {
		return Message.requestHeader() + "<connectRequest/></request>";
	}

	/* (non-Javadoc)
	 * @see request.IRequest#toMessage()
	 */
	@Override
	public Message toMessage() {
		return new Message(toString());
	}

}
