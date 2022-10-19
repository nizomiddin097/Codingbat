package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.User;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.UserRepository;
import uz.developers.codingbat.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
       return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public Result addUser(User user) {
        boolean existsByEmail = userRepository.existsByEmail(user.getEmail());
        if (existsByEmail) {
            return new Result("Such email already exist",false);
        }
        userRepository.save(user);
        return new Result("User is saved",true);
    }

    @Override
    public Result editUser(Integer id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return new Result("Such user is not found",false);
        }
        User editedUser = optionalUser.get();
        editedUser.setEmail(user.getEmail());
        editedUser.setPassword(user.getPassword());
        userRepository.save(editedUser);
        return new Result("User is edited",true);
    }

    @Override
    public Result deleteUser(Integer id) {
        userRepository.deleteById(id);
        return new Result("User is deleted",true);
    }
}
