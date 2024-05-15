package com.litium.planer.service;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.dto.SeventeenDFDto;
import com.litium.planer.dto.ThirtyOneDFDto;
import com.litium.planer.dto.ThirtyTwoDFDto;
import com.litium.planer.dto.TwentySvenDFDto;
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
    private final TwentySevenCellRepository twentySevenCellRepository;
    private final MvzRepository mvzRepository;
    private final SeventeenDFRepository seventeenDFRepository;
    private final ThirtyTwoDFRepository thirtyTwoDFRepository;
    private final ThirtyOneDFRepository thirtyOneDFRepository;
    private final ThirtyOneCellRepository thirtyOneCellRepository;
    private final TwentySixDFRepository twentySixDFRepository;
    private final TwentySixCellRepository twentySixCellRepository;
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

    public Map<String, Object> deleteDf4(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long dfDeleteId = jsonObject.getLong("dfDel");
        Long dfDeleteParentId = jsonObject.getLong("dfParent");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<FourDF> fourDFOptional = fourDFRepository.findById(dfDeleteId);
        if (fourDFOptional.isPresent()) {
            FourDF fourDF = fourDFOptional.get();
            if (!fourDF.getDf().getId().equals(dfDeleteParentId)) {
                map.put("massage", "Ошибка удаления не совпадает родительский DF");
                return map;
            }
            if (!fourDF.getUser().getId().equals(userAuthenticated.getId())) {
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

    public Iterable<FiveDF> findDfFiveByDF(DF dfParent) {
        return fiveDFRepository.findFiveDFByDf(dfParent);
    }

    public Iterable<SeventeenDF> findDfSeventeenByDF(DF dfParent) {
        return seventeenDFRepository.findSeventeenDFByDf(dfParent);
    }

    public Iterable<ThirtyTwoDF> findDfThirtyTwoDFIterable(DF dfParent) {
        return thirtyTwoDFRepository.findThirtyTwoDFByDf(dfParent);
    }
    public Iterable<ThirtyOneDF> findDfThirtyOneDFIterable(DF dfParent) {
        return thirtyOneDFRepository.findThirtyOneDFByDf(dfParent);
    }
    public Iterable<TwentySixDF> findDf26ByDF(DF dfParent) {
        return twentySixDFRepository.findTwentySixDFByDf(dfParent);
    }

    public DF findById(Long id) {
        return dfRepository.findById(id).get();
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

    public Map<String, Object> deleteDf5(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long dfDeleteId = jsonObject.getLong("dfDel");
        Long dfDeleteParentId = jsonObject.getLong("dfParent");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<FiveDF> fiveDFOptional = fiveDFRepository.findById(dfDeleteId);
        if (fiveDFOptional.isPresent()) {
            FiveDF fiveDF = fiveDFOptional.get();
            if (!fiveDF.getDf().getId().equals(dfDeleteParentId)) {
                map.put("massage", "Ошибка удаления не совпадает родительский DF");
                return map;
            }
            if (!fiveDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка удаления, нельзя удалить чужую запись");
                return map;
            }
            fiveDFRepository.delete(fiveDF);
            map.put("massage", "Запись удалена");
            return map;
        }
        map.put("massage", "Ошибка удаления, нету такой записи");
        return map;
    }

    public Iterable<TwentySvenDF> findDf27ByDF(DF dfParent) {
        return twentySevenDFRepository.findTwentySvenDFByDf(dfParent);
    }

    public List<Mvz> getMvzList() {
        return mvzRepository.findAll();
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

    public Map<String, Object> deleteDf27(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long dfDeleteId = jsonObject.getLong("dfDel");
        Long dfDeleteParentId = jsonObject.getLong("dfParent");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<TwentySvenDF> twentySvenDFOptional = twentySevenDFRepository.findById(dfDeleteId);
        if (twentySvenDFOptional.isPresent()) {
            TwentySvenDF twentySvenDF = twentySvenDFOptional.get();
            if (!twentySvenDF.getDf().getId().equals(dfDeleteParentId)) {
                map.put("massage", "Ошибка удаления не совпадает родительский DF");
                return map;
            }
            if (!twentySvenDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка удаления, нельзя удалить чужую запись");
                return map;
            }
            twentySevenDFRepository.delete(twentySvenDF);
            map.put("massage", "Запись удалена");
            return map;
        }
        map.put("massage", "Ошибка удаления, нету такой записи");
        return map;
    }

    public Map<String, Object> addDf27MonthValue(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long values = jsonObject.getLong("values");
        String codeId = jsonObject.getString("parent");
        String[] array = codeId.split("_");
        Long dfParentId = Long.parseLong(array[0]);
        LocalDate period = LocalDate.ofEpochDay(Long.parseLong(array[1]));
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<TwentySvenDF> twentySvenDFOptional = twentySevenDFRepository.findById(dfParentId);
        if (twentySvenDFOptional.isPresent()) {
            TwentySvenDF twentySvenDF = twentySvenDFOptional.get();
            if (!twentySvenDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка редактирования, нельзя редактировать чужую запись");
                return map;
            }
            Optional<TwentySevenCell> twentySevenCellIterable = twentySevenCellRepository.findTwentySevenCellByPeriodAndDf(period, twentySvenDF);
            TwentySevenCell twentySevenCell;
            if (twentySevenCellIterable.isPresent()) {
                twentySevenCell = twentySevenCellIterable.get();
            } else {
                twentySevenCell = new TwentySevenCell();
                twentySevenCell.setUser(userAuthenticated);
                twentySevenCell.setPeriod(period);
                twentySevenCell.setDf(twentySvenDF);
            }
            twentySevenCell.setValue(values);
            twentySevenCell.setTime(LocalDateTime.now());
            twentySevenCellRepository.save(twentySevenCell);
            map.put("massage", "");
            return map;
        }
//        map.put("massage", "Ошибка удаления, нету такой записи");
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

    public Map<String, Object> deleteDf17(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long dfDeleteId = jsonObject.getLong("dfDel");
        Long dfDeleteParentId = jsonObject.getLong("dfParent");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<SeventeenDF> seventeenDFOptional = seventeenDFRepository.findById(dfDeleteId);
        if (seventeenDFOptional.isPresent()) {
            SeventeenDF seventeenDF = seventeenDFOptional.get();
            if (!seventeenDF.getDf().getId().equals(dfDeleteParentId)) {
                map.put("massage", "Ошибка удаления не совпадает родительский DF");
                return map;
            }
            if (!seventeenDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка удаления, нельзя удалить чужую запись");
                return map;
            }
            seventeenDFRepository.delete(seventeenDF);
            map.put("massage", "Запись удалена");
            return map;
        }
        map.put("massage", "Ошибка удаления, нету такой записи");
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

    public Map<String, Object> deleteDf32(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long dfDeleteId = jsonObject.getLong("dfDel");
        Long dfDeleteParentId = jsonObject.getLong("dfParent");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<ThirtyTwoDF> thirtyTwoDFOptional = thirtyTwoDFRepository.findById(dfDeleteId);
        if (thirtyTwoDFOptional.isPresent()) {
            ThirtyTwoDF thirtyTwoDF = thirtyTwoDFOptional.get();
            if (!thirtyTwoDF.getDf().getId().equals(dfDeleteParentId)) {
                map.put("massage", "Ошибка удаления не совпадает родительский DF");
                return map;
            }
            if (!thirtyTwoDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка удаления, нельзя удалить чужую запись");
                return map;
            }
            thirtyTwoDFRepository.delete(thirtyTwoDF);
            map.put("massage", "Запись удалена");
            return map;
        }
        map.put("massage", "Ошибка удаления, нету такой записи");
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

    public Map<String, Object> deleteDf31(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long dfDeleteId = jsonObject.getLong("dfDel");
        Long dfDeleteParentId = jsonObject.getLong("dfParent");
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<ThirtyOneDF> thirtyOneDFOptional = thirtyOneDFRepository.findById(dfDeleteId);
        if (thirtyOneDFOptional.isPresent()) {
            ThirtyOneDF thirtyOneDF = thirtyOneDFOptional.get();
            if (!thirtyOneDF.getDf().getId().equals(dfDeleteParentId)) {
                map.put("massage", "Ошибка удаления не совпадает родительский DF");
                return map;
            }
            if (!thirtyOneDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка удаления, нельзя удалить чужую запись");
                return map;
            }
            thirtyOneDFRepository.delete(thirtyOneDF);
            map.put("massage", "Запись удалена");
            return map;
        }
        map.put("massage", "Ошибка удаления, нету такой записи");
        return map;
    }

    public Map<String, Object> addDf31MonthValue(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long values = jsonObject.getLong("values");
        String codeId = jsonObject.getString("parent");
        String[] array = codeId.split("_");
        Long dfParentId = Long.parseLong(array[0]);
        LocalDate period = LocalDate.ofEpochDay(Long.parseLong(array[1]));
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<ThirtyOneDF> thirtyOneDFOptional = thirtyOneDFRepository.findById(dfParentId);
        if (thirtyOneDFOptional.isPresent()) {
            ThirtyOneDF thirtyOneDF = thirtyOneDFOptional.get();
            if (!thirtyOneDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка редактирования, нельзя редактировать чужую запись");
                return map;
            }
            Optional<ThirtyOneCell> thirtyOneCellOptional = thirtyOneCellRepository.findThirtyOneCellByPeriodAndDf(period, thirtyOneDF);
            ThirtyOneCell thirtyOneCell;
            if (thirtyOneCellOptional.isPresent()) {
                thirtyOneCell = thirtyOneCellOptional.get();
            } else {
                thirtyOneCell = new ThirtyOneCell();
                thirtyOneCell.setUser(userAuthenticated);
                thirtyOneCell.setPeriod(period);
                thirtyOneCell.setDf(thirtyOneDF);
            }
            thirtyOneCell.setValue(values);
            thirtyOneCell.setTime(LocalDateTime.now());
            thirtyOneCellRepository.save(thirtyOneCell);
            map.put("massage", "");
            return map;
        }
        return map;
    }


}
