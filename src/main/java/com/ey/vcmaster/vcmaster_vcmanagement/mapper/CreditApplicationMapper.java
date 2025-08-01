package com.ey.vcmaster.vcmaster_vcmanagement.mapper;

import com.ey.vcmaster.vcmaster_vcmanagement.dto.CreditApplicationDTO;
import com.ey.vcmaster.vcmaster_vcmanagement.entity.CreditApplication;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditApplicationMapper {
    CreditApplicationDTO toDto(CreditApplication entity);
    CreditApplication toEntity(CreditApplicationDTO dto);
    List<CreditApplicationDTO> toDtoList(List<CreditApplication> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCreditApplication(CreditApplicationDTO dto, @MappingTarget CreditApplication entity);
}
