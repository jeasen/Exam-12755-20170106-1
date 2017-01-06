package com.jeasen.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.jeasen.pojo.Film;
import com.jeasen.pojo.User;

public interface FilmService {
	public List<Film> selectFileList(int id);

	// 根据id来查询数据
	public List<Film> selectById(int id);

	// 查询所有的数据，这里用的easyui框架,返回EUDataGridResult的分页实体类
	public List<Film> selectFilmList();

	// 批量查询
	public int delete(List<Film> list);
	
	public int deleteId(int id);
	
	public int addFilm(Film film);

	public User selectUsername(User user);
}
