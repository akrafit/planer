package com.litium.planer.controller;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.service.DfService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Rest {

    private final DfService dfService;

    public Rest(DfService dfService) {
        this.dfService = dfService;
    }

    @PostMapping("/adddf")
    public Map<String, Object> addCow(@Valid @RequestBody JSONObject jsonObject) {
        return dfService.addNewDF(jsonObject);
    }
}
