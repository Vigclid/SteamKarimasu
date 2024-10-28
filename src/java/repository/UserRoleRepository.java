package repository;
import model.Entity.user;

public interface UserRoleRepository  {
    void addUserRole(user user);

    int findRoleIdbyUserId (int userId);
}
