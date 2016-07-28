package cn.edu.upc.yb.integrate.second.repository;


import cn.edu.upc.yb.integrate.second.model.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jaxlying on 2016/7/26.
 */
public interface ReviewRepository extends CrudRepository<Review,Integer> {
    public Iterable<Review> findByPublishid(int publishid);
}
