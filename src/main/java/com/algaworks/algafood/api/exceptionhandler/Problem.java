package com.algaworks.algafood.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
public class Problem {

    private Integer status;
    private OffsetDateTime timestamp;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private List<Object> objects;

    @Getter
    @Builder
    public static class Object {
        private String name;
        private String userMessage;
    }

}
