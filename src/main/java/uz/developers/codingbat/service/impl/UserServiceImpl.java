package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.repository.UserRepository;

@Service
public class UserServiceImpl {
    @Autowired
    UserRepository userRepository;
}
