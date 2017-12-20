package myStuff;

import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.components.*;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField nameField;
	private TextField typeField;
	private TextField hpField;
	private TextField descriptionField;
	private Button add;
	

	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		nameField = new TextField(40,40,200,30,"Monster Name","rawr");
		viewObjects.add(nameField);
		hpField = new TextField(40,80,200,30, "Base HP", "rawr");
		viewObjects.add(hpField);
		descriptionField = new TextField(40, 120, 200, 30, "Description", "rawr");
		add = new Button(30,30, 20, 10, "Add", new Action(){
			@Override
			public void act() {
				descriptionField.setText("Name");
			}
		});
	}
	
	

}
