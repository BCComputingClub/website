/**
 * This solution is MOSTLY right.
 * It does not take into account if two values are hit 
 * 	during the same 'hour'
 * I am honestly stumped on how to do that with this 
 * 	algorithm. 
 */


import java.util.*;
import java.awt.*;

public class Flooded_Maze {

	static char[][] maze = new char[100][100];
	static ArrayList<Point> pointList = new ArrayList<Point>();
	static ArrayList<Integer> tempAnswerList = new ArrayList<Integer>();
	static ArrayList<Character> answerList = new ArrayList<Character>();
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int x = 0;
		
		while(in.hasNext())
		{
			String line = in.nextLine();
			char[] charArray = line.toCharArray();
			
			/**
			 * Take in each line one at a time and place them in the maze.
			 * each line is it's own [x] and each value it's own [y], 
			 * creating a rectangular two-dimensional array that looks
			 * exactly like the input
			 */
			for(int i = 0; i < charArray.length; i++)
			{
				if(charArray[i] == 'S')
				{
					pointList.add(new Point(x,i));
				}
				maze[x][i] = charArray[i];
				//System.out.print(maze[x][i]);
			}

			/**
			 * check if the last line (donated by a line of all '#')
			 * has been parsed. if it has, break the input loop
			 */
			char[] charArray2 = new char[charArray.length];
			for(int i = 0; i < charArray2.length; i++)
			{
				charArray2[i] = '#';
			}
			
			/**
			 * We have to check the 'x' value here, or else 
			 * it will break on the first line
			 */
			if(Arrays.equals(charArray, charArray2) && x > 0)
			{
				break;
			}

			x++;	
		}
		start();
		
		/**
		 * Output all the values in the answer list
		 */
		for(char answer : answerList)
		{
			System.out.print(answer + " ");
		}
	}
	
	static private void start()
	{
		/**
		 * use an iterator to traverse the list. Iterators allow
		 * values to be changed, removed, and added to any point 
		 * in the list, while traversing it
		 */
		ListIterator<Point> iter = pointList.listIterator();
		while(iter.hasNext())
		{
			
			Point point = iter.next();
			iter.remove();
			
			/**
			 * flood each of the surrounding points
			 * 
			 * The initial 'S' point does not need
			 * to be flooded, and the starting point
			 * is already flooded from the last traversal,
			 * so it can be removed from the list and 
			 * forgotten.
			 */

			flood(new Point(point.x+1, point.y));
			
			flood(new Point(point.x, point.y+1));
			
			flood(new Point(point.x-1, point.y));
		
			flood(new Point(point.x, point.y-1));
			
			/**
			 * re-initialize the iterator. This ensures any new values
			 * that have been added to the list are recognized by the 
			 * iterator
			 */
			iter = pointList.listIterator();
			
		}
	}
	static private void flood(Point point)
	{
		/**
		 * If the current square is a digit, save it
		 */
		if(Character.isDigit(maze[point.x][point.y]))
		{
			answerList.add(maze[point.x][point.y]);
		}
		
		/**
		 * if the current square is a wall or is already
		 * 	flooded, skip it.
		 * Else, flood the square and add it to the list
		 * 	to be traversed
		 */
		if(maze[point.x][point.y] == '#' || maze[point.x][point.y] == 'F' || maze[point.x][point.y] == 'S')
		{
			return;
		}
		
		else
		{
			maze[point.x][point.y] = 'F';
		}
		
		pointList.add(point);
		
	}

}
