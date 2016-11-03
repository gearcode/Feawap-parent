package com.gearcode.feawap.util;

import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class MybatisPaginationInterceptor implements Interceptor {

	private final static Log logger = LogFactory.getLog(MybatisPaginationInterceptor.class);
	private String dialect;

	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, new DefaultObjectFactory(), new DefaultObjectWrapperFactory());
		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
			return invocation.proceed();
		}
//		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
		
//		logger.info("rowBounds: " + rowBounds.getOffset() + ", " + rowBounds.getLimit());
//		logger.info("dialect: " + dialect);
		
		if(dialect == null || dialect.equals("")) {
			throw new RuntimeException("The value of the dialect property in PaginationInterceptor is not defined");
		}
		
		if(!dialect.equals("mysql")) {
			throw new RuntimeException("The dialect must be 'mysql'");
		}
		
		String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
		logger.debug("Original SQL: " + originalSql);
		
		//设置组装好的分页sql语句
		metaStatementHandler.setValue("delegate.boundSql.sql", originalSql + " limit " + rowBounds.getOffset() + ", " + rowBounds.getLimit());
		
		//重置mybatis自带的rowBounds参数
		metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
		metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
		
		//打印调试信息
		if (logger.isDebugEnabled()) {
			logger.debug("Pagination SQL: " + boundSql.getSql());
		}
		
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
	
}

