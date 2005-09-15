package constraintMaze;

import java.util.*;

/**
 * @author Jon Rohan
 * @date Sep 15, 2005
 * @time 9:37:46 PM
 * @project Constraint-satisfaction Maze
 *  
 */
public class Maze {

	private ArrayList positions;

	public Maze() {
		positions = new ArrayList();
	}

	public void addPosition(Position p) {
		positions.add(p);
	}

	public int getPositionsSize() {
		return positions.size();
	}

	public Position getPostion(int x, int y) {
		Position p = null;
		for (int i = 0; i < positions.size(); i++) {
			Position temp = (Position) positions.get(i);
			int tempx = temp.getX();
			int tempy = temp.getY();
			if (tempx == x && tempy == y) {
				p = temp;
			}
		}
		return p;
	}

	public Position getStartPosition() {
		Position p = null;
		for (int i = 0; i < positions.size(); i++) {
			Position temp = (Position) positions.get(i);
			if (temp.start()) {
				p = temp;
			}
		}
		return p;
	}

}
