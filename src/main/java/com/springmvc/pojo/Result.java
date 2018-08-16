package com.springmvc.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("result")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "value" })
public class Result {
        @XStreamAsAttribute()
        private String name;
        private String value;


        public String getName() {
        return name;
        }
        public void setName(String name) {
        this.name = name;
        }


        public String getValue() {
        return value;
        }
        public void setValue(String value) {
        this.value = value;
        }
        }