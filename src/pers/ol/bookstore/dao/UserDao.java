package pers.ol.bookstore.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import pers.ol.bookstore.domain.User;
import pers.ol.bookstore.utils.DataSourceUtils;

public class UserDao {
	DataSource getData = DataSourceUtils.getDataSource();
	public void addUser(User user)throws SQLException{
		String sql="insert into User(username,password,gender,email,telephone,introduce,activecode) value (?,?,?,?,?,?,?)";
		QueryRunner runner = new QueryRunner(getData);
		int row = runner.update(sql, user.getUsername(), user.getPassword(), user.getGender(), user.getEmail(),
				user.getTelephone(), user.getIntroduce(), user.getActiveCode());
		if(row == 0){
			return;
		}
	}
}
