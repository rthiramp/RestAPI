package com.evry.rentamovie.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import com.evry.rentamovie.exceptions.AccessDeniedException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getRequestURI().contains("/studio")) {
			if (request.getHeader("Authorization") == null) {
				log.info("Authorization not sent.");
				log.info("Validation NOK.");
				throw new AccessDeniedException("Token not valid.");
			}

			String token = request.getHeader("Authorization").replace("Bearer ", "");
			log.info("token. -> " + token);
			try {
				restTemplate.getForEntity(
						"https://librarymanagementsystem-9b515-default-rtdb.firebaseio.com/fireblog/users.json?auth="
								+ token,
						Object.class);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new AccessDeniedException("Token not valid.");
			}
		}

		return true;

	}

}