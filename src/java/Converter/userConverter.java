package Converter;

import model.Entity.user;
import controller.dto.userDTO;

public class userConverter {
    public user convertUserDTOtoUserEntity(userDTO userDTO) {
        user user = new user();
        user.setUserId(userDTO.getId()); // assuming id is passed as a parameter in userDTO
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhonenumber());
        String dob =  userDTO.getYear() + "-" + userDTO.getMonth() + "-" + userDTO.getDay();
        user.setDob(dob);
        byte active= 1;
        user.setActive(active);
        return user;
    }

    public userDTO convertUserEntityToUserDTO(user user) {
        userDTO userDTO = new userDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhonenumber(user.getPhoneNumber());
        userDTO.setDob(user.getDob());

        return userDTO;
    }
}