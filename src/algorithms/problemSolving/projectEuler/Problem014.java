package algorithms.problemSolving.projectEuler;

public class Problem014 {
//	The following iterative sequence is defined for the set of positive integers:
//
//		n → n/2 (n is even)
//		n → 3n + 1 (n is odd)
//
//		Using the rule above and starting with 13, we generate the following sequence:
//
//		13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//		It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//		Which starting number, under one million, produces the longest chain?
//
//		NOTE: Once the chain starts the terms are allowed to go above one million.
}
//collatz알고리즘 수행하는 메서드 작성->체인숫자 카운팅->비교연산->i<=1000000 forloop, i출력
//개선안 : collatz알고리즘 재귀함수로 작성후, 체인숫자 카운팅을 재귀함수 호출로 분리