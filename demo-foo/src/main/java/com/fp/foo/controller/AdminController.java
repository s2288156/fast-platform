package com.fp.foo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RequestMapping("/admin")
@RestController
public class AdminController {

    @GetMapping("/one")
    public String one() {
        return "get /admin/one";
    }

    @PostMapping("/two")
    public String two() {
        return "post /admin/two";
    }

    @GetMapping("/three")
    public String three() {
        return "get /admin/three";
    }
}
