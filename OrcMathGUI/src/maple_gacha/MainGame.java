package maple_gacha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;

import guiTeacher.GUIApplication;
import maple_gacha.TestMusic.AL;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class MainGame extends GUIApplication {

	private static final long serialVersionUID = 6853186922252287821L;
	
	public static MainGame game;
	public static BattleScreen battle;
	public static MainScreen main;	
	public static LoadingScreen load;
	public static EthanSummonScreen summon;
//	public static FeaturedChar featured;
	public static int width;
	public static int height;
	public static UnitSelectionScreen unitsel;
	public static ArrayList<Hero> team;
	public static ArrayList<Hero> currentTeam;
	public static Hero beginnerArcher;
	public static Hero beginnerSword;
	public static Hero beginnerWizard;
	public static Hero temp;
	public static Hero temp1;
	public static Hero temp2;
	public static CharacterScreen cScreen;
	public static BeginnerSelectionScreen bScreen;
	public static DavidGetCharacterSingle single;
	public static DavidGetCharacterMulti multi;
	private static Clip g;

	
	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	} 

	public void initScreen() {
		//NOTE ADD MAIN SCREEN LATER GUYS				
		createCharacters();		
		team = new ArrayList<Hero>();
		currentTeam = new ArrayList<Hero>();
		setLocationRelativeTo(null);
		bScreen = new BeginnerSelectionScreen(getWidth(), getHeight());		
		summon = new EthanSummonScreen(getWidth(),getHeight());
//		featured = new FeaturedChar(getWidth(),getHeight());
		unitsel = new UnitSelectionScreen(getWidth(), getHeight());
//		battle = new BattleScreen(getWidth(), getHeight());				
		main = new MainScreen(getWidth(), getHeight());	
		cScreen = new CharacterScreen(getWidth(), getHeight());	
		load = new LoadingScreen(getWidth(), getHeight());		
		setScreen(load);
	}
	
	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setSize(200, 200);
//		frame.setLocationRelativeTo(null);
//		JButton button = new JButton("Click me");
//		frame.add(button);
//		button.addActionListener(new AL());
//		frame.setVisible(true);
//		
		playMusic("resources/maplestory music.wav");
		
		game = new MainGame(1280, 1024);
		Thread runner = new Thread(game);
		runner.start();
	}

	public static void playMusic(String musicPos) {
		if (g!= null) {
			g.stop();
		}
		try {
	          File soundFile = new File(musicPos);
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
	          g = AudioSystem.getClip();
	         g.open(audioIn);
	         g.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}
	
	
	public static void createCharacters() {
		beginnerArcher = new Hero("resources/characterPics/Hero_BeginnerArcher.png", "B", 10, 10, 10, 10, 100);
		beginnerSword = new Hero("resources/characterPics/Hero_BeginnerSword.png", "B", 10, 10, 10, 10, 100);
		beginnerWizard = new Hero("resources/characterPics/Hero_BeginnerWizard.png", "B", 10, 10, 10, 10, 100);
		
		 temp = new Hero("resources/characterPics/Hero_BeginnerArcher.png", "B", 10, 10, 10, 10, 100);
		 temp1 = new Hero("resources/characterPics/Hero_BeginnerSword.png", "B", 10, 10, 10, 10, 100);
		 temp2 = new Hero("resources/characterPics/Hero_BeginnerWizard.png", "B", 10, 10, 10, 10, 100);
		System.out.println(beginnerSword.getImage());
		System.out.println(beginnerArcher);
	}
	
	
	public static void addHero(Hero hero) {
		Hero newHero = new Hero(hero.getImage(),hero.getRank(),hero.getStrength(),hero.getSpeed(),hero.getAttack(),hero.getDefense(),hero.getHP());
		team.add(newHero);
	}
}