package com.devsu.cuentamovimientos.config;

/*
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "clientepersonaEntityManagerFactory",
        transactionManagerRef = "clientepersonaTransactionManager",
        basePackages = { "com.devsu.clientepersona.repository" })*/
public class RepositoryConfiguration {
/*
    @Primary
    @Bean(name = "clientepersonaDataSourceProperties")
    @ConfigurationProperties("clientepersona.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "clientepersonaDataSource")
    @ConfigurationProperties("clientepersona.datasource.configuration")
    public DataSource dataSource(
            @Qualifier("clientepersonaDataSourceProperties") DataSourceProperties convocatoriaDataSourceProperties) {
        return convocatoriaDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "clientepersonaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("clientepersonaDataSource") DataSource convocatoriaDataSource) {

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        //properties.put("hibernate.session_factory.session_scoped_interceptor",
        //        "pe.gob.servir.convocatoria.audit.AuditEntityInterceptor");
        properties.put("hibernate.proc.param_null_passing", "true");
        properties.put("hibernate.show_sql", "true");
        properties.put("tomee.jpa.factory.lazy", "true");


        return builder.dataSource(convocatoriaDataSource).packages("com.devsu.clientepersona.model")
                .persistenceUnit("clientepersona").properties(properties).build();
    }

    @Primary
    @Bean(name = "clientepersonaTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("clientepersonaEntityManagerFactory") EntityManagerFactory clientepersonaEntityManagerFactory) {
        return new JpaTransactionManager(clientepersonaEntityManagerFactory);
    } */
}
