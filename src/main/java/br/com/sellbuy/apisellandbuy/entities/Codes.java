package br.com.sellbuy.apisellandbuy.entities;


import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.annotation.Generated;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Strings",
        "Count",
        "Length"
})
@Generated("jsonschema2pojo")
public class Codes {
    @JsonProperty("Strings")
    private List<String> strings=new ArrayList<>();
    @JsonProperty("Count")
    private Long count;
    @JsonProperty("Length")
    private Long length;

    /**
     * No args constructor for use in serialization
     */
    public Codes() {

    }

    /**
     * @param strings
     * @param count
     * @param length
     */
    public Codes(List<String> strings, Long count, Long length) {
        super();
        this.strings = strings;
        this.count = count;
        this.length = length;
    }

    @JsonProperty("Strings")
    public String getString() {
        return strings.get(0);
    }

    @JsonProperty("Strings")
    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    @JsonProperty("Count")
    public Long getCount() {
        return count;
    }

    @JsonProperty("Count")
    public void setCount(Long count) {
        this.count = count;
    }

    @JsonProperty("Length")
    public Long getLength() {
        return length;
    }

    @JsonProperty("Length")
    public void setLength(Long length) {
        this.length = length;
    }




}
