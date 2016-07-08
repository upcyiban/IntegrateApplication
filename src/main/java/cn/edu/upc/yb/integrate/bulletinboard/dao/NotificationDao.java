package cn.edu.upc.yb.integrate.bulletinboard.dao;

import cn.edu.upc.yb.integrate.bulletinboard.model.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/7/8.
 */
public interface NotificationDao extends CrudRepository<Notification, Integer> {
    public Notification findFirstByOrderByIdDesc();

}
