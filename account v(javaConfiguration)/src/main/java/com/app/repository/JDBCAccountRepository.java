package com.app.repository;

import com.app.model.Account;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static com.app.factory.Factory.logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


@Repository("jdbcAccountRepository")
@Qualifier("jdbc")
public class JDBCAccountRepository implements AccountRepository {

	DataSource dataSource;
	Connection conn;

	@Autowired
	public JDBCAccountRepository(DataSource dataSource) {
		this.dataSource = dataSource;
		logger.info("Datasource created");
	}

	public Account load(String accNum) {
		logger.info(accNum + " loading...");
		Account account = new Account();
		try {
			conn = dataSource.getConnection();
			// String sql = "insert into products(id,name,price,type) values(?,?,?,?)";
			String sql = "select*from accounts where acc_number = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, accNum);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				account.setAccount(rs.getString("acc_number"));
				account.setBalance(rs.getDouble("balance"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return account;
	}

	public Account update(String accNum, double balance) {
		logger.info(accNum + " updating....");

		Account account = new Account();
		account.setAccount(accNum);
		account.setBalance(balance);
		try {
			conn = dataSource.getConnection();
			// String sql = "insert into products(id,name,price,type) values(?,?,?,?)";
			String sql = "update accounts set balance = ? where acc_number = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, balance);
			ps.setString(2, accNum);

			int x = ps.executeUpdate();
			
			logger.info(x+"rows updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return account;

	}

}