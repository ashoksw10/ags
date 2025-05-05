package com.org.ags.service;

import com.org.ags.entity.UserEntity;
import com.org.ags.model.User;
import com.org.ags.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    /*@Autowired
    UserMapper userMapper;*/

    @Override
    public User createUser(User user) {
        return modelMapper.map(userRepository.save(modelMapper.map(user, UserEntity.class)), User.class);
    }

    @Override
    public List<User> getUsers() {
        return modelMapper.map(userRepository.findAll(), new TypeToken<List<User>>() {}.getType()) ;
    }

    @Override
    public User getUsersById(Integer userId) {
        return modelMapper.map(userRepository.getReferenceById(userId), User.class);
    }
}
