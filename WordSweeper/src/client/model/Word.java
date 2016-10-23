package client.model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * The Word entity class; represents the sequence of selected Cells on the board
 * 
 * @author quangvu
 */
public class Word implements Iterator<Cell> {
	protected int current = 0;
	protected LinkedList<Cell> cell;

    public Word(){
    	this.cell = new LinkedList<Cell>();
    }

    public boolean addCell(Cell p) {
    	if (p != null){
    		cell.addLast(p);
    		return true;
    	}
    	return false;
    }
    
    public int length() {
    	return cell.size();
    }
    
    @Override
    public String toString() {
    	String result = "";
    	
    	int temp = current;
    	current = 0;
    	while (hasNext()) {
    		result += next().letter; 
    	}
    	current = temp;
    	
    	return result;
    }

	@Override
	public boolean hasNext() {
		return (current < cell.size());
	}

	@Override
	public Cell next() {
		if (hasNext()) {
			Cell c = cell.get(current);
			current++;
			
			return c;
		}		
		return null;
	}

}
