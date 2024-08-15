package com.kaanan.management_app.dao;

import com.kaanan.management_app.model.App_User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface App_UserDao {
    App_User save(App_User user);
    Optional<App_User> findByEmail(String email);
    Optional<App_User> findByUserId(int userId);
}




