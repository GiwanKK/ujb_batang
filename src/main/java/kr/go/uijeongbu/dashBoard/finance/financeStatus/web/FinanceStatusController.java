package kr.go.uijeongbu.dashBoard.finance.financeStatus.web;

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
import kr.go.uijeongbu.dashBoard.finance.financeStatus.service.FinanceStatusService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 재정현황 대시보드 controller
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
public class FinanceStatusController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FinanceStatusController.class);
	@Resource(name = "financeStatusService")
	private FinanceStatusService financeStatusService;

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
	@RequestMapping(value = "/dashBoard/finance/financeStatus.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String financeStatus(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//검색기간 넣기
		Map<String, Object> date = financeStatusService.selectFinStatusDate();
		model.addAttribute("date",date);
		//메뉴코드
		String menuCode = "MENU_00028";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/finance/financeStatus";
		
    }
	
	/**
	 * 민원 현황실 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/finance/financeStatusData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView financeStatusData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		//부서별 예산 현황 데이터 조회
		List<Map<String, Object>> finDept = financeStatusService.selectFinanceStatusDept(params);
		//분야 부문별 예산 현황 데이터 조회
		List<Map<String, Object>> finSort = financeStatusService.selectFinStatusSort(params);
		//부서별집행현황 데이터 조회
		List<Map<String, Object>> finExecution = financeStatusService.selectFinStatusExecution(params);
		//부서별 계약현황 데이터 조회
		List<Map<String, Object>> finContract = financeStatusService.selectFinStatusContract(params);
		List<Map<String, Object>> finContractList = financeStatusService.selectFinStatusContractList(params);
		
		
		modelAndView.addObject("finDept", finDept);
		modelAndView.addObject("finSort", finSort);
		modelAndView.addObject("finExecution", finExecution);
		modelAndView.addObject("finContract", finContract);
		modelAndView.addObject("finContractList", finContractList);
		//modelAndView.addObject("list", data.get("list"));
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}
	
	/**
	 * 유동인구 행정동 선택 및 검색 조건 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/finance/financeStatusSearchData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView financeStatusSearchData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		//부서별 예산 현황 데이터 조회
		List<Map<String, Object>> finDept = financeStatusService.selectFinanceStatusDept(params);
		//분야 부문별 예산 현황 데이터 조회
		List<Map<String, Object>> finSort = financeStatusService.selectFinStatusSort(params);
		//부서별집행현황 데이터 조회
		List<Map<String, Object>> finExecution = financeStatusService.selectFinStatusExecution(params);
		//부서별 계약현황 데이터 조회
		List<Map<String, Object>> finContract = financeStatusService.selectFinStatusContract(params);
		
		
		modelAndView.addObject("finDept", finDept);
		modelAndView.addObject("finSort", finSort);
		modelAndView.addObject("finExecution", finExecution);
		modelAndView.addObject("finContract", finContract);
		
		return modelAndView;
		
	}
	
}
