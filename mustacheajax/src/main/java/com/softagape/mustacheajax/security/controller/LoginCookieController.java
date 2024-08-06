package com.softagape.mustacheajax.security.controller;

import com.softagape.mustacheajax.member.IMember;
import com.softagape.mustacheajax.member.IMemberService;
import com.softagape.mustacheajax.security.dto.LoginRequest;
import com.softagape.mustacheajax.security.dto.SignUpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cologin")
public class LoginCookieController {
    @Autowired
    private IMemberService memberService;

    @GetMapping("")
    private String home() {
        return "login/home";
    }

    @GetMapping("/signup")
    private String viewSignUp() {
        return "login/signup";
    }

    @PostMapping("/signup")
    private String signUp(@ModelAttribute SignUpRequest dto) {
        try {
            if (dto == null) {
                return "redirect:/cologin";
            }
            this.memberService.addMember(dto);
        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return "redirect:/cologin";
    }

    @GetMapping("/login")
    private String viewLogin() {
        return "login/login";
    }

    @PostMapping("/signin")
    private String signin(Model model, @ModelAttribute LoginRequest dto) {
        try {
            if (dto == null) {
                return "redirect:/cologin";
            }
            IMember loginUser = this.memberService.login(dto);
            if ( loginUser != null ) {
                model.addAttribute("loginUser", loginUser);
                return "user/info";
            }
        } catch (Exception ex) {
            log.error(ex.toString());
        }
        return "login/fail";
    }
}
