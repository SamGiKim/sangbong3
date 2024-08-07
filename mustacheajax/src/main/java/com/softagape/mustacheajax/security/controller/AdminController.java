package com.softagape.mustacheajax.security.controller;

import com.softagape.mustacheajax.member.IMember;
import com.softagape.mustacheajax.member.IMemberService;
import com.softagape.mustacheajax.member.MemberRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IMemberService memberService;

    @GetMapping("/info")
    private String showInfo(Model model, @CookieValue String loginId) {
        IMember loginUser = memberService.findByLoginId(loginId);
        if ( !loginUser.getRole().equals(MemberRole.ADMIN.toString()) ) {
            return "redirect:/";
        }
        model.addAttribute("loginUser", loginUser);
        return "admin/info";
    }
}
