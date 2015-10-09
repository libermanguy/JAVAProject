package view;

public interface View {
	public void display(Object[] arg);
	public void Dir(String path);
	public void displayMaze(Object[] obj);
	public void displayCrossSection(int[][] array);
	public void displayMazeSize(int size);
	public void displayFileSize(int size);
	public void displaySolution(String solution);
	
	
}
