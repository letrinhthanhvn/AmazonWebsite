package com.amazonweb.service;

import com.amazonweb.model.User;

public interface ITokenAuthenticationService {
	String getUsernameFromToken(String token);

	String createToken(User user);

	User getUserFromToken(String token);

	Integer getRoleFromToken(String token);
}
