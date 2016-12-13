package request;

import client.model.Cell;
import client.model.Position;
import client.model.Word;

/**
 * Find word request
 * 
 * @author quangvu
 *
 */
public class FindWordRequest extends AbstractRequest {

	public final String name;
	public final String gameId;

	public final Word word;
	public final Position position;

	public FindWordRequest(String name, String gameId, Position position, Word word) {
		this.name = name;
		this.gameId = gameId;
		this.word = word;
		this.position = position;
	}

	@Override
	public String toString() {
		XmlStringBuilder builder = new XmlStringBuilder("findWordRequest").add("name", name)
				.add("word", word.toString()).add("gameId", gameId).closeSegment();

		int col_offset = position.col + 1;
		int row_offset = position.row + 1;
		while (word.hasNext()) {
			Cell c = word.next();

			// Have to add an offset of 1 when talking to server
			Position p = new Position(col_offset + c.position.col, row_offset + c.position.row);

			builder.add(new XmlStringBuilder("cell", false).add("position", p.toString()).add("letter", c.letter)
					.closeElement().toString());
		}

		return builder.finishSegment().toString();
	}

}
