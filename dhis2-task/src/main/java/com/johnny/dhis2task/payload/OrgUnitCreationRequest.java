package com.johnny.dhis2task.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hisp.dhis.model.OrgUnit;

import javax.validation.constraints.NotBlank;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrgUnitCreationRequest {
    private String code;
    private String name;
    private String shortName;
    private String description;
    private Integer level;
    @JsonIgnore
    private OrgUnit parent;
    @NotBlank
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private Date openingDate;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private Date closeDate;
    private String comment;
    private String url;
    private String contactPerson;
    private String address;
    private String email;
    private String phoneNumber;
}
