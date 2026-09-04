package com.example.Labwork_1.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Dates {

    @Column(name = "begin_date")
    private String begin;

    @Column(name = "end_date")
    private String end;

    public Dates() {
    }

    public Dates(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}