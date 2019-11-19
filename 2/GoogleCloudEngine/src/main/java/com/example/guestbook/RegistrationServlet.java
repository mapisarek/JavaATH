package com.example.guestbook;

import com.googlecode.objectify.ObjectifyService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RegistrationServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user;

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if (email != null) {
            user = new User(login, password, email);
        } else {
            user = new User(login, password);
        }

        ObjectifyService.ofy().save().entity(user).now();

        resp.sendRedirect("/registrationpage.jsp");
    }
}