package kr.go.uijeongbu.dashBoard.communication.communInfo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.uijeongbu.dashBoard.communication.communInfo.service.CommunInfoService;

/**
 * 대시보드 소통 및 CCTV 현황 > 소통 정보  - serviceImpl 클래스
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

@Service("communInfoService")
public class CommunInfoServiceImpl implements CommunInfoService {
	
	@Resource(name = "communInfoMapper")
	private CommunInfoMapper communInfoMapper;

	@Override
	public List<Map<String, Object>> selectLinkData() {
		return communInfoMapper.selectLinkData();
	}
	
}
