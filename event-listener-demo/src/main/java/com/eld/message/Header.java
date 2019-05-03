package com.eld.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Header {
    private HeaderTypes headerType;
    private String somethingElse;
}
