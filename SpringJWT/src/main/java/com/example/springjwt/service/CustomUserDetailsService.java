package com.example.springjwt.service;

import com.example.springjwt.Repository.UserRepository;
import com.example.springjwt.dto.CustomUserDetails;
import com.example.springjwt.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    // DB로 부터 userdetailservice가 특정한 회원 정보를 가져오고 그걸 userdetails에 넘겨가지고
    // 최종적으로 Authentication manager에서 검증을 한다.

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    //loadUserByUsername 메서드는 사용자의 정보를 조회하고 반환하는 역할을 합니다.
    // 이 메서드는 사용자가 인증을 시도할 때 authenticationManager에서 호출되어 사용자 정보를 검색하고,
    // 검색된 정보를 기반으로 사용자를 인증하는 데 사용됩니다.

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //DB에서 조회
        UserEntity userData = userRepository.findByUsername(username);

        if (userData != null) {

            //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
            return new CustomUserDetails(userData);
        }

        return null;
    }
}