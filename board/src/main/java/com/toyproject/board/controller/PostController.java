package com.toyproject.board.controller;

import com.toyproject.board.controller.dto.PostForm;
import com.toyproject.board.domain.Member;
import com.toyproject.board.repository.MemberRepository;
import com.toyproject.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addPostForm(Model model) {
        model.addAttribute("post", new PostForm());
        return "post/addPostForm";
    }

//    @PostMapping("/add")
//    public String addPost(@ModelAttribute PostForm form, Long memberId) {
//        Member member = memberRepository.findById(memberId).orElse(null);
//
//
//    }
}
