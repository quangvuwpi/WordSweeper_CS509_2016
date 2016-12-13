package response;

/**
 * This class encapsulates the lock game response object from the server
 * 
 * @author quangvu
 *
 */
public class LockGameResponse extends Response{

	public final String gameId;

	public LockGameResponse(String gameId) {
		this.gameId = gameId;
	}

}
