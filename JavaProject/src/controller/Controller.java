package controller;

import java.util.HashMap;

public interface Controller {
public HashMap<String, Command> getCommands();
public void PleaseTellView(String update);
public void PleaseTellModel(String update);
public void AskViewToPresent(Object[] arg);
//public void AskModelToDo(String update);
}
