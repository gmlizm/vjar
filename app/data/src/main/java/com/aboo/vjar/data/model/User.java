package com.aboo.vjar.data.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

@Data
@TableName("t_user")
public class User {
	
	@TableId("user_id")
	private long userId;
	
	@TableField("user_name")
	private String userName;
	
}
