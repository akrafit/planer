package com.litium.planer.service;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.dto.*;
import com.litium.planer.entity.*;
import com.litium.planer.model.Role;
import com.litium.planer.model.TypeDF;
import com.litium.planer.model.UserEntity;
import com.litium.planer.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DfService {
    private final DfRepository dfRepository;
    private final FourDFRepository fourDFRepository;
    private final FiveDFRepository fiveDFRepository;
    private final User2DFRepository user2DFRepository;
    private final TwentySevenDFRepository twentySevenDFRepository;
    private final MvzRepository mvzRepository;
    private final SeventeenDFRepository seventeenDFRepository;
    private final TwentyFourDFRepository twentyFourDFRepository;
    private final TwentySixDFRepository twentySixDFRepository;
    private final ThirtyOneDFRepository thirtyOneDFRepository;
    private final ThirtyTwoDFRepository thirtyTwoDFRepository;
    private final ThirtyFourDFRepository thirtyFourDFRepository;
    private final ThirtySixDFRepository thirtySixDFRepository;
    private final EightDFRepository eightDFRepository;
    private final UserService userService;
    private final FourteenDFRepository fourteenDFRepository;
    DateTimeFormatter formatPost = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<Mvz> getMvzList() {
        return mvzRepository.findAll();
    }

    public Iterable<DF> findByUser(UserEntity user) {
        Iterable<User2DF> user2DFS = user2DFRepository.findUser2DFByUser(user);
        List<DF> listDf = new ArrayList<>();
        user2DFS.forEach(user2DF -> listDf.add(user2DF.getDf()));
        return listDf;
    }

    public List<LocalDate> getFirstMonthList() {
        int year = LocalDate.now().getYear();
        ArrayList<LocalDate> firstDateYearList = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
            firstDateYearList.add(firstDayOfMonth);
        }
        return firstDateYearList;
    }

    public DF findById(Long id) {
        return dfRepository.findById(id).get();
    }

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
    }

    public Map<String, Object> addUserToDf(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        String dfId = jsonObject.getString("dfId");
        String userId = jsonObject.getString("user");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<UserEntity> userEntityOptional = userService.findUserById(Long.valueOf(userId));
        if (userEntityOptional.isPresent() && userAuthenticated.getRole().equals(Role.ADMIN)) {
            Optional<DF> dfOptional = dfRepository.findById(Long.valueOf(dfId));
            if (dfOptional.isPresent()) {
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

    public Iterable<DF> findAll() {
        return dfRepository.findAll();
    }
    public Iterable<FourDF> findAllDfFour() {
        return fourDFRepository.findAll();
    }
    public Iterable<FourDF> findDfFourByDFAndUser(DF dfParent, UserEntity userEntity) {
        return fourDFRepository.findFourDFByDfAndUser(dfParent, userEntity);
    }

    public Iterable<FourDF> findDfFourByDF(DF dfParent) {
        return fourDFRepository.findFourDFByDf(dfParent);
    }

    public Iterable<FiveDF> findDfFiveByDF(DF dfParent) {
        return fiveDFRepository.findFiveDFByDf(dfParent);
    }

    public Iterable<EightDF> findDf8ByDF(DF dfParent) {
        return eightDFRepository.findEightDFByDf(dfParent);
    }

    public Iterable<FourteenDF> findDfFourteenByDF(DF dfParent) {
        return fourteenDFRepository.findFourteenDFByDf(dfParent);
    }
    public Iterable<SeventeenDF> findDfSeventeenByDF(DF dfParent) {
        return seventeenDFRepository.findSeventeenDFByDf(dfParent);
    }
    public Iterable<TwentyFourDF> findDf24ByDF(DF dfParent) {
        return twentyFourDFRepository.findTwentyFourDFByDf(dfParent);
    }
    public Iterable<TwentySixDF> findDf26ByDF(DF dfParent) {
        return twentySixDFRepository.findTwentySixDFByDf(dfParent);
    }
    public Iterable<TwentySvenDF> findDf27ByDF(DF dfParent) {
        return twentySevenDFRepository.findTwentySvenDFByDf(dfParent);
    }
    public Iterable<ThirtyOneDF> findDfThirtyOneDFIterable(DF dfParent) {
        return thirtyOneDFRepository.findThirtyOneDFByDf(dfParent);
    }
    public Iterable<ThirtyTwoDF> findDfThirtyTwoDFIterable(DF dfParent) {
        return thirtyTwoDFRepository.findThirtyTwoDFByDf(dfParent);
    }
    public Iterable<ThirtyFourDF> findDfThirtyFourDFIterable(DF dfParent) {
        return thirtyFourDFRepository.findThirtyFourDFByDf(dfParent);
    }
    public Iterable<ThirtySixDF> findDf36ByDF(DF dfParent) {
        return thirtySixDFRepository.findThirtySixDFByDf(dfParent);
    }
    public Map<String, Object> addNewDf4(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(jsonObject.getLong("dfid"));
        UserEntity userEntity = userService.getUserByName(name);
        FourDF fourDF = new FourDF();
        fourDF.setUser(userEntity);
        if (dfParent.isPresent()) {
            fourDF.setDf(dfParent.get());
        } else {
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
        if (endDate.isEmpty()) {
            map.put("massage", "Ошибка даты");
            return map;
        }
        fourDF.setEndDate(LocalDate.parse(endDate, format));
        fourDF.setTime(LocalDateTime.now());
        map.put("massage", "OK");
        fourDFRepository.save(fourDF);
        return map;
    }

    public Map<String, Object> addNewDf5(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(jsonObject.getLong("dfId"));
        UserEntity userEntity = userService.getUserByName(name);
        FiveDF fiveDF = new FiveDF();
        fiveDF.setUser(userEntity);
        if (dfParent.isPresent()) {
            fiveDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        fiveDF.setOilfield(jsonObject.getString("oilField"));
        fiveDF.setExpWater(jsonObject.getString("expWater"));
        fiveDF.setMedWater(jsonObject.getString("medWater"));
        fiveDF.setExpPump(jsonObject.getString("expPump"));
        fiveDF.setMedPump(jsonObject.getString("medPump"));
        fiveDF.setExpHydro(jsonObject.getString("expHydro"));
        fiveDF.setMedHydro(jsonObject.getString("medHydro"));
        fiveDF.setComment(jsonObject.getString("comment"));
        fiveDF.setDate(LocalDate.parse(jsonObject.getString("datePeriod"), format));
        fiveDF.setTime(LocalDateTime.now());
        map.put("massage", "OK");
        fiveDFRepository.save(fiveDF);
        return map;
    }

    public Map<String, Object> addNewDf8(EightDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        EightDF eightDF = new EightDF(dfDto);
        eightDF.setUser(userEntity);
        eightDF.setTime(LocalDateTime.now());
        if (dfParent.isPresent()) {
            eightDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        eightDFRepository.save(eightDF);
        return map;
    }
    public Map<String, Object> addNewDf14(FourteenDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        Mvz mvz = mvzRepository.getReferenceById(dfDto.getMvz());
        FourteenDF fourteenDF = new FourteenDF(dfDto);
        fourteenDF.setUser(userEntity);
        fourteenDF.setTime(LocalDateTime.now());
        fourteenDF.setMvz(mvz);
        if (dfParent.isPresent()) {
            fourteenDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        fourteenDFRepository.save(fourteenDF);
        return map;
    }

    public Map<String, Object> addNewDf17(SeventeenDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        Mvz mvz = mvzRepository.getReferenceById(dfDto.getMvz());
        SeventeenDF seventeenDF = new SeventeenDF(dfDto);
        seventeenDF.setUser(userEntity);
        seventeenDF.setTime(LocalDateTime.now());
        seventeenDF.setMvz(mvz);
        if (dfParent.isPresent()) {
            seventeenDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        seventeenDFRepository.save(seventeenDF);
        return map;
    }

    public Map<String, Object> addNewDf24(TwentyFourDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        Mvz mvz = mvzRepository.getReferenceById(dfDto.getMvz());
        TwentyFourDF twentyFourDF = new TwentyFourDF(dfDto);
        twentyFourDF.setUser(userEntity);
        twentyFourDF.setTime(LocalDateTime.now());
        twentyFourDF.setMvz(mvz);
        if (dfParent.isPresent()) {
            twentyFourDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        twentyFourDFRepository.save(twentyFourDF);
        return map;
    }

    public Map<String, Object> addNewDf26(TwentySixDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        Mvz mvz = mvzRepository.getReferenceById(dfDto.getMvz());
        TwentySixDF twentySixDF = new TwentySixDF(dfDto);
        twentySixDF.setUser(userEntity);
        twentySixDF.setTime(LocalDateTime.now());
        twentySixDF.setMvz(mvz);
        if (dfParent.isPresent()) {
            twentySixDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        twentySixDFRepository.save(twentySixDF);
        return map;
    }

    public Map<String, Object> addNewDf27(TwentySvenDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        Mvz mvz = mvzRepository.getReferenceById(dfDto.getMvz());
        TwentySvenDF twentySvenDF = new TwentySvenDF(dfDto);
        twentySvenDF.setUser(userEntity);
        twentySvenDF.setTime(LocalDateTime.now());
        twentySvenDF.setMvz(mvz);
        if (dfParent.isPresent()) {
            twentySvenDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        twentySevenDFRepository.save(twentySvenDF);
        return map;
    }

    public Map<String, Object> addNewDf32(ThirtyTwoDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        Mvz mvz = mvzRepository.getReferenceById(dfDto.getMvz());
        ThirtyTwoDF thirtyTwoDF = new ThirtyTwoDF(dfDto);
        thirtyTwoDF.setUser(userEntity);
        thirtyTwoDF.setTime(LocalDateTime.now());
        thirtyTwoDF.setMvz(mvz);
        if (dfParent.isPresent()) {
            thirtyTwoDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        thirtyTwoDFRepository.save(thirtyTwoDF);
        return map;
    }

    public Map<String, Object> addNewDf31(ThirtyOneDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        Mvz mvz = mvzRepository.getReferenceById(dfDto.getMvz());
        ThirtyOneDF thirtyOneDF = new ThirtyOneDF(dfDto);
        thirtyOneDF.setUser(userEntity);
        thirtyOneDF.setTime(LocalDateTime.now());
        thirtyOneDF.setMvz(mvz);
        if (dfParent.isPresent()) {
            thirtyOneDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        thirtyOneDFRepository.save(thirtyOneDF);
        return map;
    }

    public Map<String, Object> addNewDf34(ThirtyFourDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        Mvz mvz = mvzRepository.getReferenceById(dfDto.getMvz());
        ThirtyFourDF thirtyFourDF = new ThirtyFourDF(dfDto);
        thirtyFourDF.setUser(userEntity);
        thirtyFourDF.setTime(LocalDateTime.now());
        thirtyFourDF.setMvz(mvz);
        if (dfParent.isPresent()) {
            thirtyFourDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        thirtyFourDFRepository.save(thirtyFourDF);
        return map;
    }

    public Map<String, Object> addNewDf36(ThirtySixDFDto dfDto, String name) {
        Map<String, Object> map = new HashMap<>();
        Optional<DF> dfParent = dfRepository.findById(dfDto.getDfId());
        UserEntity userEntity = userService.getUserByName(name);
        Mvz mvz = mvzRepository.getReferenceById(dfDto.getMvz());
        ThirtySixDF thirtySixDF = new ThirtySixDF(dfDto);
        thirtySixDF.setUser(userEntity);
        thirtySixDF.setTime(LocalDateTime.now());
        thirtySixDF.setMvz(mvz);
        if (dfParent.isPresent()) {
            thirtySixDF.setDf(dfParent.get());
        } else {
            map.put("massage", "Не найден родительский ДФ");
            return map;
        }
        map.put("massage", "OK");
        thirtySixDFRepository.save(thirtySixDF);
        return map;
    }

    public Map<String, Object> deleteDf(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long dfDeleteId = jsonObject.getLong("dfDel");
        Long dfDeleteParentId = jsonObject.getLong("dfParent");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<DF> dfOptional = dfRepository.findById(dfDeleteParentId);
        if (dfOptional.isPresent()) {
            DF dfBig = dfOptional.get();
            switch (dfBig.getType()) {
                case DF4 -> {
                    Optional<FourDF> fourDFOptional = fourDFRepository.findById(dfDeleteId);
                    if (fourDFOptional.isPresent() && fourDFOptional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        fourDFRepository.delete(fourDFOptional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF5 -> {
                    Optional<FiveDF> optional = fiveDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        fiveDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF8 -> {
                    Optional<EightDF> optional = eightDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        eightDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF14 -> {
                    Optional<FourteenDF> optional = fourteenDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        fourteenDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF17 -> {
                    Optional<SeventeenDF> optional = seventeenDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        seventeenDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF24 -> {
                    Optional<TwentyFourDF> optional = twentyFourDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        twentyFourDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF26 -> {
                    Optional<TwentySixDF> optional = twentySixDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        twentySixDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF27 -> {
                    Optional<TwentySvenDF> optional = twentySevenDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        twentySevenDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF31 -> {
                    Optional<ThirtyOneDF> optional = thirtyOneDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        thirtyOneDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF32 -> {
                    Optional<ThirtyTwoDF> optional = thirtyTwoDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        thirtyTwoDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF34 -> {
                    Optional<ThirtyFourDF> optional = thirtyFourDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        thirtyFourDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
                case DF36 -> {
                    Optional<ThirtySixDF> optional = thirtySixDFRepository.findById(dfDeleteId);
                    if (optional.isPresent() && optional.get().getUser().getId().equals(userAuthenticated.getId())) {
                        thirtySixDFRepository.delete(optional.get());
                    } else {
                        sendErr(map);
                        return map;
                    }
                }
            }
            map.put("massage", "Запись удалена !");
            return map;
        } else {
            map.put("massage", "Ошибка удаления не совпадает родительский DF");
        }
        return map;
    }

    private void sendErr(Map<String, Object> map) {
        map.put("massage", "Ошибка удаления, нельзя удалить чужую запись");
    }

    public Iterable<TwentySvenDF> findDf27ByDFAndUser(DF dfParent, UserEntity userEntity) {
        return twentySevenDFRepository.findTwentySvenDFByDfAndAndUser(dfParent, userEntity);
    }
}
