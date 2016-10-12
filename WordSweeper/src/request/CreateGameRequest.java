/**
 * 
 */
package request;

import xml.Message;

/**
 * @author quangvu
 *
 */
public class CreateGameRequest implements IRequest {
	
	public String name;
	
	public CreateGameRequest(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return new XmlStringBuilder("createGameRequest").add("name", name).finish().toString();
	}

	/* (non-Javadoc)
	 * @see request.IRequest#toMessage()
	 */
	@Override
	public Message toMessage() {
		return new Message(toString());
	}

}
