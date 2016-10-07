/**
 * 
 */
package request;

import external.xml.Message;

/**
 * @author quangvu
 *
 */
public class XmlStringBuilder {
	String xml;
	
	public XmlStringBuilder(String name) {
		this.xml = Message.requestHeader() + "<" + name;
	}
	
	public XmlStringBuilder add(String id, String value) {
		this.xml += " " + id + "='" + value + "'";
		
		return this;
	}
	
	public XmlStringBuilder finish() {
		this.xml += "/></request>";
		
		return this;
	}
	
	@Override
	public String toString() {
		return xml;
	}
}