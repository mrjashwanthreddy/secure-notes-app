package com.secure.notes.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("notes")
public class NotesController {
    @GetMapping
    public String getNotes(Principal principal) {
        // 'Principal' is the currently logged-in user (Authentication)
        return "Here are the secret notes for user: " + principal.getName();
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
