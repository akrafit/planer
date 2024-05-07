package com.litium.planer.controller;

import com.litium.planer.dto.FiveDFDto;
import com.litium.planer.dto.FourDFDto;
import com.litium.planer.dto.TwentySvenDFDto;
import com.litium.planer.entity.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/df")
public class WorkController {
    private final DfService dfService;
    private final UserService userService;

    private final DateTimeFormatter formatPost = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final DateTimeFormatter formatOption = DateTimeFormatter.ofPattern("MMMM yy");

    @GetMapping("/df26")
    public String df(Model model) {
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
        dfFourIterable = dfService.findDfFourByDF(dfParent);
        ArrayList<FourDFDto> dfs = new ArrayList<>();
        for (FourDF df : dfFourIterable){
            dfs.add(new FourDFDto(df));
        }
        model.addAttribute("dfs", dfs);
        model.addAttribute("dfId", dfParent.getId());
        model.addAttribute("user", userEntity);
        model.addAttribute("admin", userEntity.getRole().toString());
        model.addAttribute("edit", LocalDateTime.now());
        model.addAttribute("formatPost", formatPost);
        model.addAttribute("title", "ДФ 04 Геолого-технические мероприятия (ГТМ) " + dfParent.getPeriod());
        return "df/df4";
    }
    @GetMapping("/DF5")
    public String df5(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<FiveDF> dfFiveIterable;
        dfFiveIterable = dfService.findDfFiveByDF(dfParent);
        List<LocalDate> dateList = dfService.getFirstMonthList();
        ArrayList<FiveDFDto> dfs = new ArrayList<>();
        for (FiveDF df : dfFiveIterable){
            dfs.add(new FiveDFDto(df));
        }
        model.addAttribute("dfs", dfs);
        model.addAttribute("dfId", dfParent.getId());
        model.addAttribute("user", userEntity);
        model.addAttribute("admin", userEntity.getRole().toString());
        model.addAttribute("edit", LocalDateTime.now());
        model.addAttribute("formatPost", formatPost);
        model.addAttribute("formatOption", formatOption);
        model.addAttribute("dateList", dateList);
        model.addAttribute("title", "ДФ 05 Фонд скважин " + dfParent.getPeriod());
        return "df/df5";
    }

    @GetMapping("/DF27")
    public String df27(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<TwentySvenDF> df27Iterable;
        df27Iterable = dfService.findDf27ByDF(dfParent);
        List<Mvz> mvzList = dfService.getMvzList();
        List<LocalDate> dateList = dfService.getFirstMonthList();
        ArrayList<TwentySvenDFDto> dfs = new ArrayList<>();
        for (TwentySvenDF df : df27Iterable){
            Map<LocalDate, Long> cellMap = new HashMap<>();
            dateList.forEach(localDate -> cellMap.put(localDate,null));
            df.getCellList().forEach(twentySevenCell -> cellMap.put(twentySevenCell.getPeriod(), twentySevenCell.getValue()));
            TwentySvenDFDto twentySvenDFDto = new TwentySvenDFDto(df);
            twentySvenDFDto.setCellMap(cellMap);
            dfs.add(twentySvenDFDto);
        }
        model.addAttribute("dfs", dfs);
        model.addAttribute("dfId", dfParent.getId());
        model.addAttribute("user", userEntity);
        model.addAttribute("admin", userEntity.getRole().toString());
        model.addAttribute("edit", LocalDateTime.now());
        model.addAttribute("formatPost", formatPost);
        model.addAttribute("formatOption", formatOption);
        model.addAttribute("mvzList", mvzList);
        model.addAttribute("dateList", dateList);
        model.addAttribute("title", "ДФ 27 Потребность в транспорте " + dfParent.getPeriod());
        return "df/df27";
    }
}
