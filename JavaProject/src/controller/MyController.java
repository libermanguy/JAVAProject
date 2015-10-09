package controller;

import java.awt.Dialog.ModalExclusionType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import general.Position;
import general.Solution;
import model.Model;
import model.SearchableMaze;
import view.MyView;

public class MyController implements Controller{
Model model;
MyView view;
HashMap<String,Command> commands;

public MyController() {
	super();
	commands = new HashMap<String,Command>();
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

public HashMap<String, Command> getCommands()
{
return commands;
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
		view.Dir(args[0]);		
	}
		
}

public class generateCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		model.generate(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
	}
		
}

public class displayMazeCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		view.displayMaze(model.display(args[0]));		
	}
		
}

public class displayCrossCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		view.displayCrossSection((int[][]) model.getCrossSection(args[2], args[0].charAt(0), Integer.parseInt(args[1])));
		
	}
		
}

public class saveCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		try {
			model.save(args[0], args[1]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
		
}

public class loadCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		try {
			model.load(args[1], args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}

public class mazeSizeCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		view.displayMazeSize(model.mazeSize(args[0]));
	}
		
}

public class fileSizeCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		view.displayFileSize(model.fileSize(args[0]));
		
	}
		
}

public class solveCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		model.solve(args[0], args[1]);
	}
		
}

public class dislpaySolutionCommand implements Command
{

	@Override
	public void doCommand(String args[]) {
		view.displaySolution(model.displaySolution(args[0]));
		
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
