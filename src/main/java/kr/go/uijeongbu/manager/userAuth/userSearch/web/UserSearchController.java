package kr.go.uijeongbu.manager.userAuth.userSearch.web;

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

import kr.go.uijeongbu.cmm.util.CommonUtil;
import kr.go.uijeongbu.cmm.vo.LoginVO;
import kr.go.uijeongbu.manager.logMng.service.LogService;
import kr.go.uijeongbu.manager.userAuth.userSearch.service.UserSearchService;


@Controller
public class UserSearchController {
private static final Logger LOGGER = LoggerFactory.getLogger(UserSearchController.class);
	
	@Autowired
	private MappingJackson2JsonView jsonView;				// Json 데이터를 Return 받기위해 Controller 마다 선언해준다
	
	@Resource(name = "userSearchService")
	private UserSearchService userSearchService;						// DB 서비스 호출

	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	/**
	 * 관리자 > 부서 조회 화면
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/userAuth/userSearch.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String userSearch(/*@RequestBody Map<String, Object> params,*/ HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		try {
		//메뉴코드
		String menuCode = "MENU_00050";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		logService.createMenuLog(paramInfo);
		
		if(loginVO.getId() ==null) {
			return "/intro/intro";
		}else {
			
			// Parameter 객체
			paramInfo.put("loginId", loginVO.getId());
			paramInfo.put("menuCode", menuCode);
			logService.createMenuLog(paramInfo);
			logService.createUserLog(paramInfo);
			if( request.getParameter("menuCode") == null ) {
				
				return "/manager/userAuth/userSearch";
			}else {
				
				return "manager-content/manager/userAuth/userSearch";
			}
		}
		}catch (SQLException e) {
			LOGGER.info("userSearch SQLException Error");
			return "/common/errorPage/error";
		}catch (Exception e) {
			LOGGER.info("userSearch Error");
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
	@RequestMapping(value = "/mamager/userAuth/userSearchList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView userSearchList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception{
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		try {
		List<Map<String, Object>> userSearchList  = userSearchService.selectSearchList(params);
		List<Map<String, Object>> deptAllList     = userSearchService.getDeptAllGetList();
		List<Map<String, Object>> positionList    = userSearchService.getPositionList();

		
		modelAndView.addObject("userSearchList"   , userSearchList);
		modelAndView.addObject("deptAllList"      , deptAllList);
		modelAndView.addObject("positionList"     , positionList);
		}catch (SQLException e) {
			LOGGER.info("userSearchList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("userSearchList Error");
		}
		return modelAndView;
		
	}
	
}
