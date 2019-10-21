package com.pku.driver;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface MapLookup {
    <V> List<V> lookup(String regularExpression, Map<String,V> map);
}
