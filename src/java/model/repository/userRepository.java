package model.repository;

import model.Entity.User;
import controller.dto.userDTO;

import java.util.List;

public interface userRepository {
    void Register(userDTO user);
    List<User> getAllUsers() throws Exception;
    byte LoginCheck(String username, String password);
    User findUserbyName(String name);
    User findUserByEmail(String email);
}
