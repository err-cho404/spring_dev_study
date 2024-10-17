package kr.co.yangdoll.util;

public class PageInfoVO {
   
   private int currentPage;
   private int pageLimit;
   private int totalCount;
   
   private int startList;
   private int endList ;
   private int pageNumStart;
   private int pageNumEnd;
   private boolean prevPageBlock, nextPageBlock;
   private int lastPage ;
   
   
   
   //기본생성자 (아래의 내용들이 정상 작동 하도록 값을 강제함)
   public PageInfoVO(int currentPage, int pageLimit, int totalCount) { 
      this.currentPage = currentPage;
      this.pageLimit = pageLimit;
      this.totalCount = totalCount;
      pageListCompute();
      lastPageCompute();
      pageStartEndCompute();
   } 
   

   private void pageListCompute() {
      this.endList = currentPage * pageLimit;
      this.startList = endList - pageLimit;
   }
   
   //마지막 페이지 계산
   private void lastPageCompute( ) {
      lastPage= (int)(Math.ceil(totalCount / (pageLimit*1.0) ));
   }
   
   // 페이지 리스트 계산 및 이전 이후 페이지 블럭 체크(논리값)
   private void pageStartEndCompute() {
      this.pageNumEnd = ((int)(currentPage / 10.0 + 0.999999)) * 10;
      this.pageNumStart = pageNumEnd- 9;
      if( pageNumEnd >= lastPage ) {
         pageNumEnd = lastPage;
         nextPageBlock = false;
      }else{
         nextPageBlock = true;
      }
      if( pageNumStart  == 1) {
         prevPageBlock = false;
      }else {
         prevPageBlock = true;
      }
   }
   //필드에 저장된 값들을 가져갈 수 있는 메서드(getter 메서드만 설정)
   public int getCurrentPage() {
      return currentPage;
   }
   public int getPageLimit() {
      return pageLimit;
   }
   public int getTotalCount() {
      return totalCount;
   }
   public int getStartList() {
      return startList;
   }
   public int getEndList() {
      return endList;
   }
   public int getPageNumStart() {
      return pageNumStart;
   }
   public int getPageNumEnd() {
      return pageNumEnd;
   }
   public boolean isPrevPageBlock() {
      return prevPageBlock;
   }
   public boolean isNextPageBlock() {
      return nextPageBlock;
   }
   public int getLastPage() {
      return lastPage;
   }


   @Override
   public String toString() {
      return "PageInfoVO [currentPage=" + currentPage + ", pageLimit=" + pageLimit + ", totalCount=" + totalCount
            + ", startList=" + startList + ", endList=" + endList + ", pageNumStart=" + pageNumStart
            + ", pageNumEnd=" + pageNumEnd + ", prevPageBlock=" + prevPageBlock + ", nextPageBlock=" + nextPageBlock
            + ", lastPage=" + lastPage + "]";
   }
   
   
}
