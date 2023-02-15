package kr.go.uijeongbu.dashBoard.city.cityStatistics.web;

import java.sql.SQLException;
import java.util.ArrayList;
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
import kr.go.uijeongbu.dashBoard.city.cityStatistics.service.CityStatisticsService;
import kr.go.uijeongbu.manager.logMng.service.LogService;

/**
 * 도시통계지표 대시보드 controller
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
 *  2021. 08. 18.	        김 부 권              최초생성
 *   
 * </pre>
 */
@Controller
public class CityStatisticsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityStatisticsController.class);
	@Resource(name = "cityStatisticsService")
	private CityStatisticsService cityStatisticsService;
	
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
	@RequestMapping(value = "/dashBoard/city/cityStatistics.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String cityStatistics(HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		
		//검색기간 넣기
		Map<String, Object> date = cityStatisticsService.selectCityStatisticstDate();
		model.addAttribute("date",date);	
		//메뉴코드
		String menuCode = "MENU_00037";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
		return "/dashBoard/city/cityStatistics";
		
    }
	
	/**
	 * 도시통계지표 대시보드 데이터 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/city/cityStatisticsData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView cityStatisticsData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		
		//도시통계지표  데이터 조회
		List<Map<String, Object>> cityStatisticsData = cityStatisticsService.selectCityStatisticsData(params);
		
		int cityStatisticsCnt = cityStatisticsService.selectCityStatisticsCnt(params);
		
		List<Map<String, Object>> cityStatistics = cityStatisticsAdd(cityStatisticsData);
		
		modelAndView.addObject("cityStatisticsData", cityStatistics);
		modelAndView.addObject("cityStatisticsCnt", cityStatisticsCnt);
		
		return modelAndView;
		
	}
	
	//도시통계 지표 데이터 가공
	private List<Map<String, Object>> cityStatisticsAdd(List<Map<String, Object>> cityStatisticsData) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String categoryName = "";
		int no = 0;
		
		//lclaIx sclaIx stdrYy valu
		
		for( int i = 0 ; i < cityStatisticsData.size(); i++ ) {
			//결과 담을 객체
			Map<String, Object> data = new HashMap<String, Object>();
			if( !categoryName.equals(cityStatisticsData.get(i).get("lclaIx").toString()) ) {
				no += 1;
				categoryName = cityStatisticsData.get(i).get("lclaIx").toString();
				
			}
			
			data.put("no", no-1);
			data.put("lclaIx", categoryName);
			data.put("sclaIx", cityStatisticsData.get(i).get("sclaIx").toString());
			data.put("stdrYy", cityStatisticsData.get(i).get("stdrYy").toString());
			data.put("valu", cityStatisticsData.get(i).get("valu").toString());
			data.put("keyNo", cityStatisticsData.get(i).get("keyNo").toString());
			list.add(data);
		}
		return list;
	}

	/**
	 * 클릭한 데이터 조건 조회
	 * @param request
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/dashBoard/city/cityStatisticsClickData.do", method = RequestMethod.POST, produces = ("application/json; charset-UTF-8"))
	public ModelAndView cityStatisticsClickData(HttpServletRequest request, @RequestBody Map<String, Object> params) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		List<Map<String, Object>> chartData = cityStatisticsService.selectCityStatisticsChart(params);
		
		modelAndView.addObject("chartData", chartData);
		//modelAndView.addObject("list", data.get("list"));
		//modelAndView.addObject("page", data.get("page"));
		
		return modelAndView;
		
	}
	
}
