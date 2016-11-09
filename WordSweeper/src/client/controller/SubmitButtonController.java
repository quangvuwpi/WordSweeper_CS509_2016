/**
 * 
 */
package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.IController;
import client.messageController.FindWordResponseController;
import client.model.Board;
import client.model.Game;
import client.model.Model;
import client.model.Word;
import client.view.Application;
import client.view.WordHistory;
import request.FindWordRequest;
import xml.Message;

/**
 * The controller for the SUBMIT button
 * 
 * @author quangvu
 *
 */
public class SubmitButtonController extends MouseAdapter {

	Model model;
	Application app;
	WordHistory wh;

	public SubmitButtonController(Application app, Model model, WordHistory wh) {
		this.wh = wh;
		this.app = app;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Game game = model.game;
		Board board = model.game.board;
		Word word = board.selectionToWord();

		if (game.validate(word)) {
			// Create a submit message to send to server
			Message m = new FindWordRequest(game.currentUser, game.gameId, word).toMessage();
			app.getServerAccess().sendRequest(m);
			
//			app.getServerAccess().sendRequest(new IController() {
//
//				@Override
//				public void process(Message request, Message response) {
//					if (response.success() && new FindWordResponseController(app, model).process(response)) {
//						game.addToWordHistory(word);
//						wh.addWord(word.toString());
//					}
//				}
//			}, m);
		}

		board.clearSelection();
		app.refresh();
	}

}
