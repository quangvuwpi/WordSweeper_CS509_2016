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

	public final String name;
	public final String password;
	/**
	 * creat new account for player
	 * name is necessary ,password is nullable
	 * @param name
	 * @param password
	 */

	public CreateGameRequest(String name, String password) {
		this.name = name;

		if (password != null) {
			this.password = password;
		} else {
			this.password = "";
		}
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("createGameRequest").add("name", name).add("password", password).finish()
				.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see request.IRequest#toMessage()
	 */
	@Override
	public Message toMessage() {
		return new Message(toString());
	}

}
