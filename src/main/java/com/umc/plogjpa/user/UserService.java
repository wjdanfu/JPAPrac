package com.umc.plogjpa.user;

import com.umc.plogjpa.domain.User;
import com.umc.plogjpa.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public Long saveUser(UserDto userDto) {
        User entity = userRepository.save(userDto.toEntity());
        return entity.getUserIdx();
    }

}
