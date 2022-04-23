package com.example.theatre.service;

import com.example.theatre.entity.User;
import com.example.theatre.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
/*
 * @author Shicheng Fang
 *
 * Operations allowed for user's information.
 *
 * return value signals if the operation is successful
 */
public class UserService {
    private transient final UserRepository userRepository;
    private transient final EncryptionService encryptionService;

    public UserService(UserRepository userRepository, EncryptionService encryptionService) {
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
    }

    private boolean isUserExist(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public boolean insertUser(String username,
                              String password,
                              String email,
                              String phone,
                              String city,
                              String zip) {
        if (isUserExist(username)) {
            return false;
        }
        userRepository.save(new User(username, encryptionService.encode(password), email, phone, city, zip));
        return true;
    }

    public boolean isMatch(String username, String password) {
        if (!isUserExist(username)) {
            return false;
        }
        User user = userRepository.findByUsername(username);
        return encryptionService.isPasswordMatch(password, user.getPassword());
    }

    public boolean editUser(User user) {
        if (!isUserExist(user.getUsername())) {
            return false;
        }
        User editedUser = userRepository.findById(user.getU_id()).orElse(null);
        if (editedUser != null) {
            if (user.getZip().length() > 0) {
                editedUser.setZip(user.getZip());
            }
            if (user.getPhone().length() > 0) {
                editedUser.setPhone(user.getPhone());
            }
            if (user.getCity().length() > 0) {
                editedUser.setCity(user.getCity());
            }
            if (user.getEmail().length() > 0) {
                editedUser.setEmail(user.getEmail());
            }
            if (user.getPassword().length() > 0) {
                editedUser.setPassword(user.getPassword());
            }
            if (user.getUsername().length() > 0) {
                editedUser.setUsername(user.getUsername());
            }
            userRepository.save(editedUser);
        }
        return true;
    }

    public void removeUser(Long user_id) {
        userRepository.deleteById(user_id);
    }

    public boolean changePassword(String username, String newPassword) {
        if (!isUserExist(username)) {
            return false;
        }
        User user = userRepository.findByUsername(username);
        user.setPassword(encryptionService.encode(newPassword));
        userRepository.save(user);
        return true;
    }
}
