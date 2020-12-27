package com.example.ant.practice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-11-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;


}
