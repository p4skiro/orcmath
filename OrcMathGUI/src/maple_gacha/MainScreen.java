package maple_gacha;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.GUIApplication;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.HolidayCard;

public class MainScreen extends FullFunctionScreen {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AnimatedComponent featured;
	private Button dungeon;
	private Button summonb;
	private Button inventory;
	private Button quit;
	private TextArea name;
	private Button temp1;
	private Button temp3;
	private Button temp5;

	public MainScreen(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {		
		if(Math.random() > .5) {
			viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/home.jpg"));
		}else {
			viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/home2.png"));
		}	
		featured = new AnimatedComponent((getWidth()/2)-325,510,650,350);
		featured.addSequence("resources/banners.png", 5000,0,0,650,350,3);	
		viewObjects.add(featured);
		Thread banner = new Thread(featured);
		banner.start();
		dungeon = new Button((getWidth()/4)-50,875,200,100,"Dungeons",Color.yellow,new Action() {
			public void act() {
//				MainGame.game.setScreen(MainGame.summon);
			}
			
		});
		summonb = new Button(getWidth()/2-100,875,200,100,"Summon",Color.yellow,new Action() {
			public void act() {
				MainGame.game.setScreen(MainGame.summon);
			}
			
		});
		inventory = new Button(((getWidth()/4)*3)-150,875,200,100,"Units",Color.yellow,new Action() {
			public void act() {
				MainGame.game.setScreen(MainGame.cScreen);
			}
			
		});
		quit = new Button(getWidth()-175,getHeight()-100,150,75,"QUIT",Color.red,new Action() {
			public void act() {
				System.exit(1);
			}
		});
		name = new TextArea(480,10,600,200,"GachaStory");		
		viewObjects.add(new Graphic((getWidth()/2)-113,155,226,339,"resources/border1.png"));
//		viewObjects.add(new Graphic((getWidth()/2)-113,155,226,339,"resources/border1.png"));
//		viewObjects.add(new Graphic((getWidth()/2)-113,155,226,339,"resources/border1.png"));
		temp1 = new Button((getWidth()/2)-339,175,206,319,"",Color.black, new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});
//		temp3 = new Button((getWidth()/2)-103,175,206,319,"",Color.black,new Action() {
//
//			@Override
//			public void act() {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
		temp5 = new Button((getWidth()/2)+133,175,206,319,"",Color.black,new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
			
		});
		try {		
			File fontFile = new File("resources//Bobbleboddy.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(16f);
			quit.setFont(baseFont);
			quit.setSize(24);
			dungeon.setFont(baseFont);
			dungeon.setSize(36);
			summonb.setFont(baseFont);
			summonb.setSize(36);
			inventory.setFont(baseFont);
			inventory.setSize(36);	
			File fontFile2 = new File("resources//deloise.ttf");
			Font font2 = Font.createFont(Font.TRUETYPE_FONT, fontFile2);
			Font baseFont2=font2.deriveFont(16f);
			name.setFont(baseFont2);
			name.setSize(100);
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}
		viewObjects.add(new Graphic(795, 30, 75,75,"resources/mapleleaf.png"));		
		viewObjects.add(name);
		viewObjects.add(temp1);
//		viewObjects.add(temp3);
		viewObjects.add(temp5);
		viewObjects.add(dungeon);
		viewObjects.add(summonb);
		viewObjects.add(inventory);
		viewObjects.add(quit);
	}
}
