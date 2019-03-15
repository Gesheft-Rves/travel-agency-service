package com.javastudents.travelagency.entity;

import lombok.*;


@Builder
@ToString
@Getter @Setter
@EqualsAndHashCode
public class DocumentType implements Entity {
    private Integer documentTypeId;
    private String name;

    public DocumentType(Integer documentTypeId, String name) {
        this.documentTypeId = documentTypeId;
        this.name = name;
    }

    public DocumentType() {
    }
}
