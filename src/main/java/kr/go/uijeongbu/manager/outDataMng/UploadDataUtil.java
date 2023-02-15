package kr.go.uijeongbu.manager.outDataMng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.mail.iap.ConnectionException;

import kr.go.uijeongbu.cmm.util.AES256Util;
import kr.go.uijeongbu.cmm.util.ComStringUtil;
import kr.go.uijeongbu.cmm.util.ComWebUtil;
import kr.go.uijeongbu.cmm.util.GlobalProperties;

/**
 * Upload 데이터 Utility
 * @author 김부권
 * @since 2021. 08. 25.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *  수정일			수정자			수정내용
 *  -------    		-------------   ----------------------
 *  2021.08.25.   	김부권          최초 생성
 *   
 * </pre>
 */
public class UploadDataUtil {
	
	char FILE_SEPARATOR = File.separatorChar;
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadDataUtil.class);
	private Connection getConnectionDB() throws ConnectionException, Exception {
		AES256Util aesUtil = new AES256Util();
		Class.forName("org.postgresql.Driver");
		Connection con = null;
		//AES256Util 암호화 되어 들어오는 부분입니다
		String pwd = GlobalProperties.getProperty("Globals.postgres.encryptPerson");
		
		String decStr = aesUtil.decrypt(pwd);
		if (decStr == null || "".equals(decStr)) {
					
		}else {
			
			if (!decStr.matches("") && decStr.indexOf("@!#&") > 4 && decStr.length() > 8) {
			}else {
				con = DriverManager.getConnection("jdbc:log4jdbc:postgresql://192.168.1.210:5433/EZ_UJB","postgres",decStr);
				//con = DriverManager.getConnection("jdbc:log4jdbc:postgresql://105.3.10.71:5433/ez_ujb","postgres",decStr);
			}
		}
		
		con.setAutoCommit(false);
		
		return con;
	}
	
	
	/**
	 * 50셀단위 성연령별 유동인구
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makePopGenderAge(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지
		
		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.iff_agender_50cell_if" + 
				" (hcode, std_ymd, id, m00, m10, m15, m20, m25, m30, m35, m40, m45, m50, m55, m60, m65, m70," + 
				"  f00, f10, f15, f20, f25, f30, f35, f40, f45, f50, f55, f60, f65, f70, x, y)" + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = ",";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

            if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			//br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);
    			String line = "";
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 33) {
    							
    							String resultTemp = "";
    							
    							String hcode = strFileline[0];
    							String std_ymd = strFileline[1];
    							String id = strFileline[2];
    							String m00 = strFileline[3];
    							String m10 = strFileline[4];
    							String m15 = strFileline[5];
    							String m20 = strFileline[6];
    							String m25 = strFileline[7];
    							String m30 = strFileline[8];
    							String m35 = strFileline[9];
    							String m40 = strFileline[10];
    							String m45 = strFileline[11];
    							String m50 = strFileline[12];
    							String m55 = strFileline[13];
    							String m60 = strFileline[14];
    							String m65 = strFileline[15];
    							String m70 = strFileline[16];
    							String f00 = strFileline[17];
    							String f10 = strFileline[18];
    							String f15 = strFileline[19];
    							String f20 = strFileline[20];
    							String f25 = strFileline[21];
    							String f30 = strFileline[22];
    							String f35 = strFileline[23];
    							String f40 = strFileline[24];
    							String f45 = strFileline[25];
    							String f50 = strFileline[26];
    							String f55 = strFileline[27];
    							String f60 = strFileline[28];
    							String f65 = strFileline[29];
    							String f70 = strFileline[30];
    							String x = strFileline[31];
    							String y = strFileline[32];
    							if(strFileline[0].isEmpty()) {hcode = "99999999";resultTemp += ",hcode:E";}
    							if(strFileline[1].isEmpty()) {std_ymd = "99999999";resultTemp += ",std_ymd:E";}
    							if(strFileline[2].isEmpty()) {id = "99999999";resultTemp += ",id:E";}
    							if(strFileline[3].isEmpty()) {m00 = "0";resultTemp += ",m00:E";}
    							if(strFileline[4].isEmpty()) {m10 = "0";resultTemp += ",m10:E";}
    							if(strFileline[5].isEmpty()) {m15 = "0";resultTemp += ",m15:E";}

    							if(strFileline[6].isEmpty()) {m20 = "0";resultTemp += ",m20:E";}
    							if(strFileline[7].isEmpty()) {m25 = "0";resultTemp += ",m25:E";}
    							if(strFileline[8].isEmpty()) {m30 = "0";resultTemp += ",m30:E";}
    							if(strFileline[9].isEmpty()) {m35 = "0";resultTemp += ",m35:E";}
    							if(strFileline[10].isEmpty()) {m40 = "0";resultTemp += ",m40:E";}
    							if(strFileline[11].isEmpty()) {m45 = "0";resultTemp += ",m45:E";}
    							if(strFileline[12].isEmpty()) {m50 = "0";resultTemp += ",m50:E";}
    							if(strFileline[13].isEmpty()) {m55 = "0";resultTemp += ",m55:E";}
    							if(strFileline[14].isEmpty()) {m60 = "0";resultTemp += ",m60:E";}
    							if(strFileline[15].isEmpty()) {m65 = "0";resultTemp += ",m65:E";}
    							if(strFileline[16].isEmpty()) {m70 = "0";resultTemp += ",m70:E";}
    							if(strFileline[17].isEmpty()) {f00 = "0";resultTemp += ",f00:E";}
    							if(strFileline[18].isEmpty()) {f10 = "0";resultTemp += ",f10:E";}
    							if(strFileline[19].isEmpty()) {f15 = "0";resultTemp += ",f15:E";}
    							if(strFileline[20].isEmpty()) {f20 = "0";resultTemp += ",f20:E";}
    							if(strFileline[21].isEmpty()) {f25 = "0";resultTemp += ",f25:E";}
    							if(strFileline[22].isEmpty()) {f30 = "0";resultTemp += ",f30:E";}
    							if(strFileline[23].isEmpty()) {f35 = "0";resultTemp += ",f35:E";}
    							if(strFileline[24].isEmpty()) {f40 = "0";resultTemp += ",f40:E";}
    							if(strFileline[25].isEmpty()) {f45 = "0";resultTemp += ",f45:E";}
    							if(strFileline[26].isEmpty()) {f50 = "0";resultTemp += ",f50:E";}
    							if(strFileline[27].isEmpty()) {f55 = "0";resultTemp += ",f55:E";}
    							if(strFileline[28].isEmpty()) {f60 = "0";resultTemp += ",f60:E";}
    							if(strFileline[29].isEmpty()) {f65 = "0";resultTemp += ",f65:E";}
    							if(strFileline[30].isEmpty()) {f70 = "0";resultTemp += ",f70:E";}
    							if(strFileline[31].isEmpty()) {x = "0";resultTemp += ",x:E";}
    							if(strFileline[32].isEmpty()) {y = "0";resultTemp += ",y:E";}
    							//hcode, std_ymd, id, m00, m10, m15, m20, m25, m30, m35, m40, m45, m50, m55, m60, m65, m70,
    						    //f00, f10, f15, f20, f25, f30, f35, f40, f45, f50, f55, f60, f65, f70, x, y
    							pstmt.setString(1, hcode.toString());
    			                pstmt.setString(2, std_ymd.toString());
    			                pstmt.setString(3, id.toString());
    			                pstmt.setFloat(4, Float.parseFloat(m00));
    			                pstmt.setFloat(5, Float.parseFloat(m10));
    			                pstmt.setFloat(6, Float.parseFloat(m15));
    			                pstmt.setFloat(7, Float.parseFloat(m20));
    			                pstmt.setFloat(8, Float.parseFloat(m25));
    			                pstmt.setFloat(9, Float.parseFloat(m30));
    			                pstmt.setFloat(10, Float.parseFloat(m35));
    			                pstmt.setFloat(11, Float.parseFloat(m40));
    			                pstmt.setFloat(12, Float.parseFloat(m45));
    			                pstmt.setFloat(13, Float.parseFloat(m50));
    			                pstmt.setFloat(14, Float.parseFloat(m55));
    			                pstmt.setFloat(15, Float.parseFloat(m60));
    			                pstmt.setFloat(16, Float.parseFloat(m65));
    			                pstmt.setFloat(17, Float.parseFloat(m70));
    			                pstmt.setFloat(18, Float.parseFloat(f00));
    			                pstmt.setFloat(19, Float.parseFloat(f10));
    			                pstmt.setFloat(20, Float.parseFloat(f15));
    			                pstmt.setFloat(21, Float.parseFloat(f20));
    			                pstmt.setFloat(22, Float.parseFloat(f25));
    			                pstmt.setFloat(23, Float.parseFloat(f30));
    			                pstmt.setFloat(24, Float.parseFloat(f35));
    			                pstmt.setFloat(25, Float.parseFloat(f40));
    			                pstmt.setFloat(26, Float.parseFloat(f45));
    			                pstmt.setFloat(27, Float.parseFloat(f50));
    			                pstmt.setFloat(28, Float.parseFloat(f55));
    			                pstmt.setFloat(29, Float.parseFloat(f60));
    			                pstmt.setFloat(30, Float.parseFloat(f65));
    			                pstmt.setFloat(31, Float.parseFloat(f70));
    			                pstmt.setFloat(32, Float.parseFloat(x));
    			                pstmt.setFloat(33, Float.parseFloat(y));
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}
		catch(Exception e){
            
			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
            if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	
	/**
	 * 행정동별 일자별 외국인 생활인구
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makePopDongForgService(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지
		
		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.iff_forn_if" + 
				" (std_ymd, time,hcode, chn, tha, usa, jpn, hkg, twn, vnm, rus, phl, " +
				" idn, mys, aus, sgp, can, ind, gbr, fra, deu, gcc, etc )" + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = ",";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);

    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 23) {
    							
    							String resultTemp = "";
    							String std_ymd = strFileline[0];
    							String time = strFileline[1];
    							String hcode = strFileline[2];
    							String chn = strFileline[3];
    							String tha = strFileline[4];
    							String usa = strFileline[5];
    							String jpn = strFileline[6];
    							String hkg = strFileline[7];
    							String twn = strFileline[8];
    							String vnm = strFileline[9];
    							String rus = strFileline[0];
    							String phl = strFileline[11];
    							String idn = strFileline[12];
    							String mys = strFileline[13];
    							String aus = strFileline[14];
    							String sgp = strFileline[15];
    							String can = strFileline[16];
    							String ind = strFileline[17];
    							String gbr = strFileline[18];
    							String fra = strFileline[19];
    							String deu = strFileline[20];
    							String gcc = strFileline[21];
    							String etc = strFileline[22];
    							
    							
    							if(strFileline[0].isEmpty()) {std_ymd = "999999";resultTemp += ",std_ymd:E";}
    							if(strFileline[1].isEmpty()) {hcode = "999999999";resultTemp += ",hcode:E";}
    							if(strFileline[2].isEmpty()) {time = "99";resultTemp += ",time:E";}
    							
    							if(strFileline[3].isEmpty()) {chn = "0";resultTemp += ",chn:E";}
    							if(strFileline[4].isEmpty()) {tha = "0";resultTemp += ",tha:E";}
    							if(strFileline[5].isEmpty()) {usa = "0";resultTemp += ",usa:E";}
    							if(strFileline[6].isEmpty()) {jpn = "0";resultTemp += "jpn:E";}
    							if(strFileline[7].isEmpty()) {hkg = "0";resultTemp += ",hkg:E";}
    							if(strFileline[8].isEmpty()) {twn = "0";resultTemp += ",twn:E";}
    							if(strFileline[9].isEmpty()) {vnm = "0";resultTemp += ",vnm:E";}
    							if(strFileline[10].isEmpty()) {rus = "0";resultTemp += ",rus:E";}
    							if(strFileline[11].isEmpty()) {phl = "0";resultTemp += ",phl:E";}
    							if(strFileline[12].isEmpty()) {idn = "0";resultTemp += ",idn:E";}
    							if(strFileline[13].isEmpty()) {mys = "0";resultTemp += ",mys:E";}
    							if(strFileline[14].isEmpty()) {aus = "0";resultTemp += ",aus:E";}
    							if(strFileline[15].isEmpty()) {sgp = "0";resultTemp += ",sgp:E";}
    							if(strFileline[16].isEmpty()) {can = "0";resultTemp += ",can:E";}
    							if(strFileline[17].isEmpty()) {ind = "0";resultTemp += ",ind:E";}
    							if(strFileline[18].isEmpty()) {gbr = "0";resultTemp += ",gbr:E";}
    							if(strFileline[19].isEmpty()) {fra = "0";resultTemp += ",fra:E";}
    							if(strFileline[20].isEmpty()) {deu = "0";resultTemp += ",deu:E";}
    							if(strFileline[21].isEmpty()) {gcc = "0";resultTemp += ",gcc:E";}
    							if(strFileline[22].isEmpty()) {etc = "0";resultTemp += ",etc:E";}
    							//if(strFileline[33].isEmpty()) {geom = "0";resultTemp += ",geom:E";}
    							
    							//String geom = "ST_SetSRID(ST_MakePoint('" + x_coord + "','" + y_coord + "'), 5179)";
    							
    							// ST_SetSRID(ST_MakePoint('972833.99178700', '1937029.14738900'), 5179)
    							//std_ymd, hcode, chn, tha, usa, jpn, hkg, twn, vnm, rus, phl,
    							//idn, mys, aus, sgp, can, ind, gbr, fra, deu, gcc, etc
    							pstmt.setString(1, std_ymd);
    			                pstmt.setString(2, hcode);
    			                pstmt.setString(3, time);
    			                
    			                pstmt.setFloat(4, Float.parseFloat(chn));
    			                pstmt.setFloat(5, Float.parseFloat(tha));
    			                pstmt.setFloat(6, Float.parseFloat(usa));
    			                pstmt.setFloat(7, Float.parseFloat(jpn));
    			                pstmt.setFloat(8, Float.parseFloat(hkg));
    			                pstmt.setFloat(9, Float.parseFloat(twn));
    			                pstmt.setFloat(10, Float.parseFloat(vnm));
    			                pstmt.setFloat(11, Float.parseFloat(rus));
    			                pstmt.setFloat(12, Float.parseFloat(phl));
    			                pstmt.setFloat(13, Float.parseFloat(idn));
    			                pstmt.setFloat(14, Float.parseFloat(mys));
    			                pstmt.setFloat(15, Float.parseFloat(aus));
    			                pstmt.setFloat(16, Float.parseFloat(sgp));
    			                pstmt.setFloat(17, Float.parseFloat(can));
    			                pstmt.setFloat(18, Float.parseFloat(ind));
    			                pstmt.setFloat(19, Float.parseFloat(gbr));
    			                pstmt.setFloat(20, Float.parseFloat(fra));
    			                pstmt.setFloat(21, Float.parseFloat(deu));
    			                pstmt.setFloat(22, Float.parseFloat(gcc));
    			                pstmt.setFloat(23, Float.parseFloat(etc));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){
			
			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }

            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	

	/**
	 * 50셀단위 시간대별 유동인구
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makePopTimeFlow(String filePath) throws IOException,Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지
		
		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.iff_hourly_50cell_if" + 
				" (hcode, std_ymd, id, time_00, time_01, time_02, time_03, time_04, time_05, time_06, time_07, time_08, time_09, time_10, time_11, " + 
				" time_12, time_13, time_14, time_15, time_16, time_17, time_18, time_19, time_20, time_21, time_22, time_23, x, y ) " + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = ",";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);

    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 29) {
    							
    							String resultTemp = "";
    							
    							String hcode = strFileline[0];
    							String std_ymd = strFileline[1];
    							String id = strFileline[2];
    							String time_00 = strFileline[3];
    							String time_01 = strFileline[4];
    							String time_02 = strFileline[5];
    							String time_03 = strFileline[6];
    							String time_04 = strFileline[7];
    							String time_05 = strFileline[8];
    							String time_06 = strFileline[9];
    							String time_07 = strFileline[10];
    							String time_08 = strFileline[11];
    							String time_09 = strFileline[12];
    							String time_10 = strFileline[13];
    							String time_11 = strFileline[14];
    							String time_12 = strFileline[15];
    							String time_13 = strFileline[16];
    							String time_14 = strFileline[17];
    							String time_15 = strFileline[18];
    							String time_16 = strFileline[19];
    							String time_17 = strFileline[20];
    							String time_18 = strFileline[21];
    							String time_19 = strFileline[22];
    							String time_20 = strFileline[23];
    							String time_21 = strFileline[24];
    							String time_22 = strFileline[25];
    							String time_23 = strFileline[26];
    							String x = strFileline[27];
    							String y = strFileline[28];
    							
    							if(strFileline[0].isEmpty()) {hcode = "999999";resultTemp += ",hcode";}
    							if(strFileline[1].isEmpty()) {std_ymd = "99999999";resultTemp += ",std_ymd:E";}
    							if(strFileline[2].isEmpty()) {id = "999999";resultTemp += ",id:E";}
    							if(strFileline[3].isEmpty()) {time_00 = "0";resultTemp += ",time_00:E";}
    							if(strFileline[4].isEmpty()) {time_01 = "0";resultTemp += ",time_01:E";}
    							if(strFileline[5].isEmpty()) {time_02 = "0";resultTemp += ",time_02:E";}
    							if(strFileline[6].isEmpty()) {time_03 = "0";resultTemp += ",time_03:E";}
    							if(strFileline[7].isEmpty()) {time_04 = "0";resultTemp += ",time_04:E";}
    							if(strFileline[8].isEmpty()) {time_05 = "0";resultTemp += ",time_05:E";}
    							if(strFileline[9].isEmpty()) {time_06 = "0";resultTemp += ",time_06:E";}
    							if(strFileline[10].isEmpty()) {time_07 = "0";resultTemp += ",time_07:E";}
    							if(strFileline[11].isEmpty()) {time_08 = "0";resultTemp += ",time_08:E";}
    							if(strFileline[12].isEmpty()) {time_09 = "0";resultTemp += ",time_09:E";}
    							if(strFileline[13].isEmpty()) {time_10 = "0";resultTemp += ",time_10:E";}
    							if(strFileline[14].isEmpty()) {time_11 = "0";resultTemp += ",time_11:E";}
    							if(strFileline[15].isEmpty()) {time_12 = "0";resultTemp += ",time_12:E";}
    							if(strFileline[16].isEmpty()) {time_13 = "0";resultTemp += ",time_13:E";}
    							if(strFileline[17].isEmpty()) {time_14 = "0";resultTemp += ",time_14:E";}
    							if(strFileline[18].isEmpty()) {time_15 = "0";resultTemp += ",time_15:E";}
    							if(strFileline[19].isEmpty()) {time_16 = "0";resultTemp += ",time_16:E";}
    							if(strFileline[20].isEmpty()) {time_17 = "0";resultTemp += ",time_17:E";}
    							if(strFileline[21].isEmpty()) {time_18 = "0";resultTemp += ",time_18:E";}
    							if(strFileline[22].isEmpty()) {time_19 = "0";resultTemp += ",time_19:E";}
    							if(strFileline[23].isEmpty()) {time_20 = "0";resultTemp += ",time_20:E";}
    							if(strFileline[24].isEmpty()) {time_21 = "0";resultTemp += ",time_21:E";}
    							if(strFileline[25].isEmpty()) {time_22 = "0";resultTemp += ",time_22:E";}
    							if(strFileline[26].isEmpty()) {time_23 = "0";resultTemp += ",time_23:E";}
    							if(strFileline[27].isEmpty()) {x = "0";resultTemp += ",x:E";}
    							if(strFileline[28].isEmpty()) {y = "0";resultTemp += ",y:E";}
    							
    							//hcode, std_ymd, id, time_00, time_01, time_02, time_03, time_04, time_05, time_06, time_07, time_08, time_09, time_10, time_11, 
    							//time_12, time_13, time_14, time_15, time_16, time_17, time_18, time_19, time_20, time_21, time_22, time_23, x, y
    							pstmt.setString(1, hcode);
    			                pstmt.setString(2, std_ymd);
    			                pstmt.setString(3, id);
    			                pstmt.setFloat(4, Float.parseFloat(time_00));
    			                pstmt.setFloat(5, Float.parseFloat(time_01));
    			                pstmt.setFloat(6, Float.parseFloat(time_02));
    			                pstmt.setFloat(7, Float.parseFloat(time_03));
    			                pstmt.setFloat(8, Float.parseFloat(time_04));
    			                pstmt.setFloat(9, Float.parseFloat(time_05));
    			                pstmt.setFloat(10, Float.parseFloat(time_06));
    			                pstmt.setFloat(11, Float.parseFloat(time_07));
    			                pstmt.setFloat(12, Float.parseFloat(time_08));
    			                pstmt.setFloat(13, Float.parseFloat(time_09));
    			                pstmt.setFloat(14, Float.parseFloat(time_10));
    			                pstmt.setFloat(15, Float.parseFloat(time_11));
    			                pstmt.setFloat(16, Float.parseFloat(time_12));
    			                pstmt.setFloat(17, Float.parseFloat(time_13));
    			                pstmt.setFloat(18, Float.parseFloat(time_14));
    			                pstmt.setFloat(19, Float.parseFloat(time_15));
    			                pstmt.setFloat(20, Float.parseFloat(time_16));
    			                pstmt.setFloat(21, Float.parseFloat(time_17));
    			                pstmt.setFloat(22, Float.parseFloat(time_18));
    			                pstmt.setFloat(23, Float.parseFloat(time_19));
    			                pstmt.setFloat(24, Float.parseFloat(time_20));
    			                pstmt.setFloat(25, Float.parseFloat(time_21));
    			                pstmt.setFloat(26, Float.parseFloat(time_22));
    			                pstmt.setFloat(27, Float.parseFloat(time_23));
    			                pstmt.setFloat(28, Float.parseFloat(x));
    			                pstmt.setFloat(29, Float.parseFloat(y));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}
            
		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){
			
			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	
	/**
	 * 행정동별 성연령별 생활인구
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makePopDongGenderAge(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지

		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.iff_sex_age_if" + 
				" (std_ym, std_ymd, hcode, " +
				" time, sex_age, h_pop, w_pop, v_pop) " + 
				" VALUES" + 
				" ( ?, ?, ?, ?, ?, ?, ?, ? )";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = ",";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);

    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 8) {
    							
    							String resultTemp = "";
    							
    							String std_ym = strFileline[0];
    							String std_ymd = strFileline[1];
    							String hcode = strFileline[2];
    							String time = strFileline[3];
    							String sex_age = strFileline[4];
    							String h_pop = strFileline[5];
    							String w_pop = strFileline[6];
    							String v_pop = strFileline[7];
    							
    							
    							
    							if(strFileline[0].isEmpty()) {std_ym = "999999";resultTemp += ",std_ym:E";}
    							if(strFileline[1].isEmpty()) {std_ymd = "99999999";resultTemp += ",std_ymd:E";}
    							if(strFileline[2].isEmpty()) {hcode = "999999999";resultTemp += ",hcode:E";}
    							if(strFileline[3].isEmpty()) {time = "999999999";resultTemp += ",time:E";}
    							if(strFileline[4].isEmpty()) {sex_age = "999999999";resultTemp += ",sex_age:E";}
    							if(strFileline[5].isEmpty()) {h_pop = "0";resultTemp += ",h_pop:E";}
    							if(strFileline[5].isEmpty()) {w_pop = "0";resultTemp += ",w_pop:E";}
    							if(strFileline[5].isEmpty()) {v_pop = "0";resultTemp += ",v_pop:E";}
    							
    							//std_ym, std_ymd, hcode, time, sex_age, h_pop, w_pop, v_pop
    							pstmt.setString(1, std_ym);
    			                pstmt.setString(2, std_ymd);
    			                pstmt.setString(3, hcode);
    			                pstmt.setString(4, time);
    			                pstmt.setString(5, sex_age);
    			                pstmt.setFloat(6, Float.parseFloat(h_pop));
    			                pstmt.setFloat(7, Float.parseFloat(w_pop));
    			                pstmt.setFloat(8, Float.parseFloat(v_pop));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){
			
			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	
	/**
	 * 행정동 성연령별 유입지 조합 생활인구
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makePopGenderAgeService(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지

		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.iff_sex_age_time_if" + 
				" (std_ym, std_ymd, hcode, time, inflow_cd, h_pop, w_pop, v_pop) " + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?) ";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = ",";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);

    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 8) {
    							
    							String resultTemp = "";
    							//std_ym, std_ymd, hcode, time, inflow_cd, h_pop, w_pop, v_pop
    							String std_ym = strFileline[0];
    							String std_ymd = strFileline[1];
    							String hcode = strFileline[2];
    							String time = strFileline[3];
    							String inflow_cd = strFileline[4];
    							String h_pop = strFileline[5];
    							String w_pop = strFileline[6];
    							String v_pop = strFileline[7];
    							
    							if(strFileline[0].isEmpty()) {std_ym = "999999";resultTemp += ",std_ym:E";}
    							if(strFileline[1].isEmpty()) {std_ymd = "99999999";resultTemp += ",std_ymd:E";}
    							if(strFileline[2].isEmpty()) {hcode = "999999";resultTemp += ",hcode:E";}
    							if(strFileline[3].isEmpty()) {time = "99";resultTemp += ",time:E";}
    							
    							
    							if(strFileline[4].isEmpty()) {inflow_cd = "9999999999";resultTemp += ",inflow_cd:E";}
    							if(strFileline[5].isEmpty()) {h_pop = "0";resultTemp += ",h_pop:E";}
    							if(strFileline[6].isEmpty()) {w_pop = "0";resultTemp += ",w_pop:E";}
    							if(strFileline[7].isEmpty()) {v_pop = "0";resultTemp += ",v_pop:E";}
    							
    							pstmt.setString(1, std_ym);
    			                pstmt.setString(2, std_ymd);
    			                pstmt.setString(3, hcode);
    			                pstmt.setString(4, time);
    			                
    			                pstmt.setString(5, inflow_cd);
    			                pstmt.setFloat(6, Float.parseFloat(h_pop));
    			                pstmt.setFloat(7, Float.parseFloat(w_pop));
    			                pstmt.setFloat(8, Float.parseFloat(v_pop));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null )  con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){
			
			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	/**
	 * 행정동별 유입지별 생활인구
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makePopFlowService(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지

		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.iff_time_if" + 
				" (std_ym, std_ymd, hcode, time, inflow_cd, h_pop, w_pop, v_pop )" + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ? )";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = ",";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			//br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);
    			
    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 8) {
    							
    							String resultTemp = "";
    							//std_ym, std_ymd, hcode, time, inflow_cd, h_pop, w_pop, v_pop
    							String std_ym = strFileline[0];
    							String std_ymd = strFileline[1];
    							String hcode = strFileline[2];
    							String time = strFileline[3];
    							String inflow_cd = strFileline[4];
    							String h_pop = strFileline[5];
    							String w_pop = strFileline[6];
    							String v_pop = strFileline[7];
    							
    							if(strFileline[0].isEmpty()) {std_ym = "999999";resultTemp += ",std_ym:E";}
    							if(strFileline[1].isEmpty()) {std_ymd = "99999999";resultTemp += ",std_ymd:E";}
    							if(strFileline[2].isEmpty()) {hcode = "99999999";resultTemp += ",hcode:E";}
    							if(strFileline[3].isEmpty()) {time = "99";resultTemp += ",time:E";}
    							if(strFileline[4].isEmpty()) {inflow_cd = "9999999999";resultTemp += ",inflow_cd:E";}
    							if(strFileline[5].isEmpty()) {h_pop = "0";resultTemp += ",h_pop:E";}
    							if(strFileline[6].isEmpty()) {w_pop = "0";resultTemp += ",w_pop:E";}
    							if(strFileline[7].isEmpty()) {v_pop = "0";resultTemp += ",v_pop:E";}
    							
    							pstmt.setString(1, std_ym);
    			                pstmt.setString(2, std_ymd);
    			                pstmt.setString(3, hcode);
    			                pstmt.setString(4, time);
    			                pstmt.setString(5, inflow_cd);
    			                pstmt.setFloat(6, Float.parseFloat(h_pop));
    			                pstmt.setFloat(7, Float.parseFloat(w_pop));
    			                pstmt.setFloat(8, Float.parseFloat(v_pop));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){

			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	/**
	 * 법인매출
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makeSaleCorp(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지

		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.ifc_corp_sls_if" + 
				" (block_cd, toi_lcla_nm, toi_midc_nm, crtr_ym, crtr_ymd, dow, corp_prsn_se, use_amt, use_cnt, pay_custm_cnt ) " +
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = "\t";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			//br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);
    			
    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
							
    						if(strFileline.length == 10) {
    							
    							String resultTemp = "";
    							//block_cd, toi_lcla_nm, toi_midc_nm, crtr_ym, crtr_ymd, dow, corp_prsn_se,
    							//use_amt, use_cnt, pay_custm_cnt
    							String block_cd = strFileline[0];
    							String toi_lcla_nm = strFileline[1];
    							String toi_midc_nm = strFileline[2];
    							String crtr_ym = strFileline[3];
    							String crtr_ymd = strFileline[4];
    							String dow = strFileline[5];
    							String corp_prsn_se = strFileline[6];
    							String use_amt = strFileline[7];
    							String use_cnt = strFileline[8];
    							String pay_custm_cnt = strFileline[9];
    							
    							
    							
    							if(strFileline[0].isEmpty()) {block_cd = "999999";resultTemp += ",std_ym:E";}
    							if(strFileline[1].isEmpty()) {toi_lcla_nm = "9999999999";resultTemp += ",adm_cd:E";}
    							if(strFileline[2].isEmpty()) {toi_midc_nm = "";resultTemp += ",adm_nm:E";}
    							if(strFileline[3].isEmpty()) {crtr_ym = "0";resultTemp += ",m_sum:E";}
    							if(strFileline[4].isEmpty()) {crtr_ymd = "0";resultTemp += ",m_age_sum:E";}
    							if(strFileline[5].isEmpty()) {dow = "0";resultTemp += ",m_0004:E";}
    							if(strFileline[6].isEmpty()) {corp_prsn_se = "0";resultTemp += ",m_0509:E";}
    							if(strFileline[7].isEmpty()) {use_amt = "0";resultTemp += ",m_1014:E";}
    							if(strFileline[8].isEmpty()) {use_cnt = "0";resultTemp += ",m_1519:E";}
    							if(strFileline[9].isEmpty()) {pay_custm_cnt = "0";resultTemp += ",m_2024:E";}
    							
    							
    							pstmt.setString(1, block_cd);
    			                pstmt.setString(2, toi_lcla_nm);
    			                pstmt.setString(3, toi_midc_nm);
    			                pstmt.setString(4, crtr_ym);
    			                pstmt.setString(5, crtr_ymd);
    			                pstmt.setString(6, dow);
    			                pstmt.setString(7, corp_prsn_se);
    			                pstmt.setFloat(8, Float.parseFloat(use_amt));
    			                pstmt.setFloat(9, Float.parseFloat(use_cnt));
    			                pstmt.setFloat(10, Float.parseFloat(pay_custm_cnt));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){
			
			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	
	
	/**
	 * 외국인 매출
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makeSaleForeigner(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지

		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.ifc_forn_sls_if" + 
				" (emd_nm, toi_lcla_nm, toi_midc_nm, crtr_ym, nation, use_amt, use_cnt, pay_custm_cnt)" + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?)";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = "\t";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			//br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);
    			
    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
							
    						
    						if(strFileline.length == 8) {
    							//emd_nm, toi_lcla_nm, toi_midc_nm, crtr_ym, nation, use_amt, use_cnt, pay_custm_cnt
    							String resultTemp = "";
    							
    							String emd_nm = strFileline[0];
    							String toi_lcla_nm = strFileline[1];
    							String toi_midc_nm = strFileline[2];
    							String crtr_ym = strFileline[3];
    							String nation = strFileline[4];
    							String use_amt = strFileline[5];
    							String use_cnt = strFileline[6];
    							String pay_custm_cnt = strFileline[7];
    							
    							if(strFileline[0].isEmpty()) {emd_nm = "999999";resultTemp += ",std_ym:E";}
    							if(strFileline[1].isEmpty()) {toi_lcla_nm = "999999";resultTemp += ",std_ymd:E";}
    							if(strFileline[2].isEmpty()) {toi_midc_nm = "999999";resultTemp += ",sido_nm:E";}
    							if(strFileline[3].isEmpty()) {crtr_ym = "999999";resultTemp += ",sig_nm:E";}
    							if(strFileline[4].isEmpty()) {nation = "999999";resultTemp += ",user_type:E";}
    							if(strFileline[5].isEmpty()) {use_amt = "";resultTemp += ",cat_biz:E";}
    							if(strFileline[6].isEmpty()) {use_cnt = "";resultTemp += ",sub_cat_biz:E";}
    							if(strFileline[7].isEmpty()) {pay_custm_cnt = "0";resultTemp += ",sum:E";}
    							
    							pstmt.setString(1, emd_nm);
    			                pstmt.setString(2, toi_lcla_nm);
    			                pstmt.setString(3, toi_midc_nm);
    			                pstmt.setString(4, crtr_ym);
    			                pstmt.setString(5, nation);
    			                pstmt.setInt(6, Integer.parseInt(use_amt));
    			                pstmt.setInt(7, Integer.parseInt(use_cnt));
    			                pstmt.setInt(8, Integer.parseInt(pay_custm_cnt));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null )  con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){

			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	
	/**
	 * 일별/시간대별 매출
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makeSaleDayTime(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지

		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.ifc_hr_sls_if" + 
				" (block_cd, toi_lcla_nm, toi_midc_nm, crtr_ym, crtr_ymd, dow, hr, corp_prsn_se, inflow_se, use_amt, use_cnt, pay_custm_cnt)" + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::numeric, ?::numeric)";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = "\t";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			//br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);

    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 12) {
    							//block_cd, toi_lcla_nm, toi_midc_nm, crtr_ym, crtr_ymd, 
    							//dow, hr, corp_prsn_se, inflow_se, use_amt, use_cnt, pay_custm_cnt
    							String resultTemp = "";
    							
    							String block_cd = strFileline[0];
    							String toi_lcla_nm = strFileline[1];
    							String toi_midc_nm = strFileline[2];
    							String crtr_ym = strFileline[3];
    							String crtr_ymd = strFileline[4];
    							String dow = strFileline[5];
    							String hr = strFileline[6];
    							String corp_prsn_se = strFileline[7];
    							String inflow_se = strFileline[8];
    							String use_amt = strFileline[9];
    							String use_cnt = strFileline[10];
    							String pay_custm_cnt = strFileline[11];
    							
    							if(strFileline[0].isEmpty()) {block_cd = "999999";resultTemp += ",block_cd:E";}
    							if(strFileline[1].isEmpty()) {toi_lcla_nm = "99999999";resultTemp += ",toi_lcla_nm:E";}
    							if(strFileline[2].isEmpty()) {toi_midc_nm = "99999999";resultTemp += ",toi_midc_nm:E";}
    							if(strFileline[3].isEmpty()) {crtr_ym = "999999";resultTemp += ",crtr_ym:E";}
    							if(strFileline[4].isEmpty()) {crtr_ymd = "99999999";resultTemp += ",crtr_ymd:E";}
    							if(strFileline[5].isEmpty()) {dow = "999";resultTemp += ",dow:E";}
    							if(strFileline[6].isEmpty()) {hr = "999999";resultTemp += ",hr:E";}
    							if(strFileline[7].isEmpty()) {corp_prsn_se = "999999";resultTemp += ",corp_prsn_se:E";}
    							if(strFileline[8].isEmpty()) {inflow_se = "999999";resultTemp += ",inflow_se:E";}
    							if(strFileline[9].isEmpty()) {use_amt = "0";resultTemp += ",use_amt:E";}
    							if(strFileline[10].isEmpty()) {use_cnt = "0";resultTemp += ",use_cnt:E";}
    							if(strFileline[11].isEmpty()) {pay_custm_cnt = "0";resultTemp += ",pay_custm_cnt:E";}
    							
    							pstmt.setString(1, block_cd);
    			                pstmt.setString(2, toi_lcla_nm);
    			                pstmt.setString(3, toi_midc_nm);
    			                pstmt.setString(4, crtr_ym);
    			                pstmt.setString(5, crtr_ymd);
    			                pstmt.setString(6, dow);
    			                pstmt.setString(7, hr);
    			                pstmt.setString(8, corp_prsn_se);
    			                pstmt.setString(9, inflow_se);
    			                pstmt.setFloat(10, Float.parseFloat(use_amt));
    			                pstmt.setFloat(11, Float.parseFloat(use_cnt));
    			                pstmt.setFloat(12, Float.parseFloat(pay_custm_cnt));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){

			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	
	
	/**
	 * 월별/유입지별 매출
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makeSaleMonthFlow(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지

		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.ifc_inflow_sls_if" + 
				" (block_cd, toi_lcla_nm, toi_midc_nm, crtr_ym, corp_prsn_se, custm_addr_ctpv, custm_addr_sgg, custm_addr_emd, use_amt, use_cnt, pay_custm_cnt)" + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = "\t";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			//br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);
    			
    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 11) {
    							
    							String resultTemp = "";
    							//block_cd, toi_lcla_nm, toi_midc_nm, crtr_ym, corp_prsn_se, custm_addr_ctpv, 
    							//custm_addr_sgg, custm_addr_emd, use_amt, use_cnt, pay_custm_cnt
    							String block_cd = strFileline[0];
    							String toi_lcla_nm = strFileline[1];
    							String toi_midc_nm = strFileline[2];
    							String crtr_ym = strFileline[3];
    							String corp_prsn_se = strFileline[4];
    							String custm_addr_ctpv = strFileline[5];
    							String custm_addr_sgg = strFileline[6];
    							String custm_addr_emd = strFileline[7];
    							String use_amt = strFileline[8];
    							String use_cnt = strFileline[9];
    							String pay_custm_cnt = strFileline[10];
    							
    							if(strFileline[0].isEmpty()) {block_cd = "999999";resultTemp += ",block_cd:E";}
    							if(strFileline[1].isEmpty()) {toi_lcla_nm = "99999999";resultTemp += ",toi_lcla_nm:E";}
    							if(strFileline[2].isEmpty()) {toi_midc_nm = "99999999";resultTemp += ",toi_midc_nm:E";}
    							if(strFileline[3].isEmpty()) {crtr_ym = "999999";resultTemp += ",crtr_ym:E";}
    							if(strFileline[4].isEmpty()) {corp_prsn_se = "99999999";resultTemp += ",corp_prsn_se:E";}
    							if(strFileline[5].isEmpty()) {custm_addr_ctpv = "99999999";resultTemp += ",custm_addr_ctpv:E";}
    							if(strFileline[6].isEmpty()) {custm_addr_sgg = "99999999";resultTemp += ",custm_addr_sgg:E";}
    							if(strFileline[7].isEmpty()) {custm_addr_emd = "99999999";resultTemp += ",custm_addr_emd:E";}
    							if(strFileline[8].isEmpty()) {use_amt = "0";resultTemp += ",use_amt:E";}
    							if(strFileline[9].isEmpty()) {use_cnt = "0";resultTemp += ",use_cnt:E";}
    							if(strFileline[10].isEmpty()) {pay_custm_cnt = "0";resultTemp += ",pay_custm_cnt:E";}
    							
    							pstmt.setString(1, block_cd);
    			                pstmt.setString(2, toi_lcla_nm);
    			                pstmt.setString(3, toi_midc_nm);
    			                pstmt.setString(4, crtr_ym);
    			                pstmt.setString(5, corp_prsn_se);
    			                pstmt.setString(6, custm_addr_ctpv);
    			                pstmt.setString(7, custm_addr_sgg);
    			                pstmt.setString(8, custm_addr_emd);
    			                pstmt.setFloat(9, Float.parseFloat(use_amt));
    			                pstmt.setFloat(10, Float.parseFloat(use_cnt));
    			                pstmt.setFloat(11, Float.parseFloat(pay_custm_cnt));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){

			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	
	/**
	 * 일별/성별/연령대별 매출
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makeSaleDayGenderAge(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지

		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.ifc_sexd_age_sls_if" + 
				" (block_cd, toi_lcla_nm, toi_midc_nm, crtr_ym, crtr_ymd, dow, corp_prsn_se, sexd_cd, age, inflow_se, use_amt, use_cnt, pay_custm_cnt)" + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = "\t";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			//br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);
    			
    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 13) {
    							
    							String resultTemp = "";
    							//block_cd, toi_lcla_nm, toi_midc_nm, crtr_ym, crtr_ymd, dow, corp_prsn_se, 
    							//sexd_cd, age, inflow_se, use_amt, use_cnt, pay_custm_cnt
    							String block_cd = strFileline[0];
    							String toi_lcla_nm = strFileline[1];
    							String toi_midc_nm = strFileline[2];
    							String crtr_ym = strFileline[3];
    							String crtr_ymd = strFileline[4];
    							String dow = strFileline[5];
    							String corp_prsn_se = strFileline[6];
    							String sexd_cd = strFileline[7];
    							String age = strFileline[8];
    							String inflow_se = strFileline[9];
    							String use_amt = strFileline[10];
    							String use_cnt = strFileline[11];
    							String pay_custm_cnt = strFileline[12];
    							
    							if(strFileline[0].isEmpty()) {block_cd = "999999";resultTemp += ",block_cd:E";}
    							if(strFileline[1].isEmpty()) {toi_lcla_nm = "99999999";resultTemp += ",toi_lcla_nm:E";}
    							if(strFileline[2].isEmpty()) {toi_midc_nm = "99999999";resultTemp += ",toi_midc_nm:E";}
    							if(strFileline[3].isEmpty()) {crtr_ym = "999999";resultTemp += ",crtr_ym:E";}
    							if(strFileline[4].isEmpty()) {crtr_ymd = "99999999";resultTemp += ",crtr_ymd:E";}
    							if(strFileline[5].isEmpty()) {dow = "999";resultTemp += ",dow:E";}
    							if(strFileline[6].isEmpty()) {corp_prsn_se = "99999999";resultTemp += ",corp_prsn_se:E";}
    							if(strFileline[7].isEmpty()) {sexd_cd = "99999999";resultTemp += ",sexd_cd:E";}
    							if(strFileline[8].isEmpty()) {age = "99999999";resultTemp += ",age:E";}
    							if(strFileline[9].isEmpty()) {inflow_se = "99999999";resultTemp += ",inflow_se:E";}
    							if(strFileline[10].isEmpty()) {use_amt = "0";resultTemp += ",use_amt:E";}
    							if(strFileline[11].isEmpty()) {use_cnt = "0";resultTemp += ",use_cnt:E";}
    							if(strFileline[12].isEmpty()) {pay_custm_cnt = "0";resultTemp += ",pay_custm_cnt:E";}
    							
    							pstmt.setString(1, block_cd);
    			                pstmt.setString(2, toi_lcla_nm);
    			                pstmt.setString(3, toi_midc_nm);
    			                pstmt.setString(4, crtr_ym);
    			                pstmt.setString(5, crtr_ymd);
    			                pstmt.setString(6, dow);
    			                pstmt.setString(7, corp_prsn_se);
    			                pstmt.setString(8, sexd_cd);
    			                pstmt.setString(9, age);
    			                pstmt.setString(10, inflow_se);
    			                pstmt.setFloat(11, Float.parseFloat(use_amt));
    			                pstmt.setFloat(12, Float.parseFloat(use_cnt));
    			                pstmt.setFloat(13, Float.parseFloat(pay_custm_cnt));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){

			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	
	/**
	 * 의정부시민 매출
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> makeSaleCitizen(String filePath) throws IOException, Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지

		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;			// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO data.ifc_ujb_ctzn_sls_if" + 
				" (pay_area_se, toi_lcla_nm, toi_midc_nm, toi_scla_nm, crtr_ym, crtr_ymd, dow, corp_prsn_se, sexd_cd, age, use_amt, use_cnt, pay_custm_cnt)" + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = "\t";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		BufferedReader br = null;
		FileInputStream fileStr = null;
		InputStreamReader inputStr = null;
		try{

			if( con != null ) pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			//br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    			fileStr = new FileInputStream(file);
    			inputStr = new InputStreamReader(fileStr, "UTF-8");
    			br = new BufferedReader(inputStr);
    			
    			String line = "";
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 13) {
    							
    							String resultTemp = "";
    							//pay_area_se, toi_lcla_nm, toi_midc_nm, toi_scla_nm, crtr_ym, crtr_ymd, 
    							//dow, corp_prsn_se, sexd_cd, age, use_amt, use_cnt, pay_custm_cnt
    							String pay_area_se = strFileline[0];
    							String toi_lcla_nm = strFileline[1];
    							String toi_midc_nm = strFileline[2];
    							String toi_scla_nm = strFileline[3];
    							String crtr_ym = strFileline[4];
    							String crtr_ymd = strFileline[5];
    							String dow = strFileline[6];
    							String corp_prsn_se = strFileline[7];
    							String sexd_cd = strFileline[8];
    							String age = strFileline[9];
    							String use_amt = strFileline[10];
    							String use_cnt = strFileline[11];
    							String pay_custm_cnt = strFileline[12];
    							
    							if(strFileline[0].isEmpty()) {pay_area_se = "99999999";resultTemp += ",pay_area_se:E";}
    							if(strFileline[1].isEmpty()) {toi_lcla_nm = "99999999";resultTemp += ",toi_lcla_nm:E";}
    							if(strFileline[2].isEmpty()) {toi_midc_nm = "99999999";resultTemp += ",toi_midc_nm:E";}
    							if(strFileline[3].isEmpty()) {toi_scla_nm = "99999999";resultTemp += ",toi_scla_nm:E";}
    							if(strFileline[4].isEmpty()) {crtr_ym = "999999";resultTemp += ",crtr_ym:E";}
    							if(strFileline[5].isEmpty()) {crtr_ymd = "99999999";resultTemp += ",crtr_ymd:E";}
    							if(strFileline[6].isEmpty()) {dow = "999";resultTemp += ",dow:E";}
    							if(strFileline[7].isEmpty()) {corp_prsn_se = "99999999";resultTemp += ",corp_prsn_se:E";}
    							if(strFileline[8].isEmpty()) {sexd_cd = "99999999";resultTemp += ",sexd_cd:E";}
    							if(strFileline[9].isEmpty()) {age = "99999999";resultTemp += ",age:E";}
    							if(strFileline[10].isEmpty()) {use_amt = "0";resultTemp += ",use_amt:E";}
    							if(strFileline[11].isEmpty()) {use_cnt = "0";resultTemp += ",use_cnt:E";}
    							if(strFileline[12].isEmpty()) {pay_custm_cnt = "0";resultTemp += ",pay_custm_cnt:E";}
    							
    							pstmt.setString(1, pay_area_se);
    			                pstmt.setString(2, toi_lcla_nm);
    			                pstmt.setString(3, toi_midc_nm);
    			                pstmt.setString(4, toi_scla_nm);
    			                pstmt.setString(5, crtr_ym);
    			                pstmt.setString(6, crtr_ymd);
    			                pstmt.setString(7, dow);
    			                pstmt.setString(8, corp_prsn_se);
    			                pstmt.setString(9, sexd_cd);
    			                pstmt.setString(10, age);
    			                pstmt.setFloat(11, Float.parseFloat(use_amt));
    			                pstmt.setFloat(12, Float.parseFloat(use_cnt));
    			                pstmt.setFloat(13, Float.parseFloat(pay_custm_cnt));
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    if( con != null ) con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            if( con != null ) con.commit() ;
	            
	            if( con != null ) con.setAutoCommit(true);
    			
    		}

		}catch(IOException e) {
			if( con != null ) con.rollback();
			throw e;
		}catch(Exception e){

			if( con != null ) con.rollback();
			throw e;
               
        }finally{
        	
        	if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (con != null) try {con.close();con = null;} catch(SQLException ex){LOGGER.info("SQLException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (br != null) try {br.close();br = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (fileStr != null) try {fileStr.close();fileStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            if (inputStr != null) try {inputStr.close();inputStr = null;} catch(IOException ex){LOGGER.info("IOException : " + ex);} catch(Exception e) { LOGGER.info("Exception : " + e); }
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}
	
	
	
	
	
	/**
	 * 블록별, 월별 개인카드 사용금액 및 건수
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	/*public Map<String, Object> makePoCardBasMonIndv(String filePath) throws Exception {
		
		// 처리 결과 데이터 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		StringBuilder errorMsg = new StringBuilder();		// 에러 메시지
		
		Connection con = getConnectionDB();			// DB Connection 객체
		
		PreparedStatement pstmt = null;				// Prestatement 객체
		
		// Table Insert 스크립트
		String sql = "INSERT INTO dsu_po_card_bas_mon_indv_if" + 
				" (std_ym, sido_nm, sig_nm, adm_nm, blk_cd, user_type, gender, age, influx, cat_biz, sum, times)" + 
				" VALUES" + 
				" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?::numeric, ?::numeric)";

		// 파일에서 읽어온 데이터 구분자
		String charSplit = "|";
		
		int readLineCnt = 0;		// 데이터 Row 수
		int batchCnt = 0;			// 트랜잭션 단위
		int errorCnt = 0;			// 에러 메시지 수
		
		try{

            pstmt = con.prepareStatement(sql) ;

            
            // 파일 오픈
    		String parFile1 = filePath.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
    		File file = new File(ComWebUtil.filePathBlackList(parFile1));
    		BufferedReader br = null;
            
    		// 파일이며, 존재하면 파싱 시작
    		if (file.exists() && file.isFile()) {
    			
    			// 파일에서 내용을 읽어서 StringBuffer에 쌓는다.
    			//br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

    			String line = "";
    			
    			//List<String> arr = new ArrayList<String>();
    			
    			while ((line = br.readLine()) != null) {
    				
    				if(line.length() > 0) {
    					
    					// 첫 라인은 컬럼 정보이기 때문에 2번째 라인부터 저장한다
    					if(readLineCnt > 0){
    						
							String[] strFileline = ComStringUtil.split(line.toString(), charSplit);
    						
    						if(strFileline.length == 12) {
    							
    							String resultTemp = "";
    							
    							String std_ym = strFileline[0];
    							String sido_nm = strFileline[1];
    							String sig_nm = strFileline[2];
    							String adm_nm = strFileline[3];
    							String blk_cd = strFileline[4];
    							String user_type = strFileline[5];
    							String gender = strFileline[6];
    							String age = strFileline[7];
    							String influx = strFileline[8];
    							String cat_biz = strFileline[9];
    							String sum = strFileline[10];
    							String times = strFileline[11];
    							
    							if(strFileline[0].isEmpty()) {std_ym = "999999";resultTemp += ",std_ym:E";}
    							if(strFileline[1].isEmpty()) {sido_nm = "";resultTemp += ",sido_nm:E";}
    							if(strFileline[2].isEmpty()) {sig_nm = "";resultTemp += ",sig_nm:E";}
    							if(strFileline[3].isEmpty()) {adm_nm = "";resultTemp += ",adm_nm:E";}
    							if(strFileline[4].isEmpty()) {blk_cd = "";resultTemp += ",blk_cd:E";}
    							if(strFileline[5].isEmpty()) {user_type = "";resultTemp += ",user_type:E";}
    							if(strFileline[6].isEmpty()) {gender = "";resultTemp += ",gender:E";}
    							if(strFileline[7].isEmpty()) {age = "";resultTemp += ",age:E";}
    							if(strFileline[8].isEmpty()) {influx = "";resultTemp += ",influx:E";}
    							if(strFileline[9].isEmpty()) {cat_biz = "";resultTemp += ",cat_biz:E";}
    							if(strFileline[10].isEmpty()) {sum = "";resultTemp += ",sum:E";}
    							if(strFileline[11].isEmpty()) {times = "";resultTemp += ",times:E";}
    							
    							pstmt.setString(1, std_ym);
    			                pstmt.setString(2, sido_nm);
    			                pstmt.setString(3, sig_nm);
    			                pstmt.setString(4, adm_nm);
    			                pstmt.setString(5, blk_cd);
    			                pstmt.setString(6, user_type);
    			                pstmt.setString(7, gender);
    			                pstmt.setString(8, age);
    			                pstmt.setString(9, influx);
    			                pstmt.setString(10, cat_biz);
    			                pstmt.setString(11, sum);
    			                pstmt.setString(12, times);
    			                
    			                // addBatch에 담기
    			                pstmt.addBatch();
    			                   
    			                // 파라미터 Clear
    			                pstmt.clearParameters() ;
    			                
    			                // Batch Count 증가
    			                batchCnt++;
    			                
    			                // 데이터 체크 메시지 만들기
    			                if(resultTemp.length() > 0) {
    			                	
    			                	errorMsg.append("L:" + readLineCnt + "" + resultTemp + "|");		// 에러 메시지 남기기
    			                	errorCnt++;			// 에러 수 증가하기
    			                }
    			                   
    			                // OutOfMemory를 고려하여 만건 단위로 커밋
    			                if( (batchCnt % 10000) == 0){
    			                //if( (batchCnt % 10) == 0){	
    			                       
    			                    // Batch 실행
    			                    pstmt.executeBatch() ;
    			                       
    			                    // Batch 초기화
    			                    pstmt.clearBatch();
    			                       
    			                    // 커밋
    			                    con.commit() ;
    			                    
    			                    batchCnt = 0;
    			                    
    			                }
    			                
    						}else {
    							
    							errorMsg.append("L:" + readLineCnt + ",C|");
    							errorCnt++;			// 에러 수 증가하기
    						}
    					}
    					
    					readLineCnt++;		// Read Count 중가
    				}
    			}
    			
    			// 커밋되지 못한 나머지 구문에 대하여 커밋
	            pstmt.executeBatch() ;
	            con.commit() ;
	            
	            con.setAutoCommit(true);
    			
    		}

		}catch(Exception e){

			con.rollback();
			throw e;
               
        }finally{
        	
            if (pstmt != null) try {pstmt.close();pstmt = null;} catch(SQLException ex){}
            if (con != null) try {con.close();con = null;} catch(SQLException ex){}
            
            readLineCnt--;
        }
		
		resultMap.put("dataCnt", readLineCnt);
		resultMap.put("errorMsg", errorMsg.toString());
		resultMap.put("errorCnt", errorCnt);
		
		
		return resultMap;
	}*/
}
