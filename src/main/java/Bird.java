public class Bird extends Element {

    private  int hp = 3;
    private final int coinCount = 0;

    public Bird(int x, int y, Character character, String color) {
        super(x, y, character, color);
    }

    public int takeDamage() {
        return 0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int newHp) {
        this.hp = newHp;
    }

    public void addHp(int num) {

    }

    public boolean isAlive() {
        return false;
    }

    public void pickCoin(int n) {

    }

    public int getCoinCount() {
        return 0;
    }

    public void setCoinCount(int numCoins) {

    }

    public Position moveUp(int delta) {
        return null;
    }

    public Position moveDown(int delta) {
        return null;
    }

    public Position moveLeft(int delta) {
        return null;
    }

    public Position moveRight(int delta) {
        return null;
    }



}