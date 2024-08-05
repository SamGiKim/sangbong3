package com.softagape.mustacheajax.member;

import com.softagape.mustacheajax.ICommonService;
import com.softagape.mustacheajax.SearchAjaxDto;
import com.softagape.mustacheajax.security.dto.SignUpRequest;

import java.util.List;

public interface IMemberService extends ICommonService<MemberDto> {
    IMember addMember(SignUpRequest dto);
    IMember findByLoginId(String loginId);
    List<IMember> findAllByLoginIdContains(SearchAjaxDto dto);
    int countAllByLoginIdContains(SearchAjaxDto searchMemberDto);
}
