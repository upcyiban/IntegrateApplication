package cn.edu.upc.yb.integrate.contact.repository;

import cn.edu.upc.yb.integrate.contact.model.ContactsJob;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2017/3/25.
 */
public interface ContactsJobRepository extends CrudRepository<ContactsJob,Integer>{

    public Iterable<ContactsJob> findByContactsUnitId(int id);
    public Iterable<ContactsJob> findByName(String name);
}
