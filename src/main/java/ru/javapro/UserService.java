package ru.javapro;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void createUser(User user) {
        userDao.save(user);
    }

    public User getUserById(Long id) {
        return userDao.getById(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }
}
