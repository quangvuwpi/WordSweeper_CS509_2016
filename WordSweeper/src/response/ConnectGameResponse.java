package response;

/**
 * This class encapsulates the connect game response object from the server
 * 
 * @author quangvu
 *
 */
public class ConnectGameResponse extends Response{

	public final String id;

	public ConnectGameResponse(String id) {
		this.id = id;
	}

}
