package egovframework.example.category.service;

import java.util.List;

public interface ICommonService<T> {
    T findById(Long id) throws Exception;
    List<T> getAllList() throws Exception;
    T insert(T entity) throws Exception;
    Boolean delete(Long id) throws Exception;
    T update(Long id, T entity) throws Exception;
}
