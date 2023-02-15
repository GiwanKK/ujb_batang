package kr.go.uijeongbu.dashBoard.mainDetail.web;

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
import kr.go.uijeongbu.dashBoard.main.service.MainService;
import kr.go.uijeongbu.dashBoard.mainDetail.service.MainDetailService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 대시보드 메인페이지 상세보기 - controller 클래스
 * @author 김부권
 * @since 2021. 10. 15.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 10. 15.	        김부권                         최초생성
 *   
 * </pre>
 */
@Controller
public class MainDetailController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainDetailController.class);
	
	@Resource(name = "mainDetailService")
	private MainDetailService mainDetailService;
	
	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	

	@Resource(name = "mainService")
	private MainService mainService;
	
	@Autowired
	private MappingJackson2JsonView jsonView;
	
	/**
	 * 메인페이지 상세보기  화면
	 * @param 
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/main/mainDetail.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String mainDetail( @RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		//메뉴코드
		String menuCode = "MENU_00059";
		
		//행정동 코드
		String dongCode = params.get("dongCode").toString();
		String tp = params.get("tp").toString();
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		paramInfo.put("dongCd", dongCode);
		String dongName = mainDetailService.selectDongCenterPoint(paramInfo).get("dongNm").toString();
		model.addAttribute("dongName", dongName);
		model.addAttribute("tp", tp);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/mainDetail";
    }

	
	/**
	 * 데이터 로딩
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/main/mainDetailData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView mainDetailData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		String layerIdMap = "";
		//행정동 경계 
		Map<String, Object> admdArea = mainDetailService.selectAdmdAreaLine();
		System.out.println("params : " + params);
		switch(params.get("tp").toString()) {
			case "가로수" : 
				//수목 조회
				Map<String, Object> treeData = mainDetailService.selectMainTreeDetail(params);
				layerIdMap = "tree_detail";
				modelAndView.addObject("treeData", treeData);
				break;
			case "공원수목" :
				//공원수목  조회
				Map<String, Object> treeParkData = mainDetailService.selectMainTreeParkDetail(params);
				layerIdMap = "treePark_detail";
				modelAndView.addObject("treeParkData", treeParkData);
				break;
			case "어린이집" :
				//어린이집  조회
				Map<String, Object> childData = mainDetailService.selectMainChildrenDetail(params);
				layerIdMap = "child_detail";
				modelAndView.addObject("childData", childData);
				break;
			case "신호등" :
				//신호등  조회
				Map<String, Object> trafficData = mainDetailService.selectMainTrafficDetail(params);
				layerIdMap = "traffic_detail";
				modelAndView.addObject("trafficData", trafficData);
				break;
			case "횡단보도" :
				//횡단보도  조회
				Map<String, Object> crossWalkData = mainDetailService.selectMainCrosswalkDetail(params);
				layerIdMap = "crossWalk_detail";
				modelAndView.addObject("crossWalkData", crossWalkData);
				break;
			case "안전표지" :
				//안전표지  조회
				Map<String, Object> safetyData = mainDetailService.selectMainSafetySignDetail(params);
				layerIdMap = "safety_detail";
				modelAndView.addObject("safetyData", safetyData);
				break;
			case "안전비상벨" :
				//안전비상벨  조회
				Map<String, Object> bellData = mainDetailService.selectMainEmergencyBellDetail(params);
				layerIdMap = "bell_detail";
				modelAndView.addObject("bellData", bellData);
				break;
			case "CCTV" :
				//CCTV  조회
				Map<String, Object> cctvData = mainDetailService.selectMainCctvDetail(params);
				layerIdMap = "cctv_detail";
				modelAndView.addObject("cctvData", cctvData);
				break;
			case "무료와이파이" :
				//무료와이파이  조회
				Map<String, Object> wifiData = mainDetailService.selectMainWifiDetail(params);
				layerIdMap = "wifi_detail";
				modelAndView.addObject("wifiData", wifiData);
				break;
			case "주차장" :
				//주차장  조회
				Map<String, Object> parkData = mainDetailService.selectMainParkingDetail(params);
				layerIdMap = "park_detail";
				modelAndView.addObject("parkData", parkData);
				break;
			case "소방용수시설" :
				//소방용수시설  조회
				Map<String, Object> fireData = mainDetailService.selectMainFirefightingDetail(params);
				layerIdMap = "fire_detail";
				modelAndView.addObject("fireData", fireData);
				break;
			case "어린이 보호구역" :
				//어린이보호구역  조회
				Map<String, Object> childAreaData = mainDetailService.selectMainChildrenSanctuaryDetail(params);
				layerIdMap = "childArea_detail";
				modelAndView.addObject("childAreaData", childAreaData);
				break;
			case "안내표지" :
				//안내표지  조회
				Map<String, Object> guideSignData = mainDetailService.selectMainGuideSignDetail(params);
				layerIdMap = "guide_sign_detail";
				modelAndView.addObject("guideSignData", guideSignData);
				break;
		}
		//centerpoint
		Map<String, Object> centerPoint = mainDetailService.selectDongCenterPoint(params);
		
		//centerpoint
		List<Map<String, Object>> dongList = mainDetailService.selectDongList();
		
		
		modelAndView.addObject("layerIdMap", layerIdMap);
		modelAndView.addObject("admdArea", admdArea);
		modelAndView.addObject("centerPoint", centerPoint);
		modelAndView.addObject("dongList", dongList);
	
		return modelAndView;
		
	}
}
