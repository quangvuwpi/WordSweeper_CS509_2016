/**
 * 
 */
package request;

/**
 * @author quangvu
 *
 */
public class CreateGameRequest extends AbstractRequest {

	public final String name;
	public final String password;

	public CreateGameRequest(String name, String password) {
		this.name = name;

		if (password != null) {
			this.password = password;
		} else {
			this.password = "";
		}
	}

	@Override
	public String toString() {
		return new XmlStringBuilder("createGameRequest").add("name", name).add("password", password).finish()
				.toString();
	}

}
