package com.hdxy.esdemo.demo01.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;

/**
 * @author wzh
 * @Description
 * @create 2020-12-12 15:03
 */
public class Reptile {
    private static String uri = "https://search.jd.com/Search?keyword=java&page=3";
//    Jsoup.parse

    public static void main(String[] args) throws Exception {
        Document document = Jsoup.parse(new URL(uri), 3000);
        Elements elements = document.getElementsByClass("gl-item");
        Iterator<Element> iterator = elements.iterator();
        for (Element element : elements) {
            String pName = getDataByClass(element, "p-name", "em");
            String pPrice = getDataByClass(element, "p-price", "i");
            String pCommit = getDataByClass(element, "p-commit", "strong");
            String pShopnum = getDataByClass(element, "p-shopnum", "a");
            System.out.println("名称：" + pName);
            System.out.println("价格：" + pPrice);
            System.out.println("评论数量：" + pCommit);
            System.out.println("出版社：" + pShopnum);
            System.out.println();
        }


    }

    public static String getDataByClass(Element element, String className, String tagName) {
        return element.getElementsByClass(className).first()
                .getElementsByTag(tagName).first().html();
    }

}
