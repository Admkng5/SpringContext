package ru.javapro;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "ru.javapro")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        UserService userService = context.getBean(UserService.class);

        // Создание пользователя
        User user = new User();
        user.setUsername("user1");
        userService.createUser(user);

        // Получение пользователя по идентификатору
        User retrievedUser = userService.getUserById(user.getId());
        System.out.println("Полученный пользователь: " + retrievedUser.getUsername());

        // Изменение пользователя
        retrievedUser.setUsername("user1_updated");
        userService.updateUser(retrievedUser);

        // Удаление пользователя
        userService.deleteUser(retrievedUser.getId());

        // Получение всех пользователей
        List<User> allUsers = userService.getAllUsers();
        System.out.println("Все пользователи:");
        for (User u : allUsers) {
            System.out.println(u.getUsername());
        }
    }
}
