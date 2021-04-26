package unittest.exercise3;

import org.junit.jupiter.api.Test;
import unittest.mini_projekt.services.WishService;

import static org.junit.jupiter.api.Assertions.*;

class WishServiceTest {

    @Test
    void calculateNextIdWish() {

        //Arrange
        WishService wishService = new WishService();

        //Act
        int calculatenextId = wishService.calculateNextIdWish(1);
        int expected = -1;

        //Assert
        assertEquals(expected, calculatenextId);
    }
}