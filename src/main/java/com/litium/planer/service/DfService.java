package com.litium.planer.service;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.entity.DF;
import com.litium.planer.repo.DfRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DfService {
    private final DfRepository dfRepository;

    public Map<String, Object> addNewDF(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();
        String msg;

//        Long id = jsonObject.getLong("df");
        String df = jsonObject.getString("df");
        String name = jsonObject.getString("name");
        String period = jsonObject.getString("period");

        DF dfEntity = new DF();
        dfEntity.setForm(df);
        dfEntity.setName(name);
        dfEntity.setPeriod(period);

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
}
