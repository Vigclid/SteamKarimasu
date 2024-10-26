package model.repository;

import model.Entity.User;
import controller.dto.userDTO;

import java.util.List;

public interface userRepository {
    void Register(userDTO user);
    List<User> getAllUsers() throws Exception;
    int findIdProductByName(String name) ;
    byte LoginCheck(String username, String password);
}
