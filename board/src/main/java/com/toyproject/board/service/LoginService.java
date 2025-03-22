package com.toyproject.board.service;

import com.toyproject.board.domain.Member;
import com.toyproject.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String email, String password) {
        memberRepository.findByEmail(email)
                .stream().filter(e -> e.getPassword().equals(password)).findFirst().orElseThrow();
    }
}
