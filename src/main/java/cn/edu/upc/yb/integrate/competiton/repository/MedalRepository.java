package cn.edu.upc.yb.integrate.competiton.repository;

import cn.edu.upc.yb.integrate.competiton.model.Medal;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/4/9.
 */
public interface MedalRepository extends CrudRepository<Medal,Integer>{
    public Medal findFirstByYibanId(int ybid);
}
