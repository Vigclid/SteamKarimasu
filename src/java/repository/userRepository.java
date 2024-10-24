package repository;

import model.Entity.user;
import controller.dto.userDTO;

import java.util.List;

public interface userRepository {
    void Register(userDTO user);
    List<user> getAllUsers() throws Exception;
    void addUserRole(user user);
}