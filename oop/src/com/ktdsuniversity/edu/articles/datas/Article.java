package com.ktdsuniversity.edu.articles.datas;

public class Article {
	
	/**게시물 번호*/
	private int articleId; 
	/**게시물 제목*/
	private String articleTitle;
	/**게시물 작성자*/
	private String writer;
	/**게시물 작성날짜*/
	private String writeDate;
	/**게시물 조회수*/
	private Long viewCount;
	/**게시물 내용*/
	private String content;
	
	
	public Article(int articleId,
				   String articleTitle,
				   String writer,
				   String writeDAte,
				   String content) {
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.writer = writer;
		this.writeDate = writeDate;
		this.content = content;
		//조회수는 0부터 시작하기 때문에 파라미터를 받을 필요없음
		this.viewCount = 0;
		
	}
	
	public int getArticleId() {
		return this.articleId;
	}
	
	public String getArticleTitle() {
		return this.articleTitle;
	}
	
	public String getWriter() {
		return this.writer;
	}
	
	public String getWriteDate() {
		return this.writeDate;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public long getViewCount() {
		return this.viewCount;
	}
	
	

}
