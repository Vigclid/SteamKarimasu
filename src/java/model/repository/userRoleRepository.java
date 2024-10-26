package model.repository;

import model.Entity.User;

public interface userRoleRepository {
    void addUserRole(User user);

    int findRoleIdbyUserId (int userId);
}
