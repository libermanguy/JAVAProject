package controller;

import java.util.HashMap;

import algorithms.search.Solution;
import general.Position;
import model.Model;
import model.SearchableMaze;
import view.MyView;

public class MyController implements Controller{
Model model;
MyView view;
HashMap<String,Command> commands;

public MyController() {
	super();
	commands.put("dir", new dirCommand());
	commands.put("generate 3d maze", new generateCommand());
	commands.put("display", new displayMazeCommand());
	commands.put("display cross section", new displayCrossCommand());
	commands.put("save maze", new saveCommand());
	commands.put("load maze", new loadCommand());
	commands.put("maze size", new mazeSizeCommand());
	commands.put("file size", new fileSizeCommand());
	commands.put("solve", new solveCommand());
	commands.put("display solution", new dislpaySolutionCommand());
	commands.put("exit", new exitCommand());
}


@Override
public void PleaseTellView(String update) {
	System.out.println(update);
}
@Override
public void PleaseTellModel(String update) {
	// TODO Auto-generated method stub
	
}
@Override
public void AskViewToPresent(Object[] arg) {
	view.display(arg);
}

public class dirCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class generateCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class displayMazeCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class displayCrossCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class saveCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class loadCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class mazeSizeCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class fileSizeCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class solveCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class dislpaySolutionCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}

public class exitCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		// TODO Auto-generated method stub
		
	}
		
}


}
