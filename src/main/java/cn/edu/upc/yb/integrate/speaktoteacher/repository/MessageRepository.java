package cn.edu.upc.yb.integrate.speaktoteacher.repository;

import cn.edu.upc.yb.integrate.speaktoteacher.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/3/29.
 */
public interface MessageRepository extends CrudRepository<Message,Integer> {

    public Iterable<Message> findByYibanId(int id);
    public Iterable<Message> findByTeacherId(int id);
}
