package cn.edu.upc.yb.integrate.homepage.storage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ybdevelop on 2016/10/18.
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class StorageConfig {
    CommandLineRunner init(StorageService storageService){
        return (args)->{
            storageService.deleteAll();
            storageService.init();
        };

    }
}
