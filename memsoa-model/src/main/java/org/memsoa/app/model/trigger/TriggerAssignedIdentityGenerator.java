/**
 * 
 */
package org.memsoa.app.model.trigger;

import org.hibernate.id.AbstractPostInsertGenerator;
import org.hibernate.id.PostInsertIdentityPersister;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.SequenceIdentityGenerator.NoCommentsInsert;
import org.hibernate.id.insert.AbstractReturningDelegate;
import org.hibernate.id.insert.IdentifierGeneratingInsert;
import org.hibernate.id.insert.InsertGeneratedIdentifierDelegate;

/**
 * @author <a href="mailto:cristian.arboleda@premize.com">Cristian M. Arboleda</a>
 * @project memsoa-model
 * @class TriggerAssignedIdentityGenerator
 * @date 18/07/2013
 *
 */
public class TriggerAssignedIdentityGenerator extends AbstractPostInsertGenerator{

	private static final String RETURN_PREFIX = " RETURNING ";
	private static final String RETURN_SUFFIX = " INTO ?";
	private static final String Q_MARK = "?";

	public InsertGeneratedIdentifierDelegate getInsertGeneratedIdentifierDelegate(
			PostInsertIdentityPersister persister, Dialect dialect,
			boolean isGetGeneratedKeysEnabled) throws HibernateException {
		return new Delegate(persister, dialect);
	}

	public static class Delegate extends AbstractReturningDelegate {
		private final Dialect dialect;
		private final String sqlSuffix;

		public Delegate(PostInsertIdentityPersister persister, Dialect dialect) {
			super(persister);
			this.dialect = dialect;
			String[] keyColumns = getPersister().getRootTableKeyColumnNames();
			if (keyColumns.length > 1) {
				throw new HibernateException(
						"trigger assigned identity generator cannot be used with multi-column keys");
			}
			sqlSuffix = new StringBuffer(26).append(RETURN_PREFIX).append(keyColumns[0]).append(
					RETURN_SUFFIX).toString();
		}

		public IdentifierGeneratingInsert prepareIdentifierGeneratingInsert() {
			return new NoCommentsInsert(dialect);
		}

		protected PreparedStatement prepare(String insertSQL, SessionImplementor session)
				throws SQLException {
			insertSQL += sqlSuffix;
			OraclePreparedStatement stmt = (OraclePreparedStatement) session.getBatcher()
					.prepareStatement(insertSQL);
			stmt.registerReturnParameter(StringUtils.countMatches(insertSQL, Q_MARK),
					OracleTypes.NUMBER);
			return stmt;
		}

		protected Serializable executeAndExtract(PreparedStatement statement) throws SQLException {
			OraclePreparedStatement insert = (OraclePreparedStatement) statement;
			if (insert.executeUpdate() > 0) {
				ResultSet resultSet = insert.getReturnResultSet();
				if (resultSet.next()) {
					return new Long(resultSet.getLong(1));
				}
			}
			throw new SQLException("Returned no id in resultset");
		}
	}

}
