package com.stefanini.hackaton.rest.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractParse<E, DTO> {

    public abstract E toEntity(DTO dto);
    public abstract DTO toDTO(E e);

    public List<E> toListEntity(List<DTO> dtoList){

        List<E> listEntity = new ArrayList<>();

        for (DTO dto: dtoList) {
            listEntity.add(toEntity(dto));
        }

        return listEntity;
    }

    public List<DTO> toListDTO(List<E> listEntity) {

        List<DTO> dtoList = new ArrayList<>();

        for (E e: listEntity) {
            dtoList.add(toDTO(e));
        }

        return dtoList;
    }

    public List<DTO> toMapDTO(Map<?, E> mapEntity) {

        List<DTO> list = new ArrayList<>();

        for (Map.Entry<?, E> e : mapEntity.entrySet()) {
            list.add(toDTO(e.getValue()));
        }

        return list;
    }
}
