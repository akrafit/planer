package com.litium.planer.controller;


import com.litium.planer.dto.DfDto;
import com.litium.planer.dto.UserDto;
import com.litium.planer.entity.DF;
import com.litium.planer.model.UserEntity;
import com.litium.planer.service.DfService;
import com.litium.planer.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class GeneralController {
    private final DfService dfService;
    private final UserService userService;

    @GetMapping("/home")
    public String main(Model model) {
        Iterable<DF> DfIterable = dfService.findAll();
        List<DfDto> dfs = new ArrayList<>();
        for (DF df : DfIterable){
            dfs.add(new DfDto(df));
        }
       // cows.sort((cow, cow2) -> Math.toIntExact(cow.compareTo(cow2)));
        model.addAttribute("dfs", dfs);
        model.addAttribute("date", "");
        model.addAttribute("title", "Список ДФ");
        return "home";
    }

    @GetMapping("/userlist")
    public String userList(Model model) {
        Iterable<UserEntity> userEntityIterable = userService.findAll();
        List<UserDto> users = new ArrayList<>();
        for (UserEntity userEntity : userEntityIterable){
            users.add(new UserDto(userEntity));
        }
        // cows.sort((cow, cow2) -> Math.toIntExact(cow.compareTo(cow2)));
        model.addAttribute("users", users);
        model.addAttribute("date", "");
        model.addAttribute("title", "Список пользователей");
        return "user/userform";
    }
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

    @GetMapping("/df4")
    public String df4(Model model) {
//        Iterable<Cow> cowIterable = cowService.findAll();
//        ArrayList<CowDto> cows = new ArrayList<>();
//        for (Cow cow : cowIterable){
//            cows.add(new CowDto(cow));
//        }
        // cows.sort((cow, cow2) -> Math.toIntExact(cow.compareTo(cow2)));
        model.addAttribute("cows", "");
        model.addAttribute("date", " ");
        model.addAttribute("title", "Список ДФ");
        return "df/df4";
    }
    @GetMapping("/auth/logout")
    public String logout(Model model) {
        return "redirect:/";
    }

//    @GetMapping("/traffic")
//    public String traffic(Model model) {
//        ArrayList<CowMoveDto> drives = cowService.findAllCowMove(null);
//        model.addAttribute("drives", drives);
//        return "traffic";
//    }
//
//    @GetMapping("/cow/search")
//    public String trafficWithParam(@RequestParam(name = "date") String date, @RequestParam(name = "type") String type, Model model) {
//        List<Cow> cowList = cowService.findCowWithParam(date,type);
//        if(cowList.isEmpty())
//        {
//            return "traffic";
//        }
//        ArrayList<CowDto> cows = new ArrayList<>();
//        for (Cow cow : cowList){
//            cows.add(new CowDto(cow));
//        }
//        Map<String,String> info = cowService.createInfo(date,type);
//        model.addAttribute("cows", cows);
//        model.addAttribute("date", info.get("date") + " " +cows.size() + " шт.");
//        model.addAttribute("title", info.get("title"));
//        return "cow";
//    }
//
//    @GetMapping("/api/slider/{id}")
//    public String getCowImage(@PathVariable(value = "id") Long id, Model model){
//        Cow cow = cowService.getOne(id);
//        if(cow != null){
//            List<Photo> photoList = cow.getPhotoList();
//            if(photoList.isEmpty()){
//                return null;
//            }
//            ArrayList<Photo> cowImages = new ArrayList<>(photoList);
//            // cows.sort((cow, cow2) -> Math.toIntExact(cow.compareTo(cow2)));
//            model.addAttribute("cowImages", cowImages);
//
//            return "slider";
//        }else{
//            return null;
//        }
//
//    }

}
