package com.example.test.dao.impl;

import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.stereotype.Repository;

import com.example.test.dao.TestDao;
@Repository
public class TestDaoImpl implements TestDao {
	/*private JdbcTemplate template;
	@Autowired
	private DataSource dataSource;


	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = new JdbcTemplate(dataSource);
	}
*/



	@Override
	public int addUser(String name) {
		// TODO Auto-generated method stub
		//int count = template.update("insert into user(name) values(?)",name);
		//return count;
		return 0;
	}

}
