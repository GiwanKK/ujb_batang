package kr.go.uijeongbu.dashBoard.business.businessStatus.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 사업추진 - 사업추진 현황 mapper 클래스
 * @author 김부권
 * @since 2021. 08. 09.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 09.	        김 부 권              최초생성
 *   
 * </pre>
 */

@Repository("businessStatusMapper")
public class BusinessStatusMapper extends ComAbstractDAO {
	
	/**
	 * 대시보드 사업추진 - 사업추진 대시보드 검색기간  조회
	 * @return
	 */
	public Map<String, Object> selectBusiStatusDate() {
		return selectOne("BusinessStatusMapper.selectBusiStatusDate");
	}
	
	
	/**
	 * 대시보드 사업추진 - 희망도시  데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectBusiStatusHoep(Map<String, Object> param) {
		return selectList("BusinessStatusMapper.selectBusiStatusHoep", param);
	}
	
	
	/**
	 * 대시보드 사업추진 - 선진교통도시 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectBusiStatusTrans(Map<String, Object> param) {
		return selectList("BusinessStatusMapper.selectBusiStatusTrans", param);
	}
	
	
	/**
	 * 대시보드 사업추진 - 교육선도도시 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectBusiStatusEducation(Map<String, Object> param) {
		return selectList("BusinessStatusMapper.selectBusiStatusEducation", param);
	}
	
	
	/**
	 * 대시보드 사사업추진 - 복지도시  데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectBusiStatusWelfare(Map<String, Object> param) {
		return selectList("BusinessStatusMapper.selectBusiStatusWelfare", param);
	}
	
	
	/**
	 * 대시보드 사업추진 - 행정도시 데이터 조회
	 * @return
	 */
	public List<Map<String, Object>> selectBusiStatusPublic(Map<String, Object> param) {
		return selectList("BusinessStatusMapper.selectBusiStatusPublic", param);
	}
	
	/**
	 * 대시보드 사업추진 - 클릭 정보 가져오기
	 * @return
	 */
	public Map<String, Object> selectBusiStatusLoad(Map<String, Object> param) {
		return selectOne("BusinessStatusMapper.selectBusiStatusLoad", param);
	}
	

	

}
