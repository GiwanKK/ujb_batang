package kr.go.uijeongbu.dashBoard.complain.complainStatus.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 민원 - 민원실 현황 service 클래스
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
public interface ComplainStatusService {
	
	/**
	 * 대시보드 민원 - 민원 현황실 현황 날짜 조회
	 * @param param
	 * @return
	 */
	Map<String, Object> selectComplainReceiptDate();
	
	/**
	 * 대시보드 민원 - 민원 접수 현황 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectComplainReceipt(Map<String, Object> param);
	
	/**
	 * 대시보드 민원 - 각동 주민센터 일빈민원접수 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectComplainStatus(Map<String, Object> param);
	
	/**
	 * 대시보드 민원 - 시정 뉴스 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectComplainNews(Map<String, Object> param);
	
	/**
	 * 대시보드 민원 - 민원 접수 현황 실시간 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectComplainLiveReceipt();
	
	/**
	 * 대시보드 민원 - 각동 주민센터 일빈민원접수 실시간 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> selectComplainLiveStatus();

	/**
	 * 대시보드 민원 - 실시간 데이터의 기준 시간 조회
	 * @return
	 */
	Map<String, Object> selectComplainLastDate();
	
	/**
	 * 대시보드 민원 - 시정 뉴스 데이터 조회
	 * @param param
	 * @return
	 */
	List<Map<String, Object>> getMaxNewsList();
	List<Map<String, Object>> getMaxNewsList1(Map<String, Object> params);
	List<Map<String, Object>> getMaxNewsList2(Map<String, Object> params);
	
	
}
