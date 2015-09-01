package controller;

import model.Model;
import view.MyView;

public class MyController implements Controller{
Model model;
MyView view;
@Override
public void PleaseTellView(String update) {
	System.out.println(update);
}
@Override
public void PleaseTellModel(String update) {
	// TODO Auto-generated method stub
	
}
}
