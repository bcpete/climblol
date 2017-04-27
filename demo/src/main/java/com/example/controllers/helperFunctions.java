package com.example.controllers;

import java.sql.*;

/**
 * Created by Brady on 4/27/17.
 */
public class helperFunctions {
    public static boolean checkUserNameIsUsed(String username){

        boolean userNameInUse = false;

        try
        {
            //Class.forName("com.mysql.jbdc.Driver");
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
        //catch(ClassNotFoundException cE)
        //{
        //    System.out.println("Class Not Found Exception" + cE.toString());
        //}
        return userNameInUse;
    }
}
