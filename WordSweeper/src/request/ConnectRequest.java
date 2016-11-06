/**
 * 
 */
package request;

import xml.Message;

/**
 * @author quangvu
 *
 */
public class ConnectRequest implements IRequest {

	@Override
	public String toString() {
		return new XmlStringBuilder("connectRequest").finish().toString();
	}

	/* (non-Javadoc)
	 * @see request.IRequest#toMessage()
	 */
	@Override
	public Message toMessage() {
		return new Message(toString());
	}

}
