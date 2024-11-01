package common;

import model.Entity.User;
import model.repository.impl.roleRepositoryImpl;
import model.repository.impl.userRepositoryimpl;
import model.repository.impl.userRoleRepositoryImpl;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class LoginSession {
    public User getLoginSession(HttpServletRequest request) {
        userRepositoryimpl repositoryImpl = new userRepositoryimpl();
        HttpSession session = request.getSession(false);
        if (session!= null && session.getAttribute("username")!= null) {
            Object userName = session.getAttribute("username");
            User user = repositoryImpl.findUserbyName((String) userName);
            return user;
        }
        return null;
    }

    public String getRoleNameUser(HttpServletRequest request) {
        userRepositoryimpl repositoryImpl = new userRepositoryimpl();
        HttpSession session = request.getSession(false);
        if (session!= null && session.getAttribute("username")!= null) {
            Object userName = session.getAttribute("username");
            User user = repositoryImpl.findUserbyName((String) userName);
            int userRole = new userRoleRepositoryImpl().findRoleIdbyUserId(user.getUserid());
            String roleName = new roleRepositoryImpl().findRoleById(userRole);
            return roleName;
        }
        return null;
    }
}
