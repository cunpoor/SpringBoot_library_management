package com.cp.librarymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookBorrowerDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Integer countBook;
}
