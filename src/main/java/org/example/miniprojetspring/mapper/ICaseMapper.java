package org.example.miniprojetspring.mapper;


import org.example.miniprojetspring.dto.CaseDto;
import org.example.miniprojetspring.entity.Case;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICaseMapper {



    @Mappings({
            @Mapping(source = "caseIdDto" , target = "caseId"),
            @Mapping(source = "creationDateDto" , target = "creationDate"),
            @Mapping(source = "lastUpdateDateDto" , target = "lastUpdateDate"),
            @Mapping(source = "titleDto" , target = "title"),
            @Mapping(source = "descriptionDto" , target = "description"),
    })
    Case convertDtoToEntity(CaseDto caseDto);


    @Mappings({
            @Mapping(source = "caseId" , target = "caseIdDto"),
            @Mapping(source = "creationDate" , target = "creationDateDto"),
            @Mapping(source = "lastUpdateDate" , target = "lastUpdateDateDto"),
            @Mapping(source = "title" , target = "titleDto"),
            @Mapping(source = "description" , target = "descriptionDto"),
    })
    CaseDto convertEntityToDto(Case aCase);


}
