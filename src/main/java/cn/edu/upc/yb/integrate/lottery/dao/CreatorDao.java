package cn.edu.upc.yb.integrate.lottery.dao;

import cn.edu.upc.yb.integrate.lottery.model.Creator;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by skyADMIN on 16/2/4.
 */
public interface CreatorDao extends CrudRepository<Creator,Long> {
    public Collection<Creator> findByYibanid(long yibanid);
}
