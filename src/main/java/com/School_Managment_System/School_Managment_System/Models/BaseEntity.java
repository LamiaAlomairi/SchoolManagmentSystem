package com.School_Managment_System.School_Managment_System.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@Data
public class BaseEntity {
    private Boolean isActive;
    private Date createdDate;
    private Date updateDate;
}
