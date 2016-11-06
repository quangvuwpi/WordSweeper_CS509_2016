package request;

import xml.Message;

public class LockGameRequest implements IRequest {

	private String gameId;

	public LockGameRequest(String gameId) {
		this.gameId = gameId;
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("lockGameRequest").add("gameId", gameId).finish()
				.toString();
	}

	@Override
	public Message toMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
