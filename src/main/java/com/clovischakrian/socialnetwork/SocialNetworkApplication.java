package com.clovischakrian.socialnetwork;

//import com.clovischakrian.socialnetwork.libs.data.BaseRepositoryImplementation;
//import com.clovischakrian.socialnetwork.libs.data.DependencyInjection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
//@EnableJpaRepositories(basePackages = {
//        "com.clovischakrian.socialnetwork.libs.data",
//        "com.clovischakrian.socialnetwork.infra.repositories"
//})
public class SocialNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialNetworkApplication.class, args);
    }

//	@Bean
//	public DependencyInjection genericRepositoryFactory() {
//		return new DependencyInjection();
//	}
}
