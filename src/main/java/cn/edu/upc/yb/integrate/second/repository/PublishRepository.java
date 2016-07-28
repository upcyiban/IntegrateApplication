package cn.edu.upc.yb.integrate.second.repository;


import cn.edu.upc.yb.integrate.second.model.Publish;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jaxlying on 2016/7/26.
 */
public interface PublishRepository extends CrudRepository<Publish,Integer> {
    public Iterable<Publish> findByIsdelete(boolean isdelete);
    public Iterable<Publish> findByIsdeleteOrderByCreatetimeDesc(boolean isdelete);
    public Iterable<Publish> findByYbidAndIsdelete(int ybid, boolean isdelete);
    public Iterable<Publish> findByIsdeleteOrderByIdDesc(boolean isdelete);


}
