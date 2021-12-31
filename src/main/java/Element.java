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

    public void gravityMoveDown() {}

    public Position getPosition() {return new Position(0,0);}
    public int getPositionX() {return 0;}
    public int getPositionY() {return 0;}

    public void setPosition(Position position) {}

    public  boolean isFixedPos(){return false;}
    public  void setFixedPos(boolean newBool){}

    public Character getChar() {return '_';}
    public void setChar(Character newChar) {}

    public void draw(TextGraphics graphics) {}
}
