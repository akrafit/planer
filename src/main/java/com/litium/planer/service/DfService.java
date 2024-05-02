package com.litium.planer.service;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.entity.DF;
import com.litium.planer.entity.FourDF;
import com.litium.planer.entity.User2DF;
import com.litium.planer.model.Role;
import com.litium.planer.model.TypeDF;
import com.litium.planer.model.UserEntity;
import com.litium.planer.repo.DfRepository;
import com.litium.planer.repo.FourDFRepository;
import com.litium.planer.repo.User2DFRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DfService {
    private final DfRepository dfRepository;
    private final FourDFRepository fourDFRepository;

    private final User2DFRepository user2DFRepository;

    private final UserService userService;

    DateTimeFormatter formatPost = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Map<String, Object> addNewDF(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();

        DF dfEntity = new DF();
        dfEntity.setForm(jsonObject.getString("df"));
        dfEntity.setName(jsonObject.getString("name"));
        dfEntity.setPeriod(jsonObject.getString("period"));
        dfEntity.setType(TypeDF.valueOf(jsonObject.getString("dfType")));

        map.put("massage", "OK");
        dfRepository.save(dfEntity);
        return map;

        //update
//        Cow cow;
//        if (id != null && cowRepository.findById(id).isPresent()) {
//            cow = cowRepository.findById(id).get();
//            msg = "Данные коровы изменены.";
//
//        } else {
//            //addNew
//            cow = new Cow();
//            msg = "Новая корова добавлена.";
//
//        }
//        Tag tag = tagRepository.findByEpc(tagEPC);
//        if (tag != null && !Objects.equals(cow.getId(), id)) {
//            map.put("massage", "Такой тег уже есть");
//            return map;
//        }
//        Tag newTag = new Tag();
//        if (tagEPC != null) {
//            newTag.setEpc(tagEPC);
//            cow.setTag(newTag);
//            msg = msg + " Метка: " + tagEPC + " добавлена.";
//        }
//        cow.setType(type);
//        cow.setColor(color);
//        cow.setCreateDate(LocalDateTime.now());
//        cow.setStatus(CowStatus.LIVE);
//        cow.setBirthday(LocalDate.parse(birthday, format).atStartOfDay());

    }

    public Iterable<DF> findAll() {
       return dfRepository.findAll();
    }

    public Iterable<FourDF> findAllDfFour() {
        return  fourDFRepository.findAll();
    }

    public Map<String, Object> addNewDf4(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();

        Optional<DF> dfParent = dfRepository.findById(jsonObject.getLong("dfid"));
        UserEntity userEntity = userService.getUserByName(name);
        FourDF fourDF = new FourDF();
        fourDF.setUser(userEntity);
        if(dfParent.isPresent()){
            fourDF.setDf(dfParent.get());
        }else{
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        fourDF.setTypeGTM(jsonObject.getString("typeGTM"));
        fourDF.setOilfield(jsonObject.getString("oilField"));
        fourDF.setKp(jsonObject.getString("kp"));
        fourDF.setWell(jsonObject.getString("well"));
        fourDF.setWellPurpose(jsonObject.getString("wellPurpose"));
        fourDF.setType(jsonObject.getString("type"));
        fourDF.setComment(jsonObject.getString("comment"));
        String endDate = jsonObject.getString("enddate");
        if (endDate.isEmpty()){
            map.put("massage", "Ошибка даты");
            return map;
        }
        fourDF.setEndDate(LocalDate.parse(endDate, format));
        fourDF.setTime(LocalDateTime.now());
        map.put("massage", "OK");
        fourDFRepository.save(fourDF);
        return map;
    }

    public DF findById(Long id) {
        return dfRepository.findById(id).get();
    }

    public Iterable<FourDF> findDfFourByDFAndUser(DF dfParent, UserEntity userEntity) {
        return fourDFRepository.findFourDFByDfAndUser(dfParent, userEntity);
    }

    public Iterable<FourDF> findDfFourByDF(DF dfParent) {
        return fourDFRepository.findFourDFByDf(dfParent);
    }

    public Map<String, Object> addUserToDf(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        String dfId = jsonObject.getString("dfId");
        String userId = jsonObject.getString("user");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<UserEntity> userEntityOptional = userService.findUserById(Long.valueOf(userId));
        if (userEntityOptional.isPresent() && userAuthenticated.getRole().equals(Role.ADMIN)){
            Optional<DF> dfOptional = dfRepository.findById(Long.valueOf(dfId));
            if(dfOptional.isPresent()){
                User2DF user2DF = new User2DF();
                DF df = dfOptional.get();
                UserEntity userEntity = userEntityOptional.get();
                user2DF.setUser(userEntity);
                user2DF.setDf(df);
                map.put("massage", "Пользователь " + userEntity.getName() + " добавлен в " + df.getName() + ", период " + df.getPeriod());
                user2DFRepository.save(user2DF);
                return map;
            }
        }
        map.put("massage", "Ошибка записи");
        return map;
    }

    public Map<String, Object> deleteDf4(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long dfDeleteId = jsonObject.getLong("dfDel");
        Long dfDeleteParentId = jsonObject.getLong("dfParent");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<FourDF> fourDFOptional = fourDFRepository.findById(dfDeleteId);
        if(fourDFOptional.isPresent()){
            FourDF fourDF = fourDFOptional.get();
            if(!fourDF.getDf().getId().equals(dfDeleteParentId)){
                map.put("massage", "Ошибка удаления не совпадает родительский DF");
                return map;
            }
            if(!fourDF.getUser().getId().equals(userAuthenticated.getId())){
                map.put("massage", "Ошибка удаления, нельзя удалить чужую запись");
                return map;
            }
            fourDFRepository.delete(fourDF);
            map.put("massage", "Запись удалена");
            return map;
        }
        map.put("massage", "Ошибка удаления, нету такой записи");
        return map;
    }
}
