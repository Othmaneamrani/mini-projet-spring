package org.example.miniprojetspring.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;
import org.example.miniprojetspring.config.CustomLocalDateTimeDeserializer;

import java.time.LocalDateTime;

@Entity
@Table(name = "cases_table")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caseId;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime creationDate;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime lastUpdateDate;

    private String title;

    private String description;

}
