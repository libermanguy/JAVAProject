package view;

import general.Position;
import general.Solution;
import general.State;

public interface View {
	public void display(Object[] arg);
	public void Dir(String path);
	public void displayMaze(Object[] obj);
	public void displayCrossSection(Object[] array);
	public void displayMazeSize(int size);
	public void displayFileSize(int size);
	public void displaySolution(Solution<Position> solution);
	public void displayStr(String arg);
	
}
