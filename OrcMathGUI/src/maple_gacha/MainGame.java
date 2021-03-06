package maple_gacha;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {

	private static final long serialVersionUID = 6853186922252287821L;
	
	public static MainGame game;
	public static Money money;
	public static BattleScreen battle;
	public static MainScreen main;	 
	public static LoadingScreen load;
	public static EthanSummonScreen summon;
//	public static FeaturedChar featured;
	public static int width;
	public static int height;
	public static UnitSelectionScreen unitsel;
	public static ArrayList<JohnsonHero> team;
	public static ArrayList<Monster> boss;
	public static ArrayList<JohnsonHero> currentTeam;
	public static CharacterScreen cScreen;
	public static BeginnerSelectionScreen bScreen;
	public static Monster[] mobs;
	public static JohnsonHero beginnerArcher;

	public static JohnsonHero beginnerSword;
	public static JohnsonHero beginnerWizard;
	public static JohnsonHero bCoolGuys;
	public static JohnsonHero bFanWoman;

	public static DavidGetCharacterSingle single;
	public static DavidGetCharacterMulti multi;
	private static Clip g;

	public static JohnsonHero mediumWizard;
	public static JohnsonHero mediumAxe;
	public static JohnsonHero mediumWitch;
	public static JohnsonHero mediumWolfGirl;
	public static JohnsonHero mediumCannonMan;
	public static JohnsonHero mediumHighSchoolGirl;
	public static JohnsonHero highTank;
	public static JohnsonHero highPrincess;
	public static JohnsonHero highAssassin;
	public static JohnsonHero highSirandHorse;

	private static Monster minionBlowfish;
	private static Monster minionDemon;
	private static Monster minionDevil;
	private static Monster minionInvidia;
	private static Monster minionYeti;
	private static Monster minionPsy;
	private static Monster minionDragon;
	private static Monster minionAlien;
	public static ArrayList<Monster> avaliableMonster;
	

	
	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	} 

	public void initScreen() {
		//NOTE ADD MAIN SCREEN LATER GUYS				
		createCharacters();
		createMobChar();
		createMobs();
		team = new ArrayList<JohnsonHero>();
		currentTeam = new ArrayList<JohnsonHero>();
		currentTeam.add(highTank);
		currentTeam.add(highAssassin);
		currentTeam.add(highSirandHorse);
		setLocationRelativeTo(null);
		bScreen = new BeginnerSelectionScreen(getWidth(), getHeight());		
		summon = new EthanSummonScreen(getWidth(),getHeight());
//		featured = new FeaturedChar(getWidth(),getHeight());
		unitsel = new UnitSelectionScreen(getWidth(), getHeight());
//		battle = new BattleScreen(getWidth(),getHeight());
		main = new MainScreen(getWidth(), getHeight());	
		cScreen = new CharacterScreen(getWidth(), getHeight());	
		load = new LoadingScreen(getWidth(), getHeight());		
//		JFrame frame = new JFrame();
//		frame.setSize(200, 200);
//		frame.setLocationRelativeTo(null);
//		JButton button = new JButton("Click me");
//		frame.add(button);
//		button.addActionListener(new AL());
//		frame.setVisible(true);
//			 


		load = new LoadingScreen(getWidth(), getHeight());
		//battle = new BattleScreen(getWidth(), getHeight());
		setScreen(load);
	}

	public static void main(String[] args) {
		game = new MainGame(1280, 1024);
		Thread runner = new Thread(game);
		runner.start();
		playMusic("resources/maplestory music.wav");
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
	
	public static void createMobs() {
		mobs = new Monster[100];
		for(int i = 0; i < mobs.length; i++) {
			System.out.println(avaliableMonster.get((int)(Math.random()*avaliableMonster.size())));
			addMonster(avaliableMonster.get((int)(Math.random()*avaliableMonster.size())),i);
		}
//		try {
//	          File soundFile = new File(musicPos);
//	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
//	          g = AudioSystem.getClip();
//	         g.open(audioIn);
//	         g.start();
//	      } catch (UnsupportedAudioFileException e) {
//	         e.printStackTrace();
//	      } catch (IOException e) {
//	         e.printStackTrace();
//	      } catch (LineUnavailableException e) {
//	         e.printStackTrace();
//	      }
	}


	public static void createCharacters() {
		beginnerArcher = new JohnsonHero("resources/characterPics/HeroBArcher.png", "B", 10, 10, 10, 10, 100, "Archer");
		beginnerSword = new JohnsonHero("resources/characterPics/HeroBSwordMan.png", "B", 10, 10, 10, 10, 100,"Swordsman");
		beginnerWizard = new JohnsonHero("resources/characterPics/HeroBWizard.png", "B", 10, 10, 10, 10, 100,"Wizard");

		bCoolGuys = new JohnsonHero("resources/characterPics/HeroBCoolGuy.png", "A", 20, 20, 20, 20, 150,"Cool Guy");
		bFanWoman = new JohnsonHero("resources/characterPics/HeroBFanWoman.png", "A", 20, 20, 20, 20, 150,"Fan Girl");
		mediumWizard = new JohnsonHero("resources/characterPics/HeroALilWizard.png", "A", 20, 20 ,20 ,20 , 150,"Wizard");
		mediumAxe = new JohnsonHero("resources/characterPics/HeroAAxeBoy.png", "A", 20, 20, 20, 20, 150, "Axeman");
		mediumWitch = new JohnsonHero("resources/characterPics/HeroAWitch.png", "A", 20, 20, 20, 20, 150, "Witch");
		mediumWolfGirl = new JohnsonHero("resources/characterPics/HeroAWolfandGirl.png", "A", 20, 20, 20, 20, 150, "Wolf Girl");
		
		mediumCannonMan = new JohnsonHero("resources/characterPics/HeroACannonMan.png", "S", 30, 30, 30, 30, 200, "Cannoneer");
		mediumHighSchoolGirl = new JohnsonHero("resources/characterPics/HeroAHighSchoolGirl.png","S",30, 30, 30, 30, 200,"High Girl");
		highTank = new JohnsonHero("resources/characterPics/HeroSTank.png", "S", 30, 30, 30, 30, 200,"The Tank");
		
		highPrincess = new JohnsonHero("resources/characterPics/HeroSPrincess.png", "SS", 40, 40, 40, 40, 250,"Hime Sama");
		highAssassin = new JohnsonHero("resources/characterPics/HeroSAssassin.png", "SS", 40, 40, 40, 40, 250,"Zed");
		highSirandHorse = new JohnsonHero("resources/characterPics/HeroSBraveSirandHorse.png", "SS", 40, 40, 40, 40, 250,"Hecarim with Jarvan");

//		System.out.println(beginnerSword.getImage());
//		System.out.println(beginnerArcher);
	}
	

	public void setBattle(BattleScreen battle) {
		this.battle = battle;
	}

	public static void createMobChar() {
		avaliableMonster = new  ArrayList<Monster>();
		minionDemon = new Monster("resources/characterPics/MinionDemonMors.png", "B", 10, 10, 10, 10, 20,"Demon");
		avaliableMonster.add(minionDemon);
		minionDevil = new Monster("resources/characterPics/MinionDevilMaz.png", "B", 10, 10, 10, 10, 20,"Devil");
		avaliableMonster.add(minionDevil);
		minionInvidia = new Monster("resources/characterPics/MinionInvidia.png", "B", 10, 10, 10, 10, 20,"Invidia");
		avaliableMonster.add(minionInvidia);
		minionYeti = new Monster("resources/characterPics/MinionInvidia.png", "B", 10, 10, 10, 10, 20,"Yeti");
		avaliableMonster.add(minionYeti);
		minionPsy = new Monster("resources/characterPics/MinionPSY.png", "B", 10, 10, 10, 10, 20,"Psy");
		avaliableMonster.add(minionPsy);
		minionDragon = new Monster("resources/characterPics/MinionStormDragon.png", "B", 10, 10, 10, 10, 20,"Dragon");
		avaliableMonster.add(minionDragon);
		minionAlien = new Monster("resources/characterPics/MinionWeirdAlien.png", "B", 10, 10, 10, 10, 20,"Alien");
		avaliableMonster.add(minionAlien);
		for(int i=1;i<avaliableMonster.size();i++) {
			System.out.println(avaliableMonster.get(i).getImage());
		}
	}

	public static void addHero(JohnsonHero hero) {
		JohnsonHero newHero = new JohnsonHero(hero.getImage(),hero.getRank(),hero.getStrength(),hero.getSpeed(),hero.getAttack(),hero.getDefense(),hero.getHP(),hero.getName());
		team.add(newHero);
	}
	
	public static void addMonster(Monster monster,int i) {
		Monster newMonster = new Monster(monster.getImage(),monster.getRank(),monster.getStrength(),monster.getSpeed(),monster.getAttack(),monster.getDefense(),monster.getHP(),monster.getName());
		mobs[i] = newMonster;
	}
}