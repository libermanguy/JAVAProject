package demo;

import controller.MyController;
import model.MyModel;
import view.MyView;

public class TestMVC {

	public static void main(String[] args) {
		MyView myview=new MyView();
		MyModel mymodel=new MyModel();
		MyController mycontroller = new MyController(myview,mymodel);
		myview.startCLI();
	}

}

/*
***********test commands******************

generate 3d maze testmaze 10 10 10
save maze testmaze c:\temp\tm.maz
load maze c:\temp\tm.maz testmaze2

*/