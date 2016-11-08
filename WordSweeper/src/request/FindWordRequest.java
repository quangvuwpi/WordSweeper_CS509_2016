package request;

import client.model.Cell;

public class FindWordRequest extends AbstractRequest {

	private String name;
	private String word;
	private String gameId;
	private Cell[] cell;

	public FindWordRequest(String name, String word, String gameId, Cell[] cell) {
		this.name = name;
		this.word = word;
		this.gameId = gameId;
//		this.cell = cell;
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("findWordGameRequest").add("name", name).add("word", word).add("gameId", gameId).finish()
				.toString();
	}

}
