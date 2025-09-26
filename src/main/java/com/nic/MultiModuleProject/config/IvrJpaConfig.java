package com.nic.MultiModuleProject.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.nic.ivrimpds.repository",
    entityManagerFactoryRef = "ivrEntityManager",
    transactionManagerRef = "ivrTransactionManager"
)
public class IvrJpaConfig {

    @Bean(name = "ivrDataSource")
    public DataSource ivrDataSource(DynamicDataSourceFactory factory) {
        return factory.createDataSource(
                "jdbc:postgresql://localhost:5432/ivrimpds",
                "postgres", "postgres", "org.postgresql.Driver");
    }

    @Bean(name = "ivrEntityManager")
    @Primary
    public LocalContainerEntityManagerFactoryBean ivrEntityManagerFactory(
            @Qualifier("ivrDataSource") DataSource dataSource) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true); // optional, generates tables automatically

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.nic.ivrimpds.model"); // <-- your entity package
        em.setJpaVendorAdapter(vendorAdapter);
        em.setPersistenceUnitName("ivr"); // persistence unit name
        return em;
    }

    @Bean(name = "ivrTransactionManager")
    public PlatformTransactionManager ivrTransactionManager(
            @Qualifier("ivrEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
