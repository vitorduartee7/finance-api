package com.vtduarte.financeapi.service;

import com.vtduarte.financeapi.config.TokenProvider;
import com.vtduarte.financeapi.database.model.Roles;
import com.vtduarte.financeapi.database.model.User;
import com.vtduarte.financeapi.database.model.enums.RoleType;
import com.vtduarte.financeapi.database.repository.RolesRepository;
import com.vtduarte.financeapi.database.repository.UserRepository;
import com.vtduarte.financeapi.dto.LoginRequestDTO;
import com.vtduarte.financeapi.dto.RegisterRequestDTO;
import com.vtduarte.financeapi.dto.TokenResponseDTO;
import com.vtduarte.financeapi.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    @Value("${jwt.expiration}")
    private Long expirationTime;

    public void register(RegisterRequestDTO dto) {

        if (userRepository.existsByEmail(dto.email())) throw new BadRequestException("Email já cadastrado");

        Roles role = rolesRepository.findByName(RoleType.USER.name())
                .orElseGet(() -> rolesRepository.save(Roles.builder()
                        .name(RoleType.USER.name())
                        .build()
                ));

        userRepository.save(User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .roles(Set.of(role))
                .build()
        );
    }

    public TokenResponseDTO login(LoginRequestDTO dto) {

        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(dto.email(), dto.password()));
            String token = tokenProvider.generateToken(auth);

            return new TokenResponseDTO(token, expirationTime);
        } catch (BadCredentialsException e) {
            throw new BadRequestException("Credenciais inválidas");
        }
    }
}
