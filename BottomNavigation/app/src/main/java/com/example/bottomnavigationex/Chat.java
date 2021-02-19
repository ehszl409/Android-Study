package com.example.bottomnavigationex;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat implements Serializable {
    private Integer id;
    private String username;
    private String msg;
    private String info;
    private Integer img;

}
