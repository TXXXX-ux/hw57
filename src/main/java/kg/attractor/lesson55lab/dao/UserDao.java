package kg.attractor.lesson55lab.dao;

import kg.attractor.lesson55lab.model.AccountType;
import kg.attractor.lesson55lab.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    private final List<User> users = new ArrayList<>();

    public UserDao() {
        String encodedPassword = new BCryptPasswordEncoder().encode("123456");

        // акк на APPLICANT
        users.add(User.builder()
                .id(1L)
                .email("user@gmail.com")
                .password(encodedPassword)
                .name("Тайлер")
                .accountType(AccountType.APPLICANT)
                .about("Мыловар, философ, соискатель.")
                .build());

        // акк на EMPLOYER
        users.add(User.builder()
                .id(2L)
                .email("admin@gmail.com")
                .password(encodedPassword)
                .name("Админ")
                .accountType(AccountType.EMPLOYER)
                .about("Ищем бойцов.")
                .build());
    }

    public List<User> findAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public User findByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}