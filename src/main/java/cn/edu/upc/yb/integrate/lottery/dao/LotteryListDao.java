package cn.edu.upc.yb.integrate.lottery.dao;

import cn.edu.upc.yb.integrate.lottery.model.LotteryList;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/2/4.
 */
public interface LotteryListDao extends CrudRepository<LotteryList,Long> {
    public LotteryList findById(long id);
    public Iterable<LotteryList> findByIspass(int ispass);
}
