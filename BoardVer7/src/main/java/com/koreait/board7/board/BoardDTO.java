package com.koreait.board7.board;

public class BoardDTO {
	private int startIdx;
	private int recordCnt;
	private int searchType;
	private String searchText;
	private int iboard;

	
	
	public int getIboard() {
		return iboard;
	}

	public void setIboard(int iboard) {
		this.iboard = iboard;
	}

	public int getSearchType() {
		return searchType;
	}

	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}

	public void setRecordCnt(int recordCnt) {
		this.recordCnt = recordCnt;
	}

	public int getStartIdx() {
		return startIdx;
	}

	public int getRecordCnt() {
		return recordCnt;
	}

	
}
