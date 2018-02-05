package maple_gacha;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import java.awt.Font;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

//SCREEN FOR USER PICKS ONE OUT OF THREE BEGINNER CHARACTERS

public class BeginnerSelectionScreen extends FullFunctionScreen {

	private boolean selected;
	private ArrayList<ClickableGraphic> allBeg;
	
	public BeginnerSelectionScreen(int width, int height) {
		super(width, height);
		selected = false;
	}
 
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Color or = new Color(255, 230, 179);

		Graphic charBg = new Graphic(0, 0, getWidth(), getHeight(), "resources/screenPics/charSelectBG.png");
		charBg.setVisible(true);
		viewObjects.add(charBg);
		
		Button next = new Button(620, 780, 70, 70, "Next", or, null);
		Font myFont = new Font("DialogInput", Font.PLAIN, 20);
		next.setFont(myFont);
	
		next.setCurve(100, 100);
		
//		ClickableGraphic next = new ClickableGraphic(500, 780, 500 ,125, "resources/characterPics/playbutton.png");
		

		next.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				if(selected) {
					MainGame.cScreen.reloadScreen();
					MainGame.game.setScreen((MainGame.game.cScreen));					
				}
				
			}
			
		});
		//s
		
		TextLabel text = new TextLabel(320,200,1000,500, "Choose your hero!");
		text.setFont(myFont);
		text.setCustomTextColor(or);
	
		
		text.setSize(60);
		
		
		viewObjects.add(text);
		
		ClickableGraphic begArcher = new ClickableGraphic(200, 500, 200, 200, MainGame.game.beginnerArcher.getImage());
		ClickableGraphic begSword = new ClickableGraphic(600, 500, 200 ,200, MainGame.game.beginnerSword.getImage());
		ClickableGraphic begWizard = new ClickableGraphic(1000, 500, 200 ,200, MainGame.game.beginnerWizard.getImage());
		
		
		

		allBeg = new ArrayList<ClickableGraphic>();
		allBeg.add(begArcher);
		allBeg.add(begSword);
		allBeg.add(begWizard);
		
		
		viewObjects.add(begArcher);
		viewObjects.add(begSword);
		viewObjects.add(begWizard);

		System.out.println(MainGame.game.beginnerArcher);


		begArcher.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				begSword.setVisible(false);
				begWizard.setVisible(false);
				MainGame.addHero(MainGame.beginnerArcher);
				MainGame.addHero(MainGame.game.beginnerSword);
				MainGame.addHero(MainGame.beginnerArcher);
				MainGame.addHero(MainGame.game.beginnerSword);
				MainGame.addHero(MainGame.beginnerArcher);
				MainGame.addHero(MainGame.game.beginnerWizard);
				
				
				begArcher.setX(560);
				text.setText("You chose the archer!" );
			
				selected = true;

			}

		});
		
		begSword.setAction(new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				begArcher.setVisible(false);
				begWizard.setVisible(false);
				MainGame.addHero(MainGame.game.beginnerSword);
				text.setText("You chose the Sword!" );
				selected = true;

			}

		});
		
		begWizard.setAction(new Action() {
 
			@Override
			public void act() {
				// TODO Auto-generated method stub
				begArcher.setVisible(false);
				begSword.setVisible(false);
				MainGame.addHero(MainGame.game.beginnerWizard);
				text.setText("You chose the Wizard!" );
				selected = true;
				begWizard.setX(600);

			}
		});
		
		
		viewObjects.add(next);


	}
	

}