package com.example.grid;

import android.content.Intent;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Serializable을 기본적으로 해주자. 데이터를 넘기기위해서 필수적이기 때문!
public class Movie implements Serializable {
    // 객체를 만들 때 자료형은 웹핑된 자료형을 사용하자
    // 데이터를 주고 받기 때문에 toString()을 사용할 경우가 많다.
    private Integer id; // 번호
    private String titile; // 제목
    private Integer pic; // 사진 이미지 URL
    // 만약 DB테이블이 10개면 똑같이 10개의 속성으로 모델화한다.
    // => 나중에 추가적인 데이터가 필요한 경우가 있을 수 있다.
    // 이 후에 앱을 리팩토링할 때 DTO로 바꿔서 수정한다.

}
