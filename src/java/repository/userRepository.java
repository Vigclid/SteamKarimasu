package repository;

import model.Entity.user;
import controller.dto.userDTO;

import java.util.List;

public interface userRepository {
    void Register(userDTO user);
    List<user> getAllUsers() throws Exception;
    int findIdProductByName(String name) ;
    byte LoginCheck(String username, String password);
    user findUserbyName(String name);
    void increaseKcoin(float amount , int userId);

    int decreaseKcoin(float amount , int userId);

    public user getUserByRentListId(int listId);
}