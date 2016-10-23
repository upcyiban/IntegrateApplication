package cn.edu.upc.yb.integrate.homepage.repository;

import cn.edu.upc.yb.integrate.homepage.model.App;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ybdevelop on 2016/10/18.
 */
public interface AppRepository extends CrudRepository<App,Integer> {
    public Iterable<App> findByTabid(Integer tabid);
}
