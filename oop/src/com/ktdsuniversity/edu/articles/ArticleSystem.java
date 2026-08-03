package com.ktdsuniversity.edu.articles;

public interface ArticleSystem {
	
	// 게시글 작성하기
	void articleWrite();
	// 모든 게시글 출력하기
	void readAllArticles();
	// 게시글 번호로 게시글 정보 출력하기(출력하려는 게시글 번호)
	void readOneArticles(int articleId);
	// 게시글 수정하기(수정하려는 게시글 번호)
	void editArticles(int articleId);
	// 게시글 번호로 게시글 삭제하기(삭제하려는 게시글 번호)
	void removeArticles(int articleId);
	// 게시판에 등록된 게시글의 개수 출력하기
	void articlesCount();
	// 게시글의 번호를 이용해 게시글에 댓글 작성하기(게시글 번호)
	void writeReply(int articleId);
	// 게시글에 등록된 댓글 삭제하기(삭제하려는 댓글이 있는 게시글 번호, 삭제하려는 댓글 번호)
	void removeReply(int articleId,int replyId);
	// 게시글에 등록된 댓글 하나 추천하기(추천하려는 댓글이 있는 게시글 번호, 추천하려는 댓글 번호)
	void recommendReply(int articleId, int replyId);
	// 게시글 제목으로 검색하기(검색어)
	void searchArticles(String articleTitle);
	// 게시글 목록 전체 삭제하기()
	void removeAllArticles();
	// 원하는 게시글의 모든 댓글 삭제하기(게시글 번호)
	void removeAllReply(int articleId);

}
