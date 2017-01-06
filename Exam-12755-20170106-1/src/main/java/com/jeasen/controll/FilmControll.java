package com.jeasen.controll;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jeasen.pojo.Film;
import com.jeasen.pojo.PageFilm;
import com.jeasen.service.FilmService;
import com.jeasen.uitl.PageUtil;

@Controller
public class FilmControll {

	@Resource
	private FilmService filmService;

	@RequestMapping("/showlist")
	public String list(Model model, HttpServletRequest request) {

		return "showlist";
	}

	@RequestMapping("/selectList")
	public @ResponseBody String selectList(Model model, HttpServletRequest request) {
		String pageNumStr = request.getParameter("index");
		int pageNum = Integer.parseInt(pageNumStr != null ? pageNumStr : "1");

		String pageSize = request.getParameter("size");
		int pageSizeNum = Integer.parseInt(pageSize);

		if (pageSizeNum != 123) {
			PageUtil.setPageSize(pageSizeNum);
		}

		PageHelper.startPage(pageNum, PageUtil.getPageSize());
		List<Film> films = filmService.selectFilmList();
		PageInfo<Film> pageInfo = new PageInfo<>(films);

		PageFilm pageFilm = new PageFilm(films, pageInfo);

		String s = JSON.toJSONString(pageFilm);

		return s;
	}

	@RequestMapping("/addFilm")
	public String addFilm(HttpServletRequest requests) {
		System.out.println("到了add Control");
		String title = requests.getParameter("title");
		String desc = requests.getParameter("desc");
		String lang = requests.getParameter("lang");

		Film film = new Film();
		film.setTitle(title);
		film.setDescription(desc);
		film.setName(lang);
		filmService.addFilm(film);

		return "redirect:/showlist";
	}

	@RequestMapping("/delete")
	public String deleteList(HttpServletRequest requests) {
		System.out.println("到了	deleteList");
		String getId = requests.getParameter("id");
		System.out.println("要删除的ID" + getId);

		filmService.deleteId(Integer.parseInt(getId));

		return "redirect:/showlist";
	}

	@RequestMapping("/edit")
	public String editList(HttpServletRequest requests) {
		System.out.println("到了	editList");
		String getId = requests.getParameter("id");
		System.out.println(getId + "------------------------------------");
		return "redirect:/showlist";
	}

}
