package common;

import model.Entity.user;

import repository.impl.RoleRepositoryImpl;
import repository.impl.UserRoleRepositoryImpl;
import repository.impl.userRepositoryimpl;


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class LoginSession {
    public user getLoginSession(HttpServletRequest request) {
        userRepositoryimpl repositoryImpl = new userRepositoryimpl();
        HttpSession session = request.getSession(false);
        if (session!= null && session.getAttribute("username")!= null) {
            Object userName = session.getAttribute("username");
            return repositoryImpl.findUserbyName((String) userName);
        }
        return null;
    }

    public String getRoleNameUser(HttpServletRequest request) {
        userRepositoryimpl repositoryImpl = new userRepositoryimpl();
        HttpSession session = request.getSession(false);
        if (session!= null && session.getAttribute("username")!= null) {
            Object userName = session.getAttribute("username");
            user user = repositoryImpl.findUserbyName((String) userName);
            int userRole = new UserRoleRepositoryImpl().findRoleIdbyUserId(user.getUserId());
            String roleName = new RoleRepositoryImpl().findRoleById(userRole);
            return roleName;
        }
        return null;
    }
}