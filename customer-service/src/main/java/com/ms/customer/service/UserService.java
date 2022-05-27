package com.ms.customer.service;

import com.ms.customer.model.User;
import com.ms.customer.model.dto.UserRequest;
import com.ms.customer.model.dto.UserResponse;
import com.ms.customer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserRequest userRequest) {
        User user = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .sex(userRequest.getSex())
                .birthDate(userRequest.getBirthDate())
                .email(userRequest.getEmail())
                .build();

        userRepository.save(user);
        log.info("User {} is saved", user.getId());

    }

    public List<UserResponse> getAllUsers() {
        List<User> user = userRepository.findAll();

        return user.stream().map(this::mapToUserResponse).toList();
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .sex(user.getSex())
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .build();
    }
}