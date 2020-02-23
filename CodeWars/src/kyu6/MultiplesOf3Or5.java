package kyu6;

/*
    AUTHOR: linux
    TIME: 2019/12/13
    GOOD LUCK AND NO BUG.
*/
public class MultiplesOf3Or5 {
    // my
//    public int solution(int number) {
//        //TODO: Code stuff here
//        int sum = 0;
//        for (int i = 3; i < number; i++) {
//            if (i % 3 == 0 || i % 5 == 0) {
//                sum += i;
//            }
//        }
//        return sum;
//    }

    // flekken, andreaseberhoefer, antoine.leclercq, Nzuve, 11rshaw, raluca.chintoanu (plus 13 more warriors)
//    public int solution(int number) {
//        return IntStream.range(0, number)
//                .filter(n -> (n % 3 == 0) || (n % 5 == 0))
//                .sum();
//    }

// simonharrer
    public int solution(int number) {
        int numberIncluding = number - 1;

        int result = 0;
        result += sumUpTo(numberIncluding / 3) * 3;
        result += sumUpTo(numberIncluding / 5) * 5;
        result -= sumUpTo(numberIncluding / 15) * 15;
        return result;
    }

    private static int sumUpTo(int n) {
        // 1+2+3+。。。+n
        return n * (n + 1) / 2;
    }
}
