package Converter;

import model.Entity.User;
import model.dto.userDTO;

public class userConverter {
    public User convertUserDTOtoUserEntity(userDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhonenumber());
//        user.setUserId(userDTO.getId());
        String dob =  userDTO.getYear() + "-" + userDTO.getMonth() + "-" + userDTO.getDay();
        user.setDob(dob);
        return user;
    }

    public userDTO convertUserEntityToUserDTO(User user) {
        userDTO userDTO = new userDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhonenumber(user.getPhoneNumber());
//        userDTO.setId(user.getUserId());
        userDTO.setDob(user.getDob());
        return userDTO;
    }
}
