package kr.go.uijeongbu.dashBoard.complain.complainStatus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 민원 - 민원 현황실 mapper 클래스
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

@Repository("complainStatusMapper")
public class ComplainStatusMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 민원 - 민원 현황실 현황 날짜 조회
	 * @return
	 */
	public Map<String, Object> selectComplainReceiptDate() {
		return selectOne("ComplainStatusMapper.selectComplainReceiptDate");
	}
	
	
	/**
	 * 대시보드 민원 - 민원 접수 현황 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectComplainReceipt(Map<String, Object> param) {
		return selectList("ComplainStatusMapper.selectComplainReceipt", param);
	}
	
	
	/**
	 * 대시보드 민원 - 각동 주민센터 일빈민원접수 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectComplainStatus(Map<String, Object> param) {
		return selectList("ComplainStatusMapper.selectComplainStatus", param);
	}
	
	/**
	 * 대시보드 민원 - 시정 뉴스 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectComplainNews(Map<String, Object> param) {
		return selectList("ComplainStatusMapper.selectComplainNews", param);
	}

	
	
	/**
	 * 대시보드 민원 - 민원 접수 현황 실시간 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectComplainLiveReceipt() {
		return selectList("ComplainStatusMapper.selectComplainLiveReceipt");
	}
	
	
	/**
	 * 대시보드 민원 - 각동 주민센터 일빈민원접수 실시간 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectComplainLiveStatus() {
		return selectList("ComplainStatusMapper.selectComplainLiveStatus");
	}


	/**
	 * 대시보드 민원 - 실시간 데이터의 기준 시간 조회
	 * @return
	 */
	public Map<String, Object> selectComplainLastDate() {
		return selectOne("ComplainStatusMapper.selectComplainLastDate");
	}


	public List<Map<String, Object>> getMaxNewsList() {
		// TODO Auto-generated method stub
		return selectList("ComplainStatusMapper.getMaxNewsList");
	}


	public List<Map<String, Object>> getMaxNewsList1(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return selectList("ComplainStatusMapper.getMaxNewsList1", param);
	}


	public List<Map<String, Object>> getMaxNewsList2(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return selectList("ComplainStatusMapper.getMaxNewsList2", param);
	}
	

}
