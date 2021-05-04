package com.kuehnenagel.contact.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter @Getter
public class ListResponse<T> {
    int page;
    int limit;
    int total;
    List<T> data;

    public ListResponse(int page, int limit, int total, List<T> data) {
        this.page = page;
        this.limit = limit;
        this.total = total;
        this.data = data;
    }
}
