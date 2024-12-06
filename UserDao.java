package com.foodApp.DAO;



import java.util.List;

import com.foodApp.modules.User;

public interface UserDao {
       int addUser(User u);
       List getAllUser();
       User getUser(String email);
       int updateUser(User u);
       int deleteUser(String email);

}