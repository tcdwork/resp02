package com.site.blog.my.core.util;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public class MarkDownUtil {

    private static final java.util.List<Extension> EXTENSIONS = Arrays.asList(TablesExtension.create());
    private static final Parser PARSER = Parser.builder().extensions(EXTENSIONS).build();
    private static final HtmlRenderer HTML_RENDERER = HtmlRenderer.builder().extensions(EXTENSIONS).build();

    /**
     * 转换md格式为html
     *
     * @param markdownString
     * @return
     */
    public static String mdToHtml(String markdownString) {
        if (!StringUtils.hasText(markdownString)) {
            return "";
        }
        Node document = PARSER.parse(markdownString);
        return HTML_RENDERER.render(document);
    }
}
