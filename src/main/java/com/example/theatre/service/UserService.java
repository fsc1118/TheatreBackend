package com.example.theatre.service;

import com.example.theatre.entity.Ticket;
import com.example.theatre.entity.User;
import com.example.theatre.repository.TicketRepository;
import com.example.theatre.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
    private transient final TicketRepository ticketRepository;
    private transient final EncryptionService encryptionService;

    public UserService(UserRepository userRepository, TicketRepository ticketRepository, EncryptionService encryptionService) {
        this.userRepository = userRepository;
        this.ticketRepository= ticketRepository;
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

    public boolean editUser(Map<String, String> map) {
    	String username = map.getOrDefault("name", null);
        String zip = map.getOrDefault("zip", null);
        String phone = map.getOrDefault("phone", null);
        String city = map.getOrDefault("city", null);
        String email = map.getOrDefault("email", null);
        if (username == null || zip == null || phone == null || city == null || email == null) {
        	return false;
        }
        User user = userRepository.findByUsername(username);
        user.setZip(zip);
        user.setPhone(phone);
        user.setCity(city);
        user.setEmail(email);
        userRepository.save(user);
        return true;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void removeUser(Long user_id) {
        ticketRepository.deleteTicketsOfUser(user_id);
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

    public Long getUserId(String username) {
        User user = userRepository.findByUsername(username);
        return user.getU_id();
    }

    public Map<String, String> getUserInfo(String username) {
        User user = userRepository.findByUsername(username);
        Map<String, String> map = new HashMap<>();
        map.put("name", String.valueOf(user.getUsername()));
        map.put("zip", String.valueOf(user.getZip()));
        map.put("email", String.valueOf(user.getEmail()));
        map.put("phone", String.valueOf(user.getPhone()));
        map.put("city", String.valueOf(user.getCity()));
        return map;
    }
}
