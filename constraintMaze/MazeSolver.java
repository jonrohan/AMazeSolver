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
 * @time 7:54:13 PM
 * @project Constraint-satisfaction Maze
 * 
 */
public class MazeSolver {

	private Maze aMaze;

	private char[][] arrayBoard;

	private Seeker aSeeker;

	public MazeSolver(Maze m, Seeker s, char[][] b) {
		aMaze = m;
		aSeeker = s;
		arrayBoard = b;
	}

	private char[][] drawPath() {
		Path p = aSeeker.getBestPath();
		for (int i = 0; i < p.getSize(); i++) {
			int x = p.getPosition(i).getX();
			int y = p.getPosition(i).getY();
			arrayBoard[y][x] = 'X';
		}
		return arrayBoard;
	}

	public void followPath(Position pos, Path path) {
		ArrayList children = pos.getChildren();
		for (int i = 0; i < children.size(); i++) {
			Position child = (Position) children.get(i);
			path.addPosition(child);
			if (child.end() && !aSeeker.oldPath(path)) {
				foundPath(path);
			} else if (!child.end() && !aSeeker.oldPath(path)) {
				followPath(child, path);
			} else {
				path.backtrack();
			}
		}
		path.backtrack();
	}

	public void foundPath(Path p) {

		Path temp = new Path(p.getPosition(0));
		for (int i = 1; i < p.getSize(); i++) {
			temp.addPosition(p.getPosition(i));
		}
		aSeeker.addPath(temp);
	}

	public char[][] solve() {
		char solution[][] = null;
		Position startPosition = aMaze.getStartPosition();
		Path tempPath = new Path(startPosition);
		followPath(startPosition, tempPath);
		solution = drawPath();
		return solution;
	}

}
