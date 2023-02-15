package kr.go.uijeongbu.dashBoard.welfare.welfareStatus.web;

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
import kr.go.uijeongbu.dashBoard.welfare.welfareStatus.service.WelfareStatusService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 대시보드 복지현황 - controller 클래스
 * @author 김혜림
 * @since 2021. 08. 05.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 05.	        김 혜 림              최초생성
 *   
 * </pre>
 */
@Controller
public class WelfareStatusController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WelfareStatusController.class);
	
	@Resource(name = "welfareStatusService")
	private WelfareStatusService welfareStatusService;

	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Autowired
	private MappingJackson2JsonView jsonView;
	
	/**
	 * 복지현황  화면
	 * @param 
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/welfare/welfareStatsus.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String welfareStatsus(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//데이터 존재하는 기간 조회
		//Map<String, Object> date = welfareStatusService.selectWfStatusDate();
		//System.out.println("date : " + date);
		
		//model.addAttribute("date", date);
		
		//메뉴코드
		String menuCode = "MENU_00026";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/welfare/welfareStatus";
    }
	
	
	/**
	 * 대시보드 복지현황 페이지 데이터 로딩
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/welfare/welfareStatusData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView welfareStatusData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
//		//배경지도 조회
//		Map<String, Object> defaultMap = welfareStatusService.selectDefaultMap(params);
		//의정부 행정동 경계 조회
		List<Map<String, Object>> admdArea = welfareStatusService.selectAdmdArea(params);
		//보육시설 현황 조회
		List<Map<String, Object>> childFacil = welfareStatusService.selectChildFacilStatus(params);
		//노인복지시설 현황 조회
		List<Map<String, Object>> oldWfFacil = welfareStatusService.selectOldWfFacilStatus(params);
		//노인복지시설 종류별 비율 조회
		List<Map<String, Object>> oldWfFacilRatio = welfareStatusService.selectOldWfFacilRatio(params);
		//유형별 유치원 정원 수 조회
		List<Map<String, Object>> kndgnLimit = welfareStatusService.selectKndgnLimit(params);
		//유형별 어린이집 정원 수 조회
		List<Map<String, Object>> nurseryLimit = welfareStatusService.selectNurseryLimit(params);
		//장애 정도별 수급자 수 조회
		List<Map<String, Object>> disDegreeCnt = welfareStatusService.selectDisDegreeCnt(params);
		//연령별 수급자 수 조회
		List<Map<String, Object>> disAgeCnt = welfareStatusService.selectDisAgeCnt(params);

//		System.out.println("childFacil : " + childFacil);
//		System.out.println("oldWfFacil : " + oldWfFacil);
//		System.out.println("oldWfFacilRatio : " + oldWfFacilRatio);
//		System.out.println("kndgnLimit : " + kndgnLimit);
//		System.out.println("nurseryLimit : " + nurseryLimit);
//		System.out.println("disDegreeCnt : " + disDegreeCnt);
//		System.out.println("disAgeCnt : " + disAgeCnt);
		
		modelAndView.addObject("admdArea", admdArea);
//		modelAndView.addObject("defaultMap", defaultMap);
		modelAndView.addObject("childFacil", childFacil);
		modelAndView.addObject("oldWfFacil", oldWfFacil);
		modelAndView.addObject("oldWfFacilRatio", oldWfFacilRatio);
		modelAndView.addObject("kndgnLimit", kndgnLimit);
		modelAndView.addObject("nurseryLimit", nurseryLimit);
		modelAndView.addObject("disDegreeCnt", disDegreeCnt);
		modelAndView.addObject("disAgeCnt", disAgeCnt);
		
		return modelAndView;
		
	}
}
