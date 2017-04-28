package com.example.controllers;

import java.sql.*;

/**
 * Created by Brady on 4/27/17.
 */
public class HelperFunctions {

    //Checks if username is already in the database, returns true if in use, false if not.
    public static boolean checkUserNameIsUsed(String username){

        boolean userNameInUse = false;

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/climblol", "climblol", "sasuke12");

            PreparedStatement st = connection.prepareStatement("SELECT COUNT(*) AS total FROM user where username LIKE ?");
            st.setString(1, username);
            ResultSet r1 = st.executeQuery();
            if(r1.next()){
                int check = r1.getInt("total");
                if(check>0){
                    return true;
                }
            }else{
                userNameInUse = false;
            }
        }

        catch(SQLException e)
        {
            System.out.println("SQL Exception: " + e.toString());
        }
        return userNameInUse;
    }
}
