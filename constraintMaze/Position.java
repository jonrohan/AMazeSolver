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
 * @time 5:20:47 PM
 * @project Constraint-satisfaction Maze
 * 
 */
public class Position {

	private ArrayList children;

	private char energySymbol;

	private boolean isStart = false, isEnd = false;

	private Position parent;

	private int x, y, energyCost;

	public Position(int x, int y, char eS, Position parent) {
		this.x = x;
		this.y = y;
		this.energySymbol = eS;
		this.children = new ArrayList();
		this.parent = parent;
		if (parent == null) {
			this.parent = this;
		}
		if (energySymbol == '$') {
			energyCost += 10;
		} else if (energySymbol == '$') {
			energyCost += 10;
		} else if (energySymbol == '*') {
			energyCost += 5;
		} else if (energySymbol == '#') {
			energyCost -= 10;
		} else if (energySymbol == '^') {
			energyCost -= 5;
		}

	}

	public void addChild(Position p) {
		this.children.add(p);
	}

	public void addChildren(ArrayList p) {
		this.children.addAll(p);
	}

	public boolean end() {
		return isEnd;
	}

	public ArrayList getChildren() {
		return children;
	}

	public String getCoordinates() {
		String coor = x + "," + y;
		return coor;
	}

	public int getEnergyCost() {
		return this.energyCost;
	}

	public Position getParent() {
		return this.parent;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void isEnd() {
		this.isEnd = true;
	}

	public boolean isEqual(Position p) {
		int x = this.getX();
		int y = this.getY();
		if (p.getX() == x && p.getY() == y) {
			return true;
		}
		return false;
	}

	public boolean isParent(Position p) {
		int px = this.getX();
		int py = this.getY();
		int cx = p.getX();
		int cy = p.getY();
		for (int i = 0; i < this.children.size(); i++) {
			Position temp = (Position) this.children.get(i);
			int tempx = temp.getX();
			int tempy = temp.getY();
			if (tempx == cx && tempy == cy) {
				return true;
			}
		}
		return false;
	}

	public void isStart() {
		this.isStart = true;
	}

	public boolean start() {
		return isStart;
	}

}
