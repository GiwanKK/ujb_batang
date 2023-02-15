package kr.go.uijeongbu.dashBoard.communication.communInfo.web;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.go.uijeongbu.cmm.util.CommonUtil;
import kr.go.uijeongbu.cmm.vo.LoginVO;
import kr.go.uijeongbu.dashBoard.communication.communInfo.service.CommunInfoService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 대시보드 소통 및 CCTV 현황 > 소통 정보 - controller 클래스
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
public class CommunInfoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommunInfoController.class);
	
	@Resource(name = "communInfoService")
	private CommunInfoService communInfoService;
	
	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Autowired
	private MappingJackson2JsonView jsonView;
	
	/**
	 * 소통 정보  화면
	 * @param 
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/communication/communInfo.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String communInfo(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		//메뉴코드
		String menuCode = "MENU_00034";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/communication/communInfo";
    }

	/**
	 * 데이터 로딩
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/communication/communInfoData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView communInfoData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		LOGGER.info("=============== param : " + params);
		CommunInfoController controller = new CommunInfoController();
//		List<Map<String, Object>> trafficData = controller.getTrafficData();
		//표준노드링크 데이터 조회
		List<Map<String, Object>> linkData = communInfoService.selectLinkData();
		
//		//의정부 행정동 경계 조회
//		List<Map<String, Object>> admdArea = welfareStatusService.selectAdmdArea(params);
//
		
//		modelAndView.addObject("trafficData", trafficData);
		modelAndView.addObject("linkData", linkData);
		
		return modelAndView;
		
	}
}
