package com.xingyun.smartsite.controller;

import com.google.gson.Gson;
import com.xingyun.smartsite.dto.MiniMenu;
import com.xingyun.smartsite.model.*;
import com.xingyun.smartsite.service.SmartsiteMainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

/***
 *
 */
@RequestMapping(value = "/main")
@Controller
public class SmartsiteMainController extends CommonController {
	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	SmartsiteMainService smartsiteMainService;

	@RequestMapping(value = "/getAllMenuNode", method = RequestMethod.GET)
	@ResponseBody
	public List<MiniMenu> findALlNormalMenuNode(Model model,
			HttpSession session, HttpServletResponse response) {
		List<MiniMenu> menus = new ArrayList<MiniMenu>();
		Gson gson = new Gson();
		String resultData = "";
		try {
			List<MenuNode> list = smartsiteMainService.getAllNormalMenuNode();
			for (MenuNode node : list) {
				MiniMenu mm = new MiniMenu();
				mm.setId(String.valueOf(node.getId()));
				mm.setPid(String.valueOf(node.getPid()));
				mm.setText(node.getName());
				mm.setHtmlName(node.getHtmlName());
				menus.add(mm);
			}
			resultData = gson.toJson(menus);
			// System.out.println(resultData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menus;
	}

	/**
	 * 对获取的菜单整理排序
	 */
	private List<MenuNode> getMenuNodeListById(List<MenuNode> list,
			int menuNodeId) {
		List<MenuNode> treeMenuNodeList = new ArrayList<>();
		for (MenuNode node : list) {
			if (node.getPid() == menuNodeId) {
				List<MenuNode> nodes = getMenuNodeListById(list, node.getId());
				node.setChildes(nodes);
				treeMenuNodeList.add(node);
			}
		}
		Collections.sort(treeMenuNodeList);
		return treeMenuNodeList;
	}

}
