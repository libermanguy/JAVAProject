package controller;

/**
* <h1>The interface Command</h1>
* The command interface as part of Commands design pattern
*
* @author  Omri Polnikviat
* @version 1.0
* @since   2015-08-29 
*/

public interface Command {
	
	/**
	 * Do command.
	 */
	public void doCommand(String args[]);

}
