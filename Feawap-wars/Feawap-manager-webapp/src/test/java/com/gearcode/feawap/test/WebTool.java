package com.gearcode.feawap.test;

public class WebTool {
	public static PageIndex getPageIndex(int length, int page, int total) {
		int start = (page <= length / 2 + 1 ? 1 : (page - length / 2));
		int end   = (start + length - 1 >= total ? total : start + length - 1);
		if (end >= total) start = end - length + 1;
		PageIndex pageIndex = new PageIndex(start, end);
		return pageIndex;
	}

	public static void main(String[] args) {
		for(int j=1;j<=100;j++) {
			PageIndex page = getPageIndex(5, j, 100);
			for(int i = page.getFirstIndex(); i <= page.getLastIndex(); i++) System.out.print(i + " ");
			System.out.println("");
		}
	}
}

class PageIndex {
	private int firstIndex;
	private int lastIndex;

	public PageIndex(int firstIndex, int lastIndex) {
		this.firstIndex = firstIndex;
		this.lastIndex = lastIndex;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
}