var ajax=null;//변수

function getXMLHttpRequest(){//ajax 객체얻기 함수
	
	if(window.ActiveXObject){//ie 브라우저 사용
		try{
			//최근 ie 버전
			return new ActiveXObject("Msxml2.XMLHTTP");//객체생성
		}catch(e1){
			try{
				//이전 ie 버전
				return new ActiveXObject("Microsoft.XMLHTTP");//객체생성
			}catch(e2){return null;}
		}//catch
	}else if(window.XMLHttpRequest){//ie이외의 브라우저(사파리,오페라,파이어폭스)
		return new XMLHttpRequest();
	}else{
		return null;
	}//else
}//getXMLHttpRequest() end--------


//--------------------------
function loadNews(){//html에서 호출할 함수 
	 
	var url="news.jsp";
	ajax=getXMLHttpRequest();//Ajax 객체 얻기 
	ajax.onreadystatechange=viewNews;//콜백함수 설정
	ajax.open("GET",url,true);//요청 초기화
	ajax.send(null);//서버로 요청 전송 
	 
}
//-----------------------
function viewNews(){// 콜백함수
	if(ajax.readyState==4){// 4 : 모든데이터 도착
		if(ajax.status==200){// ok 
			 
			var newList=document.getElementById("newList");//id얻기
			newList.innerHTML=ajax.responseText;//서버에서 보내준 응답 텍스트
		}else{
			alert("실패:"+ajax.status);
			//200 - 요청 성공 = ok
			//403 - 접근거부
			//404 - 페이지 없음
			//500 - 서버오류 
			
		}//else--
 	}//if
}//viewNews() end===

 
