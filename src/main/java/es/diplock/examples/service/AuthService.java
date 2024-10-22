package es.diplock.examples.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import es.diplock.examples.entities.User;
import es.diplock.examples.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User authenticate(String email, String password) {
        Optional<User> userOpt = userRepository.findByUsername(email);
        User user = null;
        if (userOpt.isPresent() && BCrypt.checkpw(password, userOpt.get().getPassword())) {
            user = userOpt.get();
        }
        return user;
    }

    public void registerUser(String username, String rawPassword) {
        String hashedPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
        User user = new User(null, username, hashedPassword);
        userRepository.save(user);
    }
}
