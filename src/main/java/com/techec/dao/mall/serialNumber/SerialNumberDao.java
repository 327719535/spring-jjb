package com.techec.dao.mall.serialNumber;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 *
 */
public interface SerialNumberDao {
	Map<String, String> getNum();

	Integer update(@Param("date") String date, @Param("num") String num);
	
	void insert(@Param("date") String date, @Param("num") String num);
}
