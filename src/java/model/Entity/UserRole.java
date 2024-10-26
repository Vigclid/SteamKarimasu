package model.Entity;

public class UserRole {
    private int userRoleId;
    private int userId;
    private int roleId;

    // Constructor không tham số
    public UserRole() {}

    // Constructor có tham số
    public UserRole(int userRoleId, int userId, int roleId) {
        this.userRoleId = userRoleId;
        this.userId = userId;
        this.roleId = roleId;
    }

    // Getter và Setter
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public int setRoleId(int roleId) {
        this.roleId = roleId;
        return roleId;
    }

    // Phương thức để hiển thị thông tin đối tượng UserRole
    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}
