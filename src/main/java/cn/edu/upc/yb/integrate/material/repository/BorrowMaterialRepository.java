package cn.edu.upc.yb.integrate.material.repository;

import cn.edu.upc.yb.integrate.material.model.BorrowMaterial;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wanghaojun on 2017/2/10.
 */
public interface BorrowMaterialRepository extends CrudRepository<BorrowMaterial,Integer> {

    public Iterable<BorrowMaterial> findByMaterialId(int id);
    public Iterable<BorrowMaterial> findByBorrowerYibanId(int id);
}
