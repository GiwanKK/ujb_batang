package kr.go.uijeongbu.dashBoard.business.businessStatus.web;

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
import kr.go.uijeongbu.dashBoard.business.businessStatus.service.BusinessStatusService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 사업추진현황 대시보드 controller
 * @author 김부권
 * @since 2021. 08. 03.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 03.	        김 부 권              최초생성
 *   
 * </pre>
 */
@Controller
public class BusinessStatusController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BusinessStatusController.class);
	@Resource(name = "businessStatusService")
	private BusinessStatusService businessStatusService;
	
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
	@RequestMapping(value = "/dashBoard/business/businessStatus.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String businessStatus(HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		
		//검색기간 넣기
		Map<String, Object> date = businessStatusService.selectBusiStatusDate();
		model.addAttribute("date",date);
		
		//메뉴코드
		String menuCode = "MENU_00036";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/business/businessStatus";
		
    }
	
	/**
	 * 사업추진현황 대시보드 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/business/businessStatusData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView businessStatusData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		//희망도시  데이터 조회
		List<Map<String, Object>> busiStatusHope = businessStatusService.selectBusiStatusHoep(params);
		//선진교통도시 데이터 조회
		List<Map<String, Object>> busiStatusTrans = businessStatusService.selectBusiStatusTrans(params);
		//교육선도도시 데이터 조회
		List<Map<String, Object>> busiStatusEducation = businessStatusService.selectBusiStatusEducation(params);
		//복지도시 데이터 조회
		List<Map<String, Object>> busiStatusWelfare = businessStatusService.selectBusiStatusWelfare(params);
		//행정도시 데이터 조회
		List<Map<String, Object>> busiStatusPublic = businessStatusService.selectBusiStatusPublic(params);
		
		
		modelAndView.addObject("busiStatusHope", busiStatusHope);
		modelAndView.addObject("busiStatusTrans", busiStatusTrans);
		modelAndView.addObject("busiStatusEducation", busiStatusEducation);
		modelAndView.addObject("busiStatusWelfare", busiStatusWelfare);
		modelAndView.addObject("busiStatusPublic", busiStatusPublic);
		
		return modelAndView;
		
	}
	
	/**
	 * 클릭한 데이터 조건 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/business/businessStatusClickData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView businessStatusClickData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		Map<String, Object> statusLoad = businessStatusService.selectBusiStatusLoad(params);
		
		modelAndView.addObject("statusLoad", statusLoad);
		//modelAndView.addObject("list", data.get("list"));
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}
	
}
