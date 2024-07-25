package com.softagape.mybatisprj.category;

import com.softagape.mybatisprj.ICommonService;

import java.util.List;

public interface ICategoryService<T> extends ICommonService<T> {
    ICategory findByName(String name);
    List<ICategory> findAllByNameContains(String name);
}
