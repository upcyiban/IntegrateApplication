package cn.edu.upc.yb.integrate.lostandfound.dao;

import cn.edu.upc.yb.integrate.lostandfound.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wanghaojun on 2016/7/12.
 */
public interface UserDao extends CrudRepository<User,Integer>,PagingAndSortingRepository<User,Integer> {
    public Iterable<User> findByIsdeletNotAndIsloserNotOrderByDateDesc(Boolean isdelet,Boolean isloser);
    public Iterable<User> findByIsdeletNotOrderByDateDesc(Boolean isdelet);
    public Page<User> findAll(Pageable pageable);
    public Page<User> findByIsdeletNotAndIsloserNotOrderByDateDesc(Boolean isdelet,Boolean isloser,Pageable pageable);
    public Page<User> findByIsdeletNotOrderByDateDesc(Boolean isdelet,Pageable pageable);
}