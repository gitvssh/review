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
window.onload = function() {
 	var url = "member_json.jsp"; 
  	ajax = getXMLHttpRequest();//XMLHttpRequest 객체를 얻는다 
  	ajax.onreadystatechange = viewInfo;// 콜백함수설정
  	ajax.open("GET", url, true); //요청 초기화,GET/POST선택,접속URL입력
  	ajax.send(null); //웹 서버에 요청 전송 
};

function viewInfo() {//콜백함수: 서버에서 보내준 내용을 클라이언트에 반영
	if (ajax.readyState == 4) {
		if (ajax.status == 200) {
 			var json = ajax.responseText ;//서버가 응답한 내용받기
 			var result = eval('('+ json +')'); //eval() 파싱작업
 			 
			if (result.code == 'success') {
				var m = result.data.member;
				//alert("m.id="+m.id+ "\n"+
				//	  "m.name:"+m.name+"\n"+
				//	  "m.sno="+m.sno);
				document.getElementById("name").value=m.name;
				document.getElementById("id").value=m.id;
				document.getElementById("sno").value=m.sno;
			} else {
				alert("실패");
			}
		} else {
			alert("에러 발생:"+ajax.status);
		}//else
	}//if
}//function viewInfo()


 
