package client.model;

import java.util.Stack;

public class Word {
	Stack<Cell> cell;
	int point;

    public Word(){
    	this.point = 0;
    	this.cell = new Stack<Cell>();
    }

    public boolean addCell(Cell p) {
    	if (p != null){
    		cell.push(p);
    		return true;
    	}
    	return false;
    }

}
