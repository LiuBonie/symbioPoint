package com.symbio.dao;

import java.io.Serializable;
import java.util.List;

public interface DaomianDao <T>{
	//获取全部
	List<T> getAll();
	//根据ID获取
	T getById(Long id);
	//增加
	int post (T entity);
	//更新
	void put(T entity);
	//根据ID删除
	void delete(Long id);
}
