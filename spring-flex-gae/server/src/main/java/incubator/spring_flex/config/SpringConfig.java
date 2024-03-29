package incubator.spring_flex.config;

import incubator.spring_flex.persistence.GAE_EntityManagerFactory;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;

/**
 * @author iwaszkiewicz
 * @date 02.03.2010
 */
@Configuration
public class SpringConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        return new GAE_EntityManagerFactory("pizza-pu").entityManagerFactory();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }

}
