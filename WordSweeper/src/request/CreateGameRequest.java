/**
 * 
 */
package request;

import external.xml.Message;

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
		String xml = new XmlStringBuilder("createGameRequest").add("name", name).finish().toString();
		
		return xml;
	}

	/* (non-Javadoc)
	 * @see request.IRequest#toMessage()
	 */
	@Override
	public Message toMessage() {
		return new Message(toString());
	}

}
