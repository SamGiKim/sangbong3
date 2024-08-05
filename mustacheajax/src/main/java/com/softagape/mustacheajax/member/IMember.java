package com.softagape.mustacheajax.member;

public interface IMember {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    String getLoginId();
    void setLoginId(String loginId);

    String getPassword();
    void setPassword(String password);

    String getEmail();
    void setEmail(String email);

    String getRole();
    void setRole(String role);
}
