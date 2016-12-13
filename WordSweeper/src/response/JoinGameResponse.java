package response;

/**
 * This class encapsulates the join game response object from the server
 * 
 * @author quangvu
 *
 */
public class JoinGameResponse extends Response{

	public final String gameId;

	public JoinGameResponse(String gameId) {
		this.gameId = gameId;
	}

}
