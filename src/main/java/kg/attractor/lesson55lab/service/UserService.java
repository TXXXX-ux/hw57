package kg.attractor.lesson55lab.service;

import kg.attractor.lesson55lab.dao.UserDao;
import kg.attractor.lesson55lab.dto.UserRegistrationDto;
import kg.attractor.lesson55lab.model.AccountType;
import kg.attractor.lesson55lab.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public void register(UserRegistrationDto dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .accountType(AccountType.valueOf(dto.getAccountType()))
                .name("Новый пользователь")
                .build();
        userDao.save(user);
    }

    public User getUserByEmail(String email) {
        return userDao.findAll().stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }
}