package request;

import xml.Message;

public class ExitGameRequest implements IRequest {

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
	@Override
	public Message toMessage() {
		return new Message(toString());
	}

}
