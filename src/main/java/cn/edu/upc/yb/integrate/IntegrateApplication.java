package cn.edu.upc.yb.integrate;


import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.http.HttpSession;

@SpringBootApplication
public class IntegrateApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrateApplication.class, args);
	}

}
