package com.gearcode.feawap.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlContentUtils {

	public static String format(String html, String imgSrcPreview) {
		Document doc = Jsoup.parse(html);
	
		if(imgSrcPreview != null && imgSrcPreview.length() > 0) {
			Elements imgs = doc.getElementsByTag("img");
			for (Element img : imgs) {
				String src = img.attr("src");
				if(src.startsWith(imgSrcPreview)) {
					src = src.replaceFirst(imgSrcPreview, "\\$\\{preview\\}");
				}
				img.attr("src", src);
			}
		}
		
		return doc.body().html();
	}
	
	public static String parseImgSrc(String html, String preview) {
		if(html == null || html.length() == 0) {
			return null;
		}
		Document doc = Jsoup.parse(html);
		Elements imgs = doc.getElementsByTag("img");
		for (Element img : imgs) {
			String src = img.attr("src");
			if(src.startsWith("${preview}")) {
				src = src.replaceFirst("\\$\\{preview\\}", preview);
			}
			img.attr("src", src);
		}
		return doc.body().html();
	}
	
	public static void main(String[] args) {
		String html = format("<p>\n    aa bb<img src=\"http://localhost/feawap_upload/consultation/images/IMG_2965.JPG\" alt=\"IMG_2965.JPG\"/>\n</p>\n<p>\n    ns<span style=\"color: rgb(217, 150, 148);\"><strong>afio</strong></span><strong>nwio</strong>an\n</p>", "http://localhost");
		System.out.println(html);
		System.out.println(parseImgSrc(html, "http://localhost"));
	}
}
