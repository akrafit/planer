package com.litium.planer.controller;

import com.litium.planer.dto.*;
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

    private void setModel(Model model, DF dfParent, UserEntity userEntity, DateTimeFormatter formatPost, DateTimeFormatter formatOption, List<Mvz> mvzList, List<LocalDate> dateList) {
        model.addAttribute("dfId", dfParent.getId());
        model.addAttribute("user", userEntity);
        model.addAttribute("admin", userEntity.getRole().toString());
        model.addAttribute("edit", LocalDateTime.now());
        model.addAttribute("formatPost", formatPost);
        model.addAttribute("formatOption", formatOption);
        model.addAttribute("mvzList", mvzList);
        model.addAttribute("dateList", dateList);
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
        setModel(model, dfParent, userEntity, formatPost, formatOption, null, null);
        model.addAttribute("dfs", dfs);
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
        setModel(model, dfParent, userEntity, formatPost, formatOption, null, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 05 Фонд скважин " + dfParent.getPeriod());
        return "df/df5";
    }
    @GetMapping("/DF8")
    public String df8(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<EightDF> df8Iterable;
        df8Iterable = dfService.findDf8ByDF(dfParent);
        List<Mvz> mvzList = dfService.getMvzList();
        List<LocalDate> dateList = dfService.getFirstMonthList();
        ArrayList<EightDFDto> dfs = new ArrayList<>();
        for (EightDF df : df8Iterable){
            Map<LocalDate, Double> cellMap = new HashMap<>();
            dateList.forEach(localDate -> cellMap.put(localDate,null));
            df.getCellList().forEach(eightCell ->  cellMap.put(eightCell.getPeriod(), eightCell.getValue()));
            EightDFDto eightDFDto = new EightDFDto(df);
            eightDFDto.setCellMap(cellMap);
            dfs.add(eightDFDto);
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 8 Добыча и закачка жидкости по месторождениям " + dfParent.getPeriod());
        return "df/df8";
    }
    @GetMapping("/DF14")
    public String df14(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<FourteenDF> fourteenDFIterable;
        fourteenDFIterable = dfService.findDfFourteenByDF(dfParent);
        List<LocalDate> dateList = dfService.getFirstMonthList();
        List<Mvz> mvzList = dfService.getMvzList();
        ArrayList<FourteenDFDto> dfs = new ArrayList<>();
        for (FourteenDF df : fourteenDFIterable){
            dfs.add(new FourteenDFDto(df));
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 14 Потребность УВС для обработки скважин " + dfParent.getPeriod());
        return "df/df14";
    }
    @GetMapping("/DF17")
    public String df17(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<SeventeenDF> dfSeventeenIterable;
        dfSeventeenIterable = dfService.findDfSeventeenByDF(dfParent);
        List<LocalDate> dateList = dfService.getFirstMonthList();
        List<Mvz> mvzList = dfService.getMvzList();
        ArrayList<SeventeenDFDto> dfs = new ArrayList<>();
        for (SeventeenDF df : dfSeventeenIterable){
            dfs.add(new SeventeenDFDto(df));
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 17 Потребность нефтепродуктах " + dfParent.getPeriod());
        return "df/df17";
    }
    @GetMapping("/DF24")
    public String df24(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<TwentyFourDF> df24Iterable;
        df24Iterable = dfService.findDf24ByDF(dfParent);
        List<Mvz> mvzList = dfService.getMvzList();
        List<LocalDate> dateList = dfService.getFirstMonthList();
        ArrayList<TwentyFourDFDto> dfs = new ArrayList<>();
        for (TwentyFourDF df : df24Iterable){
            Map<LocalDate, Long> cellMap = new HashMap<>();
            dateList.forEach(localDate -> cellMap.put(localDate,null));
            df.getCellList().forEach(twentyFourCell -> cellMap.put(twentyFourCell.getPeriod(), twentyFourCell.getValue()));
            TwentyFourDFDto twentyFourDFDto = new TwentyFourDFDto(df);
            twentyFourDFDto.setCellMap(cellMap);
            twentyFourDFDto.setMvzName(df.getMvz().getName());
            dfs.add(twentyFourDFDto);
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 24 Электроэнергия " + dfParent.getPeriod());
        return "df/df24";
    }
    @GetMapping("/DF26")
    public String df26(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<TwentySixDF> df26Iterable;
        df26Iterable = dfService.findDf26ByDF(dfParent);
        List<Mvz> mvzList = dfService.getMvzList();
        List<LocalDate> dateList = dfService.getFirstMonthList();
        ArrayList<TwentySixDFDto> dfs = new ArrayList<>();
        for (TwentySixDF df : df26Iterable){
            Map<LocalDate, Long> cellMap = new HashMap<>();
            dateList.forEach(localDate -> cellMap.put(localDate,null));
            df.getCellList().forEach(twentySixCell -> cellMap.put(twentySixCell.getPeriod(), twentySixCell.getValue()));
            TwentySixDFDto twentySixDFDto = new TwentySixDFDto(df);
            twentySixDFDto.setCellMap(cellMap);
            twentySixDFDto.setMvzName(df.getMvz().getName());
            dfs.add(twentySixDFDto);
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 26 Потребность в перевозках " + dfParent.getPeriod());
        return "df/df26";
    }
    @GetMapping("/DF27")
    public String df27(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<TwentySvenDF> df27Iterable;
        if (userEntity.getRole().equals(Role.USER)){
            df27Iterable = dfService.findDf27ByDFAndUser(dfParent,userEntity);
        }else{
            df27Iterable = dfService.findDf27ByDF(dfParent);
        }

        List<Mvz> mvzList = dfService.getMvzList();
        List<LocalDate> dateList = dfService.getFirstMonthList();
        ArrayList<TwentySvenDFDto> dfs = new ArrayList<>();
        for (TwentySvenDF df : df27Iterable){
            Map<LocalDate, Long> cellMap = new HashMap<>();
            dateList.forEach(localDate -> cellMap.put(localDate,null));
            df.getCellList().forEach(twentySevenCell -> cellMap.put(twentySevenCell.getPeriod(), twentySevenCell.getValue()));
            TwentySvenDFDto twentySvenDFDto = new TwentySvenDFDto(df);
            twentySvenDFDto.setCellMap(cellMap);
            twentySvenDFDto.setMvzName(df.getMvz().getName());
            dfs.add(twentySvenDFDto);
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 27 Потребность в транспорте " + dfParent.getPeriod());
        return "df/df27";
    }
    @GetMapping("/DF31")
    public String df31(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<ThirtyOneDF> thirtyOneDFIterable;
        thirtyOneDFIterable = dfService.findDfThirtyOneDFIterable(dfParent);
        List<LocalDate> dateList = dfService.getFirstMonthList();
        List<Mvz> mvzList = dfService.getMvzList();
        ArrayList<ThirtyOneDFDto> dfs = new ArrayList<>();
        for (ThirtyOneDF df : thirtyOneDFIterable){
            Map<LocalDate, Long> cellMap = new HashMap<>();
            dateList.forEach(localDate -> cellMap.put(localDate,null));
            df.getCellList().forEach(thirtyOneCell -> cellMap.put(thirtyOneCell.getPeriod(), thirtyOneCell.getValue()));
            ThirtyOneDFDto thirtyOneDFDto = new ThirtyOneDFDto(df);
            thirtyOneDFDto.setCellMap(cellMap);
            dfs.add(thirtyOneDFDto);
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 31 Потребность в щебне " + dfParent.getPeriod());
        return "df/df31";
    }
    @GetMapping("/DF32")
    public String df32(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<ThirtyTwoDF> thirtyTwoDFIterable;
        thirtyTwoDFIterable = dfService.findDfThirtyTwoDFIterable(dfParent);
        List<LocalDate> dateList = dfService.getFirstMonthList();
        List<Mvz> mvzList = dfService.getMvzList();
        ArrayList<ThirtyTwoDFDto> dfs = new ArrayList<>();
        for (ThirtyTwoDF df : thirtyTwoDFIterable){
            dfs.add(new ThirtyTwoDFDto(df));
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 32 Потребность в газе " + dfParent.getPeriod());
        return "df/df32";
    }
    @GetMapping("/DF34")
    public String df34(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<ThirtyFourDF> thirtyFourDFIterable;
        thirtyFourDFIterable = dfService.findDfThirtyFourDFIterable(dfParent);
        List<LocalDate> dateList = dfService.getFirstMonthList();
        List<Mvz> mvzList = dfService.getMvzList();
        ArrayList<ThirtyFourDFDto> dfs = new ArrayList<>();
        for (ThirtyFourDF df : thirtyFourDFIterable){
            dfs.add(new ThirtyFourDFDto(df));
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 34 Потребность в бетоне " + dfParent.getPeriod());
        return "df/df34";
    }
    @GetMapping("/DF36")
    public String df36(Model model, Principal principal, @RequestParam(required = false) String id) {
        DF dfParent = dfService.findById(Long.valueOf(id));
        UserEntity userEntity = userService.getUserByName(principal.getName());
        Iterable<ThirtySixDF> df36Iterable;
        df36Iterable = dfService.findDf36ByDF(dfParent);
        List<Mvz> mvzList = dfService.getMvzList();
        List<LocalDate> dateList = dfService.getFirstMonthList();
        ArrayList<ThirtySixDFDto> dfs = new ArrayList<>();
        for (ThirtySixDF df : df36Iterable){
            Map<LocalDate, Double> cellMap = new HashMap<>();
            dateList.forEach(localDate -> cellMap.put(localDate,null));
            df.getCellList().forEach(thirtySixCell -> cellMap.put(thirtySixCell.getPeriod(), thirtySixCell.getValue()));
            ThirtySixDFDto thirtySixDFDto = new ThirtySixDFDto(df);
            thirtySixDFDto.setCellMap(cellMap);
            thirtySixDFDto.setMvzName(df.getMvz().getName());
            dfs.add(thirtySixDFDto);
        }
        setModel(model, dfParent, userEntity, formatPost, formatOption, mvzList, dateList);
        model.addAttribute("dfs", dfs);
        model.addAttribute("title", "ДФ 36 Продукция " + dfParent.getPeriod());
        return "df/df36";
    }
}
