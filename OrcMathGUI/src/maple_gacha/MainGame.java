package maple_gacha;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {

	private static final long serialVersionUID = 6853186922252287821L;
	private static BattleScreen battle;

	public static Hero beginnerArcher;
	public static Hero beginnerSword;
	public static Hero beginnerWizard;

	public static MainGame game;

	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		// NOTE ADD MAIN SCREEN LATER GUYS
		// MainScreen main = new MainScreen(getWidth(), getHeight());
		// BattleScreen battle = new BattleScreen(getWidth(), getHeight());
		createCharacters();
		//BeginnerSelectionScreen bScreen = new BeginnerSelectionScreen(getWidth(), getHeight());
		//setScreen(bScreen);
		//setLocationRelativeTo(null);
		CharacterScreen cScreen = new CharacterScreen(getWidth(), getHeight());
		setScreen(cScreen);
	}

	public static void main(String[] args) {
		game = new MainGame(1280, 1024);
		Thread runner = new Thread(game);

		runner.start();
	}

	public static void createCharacters() {
		beginnerArcher = new Hero("resources/characterPics/Beginner_Archer_Character.png", "B", 10, 10, 10, 10, 100);
		beginnerSword = new Hero("resources/characterPics/Hero_BeginnerSword.png", "B", 10, 10, 10, 10, 100);
		beginnerWizard = new Hero("resources/characterPics/Hero_BeginnerWizard.png", "B", 10, 10, 10, 10, 100);
		System.out.println(beginnerSword.getImage());
		System.out.println(beginnerArcher);
	}

}
