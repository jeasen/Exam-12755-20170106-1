package com.jeasen.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jeasen.dao.FilmDao;
import com.jeasen.pojo.Film;
import com.jeasen.pojo.User;
import com.jeasen.service.FilmService;

@Service("filmService")
public class FilmServiceImpl implements FilmService {

	@Resource
	public FilmDao filmDao;

	@Override
	public List<Film> selectFileList(int id) {
		// TODO Auto-generated method stub
		if (id != 0) {
			id = 10 * (id - 1);
		}
		List<Film> list = filmDao.selectFileList(id);
		return list;
	}


	@Override
	public List<Film> selectById(int id) {
		// TODO Auto-generated method stub
		List<Film> selectByIdList = filmDao.selectById(id);
		return selectByIdList;
	}

	@Override
	public List<Film> selectFilmList() {
		List<Film> pageInfoList = filmDao.selectFilmList();
		if (pageInfoList == null) {
			System.out.println("没有数据");
			return null;
		}
		return pageInfoList;
	}

	// easyUi通过service层

	@Override
	public int delete(List<Film> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectUsername(User user) {
		// TODO Auto-generated method stub
		return filmDao.login(user.getUsername());
	}


	@Override
	public int deleteId(int id) {
		// TODO Auto-generated method stub
		return filmDao.deleteid(id);
	}


	@Override
	public int addFilm(Film film) {
		// TODO Auto-generated method stub
		return filmDao.addFilm(film);
	}

}
