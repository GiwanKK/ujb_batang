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
package kr.go.uijeongbu.manager.codeMng.web;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.executor.ExecutorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.go.uijeongbu.cmm.util.CommonUtil;
import kr.go.uijeongbu.manager.codeMng.service.CodeService;

/**
 * 관리자 공통코드 관리 Controller 클래스
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
public class CodeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CodeController.class);
	
	@Autowired
	private MappingJackson2JsonView jsonView;				// Json 데이터를 Return 받기위해 Controller 마다 선언해준다
	
	@Resource(name = "codeService")
	private CodeService codeService;						// DB 서비스 호출
		
	/**
	 * 관리자 > 공통코드관리 화면
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/codeMng/codeMain.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String codeMain(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws ExecutorException, Exception {

        return "manager/codeMng/codeMain";
    }
	
	
	/**
	 * 공통코드 목록 가져오기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/codeMng/getCodeList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView getCodeList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> menuInfo = CommonUtil.convertMapToJson(params, "codeInfo");

		// 메뉴 목록 조회
		List<Map<String, Object>> codeList = codeService.selectCodeList(menuInfo);
		
		
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("gridList", codeList);

		return modelAndView;
	}
	
	
	/**
	 * 공통코드 정보 저장하기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/codeMng/insertCodeList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView insertCodeList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> codeInfo = CommonUtil.convertMapToJson(params, "codeInfo");
		
		// 공통코드 정보 저장
		int resultCnt = codeService.insertCodeInfo(codeInfo);
		
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("resultCnt", resultCnt);
		modelAndView.addObject("resultValue", "Y");

		return modelAndView;
	}
	
	
	/**
	 * 공통코드 정보 수정하기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/codeMng/updateCodeList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView updateCodeList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> codeInfo = CommonUtil.convertMapToJson(params, "codeInfo");

		// 수정 처리
		int resultCnt = codeService.updateCodeInfo(codeInfo);
		
		
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("resultCnt", resultCnt);
		modelAndView.addObject("resultValue", "Y");

		return modelAndView;
	}
	
	
	/**
	 * 공통코드 정보 삭제하기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/codeMng/deleteCodeList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView deleteCodeList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> codeInfo = CommonUtil.convertMapToJson(params, "codeInfo");

		int resultCnt = codeService.deleteCodeInfo(codeInfo);
		
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("resultCnt", resultCnt);
		modelAndView.addObject("resultValue", "Y");

		return modelAndView;
	}
	
}
