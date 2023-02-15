package kr.go.uijeongbu.dashBoard.complain.complainPublic.web;

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
import kr.go.uijeongbu.dashBoard.complain.complainPublic.service.ComplainPublicService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 여론분석 대시보드 controller
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
public class ComplainPublicController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComplainPublicController.class);
	@Resource(name = "complainPublicService")
	private ComplainPublicService complainPublicService;

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
	@RequestMapping(value = "/dashBoard/complain/complainPublic.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String populationFlow(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//여론분석 검색기간 넣기
		Map<String, Object> date = complainPublicService.selectCompPublicDate();
		model.addAttribute("date",date);
		//메뉴코드
		String menuCode = "MENU_00024";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/complain/complainPublic";
		
    }
	
	/**
	 * 여론분석 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/complain/complainPublicData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView complainPublicData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		//여론 현황
		List<Map<String, Object>> compPublicStatus = complainPublicService.selectCompPublicStatus(params);
		
		if( params.get("keyword") == null ) {
			if( compPublicStatus.size() > 0 ) {
				params.put("keyword", compPublicStatus.get(0).get("keyword").toString());
				modelAndView.addObject("keyword", compPublicStatus.get(0).get("keyword").toString());
			}
		}
		//여론 키워드 관련글
		List<Map<String, Object>> compPublicKeyword = complainPublicService.selectCompPublicKeyword(params);
		//일별 언급량 추이
		List<Map<String, Object>> compPublicDay = complainPublicService.selectCompPublicDay(params);
		// 워드 클라우드
		List<Map<String, Object>> compPublicWordcloud = complainPublicService.selectCompPublicWordcloud(params);
		//연관어 분석
		List<Map<String, Object>> compPublicRelate = complainPublicService.selectCompPublicRelate(params);
		modelAndView.addObject("compPublicStatus", compPublicStatus);
		modelAndView.addObject("compPublicKeyword", compPublicKeyword);
		modelAndView.addObject("compPublicDay", compPublicDay);
		modelAndView.addObject("compPublicWordcloud", compPublicWordcloud);
		modelAndView.addObject("compPublicRelate", compPublicRelate);
		
		return modelAndView;
		
	}
	
	/**
	 * 여론분석 키워드 선택 시 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/complain/complainPublicSearchData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView complainPublicSearchData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		//여론 키워드 관련글
		List<Map<String, Object>> compPublicKeyword = complainPublicService.selectCompPublicKeyword(params);
		//일별 언급량 추이
		List<Map<String, Object>> compPublicDay = complainPublicService.selectCompPublicDay(params);
		// 워드 클라우드
		List<Map<String, Object>> compPublicWordcloud = complainPublicService.selectCompPublicWordcloud(params);
		//연관어 분석
		List<Map<String, Object>> compPublicRelate = complainPublicService.selectCompPublicRelate(params);
		
		modelAndView.addObject("compPublicKeyword", compPublicKeyword);
		modelAndView.addObject("compPublicDay", compPublicDay);
		modelAndView.addObject("compPublicWordcloud", compPublicWordcloud);
		modelAndView.addObject("compPublicRelate", compPublicRelate);
		
		return modelAndView;
	
	}
	
}
