package com.miri.blephone.mediainjector.controller;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rsp<T> {

    int     draw;
    int     recordsTotal;
    int     recordsFiltered;

    List<T> data;
}
