/**
 * 
 */
package request;

/**
 * Join existing game request
 * 
 * @author quangvu
 *
 */
public class JoinGameRequest extends AbstractRequest {

	public final String name;
	public final String gameId;
	public final String password;
	/**
	 * Send a request to join game
	 * @param name
	 * @param gameId
	 * @param password
	 */
	public JoinGameRequest(String name, String gameId, String password) {
		this.name = name;
		this.gameId = gameId;

		if (password != null) {
			this.password = password;
		} else {
			this.password = "";
		}
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("joinGameRequest").add("name", name).add("gameId", gameId).add("password", password)
				.finish().toString();
	}

}
