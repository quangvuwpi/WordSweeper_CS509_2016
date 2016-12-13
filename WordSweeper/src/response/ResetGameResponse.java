package response;

/**
 * This class encapsulates the reset game response object from the server
 * 
 * @author quangvu
 *
 */
public class ResetGameResponse extends Response{

	public final String gameId;

	public ResetGameResponse(String gameId) {
		this.gameId = gameId;
	}

}
