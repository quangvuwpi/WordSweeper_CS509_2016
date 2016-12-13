/**
 * 
 */
package request;

import xml.Message;

/**
 * Request common interface
 * 
 * @author quangvu
 *
 */
public interface IRequest {
	
	/**
	 * Get the Message object for this message
	 * 
	 * @return Message object for this request
	 */
	public Message toMessage();

}
