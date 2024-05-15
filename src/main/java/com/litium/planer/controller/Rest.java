package com.litium.planer.controller;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.dto.SeventeenDFDto;
import com.litium.planer.dto.ThirtyOneDFDto;
import com.litium.planer.dto.ThirtyTwoDFDto;
import com.litium.planer.dto.TwentySvenDFDto;
import com.litium.planer.entity.ThirtyTwoDF;
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
    public Map<String, Object> addDf4(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.addNewDf4(jsonObject, principal.getName());
    }

    @PostMapping("/deleteDf4")
    public Map<String, Object> deleteDf4(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.deleteDf4(jsonObject, principal.getName());
    }
    @PostMapping("/deleteDf5")
    public Map<String, Object> deleteDf5(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.deleteDf5(jsonObject, principal.getName());
    }

    @PostMapping("/deleteDf17")
    public Map<String, Object> deleteDf17(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.deleteDf17(jsonObject, principal.getName());
    }
    @PostMapping("/deleteDf27")
    public Map<String, Object> deleteDf27(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.deleteDf27(jsonObject, principal.getName());
    }
    @PostMapping("/deleteDf31")
    public Map<String, Object> deleteDf31(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.deleteDf31(jsonObject, principal.getName());
    }
    @PostMapping("/deleteDf32")
    public Map<String, Object> deleteDf32(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.deleteDf32(jsonObject, principal.getName());
    }

    @PostMapping("/addusertodf")
    public Map<String, Object> addUserToDf(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.addUserToDf(jsonObject, principal.getName());
    }

    @PostMapping("/addDf5")
    public Map<String, Object> addDf5(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.addNewDf5(jsonObject, principal.getName());
    }
    @PostMapping("/addDf17")
    public Map<String, Object> addDf17(@Valid @RequestBody SeventeenDFDto seventeenDFDto, Principal principal) {
        return dfService.addNewDf17(seventeenDFDto, principal.getName());
    }
    @PostMapping("/addDf27")
    public Map<String, Object> addDf27(@Valid @RequestBody TwentySvenDFDto twentySvenDFDto, Principal principal) {
        return dfService.addNewDf27(twentySvenDFDto, principal.getName());
    }

    @PostMapping("/adddf27monthval")
    public Map<String, Object> addDf27MonthValue(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.addDf27MonthValue(jsonObject, principal.getName());
    }
    @PostMapping("/addDf31")
    public Map<String, Object> addDf31(@Valid @RequestBody ThirtyOneDFDto thirtyOneDFDto, Principal principal) {
        return dfService.addNewDf31(thirtyOneDFDto, principal.getName());
    }
    @PostMapping("/addDf32")
    public Map<String, Object> addDf32(@Valid @RequestBody ThirtyTwoDFDto thirtyTwoDFDto, Principal principal) {
        return dfService.addNewDf32(thirtyTwoDFDto, principal.getName());
    }
    @PostMapping("/adddf31monthval")
    public Map<String, Object> addDf31MonthValue(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.addDf31MonthValue(jsonObject, principal.getName());
    }


}
