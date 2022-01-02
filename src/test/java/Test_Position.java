import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_Position {
    Position position = new Position(2,4);
    Position position2 = new Position(4,5);

    @Test
    public void Test_Get_Positions(){
        Assertions.assertEquals(2, position.getX());
        Assertions.assertEquals(4, position.getY());
    }

    @Test
    public void Test_Equal_Positions(){

        Assertions.assertNotEquals(position, position2);
        position2.set(new Position(2,4));
        Assertions.assertEquals(position, position2);
    }

}
