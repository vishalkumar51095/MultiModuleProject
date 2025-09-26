package com.nic.MultiModuleProject.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.nic.onorcs.repository",
    entityManagerFactoryRef = "onorcsEntityManager",
    transactionManagerRef = "onorcsTransactionManager"
)
public class OnorcsJpaConfig {

    @Bean(name = "onorcsDataSource")
    public DataSource onorcsDataSource(DynamicDataSourceFactory factory) {
        return factory.createDataSource(
                "jdbc:postgresql://localhost:5432/onorcs",
                "postgres",
                "postgres",
                "org.postgresql.Driver"
        );
    }

    @Bean(name = "onorcsEntityManager")
    public LocalContainerEntityManagerFactoryBean onorcsEntityManagerFactory(
            @Qualifier("onorcsDataSource") DataSource dataSource) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true); // optional, auto-generate tables

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.nic.onorcs.model"); // <-- package of your entities
        em.setJpaVendorAdapter(vendorAdapter);
        em.setPersistenceUnitName("onorcs");
        return em;
    }

    @Bean(name = "onorcsTransactionManager")
    public PlatformTransactionManager onorcsTransactionManager(
            @Qualifier("onorcsEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
