package com.stackabuse.facebookapi.controller.com.stackabuse.facebookapi.controller;

import java.util.List;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;
import com.restfb.types.User.Education;
import com.stackabuse.facebookapi.service.FBService;

@Controller
@RequestMapping("/")
public class HelloController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;
    private FBService fbService;
    private FacebookClient facebookClient;
    private String token = "EAAiuLZC4JvW8BAJmihXe3ZAVuMfFBIhGwK8sz1gAJZAZBgXkNjK3pwkuQxLd5r8B1SFtdiv3mUssrtDfjUcyBZAkJa6tLgAHMZBKgceyRtarZA1gKv3vtLLAw9ZCU5kBdvdFWVLvWKQ0xGU2AtFOiGfsKRd8CHaRiER81gDhiZADnxHs0dDU0cMTrsQC7nZAKFtJsKQpAS031tCzEjXkTPcfGUSCw7lMtCdbVyNalZAX5BQHgZDZD";
    

    public HelloController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

	@GetMapping
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        FacebookClient facebookClient= new DefaultFacebookClient(token, Version.LATEST);

        User user = facebookClient.fetchObject("me", User.class,Parameter.with("fields", "id, name, email, first_name, last_name"));
        model.addAttribute("loggedUser", user);
        return "hello";
    }
}