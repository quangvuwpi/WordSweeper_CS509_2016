package response;

public class FindWordResponse extends Response{

	public final String gameId;
	public final String name;
	public final long score;

	public FindWordResponse(String gameId, String name, long score) {
		this.gameId = gameId;
		this.name = name;
		this.score = score;
	}

}
