package com.learning.mvc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.mvc.ForntController.UserModels;

@Component
public class IDAO_imp implements IDAO {

	String url = "jdbc:h2:tcp://localhost/~/test";
	String user = "sa";
	String pwd = "";
	Connection conn;
	UserModels model;
	PreparedStatement stmt;

	public boolean getConnection() {
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (conn != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<UserModels> getRecords() {
		List<UserModels> userlist = new ArrayList();
		// System.out.println("inside records");

		if (getConnection()) {
			try {
				Statement statement = conn.createStatement();
				String query = "select * from data ";
				ResultSet resultset = statement.executeQuery(query);
				while (resultset.next()) {
					model = new UserModels();
					model.setId(resultset.getInt("ID"));
					model.setName(resultset.getString("Name"));
					model.setEmail(resultset.getString("Email"));
					model.setAddr(resultset.getString("Addr"));
					model.setPhone(resultset.getString("Phone"));

					userlist.add(model);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}
		return userlist;
	}

	public boolean insertingRecords(UserModels model) {
		int rowInserted = 0;
		if (getConnection()) {
			System.out.println("Connection is SuccessFully");
			String query = "insert into data  values (?,?,?,?,?)";
			try {
				PreparedStatement preparestmt = conn.prepareStatement(query);
				preparestmt.setInt(1, model.getId());
				preparestmt.setString(2, model.getName());
				preparestmt.setString(3, model.getEmail());
				preparestmt.setString(4, model.getAddr());
				preparestmt.setString(5, model.getPhone());

				rowInserted = preparestmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		if (rowInserted > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int editRecords(int i, UserModels model) {
		int rowCount = 0;
		if (getConnection()) {
			System.out.println("Connection is Successfully");
			String query = "update data" + " set Name=?,Email=?,Addr=?,Phone=?" + " where id=?";
			try {
				stmt = conn.prepareStatement(query);
				stmt.setString(1, model.getName());
				stmt.setString(2, model.getEmail());
				stmt.setString(3, model.getAddr());
				stmt.setString(4, model.getPhone());
				stmt.setInt(5, model.getId());
				rowCount = stmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("EditRecords Exception" + e.getMessage());

			}
		}
		return rowCount;
	}

	public UserModels getRecordsById(int i) {
		if (getConnection()) {
			String query = "select * from data where id=?";
			try {
				PreparedStatement preparestmt = conn.prepareStatement(query);
				preparestmt.setInt(1, i);
				ResultSet resultset = preparestmt.executeQuery();
				if (resultset.next()) {
					model = new UserModels();
					model.setId(resultset.getInt("id"));
					model.setName(resultset.getString("name"));
					model.setEmail(resultset.getString("email"));
					model.setAddr(resultset.getString("Addr"));
					model.setPhone(resultset.getString("Phone"));
				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return model;
	}

	public int deleteRecords(int i) {
		int rowCount = 0;

		if (getConnection()) {
			System.out.println("connection Successfully");

			String query = "delete Data " + "WHERE ID=?";

			try {
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, i);
				rowCount = stmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Deleted Value Exception " + e.getMessage());
			}

		}

		return rowCount;
	}

}
