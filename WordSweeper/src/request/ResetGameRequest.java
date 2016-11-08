package request;

public class ResetGameRequest extends AbstractRequest {

	private String gameId;

	public ResetGameRequest(String gameId) {
		this.gameId = gameId;
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("resetGameRequest").add("gameId", gameId).finish()
				.toString();
	}

}
