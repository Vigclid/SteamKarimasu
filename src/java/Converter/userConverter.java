package Converter;

import model.Entity.Role;
import model.Entity.User;
import controller.dto.userDTO;

import static java.lang.Float.parseFloat;

public class userConverter {
    public User convertUserDTOtoUserEntityToRegister(userDTO userDTO) {
        User user = new User();
        user.setUserid(userDTO.getId()); // assuming id is passed as a parameter in userDTO
        user.setUsername(userDTO.getUsername());
        user.setPass(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhonenumber(userDTO.getPhonenumber());
        String dob =  userDTO.getYear() + "-" + userDTO.getMonth() + "-" + userDTO.getDay();
        user.setDob(dob);
        byte active= 1;
        user.setActive(active);
        return user;
    }

    public userDTO convertUserEntityToUserDTO(User user) {
        userDTO userDTO = new userDTO();
        Role role = new Role();
        userDTO.setId(user.getUserid());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPass());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhonenumber(user.getPhonenumber());
        userDTO.setDob(user.getDob());
        userDTO.setTotalAmount(Float.toString(user.getTotalAmount()));
        return userDTO;
    }


}
