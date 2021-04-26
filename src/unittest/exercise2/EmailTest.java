package unittest.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void validEmail() {

        //Arrange
        Email email = new Email();

        //Act

        //Laver 3 valide emails og 1 ikke valid til sidst
        boolean first = email.validEmail("lalala@gmail.com");
        boolean expected = true;

        boolean second = email.validEmail("hahaha@live.dk");
        boolean expected2 = true;

        boolean third = email.validEmail("what@hotmail.com");
        boolean expected3 = true;

        boolean fourth = email.validEmail("noget@enaltforlangemail.com");
        boolean expected4 = false;

        //Assert
        assertEquals(expected, first);
        assertEquals(expected2, second);
        assertEquals(expected3, third);
        assertEquals(expected4, fourth);
    }
}