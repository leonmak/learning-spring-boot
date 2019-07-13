package com.leon.learningspringboot.reactivewebapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // @ToString, @EqualsAndHashCode, @Getter on all fields, @Setter on all non-final fields
@NoArgsConstructor  // for `create(@RequestBody Flux<Image> images)` to parse json
@AllArgsConstructor // for constructor new Image("1", "reading.jpg")
public class Image {
  private String id;
  private String name;
}