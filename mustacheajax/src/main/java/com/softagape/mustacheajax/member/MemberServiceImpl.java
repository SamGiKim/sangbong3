package com.softagape.mustacheajax.member;

import com.softagape.mustacheajax.SearchAjaxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private MemberMybatisMapper memberMybatisMapper;

    @Override
    public MemberDto findById(Long id) {
        MemberDto find = this.memberMybatisMapper.findById(id);
        return find;
    }

    @Override
    public List<MemberDto> getAllList() {
        return List.of();
    }

    @Override
    public MemberDto insert(MemberDto dto) throws Exception {
        this.memberMybatisMapper.insert(dto);
        return dto;
    }

    @Override
    public Boolean delete(Long id) throws Exception {
        this.memberMybatisMapper.delete(id);
        return true;
    }

    @Override
    public MemberDto update(Long id, MemberDto dto) throws Exception {
        dto.setId(id);
        this.memberMybatisMapper.update(dto);
        return null;
    }

    @Override
    public IMember findByLoginId(String loginId) {
        IMember find = this.memberMybatisMapper.findByLoginId(loginId);
        return find;
    }

    @Override
    public List<IMember> findAllByLoginIdContains(SearchAjaxDto dto) {
        List<IMember> list = this.memberMybatisMapper.findAllByLoginIdContains(dto);
        return list;
    }

    @Override
    public int countAllByLoginIdContains(SearchAjaxDto dto) {
        int count = this.memberMybatisMapper.countAllByLoginIdContains(dto);
        return 0;
    }
}
