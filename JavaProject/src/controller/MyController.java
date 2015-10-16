package controller;

import java.awt.Dialog.ModalExclusionType;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import general.Position;
import general.Solution;
import model.Model;
import model.MyModel;
import model.SearchableMaze;
import view.MyView;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class MyController.
 */
public class MyController implements Controller{

/** The model. */
Model model;

/** The view. */
View view;

/** The commands. */
HashMap<String,Command> commands;

/**
 * Instantiates a new my controller.
 *
 * @param view the view
 * @param model the model
 */
public MyController(MyView view, MyModel model) {
	super();
	this.model=model;
	this.view=view;
	model.setController(this);
	view.setController(this);
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
	view.setCLI(commands);
}

/* (non-Javadoc)
 * @see controller.Controller#getCommands()
 */
public HashMap<String, Command> getCommands()
{
return commands;
}

/* (non-Javadoc)
 * @see controller.Controller#PleaseTellView(java.lang.String)
 */
@Override
public void PleaseTellView(String update) {
	view.displayStr(update);
}

/* (non-Javadoc)
 * @see controller.Controller#PleaseTellModel(java.lang.String)
 */
@Override
public void PleaseTellModel(String update) {
	// TODO Auto-generated method stub
	
}

/* (non-Javadoc)
 * @see controller.Controller#AskViewToPresent(java.lang.Object[])
 */
@Override
public void AskViewToPresent(Object[] arg) {
	view.display(arg);
}

/**
 * The Class dirCommand.
 */
public class dirCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		if (args.length == 1)
		view.Dir(args[0]);	
		else
			view.displayStr("Wrong number of parameters");
	}
		
}

/**
 * The Class generateCommand.
 */
public class generateCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		if (args.length == 4)
		try
		{
		model.generate(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		}
		catch (Exception e)
		{
			view.displayStr("Error while generating the maze !");
		}
		else
			view.displayStr("Wrong number of parameters");
	}
		
}

/**
 * The Class displayMazeCommand.
 */
public class displayMazeCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		if (args.length == 1)
		{
			try
			{
			view.displayMaze(model.display(args[0]));		
			}
			catch (Exception e)
			{
				view.displayStr("Error while displaying the maze !");
			}
		}
		else
			view.displayStr("Wrong number of parameters");
	}
		
}

/**
 * The Class displayCrossCommand.
 */
public class displayCrossCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		if (args.length == 5)
		{
			try
			{
			view.displayCrossSection((int[][]) model.getCrossSection(args[4], args[1].charAt(0), Integer.parseInt(args[2])));
			}
			catch (Exception e)
			{
				view.displayStr("Error while displaying the cross section !");
			}
		}
		else 
			view.displayStr("Wrong Number of parameters");
		
	}
		
}

/**
 * The Class saveCommand.
 */
public class saveCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		if (args.length == 2)
		{
			try {
			model.save(args[0], args[1]);
		} catch (Exception e) {
			view.displayStr("Can not save to file !");
		}	
		}
		else 
			view.displayStr("Wrong Number of parameters");
	}
		
}

/**
 * The Class loadCommand.
 */
public class loadCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		if (args.length == 2)
		{
		try {
			model.load(args[1], args[0]);
		} catch (Exception e) {
			view.displayStr("Can not load the file !");
		}
		}
		else 
			view.displayStr("Wrong Number of parameters");
	}
		
}

/**
 * The Class mazeSizeCommand.
 */
public class mazeSizeCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		if (args.length == 1)
		{
		try
		{
		view.displayMazeSize(model.mazeSize(args[0]));
		}
		catch (Exception e)
		{
			view.displayStr("Error displaying maze size !");
		}
		}
		
		else
			view.displayStr("Wrong number of parameters");
	}	
}

/**
 * The Class fileSizeCommand.
 */
public class fileSizeCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		if (args.length==1)	
		{
			try
			{
			view.displayFileSize(model.fileSize(args[0]));
			}
			catch (Exception e)
			{
				view.displayStr("Error displaying saved file size !");
			}
		}
		else
			view.displayStr("Wrong number of parameters");
	}
		
}

/**
 * The Class solveCommand.
 */
public class solveCommand implements Command
{
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
	if (args.length == 2) 
		{
			try
			{
				model.solve(args[0], args[1]);
			}
			catch (Exception e)
			{
				view.displayStr("Failure while solving the maze");
			}
		}
	else
		view.displayStr("Wrong number of parameters");
	}
		
}

/**
 * The Class dislpaySolutionCommand.
 */
public class dislpaySolutionCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		if (args.length == 1)
		{
			try
			{
				view.displaySolution(model.displaySolution(args[0]));
			}
			catch (Exception e)
			{
				view.displayStr("Failure while displaying solution");
			}
		}
		else
			view.displayStr("Wrong number of parameters");
		
	}
		
}

/**
 * The Class exitCommand.
 */
public class exitCommand implements Command
{

	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String[])
	 */
	@Override
	public void doCommand(String args[]) {
		model.exit();
		view.displayStr("Program will now exit !");
		System.exit(0);
	}
		
}


}
