package com.toyproject.board.controller;

import com.toyproject.board.controller.dto.LoginForm;
import com.toyproject.board.domain.Member;
import com.toyproject.board.controller.dto.MemberForm;
import com.toyproject.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("memberDto", new MemberForm());
        return "addMemberForm";
    }

    @PostMapping("/add")
    public String addMember(@Validated @ModelAttribute MemberForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        Member member = new Member(form.getEmail(), form.getPassword(), form.getName());
        memberService.join(member);

        log.info("Member joined, Member={}", member);
        redirectAttributes.addAttribute("memberId", member.getId());

        return "redirect:/members";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "members/loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/loginForm";
        }



    }
}
