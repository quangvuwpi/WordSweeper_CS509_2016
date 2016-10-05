package external.client;

import external.xml.Message;

public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(Message response);
}