package kr.go.uijeongbu.dashBoard.communication.communInfo.service;

import java.util.List;
import java.util.Map;
/**
 * 대시보드 소통 및 CCTV 현황 > 소통 정보  - service 클래스
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
public interface CommunInfoService {

	List<Map<String, Object>> selectLinkData();
	
	
}
