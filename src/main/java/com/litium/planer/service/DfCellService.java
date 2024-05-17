package com.litium.planer.service;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.entity.*;
import com.litium.planer.entity.cell.*;
import com.litium.planer.model.UserEntity;
import com.litium.planer.repo.*;
import com.litium.planer.repo.cell.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DfCellService {
    private final TwentySevenCellRepository twentySevenCellRepository;
    private final TwentyFourCellRepository twentyFourCellRepository;
    private final TwentySixCellRepository twentySixCellRepository;
    private final ThirtyOneCellRepository thirtyOneCellRepository;
    private final ThirtySixCellRepository thirtySixCellRepository;

    private final EightCellRepository eightCellRepository;
    private final EightDFRepository eightDFRepository;
    private final UserService userService;
    private final TwentySevenDFRepository twentySevenDFRepository;
    private final TwentyFourDFRepository twentyFourDFRepository;
    private final TwentySixDFRepository twentySixDFRepository;
    private final ThirtyOneDFRepository thirtyOneDFRepository;
    private final ThirtySixDFRepository thirtySixDFRepository;

    public Map<String, Object> addDf8MonthValue(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long values = jsonObject.getLong("values");
        String codeId = jsonObject.getString("parent");
        String[] array = codeId.split("_");
        Long dfParentId = Long.parseLong(array[0]);
        LocalDate period = LocalDate.ofEpochDay(Long.parseLong(array[1]));
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<EightDF> eightDFOptional = eightDFRepository.findById(dfParentId);
        if (eightDFOptional.isPresent()) {
            EightDF eightDF = eightDFOptional.get();
            if (!eightDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка редактирования, нельзя редактировать чужую запись");
                return map;
            }
            Optional<EightCell> eightCellOptional = eightCellRepository.findEightCellByPeriodAndDf(period, eightDF);
            EightCell eightCell;
            if (eightCellOptional.isPresent()) {
                eightCell = eightCellOptional.get();
            } else {
                eightCell = new EightCell();
                eightCell.setUser(userAuthenticated);
                eightCell.setPeriod(period);
                eightCell.setDf(eightDF);
            }
            eightCell.setValue(values);
            eightCell.setTime(LocalDateTime.now());
            eightCellRepository.save(eightCell);
            map.put("massage", "");
            return map;
        }
        return map;
    }
    public Map<String, Object> addDf24MonthValue(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long values = jsonObject.getLong("values");
        String codeId = jsonObject.getString("parent");
        String[] array = codeId.split("_");
        Long dfParentId = Long.parseLong(array[0]);
        LocalDate period = LocalDate.ofEpochDay(Long.parseLong(array[1]));
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<TwentyFourDF> twentyFourDFOptional = twentyFourDFRepository.findById(dfParentId);
        if (twentyFourDFOptional.isPresent()) {
            TwentyFourDF twentyFourDF = twentyFourDFOptional.get();
            if (!twentyFourDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка редактирования, нельзя редактировать чужую запись");
                return map;
            }
            Optional<TwentyFourCell> twentyFourCellIterable = twentyFourCellRepository.findTwentyFourCellByPeriodAndDf(period, twentyFourDF);
            TwentyFourCell twentyFourCell;
            if (twentyFourCellIterable.isPresent()) {
                twentyFourCell = twentyFourCellIterable.get();
            } else {
                twentyFourCell = new TwentyFourCell();
                twentyFourCell.setUser(userAuthenticated);
                twentyFourCell.setPeriod(period);
                twentyFourCell.setDf(twentyFourDF);
            }
            twentyFourCell.setValue(values);
            twentyFourCell.setTime(LocalDateTime.now());
            twentyFourCellRepository.save(twentyFourCell);
            map.put("massage", "");
            return map;
        }
        return map;
    }
    public Map<String, Object> addDf26MonthValue(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long values = jsonObject.getLong("values");
        String codeId = jsonObject.getString("parent");
        String[] array = codeId.split("_");
        Long dfParentId = Long.parseLong(array[0]);
        LocalDate period = LocalDate.ofEpochDay(Long.parseLong(array[1]));
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<TwentySixDF> twentySixDFOptional = twentySixDFRepository.findById(dfParentId);
        if (twentySixDFOptional.isPresent()) {
            TwentySixDF twentySixDF = twentySixDFOptional.get();
            if (!twentySixDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка редактирования, нельзя редактировать чужую запись");
                return map;
            }
            Optional<TwentySixCell> twentySixCellIterable = twentySixCellRepository.findTwentySixCellByPeriodAndDf(period, twentySixDF);
            TwentySixCell twentySixCell;
            if (twentySixCellIterable.isPresent()) {
                twentySixCell = twentySixCellIterable.get();
            } else {
                twentySixCell = new TwentySixCell();
                twentySixCell.setUser(userAuthenticated);
                twentySixCell.setPeriod(period);
                twentySixCell.setDf(twentySixDF);
            }
            twentySixCell.setValue(values);
            twentySixCell.setTime(LocalDateTime.now());
            twentySixCellRepository.save(twentySixCell);
            map.put("massage", "");
            return map;
        }
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
    public Map<String, Object> addDf36MonthValue(JSONObject jsonObject, String name) {
        Map<String, Object> map = new HashMap<>();
        Long values = jsonObject.getLong("values");
        String codeId = jsonObject.getString("parent");
        String[] array = codeId.split("_");
        Long dfParentId = Long.parseLong(array[0]);
        LocalDate period = LocalDate.ofEpochDay(Long.parseLong(array[1]));
        UserEntity userAuthenticated = userService.getUserByName(name);
        Optional<ThirtySixDF> thirtySixDFOptional = thirtySixDFRepository.findById(dfParentId);
        if (thirtySixDFOptional.isPresent()) {
            ThirtySixDF thirtySixDF = thirtySixDFOptional.get();
            if (!thirtySixDF.getUser().getId().equals(userAuthenticated.getId())) {
                map.put("massage", "Ошибка редактирования, нельзя редактировать чужую запись");
                return map;
            }
            Optional<ThirtySixCell> thirtySixCellIterable = thirtySixCellRepository.findThirtySixCellByPeriodAndDf(period, thirtySixDF);
            ThirtySixCell thirtySixCell;
            if (thirtySixCellIterable.isPresent()) {
                thirtySixCell = thirtySixCellIterable.get();
            } else {
                thirtySixCell = new ThirtySixCell();
                thirtySixCell.setUser(userAuthenticated);
                thirtySixCell.setPeriod(period);
                thirtySixCell.setDf(thirtySixDF);
            }
            thirtySixCell.setValue(values);
            thirtySixCell.setTime(LocalDateTime.now());
            thirtySixCellRepository.save(thirtySixCell);
            map.put("massage", "");
            return map;
        }
        return map;
    }
}
