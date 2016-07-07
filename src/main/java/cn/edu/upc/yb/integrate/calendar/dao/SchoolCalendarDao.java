package cn.edu.upc.yb.integrate.calendar.dao;

import cn.edu.upc.yb.integrate.calendar.model.SchoolCalendar;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skyADMIN on 16/7/4.
 */
public interface SchoolCalendarDao extends CrudRepository<SchoolCalendar, Integer> {
}
