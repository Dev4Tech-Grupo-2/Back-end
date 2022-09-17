package com.dev4tech.group2.littlegeniuses.domain.service;

import com.dev4tech.group2.littlegeniuses.domain.entity.UserAccount;
import com.dev4tech.group2.littlegeniuses.domain.exception.BusinessException;
import com.dev4tech.group2.littlegeniuses.domain.exception.ForeignKeyException;
import com.dev4tech.group2.littlegeniuses.domain.exception.ResourceNotFoundException;
import com.dev4tech.group2.littlegeniuses.domain.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserAccount findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
    }

    public UserAccount save(UserAccount user) {

        Optional<UserAccount> userExists = userRepository.findByEmail(user.getEmail());

        if (userExists.isPresent() && !userExists.get().equals(user)) {
            throw new BusinessException(
                    String.format("There is already a registered user with the email %s", user.getEmail()));
        }

        if (user.isNew()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(user);
    }

    @Transactional
    public void changePassword(Long userId, String currentPassword, String newPassword) {
        UserAccount user = findById(userId);

        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new BusinessException("The current password entered does not match the user's password.");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
    }

    public void delete(Long id) {
        try {
            userRepository.delete(findById(id));
        } catch (DataIntegrityViolationException e) {
            throw new ForeignKeyException(id);
        }

    }

}
