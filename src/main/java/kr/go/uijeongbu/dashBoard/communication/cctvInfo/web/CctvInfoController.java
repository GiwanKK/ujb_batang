package kr.go.uijeongbu.dashBoard.communication.cctvInfo.web;

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
import kr.go.uijeongbu.dashBoard.communication.cctvInfo.service.CctvInfoService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 대시보드 소통 및 CCTV 현황 > CCTV 정보 - controller 클래스
 * @author 김혜림
 * @since 2021. 08. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 25.	        김 혜 림                         최초생성
 *   
 * </pre>
 */
@Controller
public class CctvInfoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CctvInfoController.class);
	
	@Resource(name = "cctvInfoService")
	private CctvInfoService cctvInfoService;
	
	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Autowired
	private MappingJackson2JsonView jsonView;
	
	/**
	 * CCTV 정보  화면
	 * @param 
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/communication/cctvInfo.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String populationMove(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		//메뉴코드
		String menuCode = "MENU_00033";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/communication/cctvInfo";
    }

	/**
	 * CCTV 정보 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/communication/cctvInfoList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView cctvInfoList(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		//도시통계지표  데이터 조회
		List<Map<String, Object>> cctvInfoList = cctvInfoService.selectCCTVPointData(params);
				
		modelAndView.addObject("cctvInfoList", cctvInfoList);
		
		return modelAndView;
				
		
	}
	
	
}
