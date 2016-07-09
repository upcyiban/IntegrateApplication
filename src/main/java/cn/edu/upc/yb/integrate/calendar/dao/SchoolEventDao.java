package cn.edu.upc.yb.integrate.calendar.dao;

import cn.edu.upc.yb.integrate.calendar.model.SchoolEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Jaxlying on 2016/7/9.
 */
public interface SchoolEventDao extends CrudRepository<SchoolEvent,Integer>,PagingAndSortingRepository<SchoolEvent,Integer>{

}
