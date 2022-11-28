package com.facebook.Facebook.dao;

import com.facebook.Facebook.mapper.IRowMapper;

import java.util.List;

public interface GenericDAO<T> {
    Integer save(String sql,Object... parameters);
    <T> List<T> query(String sql, IRowMapper<T> rowMapper,Object... parameters);
}
