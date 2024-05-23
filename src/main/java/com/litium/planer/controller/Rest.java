package com.litium.planer.controller;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.dto.*;
import com.litium.planer.service.DfCellService;
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
    private final DfCellService dfCellService;
    private final UserService userService;

    public Rest(DfService dfService, DfCellService dfCellService, UserService userService) {
        this.dfService = dfService;
        this.dfCellService = dfCellService;
        this.userService = userService;
    }
    @PostMapping("/deleteDf")
    public Map<String, Object> deleteDf(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.deleteDf(jsonObject, principal.getName());
    }
    @PostMapping("/adddf")
    public Map<String, Object> addCow(@Valid @RequestBody JSONObject jsonObject) {
        return dfService.addNewDF(jsonObject);
    }
    @PostMapping("/adduser")
    public Map<String, Object> addUser(@Valid @RequestBody JSONObject jsonObject) {
        return userService.addNewUser(jsonObject);
    }
    @PostMapping("/addusertodf")
    public Map<String, Object> addUserToDf(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.addUserToDf(jsonObject, principal.getName());
    }
    @PostMapping("/addUpdateMvz")
    public Map<String, Object> addUpdateMvz(@Valid @RequestBody MvzDto mvzDto, Principal principal) {
        return dfService.addUpdateMvz(mvzDto, principal.getName());
    }
    @PostMapping("/addDf4")
    public Map<String, Object> addDf4(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.addNewDf4(jsonObject, principal.getName());
    }
    @PostMapping("/addDf5")
    public Map<String, Object> addDf5(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfService.addNewDf5(jsonObject, principal.getName());
    }
    @PostMapping("/addDf8")
    public Map<String, Object> addDf8(@Valid @RequestBody EightDFDto eightDFDto, Principal principal) {
        return dfService.addNewDf8(eightDFDto, principal.getName());
    }
    @PostMapping("/adddf8monthval")
    public Map<String, Object> addDf8MonthValue(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfCellService.addDf8MonthValue(jsonObject, principal.getName());
    }
    @PostMapping("/addDf14")
    public Map<String, Object> addDf14(@Valid @RequestBody FourteenDFDto fourteenDFDto, Principal principal) {
        return dfService.addNewDf14(fourteenDFDto, principal.getName());
    }
    @PostMapping("/addDf17")
    public Map<String, Object> addDf17(@Valid @RequestBody SeventeenDFDto seventeenDFDto, Principal principal) {
        return dfService.addNewDf17(seventeenDFDto, principal.getName());
    }
    @PostMapping("/addDf24")
    public Map<String, Object> addDf26(@Valid @RequestBody TwentyFourDFDto twentyFourDFDto, Principal principal) {
        return dfService.addNewDf24(twentyFourDFDto, principal.getName());
    }
    @PostMapping("/adddf24monthval")
    public Map<String, Object> addDf24MonthValue(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfCellService.addDf24MonthValue(jsonObject, principal.getName());
    }
    @PostMapping("/addDf26")
    public Map<String, Object> addDf26(@Valid @RequestBody TwentySixDFDto twentySixDFDto, Principal principal) {
        return dfService.addNewDf26(twentySixDFDto, principal.getName());
    }
    @PostMapping("/adddf26monthval")
    public Map<String, Object> addDf26MonthValue(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfCellService.addDf26MonthValue(jsonObject, principal.getName());
    }
    @PostMapping("/addDf27")
    public Map<String, Object> addDf27(@Valid @RequestBody TwentySvenDFDto twentySvenDFDto, Principal principal) {
        return dfService.addNewDf27(twentySvenDFDto, principal.getName());
    }
    @PostMapping("/adddf27monthval")
    public Map<String, Object> addDf27MonthValue(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfCellService.addDf27MonthValue(jsonObject, principal.getName());
    }
    @PostMapping("/addDf31")
    public Map<String, Object> addDf31(@Valid @RequestBody ThirtyOneDFDto thirtyOneDFDto, Principal principal) {
        return dfService.addNewDf31(thirtyOneDFDto, principal.getName());
    }
    @PostMapping("/adddf31monthval")
    public Map<String, Object> addDf31MonthValue(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfCellService.addDf31MonthValue(jsonObject, principal.getName());
    }
    @PostMapping("/addDf32")
    public Map<String, Object> addDf32(@Valid @RequestBody ThirtyTwoDFDto thirtyTwoDFDto, Principal principal) {
        return dfService.addNewDf32(thirtyTwoDFDto, principal.getName());
    }
    @PostMapping("/addDf34")
    public Map<String, Object> addDf34(@Valid @RequestBody ThirtyFourDFDto thirtyFourDFDto, Principal principal) {
        return dfService.addNewDf34(thirtyFourDFDto, principal.getName());
    }
    @PostMapping("/addDf36")
    public Map<String, Object> addDf36(@Valid @RequestBody ThirtySixDFDto thirtySixDFDto, Principal principal) {
        return dfService.addNewDf36(thirtySixDFDto, principal.getName());
    }
    @PostMapping("/adddf36monthval")
    public Map<String, Object> addDf36MonthValue(@Valid @RequestBody JSONObject jsonObject, Principal principal) {
        return dfCellService.addDf36MonthValue(jsonObject, principal.getName());
    }
}
