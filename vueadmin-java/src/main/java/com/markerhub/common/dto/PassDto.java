package com.markerhub.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PassDto implements Serializable {

//	@NotBlank(message = "新密码不能为空")
	private String password;

//	@NotBlank(message = "旧密码不能为空")
	private String currentPass;
}
