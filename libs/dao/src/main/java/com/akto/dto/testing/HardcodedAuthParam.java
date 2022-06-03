package com.akto.dto.testing;

import com.akto.dto.HttpRequestParams;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HardcodedAuthParam extends AuthParam {
    private Location where;
    private String key;
    private String value;


    public HardcodedAuthParam() { }

    public HardcodedAuthParam(Location where, String key, String value) {
        this.where = where;
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean addAuthTokens(HttpRequestParams httpRequestParams) {
        Map<String, List<String>> headers = httpRequestParams.getHeaders();
        if (!headers.containsKey(this.key)) return false;
        headers.put(this.key, Collections.singletonList(this.value));
        return true;
    }

    @Override
    public boolean removeAuthTokens(HttpRequestParams httpRequestParams) {
        Map<String, List<String>> headers = httpRequestParams.getHeaders();
        if (!headers.containsKey(this.key)) return false;
        headers.put(this.key, Collections.singletonList(null));
        return true;
    }

    public Location getWhere() {
        return where;
    }

    public void setWhere(Location where) {
        this.where = where;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
