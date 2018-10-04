package algorithms.problemSolving.projectEuler;

public class problem017 {
//If the numbers 1 to 5 are written out in words: 
//	one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//
//If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
//how many letters would be used?
//
//
//NOTE: Do not count spaces or hyphens. For example, 
//342 (three hundred and forty-two) contains 23 letters and 
//115 (one hundred and fifteen) contains 20 letters. The use of "and" 
//when writing out numbers is in compliance with British usage.
}
//1의자리수, 10의자리수, 100의자리수이상(and추가), 천의자리수로 구분하고
//각 자리수별 문자수 더하는 알고리즘 
//1~20까지 필요하고, 21~99 알고리즘 필요하고, 100+ 필요하고, 천 필요함
//각 알고리즘 분해하고 나누고 나머지, 몫등을 활용해서 구함, 기본조건 0에서 -1을 리턴해서 오류 있었음