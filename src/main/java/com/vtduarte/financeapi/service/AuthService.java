package com.vtduarte.financeapi.service;

import com.vtduarte.financeapi.database.model.Roles;
import com.vtduarte.financeapi.database.model.User;
import com.vtduarte.financeapi.database.model.enums.RoleType;
import com.vtduarte.financeapi.database.repository.RolesRepository;
import com.vtduarte.financeapi.database.repository.UserRepository;
import com.vtduarte.financeapi.dto.UserRegisterRequestDTO;
import com.vtduarte.financeapi.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO register(UserRegisterRequestDTO dto) throws BadRequestException {

        User user = userRepository.findByEmail(dto.email())
                        .orElse(null);

        if (user != null) throw new BadRequestException("Aluno já cadastrado");

        Roles role = rolesRepository.findByName(RoleType.USER.name())
                .orElseGet(() -> rolesRepository.save(Roles.builder()
                        .name(RoleType.USER.name())
                        .build()
                ));

        User save = userRepository.save(User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .roles(Set.of(role))
                .build()
        );

        return toResponse(save);
    }

    public UserResponseDTO toResponse(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
