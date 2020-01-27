package com.quizapp.springREST.responses;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SocietyResponse {

    public SocietyResponse() {
    }

    public SocietyResponse(List<SocEntity> societiesEntities) {
        this.societiesEntities = societiesEntities;
    }

    private List<SocEntity> societiesEntities = new ArrayList<>();



}
