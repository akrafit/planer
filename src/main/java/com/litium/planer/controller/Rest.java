package com.litium.planer.controller;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.service.DfService;
import com.litium.planer.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Rest {

    private final DfService dfService;
    private final UserService userService;

    public Rest(DfService dfService, UserService userService) {
        this.dfService = dfService;
        this.userService = userService;
    }

    @PostMapping("/adddf")
    public Map<String, Object> addCow(@Valid @RequestBody JSONObject jsonObject) {
        return dfService.addNewDF(jsonObject);
    }
    @PostMapping("/adduser")
    public Map<String, Object> addUser(@Valid @RequestBody JSONObject jsonObject) {
        return userService.addNewUser(jsonObject);
    }

    @PostMapping("/addDf4")
    public Map<String, Object> addDf4(@Valid @RequestBody JSONObject jsonObject) {
        return dfService.addNewDf4(jsonObject);
    }

    @PostMapping("/addusertodf")
    public Map<String, Object> addUserToDf(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.addUserToDf(jsonObject, principal.getName());
    }
}
