// определите только функцию power, где
//    x - число, которое нужно возвести в степень
//    p - степень, в которую нужно возвести x
//

int power(int x, unsigned p) {
    int answer(1);
    while(p!=0){
        answer*=x;
        p--;
    }
    return answer;
}