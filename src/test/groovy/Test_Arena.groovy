import spock.lang.Specification

class Test_Arena extends Specification {
    int width,height
    Bird bird;
    Matrix matrix;

    def setup() throws Exception {
        width = 50
        height = 30
        matrix = new Matrix(width,height, ' ' as Character)
        bird = new Bird(new Position(width/2 as int, height/2 as int), 'B' as Character, "#000000")
    }

    def "Test createMatrix"(){

    }

    def "Test addRandomElem"(){

    }

    def "Test canBirdMove"(){

    }

    def "Test moveBird"(){

    }

    def "Test detectCollision"(){

    }

    def "Test applyGravity"(){

    }

    def "Test matrixUpdate"(){

    }

    def "Test playerAlive"(){

    }






}