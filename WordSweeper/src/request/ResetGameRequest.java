package request;

import xml.Message;

public class ResetGameRequest implements IRequest {

	private String gameId;

	public ResetGameRequest(String gameId) {
		this.gameId = gameId;
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("resetGameRequest").add("gameId", gameId).finish()
				.toString();
	}

	@Override
	public Message toMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
