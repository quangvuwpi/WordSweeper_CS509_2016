package request;

public class RepositionBoardRequest extends AbstractRequest {

	public final String name;
	public final String gameId;
	public final int rowChange;
	public final int colChange;

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

}
