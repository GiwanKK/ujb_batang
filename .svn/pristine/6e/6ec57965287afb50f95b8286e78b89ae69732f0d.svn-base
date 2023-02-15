package kr.go.uijeongbu.dashBoard.communication.cctvInfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.go.uijeongbu.cmm.service.impl.ComAbstractDAO;

/**
 * 대시보드 소통 및 CCTV 현황 > CCTV 정보  - mapper 클래스
 * @author 김혜림
 * @since 2021. 08. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *     수정일			         수정자				수정내용
 *  -------------    -------------   ----------------------
 *  2021. 08. 25.	        김 혜 림                         최초생성
 *   
 * </pre>
 */

@Repository("cctvInfoMapper")
public class CctvInfoMapper extends ComAbstractDAO {


	public List<Map<String, Object>> selectCCTVPointData(Map<String, Object> param) {
		return selectList("CCTVInfoMapper.selectCCTVPointData", param);
	}

	public List<Map<String, Object>> selectCCTVPurposeList() {
		return selectList("CCTVInfoMapper.selectCCTVPurposeList");
	}

	
}
