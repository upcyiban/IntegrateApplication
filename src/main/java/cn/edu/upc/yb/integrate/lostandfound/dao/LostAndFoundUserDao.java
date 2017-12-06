package cn.edu.upc.yb.integrate.lostandfound.dao;

import cn.edu.upc.yb.integrate.lostandfound.model.LostAndFoundUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by 17797 on 2017/5/30.
 */
public interface LostAndFoundUserDao extends CrudRepository<LostAndFoundUser,Integer>,PagingAndSortingRepository<LostAndFoundUser,Integer> {
    public Iterable<LostAndFoundUser> findByIsdeletNotAndIsloserNotOrderByDateDesc(Boolean isdelet,Boolean isloser);
    public Iterable<LostAndFoundUser> findByIsdeletNotOrderByDateDesc(Boolean isdelet);
    public Iterable<LostAndFoundUser> findAll();
    public Iterable<LostAndFoundUser> findByIsdeletNotAndIsloserNotOrderByIdDesc(Boolean isdelet, Boolean isloser);
    public Iterable<LostAndFoundUser> findByIsdeletNotOrderByIdDesc(Boolean isdelet);
}