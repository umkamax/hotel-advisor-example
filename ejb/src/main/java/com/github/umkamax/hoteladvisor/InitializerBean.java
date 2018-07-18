package com.github.umkamax.hoteladvisor;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//@Startup
//@Singleton
//@TransactionManagement(TransactionManagementType.BEAN)
public class InitializerBean {

    private static final Logger logger = LoggerFactory.getLogger(InitializerBean.class);

    private static final String STAGE = "development";
    private static final String CHANGELOG_FILE = "liquibase/db.changelog.xml";

    @Resource
    private DataSource ds;

    @PostConstruct
    protected void bootstrap() {
        logger.info("Initialize...");

//        ResourceAccessor resourceAccessor = new ClassLoaderResourceAccessor(getClass().getClassLoader());
//        try (Connection connection = ds.getConnection()) {
//            JdbcConnection jdbcConnection = new JdbcConnection(connection);
//            Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(jdbcConnection);
//
//            Liquibase liquiBase = new Liquibase(CHANGELOG_FILE, resourceAccessor, db);
//            liquiBase.update(STAGE);
//        } catch(SQLException | LiquibaseException e) {
//            logger.error("Liquibase migration failed!");
//        }
    }
}
