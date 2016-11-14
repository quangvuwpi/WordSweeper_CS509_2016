/**
 * 
 */
package request;

/**
 * @author quangvu
 *
 */
public class ConnectRequest extends AbstractRequest {

	/**
	 * Define connect request to sever
	 */
	@Override
	public String toString() {
		return new XmlStringBuilder("connectRequest").finish().toString();
	}

}
