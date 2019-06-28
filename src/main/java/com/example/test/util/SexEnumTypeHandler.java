package com.example.test.util;

import com.example.test.pojo.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//这个是对应数据库的类型
@MappedJdbcTypes(JdbcType.INTEGER)
//这个是自己类型
@MappedTypes(value=SexEnum.class)
public class SexEnumTypeHandler extends BaseTypeHandler<SexEnum> {

	@Override
	//将枚举的id 设置到数据库中
	public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(i,parameter.getValue());
	}

	@Override
	public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
		//这个是根据列名去获取值
		int sexid = rs.getInt(columnName);
		if(sexid!=1&&sexid!=2){
			return null;
		}
		return  SexEnum.getEnumValueById(sexid);
	}

	@Override
	public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		//这个是根据列的下标去获取值
		int sexid = rs.getInt(columnIndex);
		if(sexid!=1&&sexid!=2){
			return null;
		}
		return  SexEnum.getEnumValueById(sexid);
	}

	@Override
	//这个是根据存储过程来获取值，这里暂时用不到就不重写
	public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return null;
	}
}
