package com.yida;

import java.util.Optional;

import com.yida.pojo.UserDo;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年6月8日 下午12:04:44
 ***********************
 */
public class OptionalTest {
	public static void main(String[] args) {

		UserDo userDo = new UserDo();
		Optional<UserDo> user = Optional.of(userDo);
		user.map(u -> u.getName()).map(name -> name.toUpperCase()).orElse(null);

	}
}
