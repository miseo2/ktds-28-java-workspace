package com.ktdsuniversity.edu.articles.datas;

public class Reply {
	// Article이 댓글을 가지고 있기 때문에, 댓글 한 개를 표현하는 Reply 클래스를 가장 먼저 완성해야함
	
	/**댓글 번호*/
	private int replyId;
	/**댓글 내용*/
	private String replyContent;
	/**댓글 작성자*/
	private String replyWriter;
	/**댓글 작성 날짜*/
	private String replyWriteDate;
	/**댓글 추천 수*/
	private long recommendCount;
	
	public Reply(int replyId,
				String replyContent,
				String replyWriter,
				String replyWriteDate) {
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.replyWriteDate = replyWriteDate;
		// 추천수는 댓글이 생기면 무조건 0부터 이므로 파라미터로 받을 필요가 없음
		this.recommendCount = 0;
		}
	
	public int getReplyId() {
		return this.replyId;
	}
	
	public String getReplyContent() {
		return this.replyContent;
	}
	
	public String getReplyWriter() {
		return this.replyWriter;
	}
	
	public String getReplyWriteDate() {
		return this.replyWriteDate;
	}
	
	public long getRecommendCount() {
		return this.recommendCount;
	}
	
	//추천수 증가
	public void increaseRecommendCount() {
		this.recommendCount++;
	}

}
