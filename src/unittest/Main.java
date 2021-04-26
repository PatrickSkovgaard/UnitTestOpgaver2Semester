package unittest;

import unittest.exercise2.Email;
import unittest.mini_projekt.services.WishService;

public class Main {

    public static void main(String[] args) {

        WishService wish = new WishService();

        System.out.println(wish.calculateNextIdWish(1));
    }
}
