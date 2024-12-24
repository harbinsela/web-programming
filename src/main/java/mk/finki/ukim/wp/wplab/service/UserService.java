package mk.finki.ukim.wp.wplab.service;

import mk.finki.ukim.wp.wplab.model.User;
import mk.finki.ukim.wp.wplab.model.exceptions.InvalidArgumentsException;
import mk.finki.ukim.wp.wplab.model.exceptions.InvalidUserCredentialsException;
import mk.finki.ukim.wp.wplab.model.exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.wp.wplab.model.exceptions.UsenameAlreadyExistsException;

public interface UserService {
    User register(String username, String password, String repeatPassword,
                  String name, String surname) throws InvalidArgumentsException, PasswordsDoNotMatchException, UsenameAlreadyExistsException;
    User login(String username, String password) throws InvalidArgumentsException, InvalidUserCredentialsException;
}