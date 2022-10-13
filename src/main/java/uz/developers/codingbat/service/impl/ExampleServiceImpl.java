package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Example;
import uz.developers.codingbat.repository.ExampleRepository;

@Service
public class ExampleServiceImpl {
    @Autowired
    ExampleRepository exampleRepository;

}
