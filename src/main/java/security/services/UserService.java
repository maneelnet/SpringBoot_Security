package security.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import security.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> usersList();

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(User user, Long id);

    User showUser(Long id);

    User findByUsername(String username);
}
