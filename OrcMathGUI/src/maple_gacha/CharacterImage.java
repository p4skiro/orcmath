package maple_gacha;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.Action;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Clickable;

public class CharacterImage extends Component implements Clickable {
	
	private Graphic image;
	private HpBar bar;
	private boolean selected;
	private Action action;
	private JohnsonHero hero;
	public static Graphic checkMark = new Graphic(0, 0, 30, 30, "resources/yellowarrow.png");

	
	public CharacterImage(int x, int y, String imgLocation, JohnsonHero a) {
		super(x, y, 100, 150);
		System.out.println(imgLocation+"wr");
		image = new Graphic(0,30,100,100,imgLocation);
		bar = new HpBar(10,130);
		bar.setMax(a.returnMaxHp());
		bar.setHp(a.getHP());
		bar.update();
		checkMark.update();
		this.hero = a;
		update();
	}
	
	public void hideImage() {
		setVisible(false);
		update();
	}
	public void setHero(JohnsonHero hero) {
		this.hero = hero;
	}
	@Override
	public void update(Graphics2D g) {
		g.drawImage(image.getImage(), image.getX(), image.getY(), null);
		g.drawImage(bar.getImage(), bar.getX(), bar.getY(), null);
		drawCheckMark(g);
		
	}

	public void drawCheckMark(Graphics2D g) {
		if(selected) {
			g.drawImage(checkMark.getImage(), checkMark.getX()+30, checkMark.getY(), null);
		}
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
	}
 
	@Override 
	public void act() {
		// TODO Auto-generated method stub
		if(action != null) {
			action.act();
		}
		
	}

	@Override
	public void setAction(Action a) {
		this.action = a;
		
	}
	
	public void setSelected(boolean b) {
		selected = b;
		if (b) System.out.println(this+" was selected");
		clear();
		update();
	}
	
	public void setHp() {
		bar.setHp(hero.getHP());
		update();
	}
	
	public int getHp() {
		return bar.getHp();
	}
}
