package com.slk.core;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

/**
 * 
 * @author iacdp
 *
 * @param <E>	entity
 * @param <K>	primary key
 */
@MyBatisDao
public interface BaseMyBatisRepository<E, K> {

	public E getById(K k);
	public void save(E e);
	public void update(E e);
	public void deleteById(K k);
	public Long count(PageQuery query);
	public List<E> list(PageQuery query);
	public List<E> findPage(PageQuery query);
}
