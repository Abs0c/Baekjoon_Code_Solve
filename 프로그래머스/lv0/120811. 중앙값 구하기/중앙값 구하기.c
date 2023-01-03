#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// array_len은 배열 array의 길이입니다.
int solution(int array[], size_t array_len) {
    int answer = 0; int box=0;
    for(int j=0; j<array_len; j++){
    for(int i=0; i<(array_len-1)-j; i++)
    {
        if(array[i]<array[i+1])
        {   box = array[i];
            array[i] = array[i+1];
            array[i+1] = box;
        }
    }}
    answer = array[array_len/2];
    return answer;
}