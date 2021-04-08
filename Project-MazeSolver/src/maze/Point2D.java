package maze;

public class Point2D {
	/**
	 * The four possible directions to move in a maze.
	 * Provided as an enumeration to prevent invalid access.
	 */
	enum Direction {
		ABOVE, RIGHT, BELOW, LEFT
	}
	
	/**
	 * x-coordinate of a point in the maze.
	 */
	private int x;
	/**
	 * y-coordinate of a point in the maze.
	 */
	private int y;
	/**
	 * Every point in the maze has 4 neighbors, reached by moving
	 * above, right, below or left. This boolean array indicates
	 * whether a neighbor has been visited before.
	 */
	private boolean[] isNeighborVisited;
	
	/**
	 * Constructor for points in a 2D maze. Initially all 4 neighbors
	 * of the point will be marked as "unvisited".
	 * @param x x-coordinate
	 * @param y y-coordinate
	 */
	public Point2D(int y, int x) {
		this.y = y;
		this.x = x;
		this.isNeighborVisited = new boolean[4];
		for(int i = 0; i < 4; i++) {
			isNeighborVisited[i] = false;
		}
	}
	
	/**
	 * Getter for the x-coordinate.
	 * @return x-coordinate of the point.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Getter for the y-coordinate.
	 * @return y-coordinate of the point.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Marks the given neighbor as visited.
	 * @param dir Direction of the neighbor relative to this point.
	 */
	public void markNeighborVisited(Direction dir) {   //belirtilen komþu ziyaret edildi olarak iþaretler
		switch(dir) {
		case ABOVE:
			isNeighborVisited[0] = true; break;
		case RIGHT:
			isNeighborVisited[1] = true; break;
		case BELOW:
			isNeighborVisited[2] = true; break;
		case LEFT:
			isNeighborVisited[3] = true; break;
		}
	}
	
	/**
	 * Checks if the given neighbor is visited.
	 * @param dir Direction of the neighbor relative to this point.
	 * @return True is the neighbor has been visited, false otherwise.
	 */
	public boolean isNeighborVisited(Direction dir) {       //Belirtilen komþunun ziyaret edilip edilmediðini kontrol eder.
		switch(dir) {
		case ABOVE:
			return isNeighborVisited[0];
		case RIGHT:
			return isNeighborVisited[1];
		case BELOW:
			return isNeighborVisited[2];
		case LEFT:
			return isNeighborVisited[3];
		}
		return true;
	}
	
	/**
	 * Checks if the parameter object is equal to this point.
	 * If the parameter is a Point2D, this requires equality
	 * on the x- and y-coordinates.
	 */
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(o instanceof Point2D) {
			Point2D p = (Point2D) o;
			return this.x == p.x && this.y == p.y;
		}
		return false;
	}
	
	/**
	 * String representation of a point: "[y, x]".
	 */
	public String toString() {
		return "[" + y + "," + x + "]";
	}
}
