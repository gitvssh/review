var ajax=null;//변수

//ajax 객체구하는 함수
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
function helloToServer(){//html에서 호출할 함수 
	 
	var name=document.getElementById("name");//html의 id얻기
	//var params="name="+encodeURIComponent(name.value);//한글처리 
	var params="name="+name.value;
	//get방식 요청
	var url="helloApp.jsp?"+params;//get방식
	ajax=getXMLHttpRequest();//ajax 객체 얻기 
	ajax.onreadystatechange=helloFromServer;//콜백함수
	ajax.open("GET",url,true);//요청 초기화
	ajax.send(null);//get방식 서버요청 
	 
	/*
	//post방식
	var url="helloApp.jsp";//post방식
	ajax=getXMLHttpRequest();//ajax 객체 얻기 
	ajax.onreadystatechange=helloFromServer;//콜백함수
	ajax.open("post",url,true);
	ajax.send(params);//post방식 서버요청 
	*/
}
//-----------------------
function helloFromServer(){// 콜백함수
	if(ajax.readyState==4){// 4 : 모든데이터 도착
		if(ajax.status==200){// ok 
			//alert("서버 응답 내용 :"+ajax.responseText);
			var result=document.getElementById("result");//
			result.value=ajax.responseText;//클라이언트에 반영
			
			//JSON, XML 넘어온 데이터 종류 
		}//if
 	}//if
}//helloFromServer() end===

 
