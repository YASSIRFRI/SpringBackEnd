package com.yassir.demo.Requests;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequest implements Serializable {
    private String teamName;
    private String department;
}
