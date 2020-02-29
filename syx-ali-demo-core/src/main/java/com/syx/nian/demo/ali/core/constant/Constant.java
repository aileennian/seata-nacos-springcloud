package com.syx.nian.demo.ali.core.constant;

import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

public class Constant {
    public static List<MediaType> SupportedMediaTypes = new ArrayList<>(17);
    static{
        SupportedMediaTypes.add(MediaType.APPLICATION_JSON);
        SupportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        SupportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        SupportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        SupportedMediaTypes.add(MediaType.APPLICATION_PDF);
        SupportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        SupportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        SupportedMediaTypes.add(MediaType.APPLICATION_XML);
        SupportedMediaTypes.add(MediaType.IMAGE_GIF);
        SupportedMediaTypes.add(MediaType.IMAGE_JPEG);
        SupportedMediaTypes.add(MediaType.IMAGE_PNG);
        SupportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        SupportedMediaTypes.add(MediaType.TEXT_HTML);
        SupportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        SupportedMediaTypes.add(MediaType.TEXT_PLAIN);
        SupportedMediaTypes.add(MediaType.TEXT_XML);
    }
}
