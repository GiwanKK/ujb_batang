package kr.go.uijeongbu.dashBoard.complain.complainAnalysis.web;

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
import kr.go.uijeongbu.dashBoard.complain.complainAnalysis.service.ComplainAnalysisService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 민원분석 대시보드 controller
 * @author 김부권
 * @since 2021. 07. 28.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 07. 28.	        김 부 권              최초생성
 *   
 * </pre>
 */
@Controller
public class ComplainAnalysisController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComplainAnalysisController.class);
	@Resource(name = "complainAnalysisService")
	private ComplainAnalysisService complainAnalysisService;

	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Autowired
	private MappingJackson2JsonView jsonView;
	
	/**
	 * 메인 화면
	 * @param 
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value = "/dashBoard/complain/complainAnalysis.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String complainAnalysis(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//민원분석 검색기간 넣기
		Map<String, Object> date = complainAnalysisService.selectCompAnalysisDate();
		model.addAttribute("date",date);
		//메뉴코드
		String menuCode = "MENU_00025";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/complain/complainAnalysis";
		
    }
	
	/**
	 * 민원분석 전체 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/complain/complainAnalysisData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView complainAnalysisData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		//대시보드 민원 - 민원 현황
		List<Map<String, Object>> compAnalysisStatus = complainAnalysisService.selectCompAnalysisStatus(params);
		
		if( params.get("keyword") == null ) {
			if( compAnalysisStatus.size() > 0 ) {
				params.put("keyword", compAnalysisStatus.get(0).get("keyword").toString());
				modelAndView.addObject("keyword", compAnalysisStatus.get(0).get("keyword").toString());
			}
		}
		
		//대시보드 민원 - 행정동별 민원 상위
		List<Map<String, Object>> compAnalysisRank = complainAnalysisService.selectCompAnalysisRank(params);
		//대시보드 민원 - 일별 언급량 추이
		List<Map<String, Object>> compAnalysisDay = complainAnalysisService.selectCompAnalysisDay(params);
		//대시보드 민원 - 긍정 부정분석
		List<Map<String, Object>> compAnalysisNp = complainAnalysisService.selectCompAnalysisNp(params);
		// 대시보드 민원 - 연관어 분석 
		List<Map<String, Object>> compAnalysisRelate = complainAnalysisService.selectCompAnalysisRelate(params);
		
		modelAndView.addObject("compAnalysisStatus", compAnalysisStatus);
		modelAndView.addObject("compAnalysisRank", compAnalysisRank);
		modelAndView.addObject("compAnalysisDay", compAnalysisDay);
		modelAndView.addObject("compAnalysisNp", compAnalysisNp);
		modelAndView.addObject("compAnalysisRelate", compAnalysisRelate);
		//modelAndView.addObject("list", data.get("list"));
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}
	
	/**
	 * 민원 분석에서 키워드 클릭 시 해당 하는 데이터 로딩
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/complain/complainAnalysisSearchData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView complainAnalysisSearchData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		//대시보드 민원 - 행정동별 민원 상위
		List<Map<String, Object>> compAnalysisRank = complainAnalysisService.selectCompAnalysisRank(params);
		//대시보드 민원 - 일별 언급량 추이
		List<Map<String, Object>> compAnalysisDay = complainAnalysisService.selectCompAnalysisDay(params);
		//대시보드 민원 - 긍정 부정분석
		List<Map<String, Object>> compAnalysisNp = complainAnalysisService.selectCompAnalysisNp(params);
		// 대시보드 민원 - 연관어 분석 
		List<Map<String, Object>> compAnalysisRelate = complainAnalysisService.selectCompAnalysisRelate(params);
		
		modelAndView.addObject("compAnalysisRank", compAnalysisRank);
		modelAndView.addObject("compAnalysisDay", compAnalysisDay);
		modelAndView.addObject("compAnalysisNp", compAnalysisNp);
		modelAndView.addObject("compAnalysisRelate", compAnalysisRelate);
		
		return modelAndView;
		
	}
	
}
