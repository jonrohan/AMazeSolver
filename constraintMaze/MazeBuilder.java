package constraintMaze;

import java.io.*;


/**
 * @author Jon Rohan
 * @date 9/14/2005
 * @time 2:41 pm
 * @project Constraint-satisfaction Maze
 *  
 */
public class MazeBuilder {

	public static void main(String[] args) {
		MazeBuilder mb = new MazeBuilder("maze_in.dat", "maze_out.dat");
		mb.readFile();
		mb.findPositions();
		mb.createTree();
		mb.createSeeker();
		MazeSolver ms = new MazeSolver(mb.getMaze(), mb.getSeeker(), mb
				.getBoard());
		mb.writeFile(ms.solve());
	}

	private FileReader inFileReader;

	private Maze myMaze;

	private Seeker mySeeker;

	private FileWriter outFileWriter;

	private int rows, cols, energy;

	private char tempArray[][] = null;

	public MazeBuilder(String inFile, String outFile) {
		try {
			inFileReader = new FileReader(inFile);
			outFileWriter = new FileWriter(outFile);
			myMaze = new Maze();
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getLocalizedMessage());
		}
	}

	private void checkForChildren(Position p) {
		int x = p.getX();
		int y = p.getY();
		if (x == cols - 1) {
			p.isEnd();
		}
		if (!p.end()) {
			if (tempArray[y + 1][x] == ' ' || tempArray[y + 1][x] == '$'
					|| tempArray[y + 1][x] == '*' || tempArray[y + 1][x] == '#'
					|| tempArray[y + 1][x] == '^') {
				Position child = new Position(x, y + 1, tempArray[y + 1][x], p);
				int px = p.getParent().getX();
				int py = p.getParent().getY();
				if (!(px == x && py == y + 1)) {
					p.addChild(child);
					checkForChildren(child);
				}
			}
			if (tempArray[y][x + 1] == ' ' || tempArray[y][x + 1] == '$'
					|| tempArray[y][x + 1] == '*' || tempArray[y][x + 1] == '#'
					|| tempArray[y][x + 1] == '^') {
				Position child = new Position(x + 1, y, tempArray[y][x + 1], p);
				int px = p.getParent().getX();
				int py = p.getParent().getY();
				if (!(px == x + 1 && py == y)) {
					p.addChild(child);
					checkForChildren(child);
				}
			}
			if (tempArray[y - 1][x] == ' ' || tempArray[y - 1][x] == '$'
					|| tempArray[y - 1][x] == '*' || tempArray[y - 1][x] == '#'
					|| tempArray[y - 1][x] == '^') {
				Position child = new Position(x, y - 1, tempArray[y - 1][x], p);
				int px = p.getParent().getX();
				int py = p.getParent().getY();
				if (!(px == x && py == y - 1)) {
					p.addChild(child);
					checkForChildren(child);
				}
			}

		}
	}

	private void createSeeker() {
		mySeeker = new Seeker(energy);
	}

	private void createTree() {
		Position startPosition = myMaze.getStartPosition();
		if (startPosition == null) {
			//todo throw new exception
		}
		this.checkForChildren(startPosition);
	}

	private void findPositions() {
		for (int y = 0; y < rows; y++) {
			if (tempArray[y][0] == ' ' || tempArray[y][0] == '$'
					|| tempArray[y][0] == '*' || tempArray[y][0] == '#'
					|| tempArray[y][0] == '^') {
				Position p = new Position(0, y, tempArray[y][0], null);
				p.isStart();
				myMaze.addPosition(p);
			}
		}
		for (int y = 0; y < rows; y++) {
			if (tempArray[y][cols - 1] == ' ' || tempArray[y][cols - 1] == '$'
					|| tempArray[y][cols - 1] == '*'
					|| tempArray[y][cols - 1] == '#'
					|| tempArray[y][cols - 1] == '^') {
				Position p = new Position(cols - 1, y, tempArray[y][cols - 1],
						null);
				p.isEnd();
				myMaze.addPosition(p);
			}
		}

	}

	private char[][] getBoard() {
		return tempArray;
	}

	private Maze getMaze() {
		return myMaze;
	}

	private Seeker getSeeker() {
		return mySeeker;
	}

	private void readFile() {
		try {
			// create a buffered reader to read the file as text
			BufferedReader brFile = new BufferedReader(inFileReader);
			// read the first line of the br
			String line = brFile.readLine();
			System.out.println(line);
			// split the first line by ' ' and store in a temp line array
			String lineArray[] = line.split(" ");
			// the number of rows in the maze
			rows = Integer.parseInt(lineArray[0]);
			// the number of cols in the maze
			cols = Integer.parseInt(lineArray[1]);
			// the amount of energy for the traveler
			energy = Integer.parseInt(lineArray[2]);

			tempArray = new char[rows][cols];

			// read the next line of the maze
			line = brFile.readLine();

			for (int i = 0; i < 8; i++) {
				System.out.println(line);
				for (int j = 0; j < 16; j++) {
					tempArray[i][j] = line.charAt(j);
				}
				line = brFile.readLine();
			}

		} catch (Exception e) {

		}
	}

	private void writeFile(char[][] temp) {
		try {
			System.out.println();
			BufferedWriter bw = new BufferedWriter(outFileWriter);
			bw.write(mySeeker.getEnergy());
			System.out.println(mySeeker.getEnergy());
			bw.newLine();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					bw.write(temp[i][j]);
					System.out.print(temp[i][j]);
				}
				System.out.println();
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {

		}

	}

}
