package com.jungreithmeir.database;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * Small singleton DAO which returns a DAO. This object can be used to manipulate the database contents directly.
 * This is definitely not the most clever implementation for such a structure, but for the scope of this assignment
 * quite fitting.
 * 
 * @author Jakob Jungreithmeir
 * @version 1.0 12-12-2016
 */
public class DatabaseDAO {

	static Dao<Translation, String> translationDao = null;
	
	private DatabaseDAO() {}
	
	public static Dao<Translation, String> getInstance() {
		if (translationDao == null) {
			System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");
		    String databaseUrl = "jdbc:h2:./dictionary";
		    ConnectionSource connectionSource;
			try {
				connectionSource = new JdbcConnectionSource(databaseUrl);
			    translationDao = DaoManager.createDao(connectionSource, Translation.class);
			    TableUtils.createTableIfNotExists(connectionSource, Translation.class);
			} catch (SQLException e) {
				System.err.println("Could not initialize database.");
				e.printStackTrace();
				System.exit(1);
			}
		}
		return translationDao;
	}
 	
}
