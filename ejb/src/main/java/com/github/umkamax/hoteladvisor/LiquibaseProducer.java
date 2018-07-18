package com.github.umkamax.hoteladvisor;

import liquibase.integration.cdi.CDILiquibaseConfig;
import liquibase.integration.cdi.annotations.LiquibaseType;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import java.sql.SQLException;

@Dependent
public class LiquibaseProducer {

    private static final Logger logger = LoggerFactory.getLogger(LiquibaseProducer.class);

    @Resource(name = "java:/MySQLDS")
    private DataSource myDataSource;

    @Produces
    @LiquibaseType
    public CDILiquibaseConfig createConfig() {
        logger.info("Create Liquibase config...");
        CDILiquibaseConfig config = new CDILiquibaseConfig();
        config.setChangeLog("liquibase/parser/core/xml/simpleChangeLog.xml");
        return config;
    }

    @Produces
    @LiquibaseType
    public DataSource createDataSource() throws SQLException {
        logger.info("Create data source...");
        return myDataSource;
    }

    @Produces
    @LiquibaseType
    public ResourceAccessor create() {
        logger.info("Create Resource accessor...");
        return new ClassLoaderResourceAccessor(getClass().getClassLoader());
    }
}
