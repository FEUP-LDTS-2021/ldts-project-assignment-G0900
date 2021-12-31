import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Element {

    protected String color;
    protected Character character;
    protected boolean fixedPos = false;
    protected Position position = new Position(0, 0);

    public Element(int x, int y, Character character, String color) {
        this.position.setX(x);
        this.position.setY(y);
        this.character = character;
        this.color = color;
    }

    public void gravityMoveDown() {position.setY(position.getY()+1);}

    public Position getPosition() {return position;}
    public int getPositionX() {return position.getX();}
    public int getPositionY() {return position.getY();}
    public Character getChar(){return character;}
    public  boolean isFixedPos(){return fixedPos;}

    public  void setFixedPos(boolean newFixedPos) {this.fixedPos = newFixedPos;}
    public void setChar(Character newChar) {this.character = newChar;}

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(this.color));
        graphics.enableModifiers(SGR.BOLD);

        graphics.putString(new TerminalPosition(this.position.getX(), this.position.getY()), this.character.toString());
    }


}
