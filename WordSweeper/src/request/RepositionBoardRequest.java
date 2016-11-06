package request;

import xml.Message;

public class RepositionBoardRequest implements IRequest {

	private String name;
	private String gameId;
	private int rowChange;
	private int colChange;

	public RepositionBoardRequest(String name, String gameId, int rowChange, int colChange) {
		this.name = name;
		this.gameId = gameId;
		this.rowChange = rowChange;
		this.colChange = colChange;
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("repositionBoardRequest").add("name", name).add("gameId", gameId).add("rowChange", Integer.toString(rowChange)).add("colChange", Integer.toString(colChange)).finish()
				.toString();
	}

	@Override
	public Message toMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
