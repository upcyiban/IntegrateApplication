package cn.edu.upc.yb.integrate.lostandfound.dao;

import cn.edu.upc.yb.integrate.lostandfound.model.LostAndFoundOfficial;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by 17797 on 2017/5/30.
 */

public interface LostAndFoundOfficialDao extends CrudRepository<LostAndFoundOfficial,Integer>,PagingAndSortingRepository<LostAndFoundOfficial,Integer> {
    public Iterable<LostAndFoundOfficial> findByIsdeletNotOrderByDateDesc(Boolean isdelet);
    public Iterable<LostAndFoundOfficial> findAll();
    public  Iterable<LostAndFoundOfficial> findAll(Sort sort);

}