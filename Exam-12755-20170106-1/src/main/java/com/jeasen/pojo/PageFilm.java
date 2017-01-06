package com.jeasen.pojo;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class PageFilm {

	List<Film> films;
	PageInfo<Film> pageInfo;
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	public PageInfo<Film> getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo<Film> pageInfo) {
		this.pageInfo = pageInfo;
	}
	public PageFilm(List<Film> films, PageInfo<Film> pageInfo) {
		super();
		this.films = films;
		this.pageInfo = pageInfo;
	}
	
	
	
}
