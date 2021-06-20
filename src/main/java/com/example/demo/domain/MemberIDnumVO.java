package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MemberIDnumVO {
    private String mem_idnum;

    // for deserialisation
    // Default behaviour of the Jackson library
    // https://stackoverflow.com/questions/48448079/json-parse-error-can-not-construct-instance-of-io-starter-topic-topic/48448121
    public MemberIDnumVO() {}

    public MemberIDnumVO(String mem_idnum) {
        this.mem_idnum = mem_idnum;
    }
}
