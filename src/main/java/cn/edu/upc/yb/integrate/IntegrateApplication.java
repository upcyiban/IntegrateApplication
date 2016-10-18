package cn.edu.upc.yb.integrate;

import cn.edu.upc.yb.integrate.deliverwater.dao.DeliverWaterDao;
import cn.edu.upc.yb.integrate.deliverwater.service.WriteExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrateApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrateApplication.class, args);
	}

}
