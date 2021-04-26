package unittest.exercise1;

import static org.junit.jupiter.api.Assertions.*;

class AllowedorNotTest {

    @org.junit.jupiter.api.Test
    void isAllowed() {

        //Arrange
        AllowedorNot allow = new AllowedorNot();
        allow.isAllowed("Hans", 15);

        //Act

        //navnet er længere end 10, men 15 er ikke age % 2 = 0
        boolean first = allow.isAllowed("Hansemanden", 15);
        boolean expected1 = false;

        //Navnet er ikke længere end 10, men age % 2 = 0
        boolean second = allow.isAllowed("Hans-Peter", 20);
        boolean expected2 = false;

        //Navnet er længere end 10 og age % 2 = 0
        boolean third = allow.isAllowed("Hans-Peter Mogensen", 50);
        boolean expected3 = true;

        //Navnet har samme længde som age
        boolean fourth = allow.isAllowed("hans", 4);
        boolean expected4 = true;

        //Navnet starter med n, men slutter ikke med n
        boolean fifth = allow.isAllowed("Niels", 33);
        boolean expected5 = false;

        //Navnet starter med n og slutter med n
        boolean sixth = allow.isAllowed("noninon", 20);
        boolean expected6 = true;

        //Assert
        assertEquals(expected1, first);
        assertEquals(expected2, second);
        assertEquals(expected3, third);
        assertEquals(expected4, fourth);
        assertEquals(expected5, fifth);
        assertEquals(expected6, sixth);
    }
}