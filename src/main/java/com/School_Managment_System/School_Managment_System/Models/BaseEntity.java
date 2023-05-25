package com.School_Managment_System.School_Managment_System.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Data
@Entity
public class BaseEntity {
    Date createdDate;
    Boolean isActive;
    Date updateDate;
}
