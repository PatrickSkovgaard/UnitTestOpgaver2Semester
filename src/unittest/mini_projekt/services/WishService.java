package unittest.mini_projekt.services;



import unittest.mini_projekt.models.Wish;
import unittest.mini_projekt.models.Wishlist;
import unittest.mini_projekt.repositories.WishlistRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WishService {

    private WishlistRepo repo = new WishlistRepo();
    private ResultSet repoResultSet;

    private Wishlist wishList;
    private ArrayList<Wish> wishes;

    private Map<Integer, Wishlist> map = new HashMap<>();

    private boolean nextReservedStatus;

    public int calculateNextIdWish(int extraToAdd) {

        repo = new WishlistRepo();

        try {
            repo.executeQuerySelectAll();
            repoResultSet = repo.getResultSet();

            while (repoResultSet.next()) {
                if (repoResultSet.isLast()) {
                    return repoResultSet.getInt(4)+1+extraToAdd;
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public void changeReservedStatus(int idWishlist, int idWish, boolean alreadyReserved) {
        collectFromDatabase(idWishlist,alreadyReserved);

        for (int i = 0; i < wishes.size();i++) {
            if (wishes.get(i).getIdWish() == idWish) {
                try {
                    updateColumn(idWish);
                }
                catch(SQLException e){
                    System.out.println("\nSomething went wrong...\n" + e.getMessage());
                }
            }
        }
    }

    private void collectFromDatabase(int idWishlist, boolean alreadyReserved) {
        repo.getAllWishlists();
        map = repo.getMap();

        wishList = map.get(idWishlist);
        wishes = wishList.getListOfWishes();

        if (alreadyReserved) {
            nextReservedStatus = false;
        }
        else {
            nextReservedStatus = true;
        }
    }

    private void updateColumn(int idWish) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql5.gear.host:3306/dat20cpatrick",
                "dat20cpatrick", "Lt70_OF4?8h9");
        PreparedStatement statement = connection.prepareStatement("UPDATE wish SET isReserved = " + nextReservedStatus +
                " WHERE id_wish = " + idWish + ";");
        statement.executeUpdate();
    }
}
