package request;

import client.model.Cell;
import client.model.Position;
import client.model.Word;

public class FindWordRequest extends AbstractRequest {

	public final String name;
	public final String gameId;
	public final Word word;

	public FindWordRequest(String name, String gameId, Word word) {
		this.name = name;
		this.gameId = gameId;
		this.word = word;
	}

	@Override
	public String toString() {
		XmlStringBuilder builder = new XmlStringBuilder("findWordRequest").add("name", name)
				.add("word", word.toString()).add("gameId", gameId).closeSegment();

		while (word.hasNext()) {
			Cell c = word.next();
			
			// Have to add an offset of 1 when talking to server
			Position p = new Position(c.position.col + 1, c.position.row + 1);
			
			builder.add(new XmlStringBuilder("cell", false).add("position", p.toString()).add("letter", c.letter)
					.closeElement().toString());
		}

		return builder.finishSegment().toString();
	}

}
