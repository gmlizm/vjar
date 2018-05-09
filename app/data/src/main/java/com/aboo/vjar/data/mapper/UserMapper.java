package com.aboo.vjar.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aboo.vjar.data.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
	
	User selectUser(@Param("userId") Long userId);
	
}
