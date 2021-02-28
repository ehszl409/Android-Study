package com.example.firestore01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Park {
    private String id;
    private String name;
    private String gender;
    private Integer age;
    private String job;
}
