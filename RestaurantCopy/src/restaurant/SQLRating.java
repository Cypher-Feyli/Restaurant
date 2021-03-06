/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static restaurant.DBConnection.conn;
import static restaurant.FirstFrame.username;

/**
 *
 * @author chatchai
 */
public class SQLRating extends SQLInsert {

    public static void addRating(int rating, String name) {
        try {
            System.out.println(name);
            Statement stm = conn.createStatement();
            stm.setQueryTimeout(30);
            ResultSet r = stm.executeQuery("select Restaurant_ID from Restaurant where RestName = \"" + name + "\"");
            int restID = 0;

            while (r.next()) {
                restID = r.getInt(1);
            }

            PreparedStatement p = conn.prepareStatement("INSERT INTO Star VALUES (?, ?)");
            p.setInt(1, restID);
            p.setInt(2, rating);

            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(null, "Thanks for rating!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getRating(String name) {
        int averageRating = 0;

        try {
            Statement stm = conn.createStatement();
            stm.setQueryTimeout(30);
            ResultSet r = stm.executeQuery("Select Star from Star "
                    + "INNER JOIN Restaurant USING (Restaurant_ID) "
                    + "WHERE RestName = \"" + name + "\"");
            
            // Make new array "allRating" with it size as rowcount
            int rowcount = 0;
            if (r.last()) {
                rowcount = r.getRow();
                r.beforeFirst();
            }
            int allRating[] = new int[rowcount];
            
            int i = 0;

            if (rowcount < 1) {
                averageRating = 0;
            } else {
                while (r.next()) {
                    allRating[i] = r.getInt(1);
                    i++;
                }
                
                for (int j = 0; j < allRating.length; j++) {
                    averageRating += allRating[j];
                }
                averageRating = averageRating / allRating.length;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return averageRating;
    }
}
