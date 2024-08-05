package com.softagape.mustacheajax.category;

import com.softagape.mustacheajax.SearchAjaxDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
// Mybatis 쿼리를 선언한 xml 파일의 함수와 연결한다.
public interface CategoryMybatisMapper {
    void insert(CategoryDto dto);

    void update(CategoryDto dto);

    void deleteById(Long id);

    CategoryDto findById(long id);

    CategoryDto findByName(String name);

    List<CategoryDto> findAll();

    int countAllByNameContains(SearchAjaxDto searchAjaxDto);
    List<CategoryDto> findAllByNameContains(SearchAjaxDto searchAjaxDto);
}
