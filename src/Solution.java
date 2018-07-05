import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            Stack s = new Stack();//괄호 체크 사용할 스택
            //Complete the code
            int len = input.length();//문자열 길이
            char t = ' ';
            for(int i=0;i<len;i++){//문자열길이만큼 작업
                t = input.charAt(i);//char 추출
                if(t!=')'&&t!='}'&&t!=']'){//닫는괄호인가 확인
                s.push(input.charAt(i));//아닐경우 스택에 저장
                    }
                else{//닫는괄호일경우
                    if(t==')'&&s.isEmpty()!=true){//괄호가 )일경우, (와 체크
                        if((char)s.pop()=='(')
                        continue;
                    }else if(t=='}'&&s.isEmpty()!=true){//괄호가 }일경우 {와 체크
                        if((char)s.pop()=='{')
                        continue;
                    }else if(t==']'&&s.isEmpty()!=true){//괄호가 ]일경우 [와 체크
                        if((char)s.pop()=='[')
                        continue;
                    }else{//괄호가 일치하지 않는경우
                        System.out.println("false");
                        break;
                    }
                }
               if(s.isEmpty()) {
                   System.out.println("true");
                   break;
               }else{
                   System.out.println("false");
                    break;
               }
            }
		}
		
	}
}