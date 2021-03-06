/**
 * 
 */
package request;

import xml.Message;

/**
 * Abstract client request
 * 
 * @author quangvu
 *
 */
public abstract class AbstractRequest implements IRequest {
	
	@Override
	public abstract String toString();

	/* (non-Javadoc)
	 * @see request.IRequest#toMessage()
	 */
	@Override
	public Message toMessage() {
		return new Message(toString());
	}

}
