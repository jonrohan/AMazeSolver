/*
 * Created on Sep 16, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package constraintMaze;

import java.util.*;


/**
 * @author Jon
 * @date Sep 16, 2005
 * @time 8:12:15 PM
 * @project Constraint-satisfaction Maze
 *  
 */
public class Path {

	private int energyAdded = 0;

	private int energyCost = 0;

	private ArrayList positions;

	public Path(Position start) {
		positions = new ArrayList();
		positions.add(start);
	}

	public void addPosition(Position p) {
		Position last = (Position) positions.get(positions.size() - 1);
		positions.add(p);
		if (last.getY() > p.getY()) {
			energyCost--;
		}
		this.energyCost += p.getEnergyCost();
	}

	public void backtrack() {
		Position last = (Position) positions.get(positions.size() - 1);
		Position beforelast = (Position) positions.get(positions.size() - 2);
		if (beforelast.getY() > last.getY()) {
			energyCost++;
		}
		this.energyCost -= last.getEnergyCost();
		positions.remove(positions.size() - 1);

	}

	public int getEnergyCost() {
		return energyCost;
	}

	public Position getPosition(int i) {
		return (Position) positions.get(i);
	}

	public int getSize() {
		return positions.size();
	}

}
