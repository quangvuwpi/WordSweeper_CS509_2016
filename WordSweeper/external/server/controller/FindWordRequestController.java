package server.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import server.ClientState;
import server.IProtocolHandler;
import server.model.ServerModel;
import xml.Message;

public class FindWordRequestController implements IProtocolHandler {
	
	ServerModel model;
	
	public FindWordRequestController(ServerModel m) {
		this.model = m;
	}

	@Override
	public Message process(ClientState state, Message request) {
		
		Node r = request.contents.getFirstChild();
		NamedNodeMap map = r.getAttributes();

		String name = map.getNamedItem("name").getNodeValue();
		String gameId = map.getNamedItem("gameId").getNodeValue();
		
		String xmlString = Message.responseHeader(request.id()) +
				"<findWordResponse gameId='" + gameId + "' name='" + name + "'>" +
			"</response>";
		
		return new Message(xmlString);
	}

}
