package vo;
// Servlet에서 최종적으로 뷰로 포워딩할때 필요한 값들을 저장할 클래스
public class ActionForward {
	// forward 할때 필요한 값들
	private String url;
	private boolean redirect;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}	
}
