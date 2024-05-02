package com.litium.planer.controller;

import com.litium.planer.dto.FourDFDto;
import com.litium.planer.entity.DF;
import com.litium.planer.entity.FourDF;
import com.litium.planer.model.Role;
import com.litium.planer.model.UserEntity;
import com.litium.planer.service.DfService;
import com.litium.planer.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
@RequestMapping("/df")
public class WorkController {
    private final DfService dfService;
    private final UserService userService;

    private final DateTimeFormatter formatPost = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @GetMapping("/df26")
    public String df(Model model) {
//        Iterable<Cow> cowIterable = cowService.findAll();
//        ArrayList<CowDto> cows = new ArrayList<>();
//        for (Cow cow : cowIterable){
//            cows.add(new CowDto(cow));
//        }
        // cows.sort((cow, cow2) -> Math.toIntExact(cow.compareTo(cow2)));
        model.addAttribute("cows", "");
        model.addAttribute("date", " ");
        model.addAttribute("title", "Список ДФ");
        return "df/df26";
    }

    @GetMapping("/DF4")
    public String df4(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<FourDF> dfFourIterable;
//        if(userEntity.getRole().equals(Role.ADMIN)){
//            dfFourIterable = dfService.findDfFourByDF(dfParent);
//        }else{
//            dfFourIterable = dfService.findDfFourByDFAndUser(dfParent, userEntity);
//        }
        dfFourIterable = dfService.findDfFourByDF(dfParent);
        ArrayList<FourDFDto> dfs = new ArrayList<>();
        for (FourDF df : dfFourIterable){
            dfs.add(new FourDFDto(df));
        }

        // cows.sort((cow, cow2) -> Math.toIntExact(cow.compareTo(cow2)));
        model.addAttribute("dfs", dfs);
        model.addAttribute("dfId", dfParent.getId());
        model.addAttribute("user", userEntity.getName());
        model.addAttribute("admin", userEntity.getRole().toString());
        model.addAttribute("edit", LocalDateTime.now());
        model.addAttribute("formatPost", formatPost);
        model.addAttribute("title", "ДФ 04 Геолого-технические мероприятия (ГТМ) " + dfParent.getPeriod());
        return "df/df4";
    }
}
