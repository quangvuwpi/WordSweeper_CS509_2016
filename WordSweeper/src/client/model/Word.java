package client.model;

import java.util.Iterator;
import java.util.LinkedList;

public class Word implements Iterator<Cell> {
	protected int current = 0;
	public LinkedList<Cell> cell;
	public int point;

    public Word(){
    	this.point = 0;
    	this.cell = new LinkedList<Cell>();
    }

    public boolean addCell(Cell p) {
    	if (p != null){
    		cell.push(p);
    		return true;
    	}
    	return false;
    }

	@Override
	public boolean hasNext() {
		return (current < cell.size());
	}

	@Override
	public Cell next() {
		if (hasNext()) {
			current++;
			return cell.iterator().next();
		}		
		return null;
	}

}
