package com.aboo.vjar.data.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

@Data
@TableName("t_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@TableId("user_id")
	private long userId;
	
	@TableField("user_name")
	private String userName;
	
}
