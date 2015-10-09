package demo;

import controller.MyController;
import model.MyModel;
import view.MyView;

public class TestMVC {

	public static void main(String[] args) {
		MyView myview=new MyView();
		MyModel mymodel=new MyModel();
		MyController mycontroller = new MyController();
		mymodel.setController(mycontroller);
		myview.setController(mycontroller);
		myview.startCLI();
	}

}
