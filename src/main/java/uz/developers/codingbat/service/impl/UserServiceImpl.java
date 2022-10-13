package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.User;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.UserRepository;
import uz.developers.codingbat.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public Result addUser(User user) {
        return null;
    }

    @Override
    public Result editUser(Integer id, User user) {
        return null;
    }

    @Override
    public Result deleteUser(Integer id) {
        return null;
    }
}
