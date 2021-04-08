package maze;

import java.util.Stack;

import maze.Point2D.Direction;

public class Solver_Ordinal {
	/**
	 * Solves the maze using a stack as an auxiliary data structures. <br>
	 * The solution is obtained by visiting every neighbor of the current top and looking for a path that contains 
	 * this neighbor. Any point none of whose neighbors yield a solution is popped from the stack. <br>
	 * NOTE-1: One solution for the input file "MazeConf1.txt": [[5,0], [5,1], [4,1], [3,1], [3,2], [3,3], [2,3], [1,3], [1,4], [1,5], [1,6], [1,7], [1,8]].
	 * NOTE-2: Notice that there might exist multiple solutions for an input. Any correct answer will be accepted. 
	 * NOTE-3: Use only <code>push</code>, <code>pop</code>, <code>peek</code> and <code>isEmpty</code> on <code>history</code>.
	 * NOTE-4: You may edit ONLY Solver_Ordinal.solve. Do not edit the other classes/methods.
	 * @param maze Maze to be solved
	 * @return The path from the entry point to the exit point (exit on the top, entry at the bottom)
	 */
	public static Stack<Point2D> solve(Maze maze) {
		//history of points that mark our path from start to the current position
		Stack<Point2D> history = new Stack<>();
		
		
		
		history.push(maze.getEntry());
		while(!history.peek().equals(maze.getExit())) {
			
			
			//RIGHT         
	if(maze.isWall(new Point2D(history.peek().getY(),history.peek().getX()+1) )==false && history.peek().isNeighborVisited(Direction.RIGHT)==false)  {    
	     history.peek().markNeighborVisited(Direction.RIGHT); 	     
	     history.push(new Point2D(history.peek().getY(),history.peek().getX()+1));
	     history.peek().markNeighborVisited(Direction.LEFT);
	      }
	        //LEFT                                         }
	else if(maze.isWall(new Point2D(history.peek().getY(),history.peek().getX()-1) )==false && history.peek().isNeighborVisited(Direction.LEFT)==false)  {    
	     history.peek().markNeighborVisited(Direction.LEFT);  
	     
	     history.push(new Point2D(history.peek().getY(),history.peek().getX()-1));
	     history.peek().markNeighborVisited(Direction.RIGHT);
	      }	
	        //ABOVE
	else if(maze.isWall(new Point2D(history.peek().getY()-1,history.peek().getX()) )==false && history.peek().isNeighborVisited(Direction.ABOVE)==false)  {    
	     history.peek().markNeighborVisited(Direction.ABOVE);
	     
	     history.push(new Point2D(history.peek().getY()-1,history.peek().getX()));
	     history.peek().markNeighborVisited(Direction.BELOW);
	      }		
	         //BELOW
	else if(maze.isWall(new Point2D(history.peek().getY()+1,history.peek().getX()) )==false && history.peek().isNeighborVisited(Direction.BELOW)==false)  {    
	     history.peek().markNeighborVisited(Direction.BELOW);
	     
	     history.push(new Point2D(history.peek().getY()+1,history.peek().getX()));
	     history.peek().markNeighborVisited(Direction.ABOVE);
	      }		
	else {history.pop();  }	     
		                                                                                                       
		                                                                                                                      
		                                                                                                                                                                                                                
		                                                                                                                               
		} 
		
		
		
		
		//a path from start to end, therefore a solution
		return history;
	}
	
	

	public static void main(String[] args) throws Exception{
		//read the configuration file
		Maze maze = new Maze("mazeConf1.txt");
		//output the configuration version of the maze
		System.out.println(maze.toString());
		
		//solve the maze
		Stack<Point2D> solution = solve(maze);
		//output the solution
		System.out.println(solution + "\n");
		
		//output the maze such that every visited point of the solution
		//   is marked with an "X".
		String output = "";
		for(int i = 0; i < maze.getNumRows(); i++) {
			String line = "Row " + i + ":\t";
			for(int j = 0; j < maze.getNumCols(); j++) {
				Point2D curr = new Point2D(i, j);
				if(maze.isWall(curr)) {
					line = line + "1";
				} else if(solution.contains(curr)) {
					line = line + "X";
				} else {
					line = line + "0";
				}
			}
			output = output + line + "\n";
		}
		System.out.println(output);
	}
}
