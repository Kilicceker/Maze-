package maze;

import java.io.File;
import java.util.Scanner;

public class Maze {
	/**
	 * Entry point of the maze.
	 */
	private Point2D entry;
	
	/**
	 * Exit point of the maze.
	 */
	private Point2D exit;
	
	/**
	 * 2D matrix of boolean values indicating whether 
	 * any given coordinate contains a wall or not. If there
	 * is a wall, value at corresponding cell will be marked 
	 * false.
	 */
	private boolean[][] area;
	
	/**
	 * 
	 * @param filename Path to the configuration file
	 * @throws Exception Possible exception cases are as follows:<br>
	 * * Maze area should be rectangular (mxn - m rows, n columns)<br>
	 * * Entry and exit points should be marked true (i.e., no-wall)<br>
	 * <br>
	 * Sample configuration file: <br>
	 * ------------<br>
	 * 7 9   //7 rows, 9 columns<br>
	 * 5 0    //entry point y-coordinate, x-coordinate<br>
	 * 1 8    //exit point y-coordinate, x-coordinate<br>
	 * 1 1 1 1 1 1 1 1 1 //row 0 (each value is a column)<br>
	 * 1 0 1 0 0 0 0 0 0 //row 1 (each value is a column)<br>
	 * 1 0 1 0 1 0 1 1 1 //row 2 (each value is a column)<br>
	 * 1 0 0 0 1 0 0 0 1 //row 3 (each value is a column)<br>
	 * 1 0 1 1 1 1 1 1 0 //row 4 (each value is a column)<br>
	 * 0 0 0 0 0 0 0 0 1 //row 5 (each value is a column)<br>
	 * 1 1 1 1 1 1 1 1 1 //row 6 (each value is a column)<br>
	 */
	public Maze(String filename) throws Exception {
		Scanner input = new Scanner(new File(filename));
		int numRows = input.nextInt(); //TODO check > 0
		int numCols = input.nextInt(); //TODO check > 0
		area = new boolean[numRows][numCols];
		entry = new Point2D(input.nextInt(), input.nextInt()); //TODO check validity of the coordinates
		exit = new Point2D(input.nextInt(), input.nextInt()); //TODO check validity of the coordinates
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				int val = input.nextInt();
				if(val == 0) {
					area[i][j] = true;
				} else { 
					area[i][j] = false;
				}
			}
		}
		
		if(area[entry.getY()][entry.getX()] == false) {
			input.close();
			throw new Exception("Entry point cannot be wall!");
		}
		if(area[exit.getY()][exit.getX()] == false) {
			input.close();
			throw new Exception("Exit point cannot be wall!");
		}
		
		input.close();
	}
	
	/**
	 * Returns the maze entry point
	 * @return Entry as a Point2D
	 */
	public Point2D getEntry() {
		return entry;
	}
	
	/**
	 * Returns the maze exit point
	 * @return Exit as a Point2D
	 */
	public Point2D getExit() {
		return exit;
	}
	
	/**
	 * Returns the number of rows of the maze
	 * @return Number of rows
	 */
	public int getNumRows() {
		return area.length;
	}
	
	/**
	 * Returns the number of columns of the maze
	 * @return Number of columns
	 */
	public int getNumCols() {
		return area[0].length;
	}
	
	/**
	 * Checks if a given point is covered with wall or not. Any point that is 
	 * outside the maze area is considered to be wall. 
	 * @param point The point to be checked
	 * @return True if the point is a wall, false otherwise.
	 */
	public boolean isWall(Point2D point) {     //verilen alanýn dýþý mý kontrolü
		if(point.getY() < 0 || point.getX() < 0 || point.getY() >= getNumRows() || point.getX() >= getNumCols()) {
			return true;
		}
		return !area[point.getY()][point.getX()];
	}
	
	/**
	 * Returns a String representation of the maze area.
	 * "0" indicates free-cell, and "1" indicates wall-cell. 
	 * Maze entry is marked with "S" (start), and maze exit is marked with "E" (end).
	 */
	public String toString() {
		int numRows = area.length;
		int numCols = area[0].length;
		String allLines = "";
		for(int i = 0; i < numRows; i++) {
			String s = "Row " + i + ":\t";
			for(int j = 0; j < numCols; j++) {
				Point2D curr = new Point2D(i, j);
				if(curr.equals(entry)) { //entry point, print "S" to indicate "start"
					s += "S";
				}else if(curr.equals(exit)) { //exit point, print "E" to indicate "end"
					s += "E";
				} else {
					if(area[i][j]) s += "0";
					else s+= "1";
				}
			}
			allLines = allLines + s + "\n";
		}
		return allLines + "\n";
	}
}
