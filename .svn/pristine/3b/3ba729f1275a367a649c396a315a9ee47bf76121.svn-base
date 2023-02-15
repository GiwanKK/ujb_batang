package kr.go.uijeongbu.manager.outDataMng.cityStatMng.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import kr.go.uijeongbu.cmm.util.CommonUtil;
import kr.go.uijeongbu.cmm.vo.CityStatFileUploadVO;
import kr.go.uijeongbu.cmm.vo.LoginVO;
import kr.go.uijeongbu.manager.logMng.service.LogService;
import kr.go.uijeongbu.manager.outDataMng.cityStatMng.service.CityStatMngService;

/**
 * 관리자 > 도시통계 Upload 데이터 관리 Controller 클래스
 * @author 권기완
 * @since 2022. 08. 10.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2022.08.10.   	권기완                      최초 생성
 *   
 * </pre>
 */
@Controller
public class CityStatMngController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityStatMngController.class);
	
	@Autowired
	private MappingJackson2JsonView jsonView;				// Json 데이터를 Return 받기위해 Controller 마다 선언해준다
	
	@Resource(name = "logService")
	private LogService logService;				// DB 서비스 호출
	
	@Resource(name = "cityStatMngService")
	private CityStatMngService cityStatMngService;			// DB 서비스 호출 데이터 생성
	
	/**
	 * 관리자 > 도시통계 Upload 데이터 관리 화면
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/outDataMng/cityStatMng.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String cityStatMng(/*@RequestBody Map<String, Object> params,*/ HttpServletRequest request, ModelMap model) throws NullPointerException, Exception {
		try {
		//메뉴코드
		String menuCode = "MENU_00061";
		// Parameter 객체
		Map<String, Object> paramInfo = new HashMap<String, Object>();
		// 로그인 사용자 정보를 Session에서 가져오기
		LoginVO loginVO = CommonUtil.getLoginInfo();
		paramInfo.put("loginId", loginVO.getId());
		paramInfo.put("menuCode", menuCode);
		logService.createMenuLog(paramInfo);
        return "/manager/outDataMng/cityStatMng";
		}catch (SQLException e) {
			LOGGER.info("outDataMng SQLException Error");
			return "/common/errorPage/error";
		}catch (Exception e) {
			LOGGER.info("outDataMng Error");
			return "/common/errorPage/error";
		}
    }
	
	/**
	 * Upload 데이터 목록 가져오기
	 * @param params
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mamager/uploadDataMng/getCityStatList.do", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public ModelAndView getCityStatList(@RequestBody Map<String, Object> params, HttpServletRequest request, ModelMap model) throws SQLException, Exception {
		// ModelAndView 객체 생성
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		try {
		// Json Parameter에서 Map Type으로 변환
		Map<String, Object> paramInfo = CommonUtil.convertMapToJson(params, "paramInfo");

		// Upload 데이터 목록 조회
		List<Map<String, Object>> uploadDataList = cityStatMngService.selectCityStatList(paramInfo);

		// ModelAndView에 데이터 넣기
		modelAndView.addObject("gridList", uploadDataList);
		}catch (SQLException e) {
			LOGGER.info("getUploadDataList SQLException Error");
		}catch (Exception e) {
			LOGGER.info("getUploadDataList Error");
		}
		return modelAndView;
	}
	
	/**
	 * Upload 데이터 정보 저장하기
	 * @param multiRequest
	 * @param request
	 * @return
	 * @throws Exception
	 */
	//@RequestMapping(value = "/mamager/uploadDataMng/fileDataUpload.do")
	@RequestMapping(value = "/mamager/uploadDataMng/cityStatUpload.do")
	public ModelAndView createUploadData(final MultipartHttpServletRequest multiRequest, HttpServletRequest request) throws SQLException, Exception {
		
		//int resultCnt = 0;
		String resultValue = "Y";
		String resultMsg = "";
		
		try{
			
			// DB 처리 Parameter 객체
			Map<String, Object> paramInfo = new HashMap<String, Object>();
			
			// 화면 데이터 받아오기
			int targetMonth = Integer.parseInt(multiRequest.getParameter("targetMonth"));
			
			// Parameter 설정
			paramInfo.put("targetMonth", targetMonth);
			
			// 첨부파일 데이터 받아오기
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			MultipartFile file = multiRequest.getFile("uploadFile");
			String fileNm = files.get("uploadFile").getOriginalFilename();
			String last = fileNm.substring(fileNm.lastIndexOf('.') + 1);
			// 파일 업로드 처리하기
			Map<String, Object> resultFileUpload = new HashMap<String, Object>();
			if(last.equals("xlsx") || last.equals("xls")) {
				resultFileUpload = fileDataUploadExcel(paramInfo, file);
			}else if (last.equals("csv")) {
				resultFileUpload = fileDataUploadCsv(paramInfo, file);
			}else {
				resultValue = "N";
				resultMsg = "파일은 엑셀 또는 csv 파일만 업로드 가능합니다.";
			}
			
			// 파일 업로드 처리 결과 받아오기
			if( resultFileUpload.get("resultValue") != null )  resultValue = resultFileUpload.get("resultValue").toString();
			if( resultFileUpload.get("resultMsg") != null ) resultMsg = resultFileUpload.get("resultMsg").toString();
			
		}catch(RuntimeException ex) {
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
		}catch(Exception ex) {
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
		}finally {
			//System.out.println("============================================ Start Date Time : " + strStartDateTime + "============================================");
			//System.out.println("============================================   End Date Time : " + strEndDateTime + "============================================");
		}
		
		ModelAndView modelAndView = CommonUtil.makeModelAndView(jsonView);
		modelAndView.addObject("resultValue", resultValue);
		modelAndView.addObject("resultMsg", resultMsg);
		
		return modelAndView;
	}
	
	
	/**
	 * 엑셀 업로드
	 * @param paramInfo
	 * @param file
	 * @return
	 */
	private Map<String, Object> fileDataUploadExcel(Map<String, Object> paramInfo, MultipartFile file) {
	
		// 처리결과 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String resultValue = "Y";			// 처리 완료 여부
		String resultMsg = "";				// 처리 결과 메시지
		int deleteResult = 0;
		int uploadResult = 0;
		String yearChkResult = "N";
		
		try {
			int targetMonth = Integer.parseInt(paramInfo.get("targetMonth").toString());
			 XSSFWorkbook workbook = null;
			 workbook = new XSSFWorkbook(file.getInputStream());
			 XSSFSheet worksheet = workbook.getSheetAt(0);
			 XSSFRow yearChk = worksheet.getRow(0);
			 
			 //엑셀에 해당 년도 데이터가 있는지 확인
			 for(int y = 0; y < yearChk.getPhysicalNumberOfCells(); y++) {
				 if(yearChk.getCell(y).toString().equals(Integer.toString(targetMonth))) {
					 yearChkResult = "Y";
				 }
			 }
			 
			 //해당 년도 있으면 엑셀 파일 읽어서 DB insert
			 if(yearChkResult.equals("Y")){
				// 기존 해당 년도 데이터 지우기
				deleteResult = cityStatMngService.deleteData(paramInfo);
				
				 CityStatFileUploadVO data = new CityStatFileUploadVO();
				 String notVal = "";
				 for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
					 
				      XSSFRow row = worksheet.getRow(i);
				      //대분류 VO객체에 넣기
				      if(row.getCell(1).getStringCellValue().equals("")) {
				    	  data.setLclaIx(notVal);
				      }else {
				      data.setLclaIx(row.getCell(1).getStringCellValue());
				      notVal = row.getCell(1).getStringCellValue();
				      }
				      //소분류 VO객제체 넣기
				      data.setSclaIx(row.getCell(2).getStringCellValue());
				      //년도 VO객체에 넣기
				      data.setStdrYy(targetMonth);
				      //valu값 VO객체에  넣기
				      float setVal = 0;
				      for(int j = 1; j < row.getPhysicalNumberOfCells(); j++) {
				    	  XSSFRow firstRow = worksheet.getRow(0);
				    	  if(firstRow.getCell(j).getStringCellValue().equals(Integer.toString(targetMonth))) {
				    		  if (row.getCell(j).getCellType() != 0) {
				    			  setVal = 0 ;
				    			  data.setValu(setVal);
				    		  }else {
				    		  setVal = Float.parseFloat(row.getCell(j).getRawValue());
				    		  data.setValu(setVal);
				    		  }
				    	  }
				      }
				      uploadResult = cityStatMngService.insertData(data);
				    }
				 resultMsg = "업로드에 성공하였습니다.";
			 }else {
				resultMsg = "선택하신 년도의 데이터가 존재하지 않습니다.";
				resultValue = "N";
			 }
		}catch(SQLException ex) {
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다.";
		}catch(Exception ex) {
			LOGGER.info(" Error : " + ex);
			resultValue = "N";
			resultMsg = "오류가 발생하였습니다. 데이터를 확인해주세요.";
		}
		resultMap.put("resultValue", resultValue);
		resultMap.put("resultMsg", resultMsg);
		return resultMap;
	}
	
	/**
	 * csv 업로드
	 * @param paramInfo
	 * @param file
	 * @return
	 */
	private Map<String, Object> fileDataUploadCsv(Map<String, Object> paramInfo, MultipartFile file) {
	
		// 처리결과 객체
				Map<String, Object> resultMap = new HashMap<String, Object>();
				
				String resultValue = "Y";			// 처리 완료 여부
				String resultMsg = "";				// 처리 결과 메시지
				int deleteResult = 0;
				int uploadResult = 0;
				String yearChkResult = "N";
				List<String> valueList = new ArrayList<String>();
				List<List<String>> totalList = new ArrayList<List<String>>();
				
				try {
					
					int targetMonth = Integer.parseInt(paramInfo.get("targetMonth").toString());
					//MultipartFile 를 file 객체로 변환
					File csv = creatCsv(file);
					//csv 읽기
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csv), "EUC-KR"));
					String line = null;
					
					while ((line = br.readLine()) != null) {
		                String column[] = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)" , -1);
		                if(line.equals("")) {
		                    line = " ";
		                }
		                valueList = Arrays.asList(column);
		                totalList.add(valueList);
		            }
		            br.close();
		            int chkYearI = 0;
		            for(int i =1; i < totalList.get(0).size(); i++) { //첫행을 제외하고 Seg확인
		            	if(totalList.get(0).get(i).toString().equals(Integer.toString(targetMonth))){
		            		 yearChkResult = "Y";
		            		 chkYearI = i ;
		            	}
	            	}
		          //해당 년도 있으면 엑셀 파일 읽어서 DB insert
					 if(yearChkResult.equals("Y")){
						
						// 기존 해당 년도 데이터 지우기
						deleteResult = cityStatMngService.deleteData(paramInfo);	
						CityStatFileUploadVO data = new CityStatFileUploadVO();
						for(int i = 1; i < totalList.size(); i++) { //첫행을 제외하고 Seg확인
							//대분류 VO객체에 넣기
							data.setLclaIx(totalList.get(i).get(1).toString().replaceAll("\"",""));
							//소분류 VO객체에 넣기
							data.setSclaIx(totalList.get(i).get(2).toString().replaceAll("\"",""));
							//년도 VO객체에 넣기
						    data.setStdrYy(targetMonth);
						    //valu값 VO객체에  넣기
						    float setVal = 0;
						    if(totalList.get(i).get(chkYearI).toString().replaceAll("[^0-9.]", "").equals("")) {
						    	data.setValu(setVal);
						    }else {
						    	setVal = Float.parseFloat(totalList.get(i).get(chkYearI));
						    	data.setValu(setVal);
						    }
						  uploadResult = cityStatMngService.insertData(data);
		            	}
						 resultMsg = "업로드에 성공하였습니다.";
					 }
				}catch(SQLException ex) {
					resultValue = "N";
					resultMsg = "오류가 발생하였습니다.";
				}catch(Exception ex) {
					LOGGER.info(" Error : " + ex);
					resultValue = "N";
					resultMsg = "오류가 발생하였습니다. 데이터를 확인해주세요.";
				}
				resultMap.put("resultValue", resultValue);
				resultMap.put("resultMsg", resultMsg);
				return resultMap;
	}
	
	private File creatCsv(MultipartFile file) throws IOException {
		File csv = new File(file.getOriginalFilename());
		csv.createNewFile();
		FileOutputStream fos = new FileOutputStream(csv);
		fos.write(file.getBytes());
		fos.close();
		return csv;
	}
}
