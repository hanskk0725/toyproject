package com.toyproject.board.service;

import com.toyproject.board.domain.Member;
import com.toyproject.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> source = memberRepository.findByEmail(member.getEmail());
        if (!source.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 이메일 입니다");
        }
    }

    @Transactional
    public void update(Long id, String name, String email, String password) {
        Member member = memberRepository.findById(id).orElse(null);
        member.setEmail(email);
        member.setName(name);
        member.setPassword(password);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
