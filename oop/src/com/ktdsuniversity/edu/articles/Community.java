package com.ktdsuniversity.edu.articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ktdsuniversity.edu.articles.datas.Article;

public class Community implements ArticleSystem{

	private List<Article> articles;
	
	public Community() {
		this.articles = new ArrayList<>();
	}
	
	@Override
	public void articleWrite() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("게시글 제목을 입력하세요: ");
		String title = keyboard.nextLine();
		
		
	}

	@Override
	public void readAllArticles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readOneArticles(int articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editArticles(int articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeArticles(int articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void articlesCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeReply(int articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeReply(int articleId, int replyId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recommendReply(int articleId, int replyId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchArticles(String articleTitle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllArticles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAllReply(int articleId) {
		// TODO Auto-generated method stub
		
	}

}
