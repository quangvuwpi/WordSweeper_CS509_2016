package client;

import client.ServerAccess;
import client.messageController.BoardResponseController;
import client.messageController.ClientMessageHandler;
import client.messageController.ConnectResponseController;
import client.messageController.DefaultMessageController;
import client.messageController.FindWordResponseController;
import client.model.Model;
import client.view.Application;
import request.ConnectRequest;
import xml.Message;

/** Launch command-line Client to show minimal access needs. */
public class ClientLauncher {

	/**
	 * If requested by ClientLauncher (pass in '-server' as argument).
	 */
	public static final String serverHost = "localhost";

	/** The XML protocol being used by WordSweeper **/
	public static String xmlProtocol = "wordsweeper.xsd";

	/** The library file being used by WordSweeper **/
	public static String wordLibrary = "WordTable.sort";

	/**
	 * Note that to simplify the coding of this command-client, it declares that
	 * it can throw an Exception, which is typically the failed connection to a
	 * server.
	 */
	public static void main(String[] args) throws Exception {

		String host = serverHost;
		String protocol = xmlProtocol;
		String library = wordLibrary;

		/** Parse user inputs and override default values if given */
		int i = 0;
		while (i < args.length - 1) {
			if (args[i].equalsIgnoreCase("-server")) {
				host = args[i + 1];
				i += 2;
			} else if (args[i].equalsIgnoreCase("-protocol")) {
				protocol = args[i + 1];
				i += 2;
			} else if (args[i].equalsIgnoreCase("-library")) {
				library = args[i + 1];
				i += 2;
			} else {
				i++;
			}
		}

		/** Register the XML protocol */
		if (!Message.configure(protocol)) {
			System.exit(0);
		}

		/** Initialize the client application and its corresponding model */
		Model model = new Model();
		Application app = new Application(model, library);

		/** Initialize the message handler */
		ClientMessageHandler handler = new ClientMessageHandler();
		handler.addController(new ConnectResponseController());
		handler.addController(new BoardResponseController(app, model));
		handler.addController(new FindWordResponseController(app, model));
		handler.addController(new DefaultMessageController());
		app.setMessageHandler(handler);

		/**
		 * try to connect to the server. Once connected, messages are going to
		 * be processed by SampleClientMessageHandler. For now we just continue
		 * on with the initialization because no message is actually sent by the
		 * connect method.
		 */
		ServerAccess sa = new ServerAccess(host, 11425);
		if (!sa.connect(handler)) {
			System.out.println("Unable to connect to server (" + host + "). Exiting.");
			System.exit(0);
		}
		System.out.println("Connected to " + host);

		/**
		 * As client ever time we need communicate with the server, we need this
		 * ServerAccess object.
		 */
		app.setServerAccess(sa);

		/**
		 * send an introductory connect request now that we have created (but
		 * not made visible!)
		 */
		/**
		 * the GUI
		 */
		Message m = new ConnectRequest().toMessage();
		sa.sendRequest(m);

		/**
		 * at this point, make app visible, otherwise we would terminate
		 * application
		 */
		app.start();
	}
}
