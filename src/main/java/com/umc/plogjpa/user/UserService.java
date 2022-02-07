package com.umc.plogjpa.user;

import com.umc.plogjpa.domain.User;
import com.umc.plogjpa.domain.UserRepository;
import com.umc.plogjpa.util.JwtService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public Long saveUser(UserDto userDto) {
        User entity = userRepository.save(userDto.toEntity());
        return entity.getUserIdx();
    }

    public String login(LoginDto loginDto) throws NotFoundException {
        User user = userRepository.findByName(loginDto.getName())
                .orElseThrow(() -> new NotFoundException("회원정보를 찾을 수 없습니다."));
        String jwt = jwtService.createJwt(user.getUserIdx());

        return jwt;
    }

}
