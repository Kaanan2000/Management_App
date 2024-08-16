package com.kaanan.management_app.dao;

import com.kaanan.management_app.model.App_User;
import com.kaanan.management_app.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class App_UserDaoImpl implements App_UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Row Mapper for User
    public static class AppUserRowMapper implements RowMapper<App_User> {
        @Override
        public App_User mapRow(ResultSet rs, int rowNum) throws SQLException {
            App_User user = new App_User();
            user.setUserId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUserPassword(rs.getString("password"));
            user.setRole(Role.valueOf(rs.getString("role")));
            return user;
        }
    }

    //Save a User
    @Override
    public App_User save(App_User user) {
        String sql = "INSERT INTO app_user(first_name, last_name, email, password, role) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserPassword(),
                user.getRole().name()
        );
        return user;
    }
    

    //Find User by Email
    @Override
    public Optional<App_User> findByEmail(String email) {
        try {
            String sql = "SELECT * FROM app_user WHERE email = ?";
            App_User user = jdbcTemplate.queryForObject(sql, new AppUserRowMapper(), email);
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<App_User> findByUserId(int userId) {
        try {
            String sql = "SELECT * FROM app_user WHERE user_id = ?";
            App_User user = jdbcTemplate.queryForObject(sql, new AppUserRowMapper(), userId);
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}
