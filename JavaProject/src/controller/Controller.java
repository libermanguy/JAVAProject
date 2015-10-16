package controller;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Interface Controller.
 */
public interface Controller {

/**
 * Gets the commands.
 *
 * @return the commands
 */
public HashMap<String, Command> getCommands();

/**
 * Please tell view.
 *
 * @param update the update
 */
public void PleaseTellView(String update);

/**
 * Please tell model.
 *
 * @param update the update
 */
public void PleaseTellModel(String update);

/**
 * Ask view to present.
 *
 * @param arg the arg
 */
public void AskViewToPresent(Object[] arg);
//public void AskModelToDo(String update);
}
