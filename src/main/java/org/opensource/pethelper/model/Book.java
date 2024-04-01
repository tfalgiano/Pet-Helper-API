package org.opensource.pethelper.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book {
    private Long id;
    private String title;
    private String author;
    private String test;
}
