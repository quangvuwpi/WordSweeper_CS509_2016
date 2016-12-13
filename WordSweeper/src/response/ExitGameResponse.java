package response;

/**
 * This class encapsulates the exit game response object from the server
 * 
 * @author quangvu
 *
 */
public class ExitGameResponse extends Response{

	public final String gameId;

	public ExitGameResponse(String id) {
		this.gameId = id;
	}

}
