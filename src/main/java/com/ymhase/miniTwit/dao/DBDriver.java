package com.ymhase.miniTwit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DBDriver {

	private final String url = "jdbc:postgresql://localhost/minitweet";
	private final String user = "postgres";
	private final String password = "root";
	Connection conn = null;

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public DBDriver() {

		try {
			conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
