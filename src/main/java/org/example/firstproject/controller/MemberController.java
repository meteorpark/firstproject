package org.example.firstproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.firstproject.dto.MemberForm;
import org.example.firstproject.entity.Member;
import org.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;


    @GetMapping("/signup")
    public String signupForm() {

        return "members/signup";
    }

    @PostMapping("/join")
    public String join(MemberForm form) {
        log.info(form.toString());

        Member member = form.toEntity();
        log.info(member.toString());

        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "";
    }


    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {

        Member member = memberRepository.findById(id).orElse(null);

        model.addAttribute("member", member);

        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {

        ArrayList<Member> member = memberRepository.findAll();

        model.addAttribute("memberList", member);

        return "members/index";
    }

}
