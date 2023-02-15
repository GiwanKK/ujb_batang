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
package kr.go.uijeongbu.manager.userAuth.userAuthMng.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

import kr.go.uijeongbu.cmm.util.ComStringUtil;
import kr.go.uijeongbu.cmm.util.CommonUtil;
import kr.go.uijeongbu.cmm.vo.LoginVO;
import kr.go.uijeongbu.manager.logMng.service.LogService;
import kr.go.uijeongbu.manager.userAuth.userAuthMng.service.UserAuthMngService;
import kr.go.uijeongbu.manager.userAuth.userSearch.service.UserSearchService;

/**
 * 관리자 > 부서 관리 Controller 클래스
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
public class UserAuthMngController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthMngController.class);
	
	@Autowired
	private MappingJackson2JsonView jsonView;				// Json 데이터를 Return 받기위해 Controller 마다 선언해준다
	
	@Resource(name = "userAuthMngService")
	private UserAuthMngService userAuthMngService;						// DB 서비스 호출
	
	@Resource(name = "userSearchService")
	private UserSearchService userSearchService;						// DB 서비스 호출

	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
		
	/**
	 * 관리자 > 부서 관리 화면
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/userAuth/userAuthMng.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String userAuthMng(/*@RequestBody Map<String, Object> params, */HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		try {
		//메뉴코드
		String menuCode = "MENU_00051";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
        return "/manager/userAuth/userAuthMng";
		}catch (SQLException e) {
			LOGGER.info("userAuthMng SQLException Error");
			return "/common/errorPage/error";
		}catch (Exception e) {
			LOGGER.info("userAuthMng Error");
			return "/common/errorPage/error";
		}
    }
	
	
	/**
	 * 부서 조회
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/userAuth/userAuthSearchList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView userAuthSearchList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception{
		// Json Parameter에서 Map Type으로 변환
		//Map<String, Object> deptInfo = CommonUtil.convertMapToJson(params, "deptInfo");
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		List<Map<String, Object>> deptAllList     = userSearchService.getDeptAllGetList();
		List<Map<String, Object>> positionList    = userSearchService.getPositionList();
		// 부서 목록 조회
		List<Map<String, Object>> deptList = userAuthMngService.selectDeptList(params);
				
		
		
		// ModelAndView에 데이터 넣기
		modelAndView.addObject("deptAllList"      , deptAllList);
		modelAndView.addObject("positionList"     , positionList);
		modelAndView.addObject("gridList", deptList);
		}catch (SQLException e) {
			LOGGER.info("userAuthSearchList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("userAuthSearchList Error");
		}
		return modelAndView;
	}
	
	
	/**
	 * 부서 목록 조회하기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/userAuth/getDeptList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView getDeptList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> deptInfo = CommonUtil.convertMapToJson(params, "deptInfo");
		
		
		// 부서 목록 조회
		List<Map<String, Object>> deptList = userAuthMngService.selectDeptList(deptInfo);
		
		// ModelAndView에 데이터 넣기
		modelAndView.addObject("gridList", deptList);
		}catch (SQLException e) {
			LOGGER.info("getDeptList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("getDeptList Error");
		}
		return modelAndView;
	}
	
	
	/**
	 * 부서별 권한 목록 가져오기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/userAuth/selectDeptRoleList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView selectDeptRoleList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> deptInfo = CommonUtil.convertMapToJson(params, "deptInfo");

		// 권한 목록 조회
		List<Map<String, Object>> roleList = userAuthMngService.selectDeptRoleList(deptInfo);
		
		// ModelAndView에 데이터 넣기
		modelAndView.addObject("gridList", roleList);
		}catch (SQLException e) {
			LOGGER.info("selectDeptRoleList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("selectDeptRoleList Error");
		}
		return modelAndView;
	}
	
	
	
	/**
	 * 부서별 권한 설정 정보 수정하기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/userAuth/updateDeptRoleList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView updateDeptRoleList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// 부서 정보 받기
		Map<String, Object> deptInfo = new HashMap<String, Object>(); 
		deptInfo = CommonUtil.convertMapToJson(params, "deptInfo");
		// 권한 목록 받기
		List<Map<String, Object>> paramRoleList = (List)params.get("roleList");
		
		//결과 코드
		String resultValue = "Y";
		
		// 처리 건수
		int resultCnt = 0;
		
		String strUserId = "";
		if( deptInfo.get("userId") != null ) strUserId = deptInfo.get("userId").toString();
		
		// 권한 코드값이 있는지 체크
		if(!ComStringUtil.isEmpty(strUserId)) {
			
			// Parameter로 받은 메뉴 데이터가 있는지 체크
			if(paramRoleList.size() > 0) {
				
				//솔루션 권한의 유저수 체크
				/*if( paramRoleList.get(0).get("roleCode").toString() == "USERROLE_000003" ) {
					Map<String, Object> roleParam = new HashMap<String, Object>();
					roleParam.put("roleCode", paramRoleList.get(0).get("roleCode").toString());
					
				}*/
			// 부서별 권한 정보를 삭제한다
			userAuthMngService.deleteDeptRoleInfo(deptInfo);
			// 선택한 메뉴 권한을 저장한다
			for(Map<String, Object> menuInfo : paramRoleList) {
				
				// 부서 정보에서 권한 코드 가져오기
				menuInfo.put("userId", strUserId);
				if( deptInfo.get("loginId") != null ) menuInfo.put("loginId", deptInfo.get("loginId").toString());
				
				// 메뉴 정보 저장하기
				resultCnt += userAuthMngService.insertDeptRoleInfo(menuInfo);
				
			};
			
			}
		}
		

		// ModelAndView 객체 생성
		

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("resultCnt", resultCnt);
		modelAndView.addObject("resultValue", resultValue);
		}catch (SQLException e) {
			LOGGER.info("updateDeptRoleList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("updateDeptRoleList Error");
		}
		return modelAndView;
	}
	
}
