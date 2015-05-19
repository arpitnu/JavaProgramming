/**
 * TwentyFortyEight.java
 */
package interviews.codeeval.hard.TwentyFortyEight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author arpitm
 * 
 *         CHALLENGE DESCRIPTION:
 * 
 *         The task is to implement part of the logic of 2048 game.
 * 
 *         The original 2048 is played on a 4×4 grid, with numbered tiles that
 *         slide when a player moves them using the four arrow keys. Tiles slide
 *         as far as possible in the chosen direction until they are stopped by
 *         either another tile or the edge of the grid. If two tiles of the same
 *         number collide while moving, they will merge into a tile with the
 *         total value of the two tiles that collided. The resulting tile cannot
 *         merge with another tile again in the same move (Description from
 *         Wikipedia article: https://en.wikipedia.org/w/index.php?title=
 *         2048_(video_game)&oldid=660010236).
 * 
 *         In this challenge, you have to implement the logic for the sliding
 *         tiles in the chosen direction. Unlike the original game, a new tile
 *         cannot appear after the move and the grid size may vary from 4 to 10.
 * 
 *         INPUT SAMPLE:
 * 
 *         The first argument is a path to a file. Each line of the input file
 *         contains one test case. Each test case consists of a direction (UP,
 *         DOWN, RIGHT, or LEFT), the length of a side in the square grid, and
 *         the initial configuration of the grid. All the data elements are
 *         separated by a semicolon. The configuration of the grid is a series
 *         of lines from top to bottom separated by a vertical bar. 0 indicates
 *         a blank tile.
 * 
 *         For example:
 * 
 *         RIGHT; 4; 4 0 2 0|0 0 0 8|4 0 2 4|2 4 2 2
 * 
 *         UP; 4; 2 0 2 0|0 2 0 4|2 8 0 8|0 8 0 16
 * 
 *         OUTPUT SAMPLE:
 * 
 *         For each test case, print to stdout the configuration of the grid
 *         received after slide of a tile in the chosen direction. Format is the
 *         same as in the input file. Lines are written from top to bottom and
 *         are separated by a vertical bar. Blank tiles are marked with 0.
 * 
 *         For example:
 * 
 *         0 0 4 2|0 0 0 8|0 4 2 4|0 2 4 4
 * 
 *         4 2 2 4|0 16 0 8|0 0 0 16|0 0 0 0
 * 
 *         CONSTRAINTS:
 * 
 *         1. The grid is square with the length of a side from 4 to 10.
 * 
 *         2. The value of the tiles is equal to the power of number 2 and
 *         varies from 21 to 210.
 *
 */
public class TwentyFortyEight {

	public static final String MOVE_UP = "UP";
	public static final String MOVE_DOWN = "DOWN";
	public static final String MOVE_LEFT = "LEFT";
	public static final String MOVE_RIGHT = "RIGHT";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();

			if (line.length() != 0) {
				// Process line of input Here
				String[] lineParts = line.split("; ");

				if (lineParts.length == 3) {
					String move = lineParts[0];
					int gridSize = Integer.parseInt(lineParts[1]);
					int[][] grid = constructGrid(lineParts[2], gridSize);

					// Process move
					int[][] newGrid = new int[gridSize][gridSize];
					if (move.equals(MOVE_UP)) {
						newGrid = processUp(grid, gridSize);
					} else if (move.equals(MOVE_DOWN)) {
						newGrid = processDown(grid, gridSize);
					} else if (move.equals(MOVE_LEFT)) {
						newGrid = processLeft(grid, gridSize);
					} else if (move.equals(MOVE_RIGHT)) {
						newGrid = processRight(grid, gridSize);
					}

					// Print matrix
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < gridSize; i++) {
						for (int j = 0; j < gridSize; j++) {
							if (j == 0) {
								sb.append(newGrid[i][j]);
							} else {
								sb.append(" " + newGrid[i][j]);
							}
						}

						if (i < gridSize - 1) {
							sb.append("|");
						}
					}

					System.out.println(sb.toString());
				}
			}
		}

		// Close buffer
		buffer.close();
	}

	private static int[][] processRight(int[][] grid, int size) {

		for (int i = 0; i < size; i++) {
			int j = size - 1;

			while (j >= 0) {
				int k = j - 1;

				while (k >= 0) {
					if (grid[i][k] > 0) {
						if (grid[i][j] == grid[i][k]) {
							grid[i][j] += grid[i][k];
							grid[i][k] = 0;
							break;
						} else if (grid[i][j] == 0) {
							grid[i][j] = grid[i][k];
							grid[i][k] = 0;
						} else {
							break;
						}
					}

					k--;
				}

				j--;
			}
		}

		return grid;
	}

	private static int[][] processLeft(int[][] grid, int size) {

		for (int i = 0; i < size; i++) {
			int j = 0;

			while (j < size) {
				int k = j + 1;

				while (k < size) {
					if (grid[i][k] > 0) {
						if (grid[i][j] == grid[i][k]) {
							grid[i][j] += grid[i][k];
							grid[i][k] = 0;
							break;
						} else if (grid[i][j] == 0) {
							grid[i][j] = grid[i][k];
							grid[i][k] = 0;
						} else {
							break;
						}
					}

					k++;
				}

				j++;
			}
		}

		return grid;
	}

	private static int[][] processUp(int[][] grid, int size) {

		for (int j = 0; j < size; j++) {
			int i = 0;

			while (i < size) {
				int k = i + 1;

				while (k < size) {
					if (grid[k][j] > 0) {
						if (grid[i][j] == grid[k][j]) {
							grid[i][j] += grid[k][j];
							grid[k][j] = 0;
							break;
						} else if (grid[i][j] == 0) {
							grid[i][j] = grid[k][j];
							grid[k][j] = 0;
						} else {
							break;
						}
					}

					k++;
				}

				i++;
			}
		}

		return grid;

	}

	private static int[][] processDown(int[][] grid, int size) {

		for (int j = 0; j < size; j++) {
			int i = size - 1;

			while (i > 0) {
				int k = i - 1;

				while (k >= 0) {
					if (grid[k][j] > 0) {
						if (grid[i][j] == grid[k][j]) {
							grid[i][j] += grid[k][j];
							grid[k][j] = 0;
							break;
						} else if (grid[i][j] == 0) {
							grid[i][j] = grid[k][j];
							grid[k][j] = 0;
						} else {
							break;
						}
					}

					k--;
				}

				i--;
			}
		}

		return grid;

	}

	/**
	 * Function takes in a grid string from file input. Constructs and returns a
	 * [size X size] matrix
	 * 
	 * @param gridStr
	 * @param size
	 * @return
	 */
	private static int[][] constructGrid(String gridStr, int size) {
		// Declare the 2D grid of lenght = size
		int[][] grid = new int[size][size];

		String[] gridRows = gridStr.split("\\|");

		if (gridRows.length == size) {
			// Process all rows and store in grid[][]
			for (int i = 0; i < size; i++) {
				String row = gridRows[i];
				String[] rowElements = row.split(" ");

				if (rowElements.length == size) {
					for (int j = 0; j < size; j++) {
						grid[i][j] = Integer.parseInt(rowElements[j]);
					}
				} else {
					break;
				}
			}
		}

		return grid;
	}

}
