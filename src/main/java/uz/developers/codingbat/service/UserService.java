package uz.developers.codingbat.service;

import uz.developers.codingbat.entity.User;
import uz.developers.codingbat.payload.Result;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(Integer id);

    Result addUser(User user);

    Result editUser(Integer id, User user);

    Result deleteUser(Integer id);
}
