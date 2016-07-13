package cn.edu.upc.yb.integrate.lostandfound.dao;

import cn.edu.upc.yb.integrate.lostandfound.model.Official;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wanghaojun on 2016/7/12.
 */
public interface OfficialDao extends CrudRepository<Official,Integer>,PagingAndSortingRepository<Official,Integer> {
    public Iterable<Official> findByIsdeletNotOrderByDateDesc(Boolean isdelet);
    public Page<Official> findAll(Pageable pageable);
    public Page<Official> findByIsdeletNotOrderByDateDesc(Boolean isdelet,Pageable pageable);
}