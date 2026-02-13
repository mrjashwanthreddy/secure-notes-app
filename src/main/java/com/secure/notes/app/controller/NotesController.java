package com.secure.notes.app.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("notes")
public class NotesController {

    @GetMapping
    public Map<String, Object> getNotes(@AuthenticationPrincipal OAuth2User principal) {
        // OAuth2User contains all the details sent by Google
        String name = principal.getAttribute("name");
        String email = principal.getAttribute("email");

        return Map.of(
                "message", "Hello " + name + "! Here are your secret notes.",
                "email", email,
                "google_id", principal.getName(),
                "full_profile", principal.getAttributes() // This shows everything Google sent!
        );
    }

    // This is a public endpoint (we will configure this shortly)
    @GetMapping("/public")
    public String getPublicInfo() {
        return "This is public info. No login needed.";
    }

    @GetMapping("/admin")
    public String getAdminNotes() {
        return "TOP SECRET: Launch codes are 1234. Only Admins can see this.";
    }

}
