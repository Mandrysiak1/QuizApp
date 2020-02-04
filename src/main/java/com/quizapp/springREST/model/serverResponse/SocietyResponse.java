package com.quizapp.springREST.model.serverResponse;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SocietyResponse {

    public SocietyResponse() {
    }

    public SocietyResponse(List<SocietyEntity> societiesEntities) {
        this.societiesEntities = societiesEntities;
    }

    private List<SocietyEntity> societiesEntities = new ArrayList<>();



}
