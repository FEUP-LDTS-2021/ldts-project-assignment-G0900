import spock.lang.Specification

class Test_Matrix extends Specification {
    Element el1, el2
    int width, height
    Matrix matrix

    def setup() throws Exception {

        Character ch1 = 'a'
        Character ch2 = 'b'

        el1 = new Element(4, 9, ch1, "#000000")
        el2 = new Element(8, 3, ch2, "#12FF9A")

        width = 3
        height = 4
        Matrix matrix = new Matrix(width, height)

    }

    def "Test set/get Pos"() {
        when:
        matrix.setPos(el1)

        then:
        Element elem = matrix.getPos(4, 9)
        elem.getPosition() == el1.getPosition()
        elem.getChar() == el1.getChar()

    }

    def "Test getDimensions"() {
        when:
        int height_ = matrix.getHeight()
        int width_ = matrix.getWidth()

        then:
        height_ == height
        width_ == width

    }

    def "Test getMatrix"() {
        when:
        def tempM = matrix.getMatrix()

        then:
        tempM.size() == height
        tempM.get(0).size() == width

    }


}