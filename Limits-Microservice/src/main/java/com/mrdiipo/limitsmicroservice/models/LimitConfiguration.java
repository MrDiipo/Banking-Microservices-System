package com.mrdiipo.limitsmicroservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
public class LimitConfiguration {

    private int maximum;
   private int minimum;

    protected LimitConfiguration() {
    }
}
