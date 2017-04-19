package cn.edu.upc.yb.integrate.contact.repository;

import cn.edu.upc.yb.integrate.contact.model.ContactsJob;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by lenovo on 2017/3/25.
 */
public interface ContactsJobRepository extends CrudRepository<ContactsJob,Integer>{

    public Iterable<ContactsJob> findByContactsUnitId(int id);

    @Query("select c from ContactsJob c where c.name like CONCAT('%',:name,'%')")
    public Iterable<ContactsJob> findByNameLike(@Param("name") String name);
}
