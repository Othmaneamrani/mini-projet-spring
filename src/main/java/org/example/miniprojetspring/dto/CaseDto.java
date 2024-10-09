package org.example.miniprojetspring.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.example.miniprojetspring.config.CustomLocalDateTimeDeserializer;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CaseDto {

    private int caseIdDto;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime creationDateDto;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime lastUpdateDateDto;

    private String titleDto;

    private String descriptionDto;

}
