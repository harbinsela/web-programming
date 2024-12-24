package mk.finki.ukim.wp.wplab.service.impl;

import mk.finki.ukim.wp.wplab.model.User;
import mk.finki.ukim.wp.wplab.model.exceptions.InvalidArgumentsException;
import mk.finki.ukim.wp.wplab.model.exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.wp.wplab.model.exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.wp.wplab.model.exceptions.UsenameAlreadyExistsException;
import mk.finki.ukim.wp.wplab.repository.UserRepository;
import mk.finki.ukim.wp.wplab.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) throws InvalidArgumentsException, PasswordsDoNotMatchException, UsenameAlreadyExistsException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || repeatPassword == null || repeatPassword.isEmpty() || name == null || name.isEmpty() || surname == null || surname.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        if(this.userRepository.findByUsername(username).isPresent()){
            throw new UsenameAlreadyExistsException(username);
        }
        User user=new User(username, passwordEncoder.encode(password), name, surname);
        return userRepository.save(user);
    }
    @Override
    public User login(String username, String password) throws InvalidArgumentsException, InvalidUserCredentialsException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        User user = userRepository.findByUsername(username).get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidUserCredentialsException();
        }
        return user;
    }
}