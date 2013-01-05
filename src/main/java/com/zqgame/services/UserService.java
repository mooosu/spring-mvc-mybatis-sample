package com.zqgame.services;

import com.zqgame.mappers.UserMapper;
import com.zqgame.models.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private Environment env;

	public void setEnv(Environment env) {
		this.env = env;
	}

	@Autowired(required = true)
	private UserMapper userMapper;
        
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public String encodePassphrase(String rawPassphrase, String salt) {
		return new Sha512Hash(rawPassphrase, getCombinedSalt(salt), getIterations()).toBase64();
	}

	public User create(User user)
	{
		user.setSalt(getSalt());
		user.setPassword(encodePassphrase(user.getPassword(), user.getSalt()));

		// Insert the Identity
		userMapper.save( user );

		logger.trace("INSERTED ID = (" + user.getId() + ")");
		// Get a new Identity object, fully populated from the DB
		return userMapper.findById(user.getId());
	}

	public static String getSalt() {
		return new SecureRandomNumberGenerator().nextBytes().toBase64();
	}

	public String getApplicationSalt() {
		return env.getProperty("shiro.applicationSalt");
	}

	public String getCombinedSalt(String salt) {
		return env.getProperty("shiro.applicationSalt") + ":" + salt;
	}

	public Integer getIterations() {
		return Integer.parseInt(env.getProperty("shiro.hashIterations"));
	}

}
