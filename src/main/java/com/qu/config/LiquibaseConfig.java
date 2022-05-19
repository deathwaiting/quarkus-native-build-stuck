package com.qu.config;

import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.util.ExceptionUtil;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.DatabaseConnection;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.event.Observes;

/***
 * based on workaround https://github.com/quarkusio/quarkus/issues/14682#issuecomment-828964269
 */
public class LiquibaseConfig {

    private static final Logger logger = Logger.getLogger(LiquibaseConfig.class);

    @ConfigProperty(name = "custom.liquibase.migrate")
    boolean runMigration;
    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    String datasourceUrl;
    @ConfigProperty(name = "quarkus.datasource.username")
    String datasourceUsername;
    @ConfigProperty(name = "quarkus.datasource.password")
    String datasourcePassword;
    @ConfigProperty(name = "quarkus.liquibase.change-log")
    String changeLogLocation;

    public void runLiquibaseMigration(@Observes StartupEvent event) throws LiquibaseException {
        if(runMigration)
        {
            Liquibase liquibase = null;
            try {
                var resourceAccessor = new ClassLoaderResourceAccessor(Thread.currentThread().getContextClassLoader());
                var conn = DatabaseFactory.getInstance().openConnection(datasourceUrl, datasourceUsername, datasourcePassword, null, resourceAccessor);
                liquibase = new Liquibase(changeLogLocation, resourceAccessor, conn);
                liquibase.update(new Contexts(), new LabelExpression());
            } catch (Exception e) {
                logger.error("Liquibase Migration Exception: " + ExceptionUtil.generateStackTrace(e));
            }
            finally {
                if(liquibase!=null)
                {
                    liquibase.close();
                }
            }
        }
    }
}
