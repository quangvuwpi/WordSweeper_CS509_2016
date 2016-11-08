/**
 * 
 */
package request;

/**
 * @author quangvu
 *
 */
public class ConnectRequest extends AbstractRequest {

	@Override
	public String toString() {
		return new XmlStringBuilder("connectRequest").finish().toString();
	}

}
