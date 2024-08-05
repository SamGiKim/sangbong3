package com.softagape.mustacheajax.member;

import com.softagape.mustacheajax.ICommonService;
import com.softagape.mustacheajax.SearchAjaxDto;

import java.util.List;

public interface IMemberService extends ICommonService<MemberDto> {
    IMember findByLoginId(String loginId);
    List<IMember> findAllByLoginIdContains(SearchAjaxDto dto);
    int countAllByLoginIdContains(SearchAjaxDto searchMemberDto);
}
