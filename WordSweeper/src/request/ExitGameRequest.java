package request;

/**
 * Exit current game request
 * 
 * @author quangvu
 *
 */
public class ExitGameRequest extends AbstractRequest {

	private String name;
	private String gameId;

	public ExitGameRequest(String name, String gameId) {
		this.name = name;
		this.gameId = gameId;
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("exitGameRequest").add("name", name).add("gameId", gameId).finish()
				.toString();
	}

}
