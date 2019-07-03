package com.comarch.comarch.services;

import com.comarch.comarch.dao.UserDao;
import com.comarch.comarch.dto.UserDto;
import com.comarch.comarch.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserDao userDao;
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
        modelMapper = new ModelMapper();
    }

    public Optional<User> findUserById(Long id) {
        return userDao.findById(id);
    }

    public void changeUserName(Long id, String name) {
        // TODO: 03.07.2019 czy jstnieje ?
        User user = findUserById(id).get();
        // TODO: 03.07.2019 nazwa poprawna?
        user.setName(name);
    }

    private UserDto mapToDto(User user) {
        UserDto dto = modelMapper.map(user, UserDto.class);
        return dto;
    }
}
