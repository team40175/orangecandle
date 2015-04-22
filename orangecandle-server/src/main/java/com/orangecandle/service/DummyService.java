package com.orangecandle.service;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DummyService {
	@PersistenceContext
	private EntityManager em;

	@RequestMapping("/dummy")
	public void doDummyStuff(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		response.getWriter().write("Hi, i'm a dummy servlet!");
	}

	@RequestMapping("/notdummy")
	public void doNotDummyStuff(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		Query q = em.createQuery("select u from User u");
		response.getWriter().write(
				"Hi, i'm not a dummy servlet!" + q.getResultList().size());
	}
}
