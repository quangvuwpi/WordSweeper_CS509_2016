package request;

/**
 * Lock current game request
 * 
 * @author Qihang
 *
 */
public class LockGameRequest extends AbstractRequest {

	private String gameId;

	public LockGameRequest(String gameId) {
		this.gameId = gameId;
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("lockGameRequest").add("gameId", gameId).finish()
				.toString();
	}

}
