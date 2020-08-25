package com.amazonweb.dao;

import java.util.List;

import com.amazonweb.mapper.RowMapper;

public interface IGenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
}
