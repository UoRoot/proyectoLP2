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

    public void registerUser(String username, String rawPassword) {
        String salt = BCrypt.gensalt(12);
        String hashedPassword = BCrypt.hashpw(rawPassword, salt);
        
        if (!hashedPassword.startsWith("$2a$") && !hashedPassword.startsWith("$2b$")) {
            throw new IllegalStateException("Hash generado inválido");
        }
        
        User user = new User(null, username, hashedPassword);
        userRepository.save(user);
    }
    
    public User authenticate(String email, String password) {
        Optional<User> userOpt = userRepository.findByUsername(email);
        
        if (userOpt.isPresent()) {
            String storedHash = userOpt.get().getPassword();
            
            if (!storedHash.startsWith("$2a$") && !storedHash.startsWith("$2b$")) {
                throw new IllegalStateException("Hash almacenado inválido");
            }
            
            if (BCrypt.checkpw(password, storedHash)) {
                return userOpt.get();
            }
        }
        return null;
    }
}
