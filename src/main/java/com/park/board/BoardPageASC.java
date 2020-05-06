package com.park.board;

/***************************************************************************************
 * <pre>
 * 게시판 페이지 처리를 위한 클래스
 * 필수 생성자 BoardPageASC(int total_record, int page_per_record, int now_page)
 * 나머지는 선택사항 
 * 
 * 이미지는 경로 위치는 image/ 이며 변경시 setImgURL 사용
 * 
 * 이미지 파일의 이름은 페이징코드에 되어있는 이름으로 변경해서 사용할 해야함
 * [이미지 파일 이름]
 * 첫 페이지     : bn_first.gif
 * 이전 페이지   : imgNamePrev.gif
 * 다음 페이지   : bn_next.gif
 * 마지막 페이지 : bn_last.gif
 *
 * 화면에 표시되는 예 << < 1 | 2 | 3 | 4 | 5 > >>
 * </pre>
 * 
 * @author 박수환
 * @since 2012-10-05
 * @version 1.0 
 ***************************************************************************************/

public class BoardPageASC {
	
	//생성자 쪽에서 초기화 하는 부분
	private int page_per_record;     //화면에 표시할 자료 개수
	private int block_per_page = 5;  //화면에 표시할 페이지 개수[블록당 페이지수]
	private int now_page;            //현재 페이지 번호
	private int total_record;        //전체 레코드수	
	
	//생성자 초기화 이후 처리하는 필드 부분
	private int total_page;          //전체 페이지 개수
	private int total_block;         //전체 블록 개수
	private int now_block;           //현재 페이지가 속해 있는 블록 번호
	private int start_record;        //가져올 레코드 시작 번호
	private int startBlockPage;          //가져올 페이지 시작 번호
	private int endBlockPage;            //마지막 페이지 번호
	
	//화면에 표시하기 위한 변수들
	private int startPage,prevPage;
	private int nowPage;
	private int lastPage, nextPage;
	
	private String Page;                     //Page 큰순으로 출력, 작은순으로 출력
	
	private String DivID = "board_no";       //List태그의 Clas명 
	private String imgURL = "image/";	     //이미지 경로
	
	private String idx = "page";              //페이지 파라메터 이름
	private String param = "";               //추가 파라메터
	
	private static final String imgNameFirst = "bn_first.gif";
	private static final String imgNamePrev  = "bn_prev.gif";
	private static final String imgNameNext  = "bn_next.gif";
	private static final String imgNameLast  = "bn_last.gif";
	
	
	/***************************************************************************************
	 * @param total_record     전체 레코드 개수(row count)
	 * @param page_per_record  화면에 표시할 자료 개수
	 * @param now_page         현재 페이지 번호
	 ***************************************************************************************/	
	public BoardPageASC(int total_record, int page_per_record, int now_page) { 		
		this.total_record    = total_record;
		this.page_per_record = page_per_record;
		this.now_page        = now_page;
		FieldSetting();
	
	}//end constructor
	
	/***************************************************************************************
	 * @param total_record     전체 레코드 개수(row count)
	 * @param page_per_record  화면에 표시할 자료 개수
	 * @param now_page         현재 페이지 번호
	 * @param block_per_page   화면에 표시할 페이지 개수 
	 ***************************************************************************************/	
	public BoardPageASC(int total_record, int page_per_record, int now_page, int block_per_page) {		
		this(total_record, page_per_record, now_page);		
		this.block_per_page = block_per_page;
	
	}//end constructor	
	
	/***************************************************************************************
	 * <pre>
	 * 페이징 처리를 위한 변수들을 설정한다
	 * </pre>
	 ***************************************************************************************/
	public void FieldSetting() {
		
		total_page   = (int) Math.ceil((double)total_record / (double)page_per_record); //전체 페이지 개수
		total_block  = (int) Math.ceil((double)total_page   / (double)block_per_page);  //전체 블록 개수
		now_block    = (int) Math.ceil((double)now_page     / (double)block_per_page);  //현재 페이지가 속해 있는 블록 번호
		start_record = (((now_page-1)  * page_per_record) +1) < 1 ? 1 : (((now_page-1)  * page_per_record) +1); //가져올 레코드 시작 번호
		startBlockPage   = (((now_block-1) * block_per_page)  +1) < 1 ? 1 : (((now_block-1) * block_per_page)  +1); //가져올 페이지 시작 번호
		
		endBlockPage = ( (startBlockPage + block_per_page) <= total_page ) ? (startBlockPage+block_per_page) : total_page;
		
		
		
		startPage = 1; // << 최초 1 페이지로 		
		prevPage  = (now_page-1 == 0 ? 1: now_page-1); // 이전페이지
		nowPage = now_page;
		nextPage =  (now_page+1 > total_page ? total_page : now_page+1);
		lastPage =  total_page; // >> 라스트페이지
		

		
	}

	public int getStart_record() {
		return start_record;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getendBlockPage() {
		return endBlockPage;
	}

	public int getStartBlockPage() {
		return startBlockPage;
	}	






	
}