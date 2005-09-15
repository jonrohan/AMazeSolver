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
 * @time 7:45:01 PM
 * @project Constraint-satisfaction Maze
 * 
 */
public class Seeker {

	private int energy;

	private ArrayList paths;

	public Seeker(int e) {
		energy = e;
		paths = new ArrayList();
	}

	public void addPath(Path p) {
		paths.add(p);
	}

	public Path getBestPath() {
		Path best = (Path) paths.get(0);
		for (int i = 1; i < paths.size(); i++) {
			Path temp = (Path) paths.get(i);
			if (temp.getEnergyCost() > best.getEnergyCost()) {
				best = temp;
			}
		}
		this.energy += best.getEnergyCost();
		return best;
	}

	public int getEnergy() {
		return this.energy;
	}

	public boolean oldPath(Path pa) {

		for (int i = 0; i < paths.size(); i++) {
			Path tempPath = (Path) paths.get(i);
			int equal = 0;
			for (int j = 0; j < tempPath.getSize(); j++) {
				try {

					if (tempPath.getPosition(j).isEqual(pa.getPosition(j))) {
						equal++;
					}
				} catch (Exception e) {
					return false;
				}
			}
			if (equal == pa.getSize()) {
				return true;
			} else {
				equal = 0;
			}
		}
		return false;
	}
}
