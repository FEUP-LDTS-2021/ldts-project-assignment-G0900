import spock.lang.Specification

class Test_Element extends Specification {
    Element el1, el2

    def setup() throws Exception {
        Character ch1 = 'a'
        Character ch2 = 'b'
        el1 = new Element(4, 9, ch1, "#000000")
        el2 = new Element(8, 3, ch2, "#12FF9A")
    }

    def "Test gravityMoveDown"() {
        when:
        el1.gravityMoveDown()
        el2.gravityMoveDown()

        then:
        Position pos1 = new Position(4, 10)
        Position pos2 = new Position(8, 4)
        el1.getPosition() == pos1
        el2.getPosition() == pos2


    }
}