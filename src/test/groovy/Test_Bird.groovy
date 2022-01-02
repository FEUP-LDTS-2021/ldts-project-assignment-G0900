import spock.lang.Specification

class Test_Bird extends Specification {
    Bird bird
    int x0, y0

    def setup() throws Exception {
        x0 = 7
        y0 = 10
        bird = new  Bird(x0,y0, 'X' as Character,"#00FF00")
    }

    def "Test takeDamage"() {
        given:
            int hp = bird.getHp()
            bird.setHp(20)
        when:
            bird.takeDamage()
        then:
            hp == bird.getHp()-1
    }

    def "Test get/set Hp"() {
        given:
        int hp = 10
        when:
        bird.setHp(hp)
        then:
        hp == bird.getHp()
    }

    def "Test addHp"() {
        given:
        int initialHp = bird.getHp()
        int deltaHp = 4
        when:
        bird.addHp(deltaHp)
        then:
        bird.getHp() == initialHp+deltaHp
    }

    def "Test isAlive"(){
        given:
        bird.setHp(5)
        int hp = bird.getHp()
        when:
        boolean alive = bird.isAlive()
        then:

        if(!alive)
            hp>0
        else
            hp==0


    }

    def "Test pickCoin"(){
        given:
        int numCoins = 3
        int coinCount = bird.getCoinCount()
        when:
        bird.pickCoin(numCoins)
        then:
        bird.getCoinCount() == coinCount + numCoins
    }

    def "Test moveUp"(){
        given:
        Position pos = bird.getPosition()
        int delta = 2
        when:
        bird.moveUp(delta)
        then:
        bird.getPositionX() == pos.getY() - delta
    }

    def "Test moveDown"(){
        given:
        Position pos = bird.getPosition()
        int delta = 2
        when:
        bird.moveDown(delta)
        then:
        bird.getPositionX() == pos.getY() + delta
    }

    def "Test moveLeft"(){
        given:
        Position pos = bird.getPosition()
        int delta = 2
        when:
        bird.moveLeft(delta)
        then:
        bird.getPositionX() == pos.getX() - delta
    }

    def "Test moveRight"(){
        given:
        Position pos = bird.getPosition()
        int delta = 2
        when:
        bird.moveRight(delta)
        then:
        bird.getPositionX() == pos.getX() + delta
    }

}