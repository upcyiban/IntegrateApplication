package cn.edu.upc.yb.integrate.lottery.dao;

import cn.edu.upc.yb.integrate.lottery.model.PrizeList;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by skyADMIN on 16/2/4.
 */
public interface PrizeListDao extends CrudRepository<PrizeList,Long> {
    public Iterable<PrizeList> findByLotteryidAndPrizeNot(int lotteryid, String prize);
    public Collection<PrizeList> findByLotteryidAndYibanid(int lotteryid, int yibanid);
}