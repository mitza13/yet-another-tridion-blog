package com.mitza.toolkit.tag;

import com.mitza.toolkit.dynamic.TagRenderer;

public class MyTag implements TagRenderer {

    public String doTag(String tagBody) {
        // do actual processing here

        return tagBody == null ? null : tagBody.toUpperCase();
    }
}
