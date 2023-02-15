/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.go.uijeongbu.manager.menuMng.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.RedirectException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.go.uijeongbu.cmm.util.CommonUtil;
import kr.go.uijeongbu.cmm.vo.LoginVO;
import kr.go.uijeongbu.manager.logMng.service.LogService;
import kr.go.uijeongbu.manager.menuMng.service.MenuService;

/**
 * 관리자 메뉴 관리 Controller 클래스
 * @author 김부권
 * @since 2021. 08. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2021.08.25.   	김부권          최초 생성
 *   
 * </pre>
 */
@Controller
public class MenuController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MappingJackson2JsonView jsonView;				// Json 데이터를 Return 받기위해 Controller 마다 선언해준다

	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Resource(name = "menuService")
	private MenuService menuService;						// DB 서비스 호출
	
	
	//@Resource(name = "menuIdGnrService")
	//private EgovIdGnrService idgenService;
	
		
	/**
	 * 관리자 > 메뉴관리 화면
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/menuMng/menuMain.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String menuMain(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws NoHandlerFoundException,Exception {
        return "manager/menuMng/menuMain";
    }
	
	
	/**
	 * 메뉴 목록 가져오기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/menuMng/getMenuList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView getMenuList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> menuInfo = CommonUtil.convertMapToJson(params, "menuInfo");

		// 메뉴 목록 조회
		List<Map<String, Object>> menuList = menuService.selectMenuList(menuInfo);

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("gridList", menuList);
		}catch (SQLException e) {
			LOGGER.info("getMenuList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("getMenuList Error");
		}
		return modelAndView;
	}
	
	
	/**
	 * 메뉴 정보 저장하기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/menuMng/insertMenuList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView insertMenuList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> menuInfo = CommonUtil.convertMapToJson(params, "menuInfo");
		
		// 신규 Menu ID 만들기
		//String nextMenuId = idgenService.getNextStringId();
		
		// Menu Code 설정
		//menuInfo.put("menuCode", nextMenuId);

		int resultCnt = menuService.insertMenuInfo(menuInfo);

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("resultCnt", resultCnt);
		modelAndView.addObject("resultValue", "Y");
		}catch (SQLException e) {
			LOGGER.info("insertMenuList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("insertMenuList Error");
		}
		return modelAndView;
	}
	
	
	/**
	 * 메뉴 정보 수정하기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/menuMng/updateMenuList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView updateMenuList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> menuInfo = CommonUtil.convertMapToJson(params, "menuInfo");

		// 수정 처리
		int resultCnt = menuService.updateMenuInfo(menuInfo);
		
		// ModelAndView에 데이터 넣기
		modelAndView.addObject("resultCnt", resultCnt);
		modelAndView.addObject("resultValue", "Y");
		}catch (SQLException e) {
			LOGGER.info("updateMenuList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("updateMenuList Error");
		}
		return modelAndView;
	}
	
	
	/**
	 * 메뉴 정보 삭제하기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/menuMng/deleteMenuList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView deleteMenuList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> menuInfo = CommonUtil.convertMapToJson(params, "menuInfo");

		int resultCnt = menuService.deleteMenuInfo(menuInfo);
		// ModelAndView에 데이터 넣기
		modelAndView.addObject("resultCnt", resultCnt);
		modelAndView.addObject("resultValue", "Y");
		}catch (SQLException e) {
			LOGGER.info("deleteMenuList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("deleteMenuList Error");
		}
		return modelAndView;
	}
	
}
