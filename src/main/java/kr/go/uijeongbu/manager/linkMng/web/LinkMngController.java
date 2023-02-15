package kr.go.uijeongbu.manager.linkMng.web;

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
import kr.go.uijeongbu.manager.linkMng.service.LinkMngService;
import kr.go.uijeongbu.manager.logMng.service.LogService;
/**
 * @Description		: 연계데이터 관리 Controller
 * @Source        	: LinkMngController.java
 * @author 김부권
 * @since 2021. 09. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2021.09.23.   	김부권          최초 생성
 *   
 * </pre>
 */
@Controller
public class LinkMngController {
private static final Logger LOGGER = LoggerFactory.getLogger(LinkMngController.class);
	
	@Autowired
	private MappingJackson2JsonView jsonView;				// Json 데이터를 Return 받기위해 Controller 마다 선언해준다
	

	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	
	@Resource(name = "linkMngService")
	private LinkMngService linkMngService;						// DB 서비스 호출
	
	/**
	 * 연계 데이터 관리 메인페이지
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/linkMng/linkMng.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public String linkMng(/*@RequestBody Map<String, Object> params,*/ HttpServletRequest request, ModelMap model) throws NullPointerException, Exception{
		
		
		//메뉴코드
		String menuCode = "MENU_00054";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		
		return "/manager/linkMng/linkMng";
	}
	
	/**
	 * 연계데이터 연계주기리스트 가져오기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/linkMng/linkMngCycleList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView linkMngCycleList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception{
		// Json Parameter에서 Map Type으로 변환
		//Map<String, Object> analysisInfo = CommonUtil.convertMapToJson(params, "analysisInfo");
		List<Map<String, Object>> cycleList = linkMngService.selectLinkList();
		List<Map<String, Object>> cycleStatusList = linkMngService.selectLinkStatusList();
		List<Map<String, Object>> cycleDataList = linkMngService.selectLinkData(params);
//		Map<String, Object> date = new HashMap<String, Object>();
//		List<Map<String, Object>> cycleDataLogList = new ArrayList<>();
		
//		if( cycleDataList.size() > 0 ) {
//			params.put("name", cycleDataList.get(0).get("title").toString());
//			date = linkMngService.selectLinkDataDate(params);
//			params.put("date", date.get("date").toString());
//			cycleDataLogList = linkMngService.selectLinkDataLog(params);
//			
//		}
		
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);		// ModelAndView 객체 생성
		
		
		modelAndView.addObject("cycleList", cycleList);	
		modelAndView.addObject("cycleStatusList", cycleStatusList);	
		modelAndView.addObject("cycleDataList", cycleDataList);	
//		modelAndView.addObject("date", date);	
//		modelAndView.addObject("cycleDataLogList", cycleDataLogList);
		
		return modelAndView;
	}
	
	/**
	 * 연계데이터 연계주기리스트 가져오기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/linkMng/linkMngCycleSearch.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView linkMngCycleSearch(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception{
		// Json Parameter에서 Map Type으로 변환
		//Map<String, Object> analysisInfo = CommonUtil.convertMapToJson(params, "analysisInfo");
		List<Map<String, Object>> cycleList = linkMngService.selectLinkList();
		List<Map<String, Object>> cycleStatusList = linkMngService.selectLinkStatusList();
		List<Map<String, Object>> cycleDataList = linkMngService.selectLinkData(params);
		Map<String, Object> date = linkMngService.selectLinkDataDate(params);
		List<Map<String, Object>> cycleDataLogList = linkMngService.selectLinkDataLog(params);
		
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);		// ModelAndView 객체 생성
		
		
		modelAndView.addObject("cycleList", cycleList);	
		modelAndView.addObject("cycleStatusList", cycleStatusList);	
		modelAndView.addObject("cycleDataList", cycleDataList);	
		modelAndView.addObject("date", date);	
		modelAndView.addObject("cycleDataLogList", cycleDataLogList);	
		
		return modelAndView;
	}
	
	/**
	 * 연계데이터 상세로그 데이터 가져오기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/linkMng/linkMngCycleLog.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView linkMngCycleLog(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException,Exception{
		// Json Parameter에서 Map Type으로 변환
		//Map<String, Object> analysisInfo = CommonUtil.convertMapToJson(params, "analysisInfo");
		List<Map<String, Object>> cycleDataLogList = linkMngService.selectLinkDataLog(params);
		
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);		// ModelAndView 객체 생성
		
		modelAndView.addObject("cycleDataLogList", cycleDataLogList);	
		
		return modelAndView;
	}
	
}
