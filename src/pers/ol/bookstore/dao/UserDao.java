package pers.ol.bookstore.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.ol.bookstore.domain.User;
import pers.ol.bookstore.utils.DataSourceUtils;

public class UserDao {
	DataSource getDS = DataSourceUtils.getDataSource();
	public void addUser(User user)throws SQLException{
		String sql="insert into User(username,password,gender,email,telephone,introduce,activecode) value (?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(getDS);
		int row = runner.update(sql, user.getUsername(), user.getPassword(), user.getGender(), user.getEmail(),
				user.getTelephone(), user.getIntroduce(), user.getActiveCode());
		if(row == 0){
			return;
		}
	}
	
	public void findUserByActiveCode(String activeCode)throws SQLException{
		String sql = "select * from user where activeCode=?";
		QueryRunner runner = new QueryRunner(getDS);
		runner.update(sql, 1, activeCode);
	}
	
	public User findUserByUsernameAndPassword(String username, String password)throws SQLException{
		String sql = "select * from user where username=? and password=?";
		QueryRunner runner = new QueryRunner(getDS);
		return runner.query(sql, new BeanHandler<User>(User.class), username, password);
	}
}
