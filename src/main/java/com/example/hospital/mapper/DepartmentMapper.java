package com.example.hospital.mapper;

import com.example.hospital.dao.entity.DepartmentsEntity;
import com.example.hospital.model.request.DepartmentsRequest;
import com.example.hospital.model.response.DepartmentsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.StringUtils;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper MAP = Mappers.getMapper(DepartmentMapper.class);

    default DepartmentsResponse entityToResponse(DepartmentsEntity department) {
        return DepartmentsResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .doctor(DoctorMapper.MAP.entityToResponse(department.getDoctor()))
                .build();
    }

    default void updateDepartmentFields(DepartmentsEntity department,
                                        DepartmentsRequest request) {
        if (StringUtils.hasText(request.getName())) {
            department.setName(request.getName());
        }
    }
}
