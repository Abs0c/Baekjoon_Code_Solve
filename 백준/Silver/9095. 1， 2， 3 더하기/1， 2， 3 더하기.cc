#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

int main(){
    int arr[12]={0}; int i = 4;
    arr[1]=1; arr[2]=2; arr[3]=4;
    for (int k=4;k<11;k++){
        arr[k] = arr[k-1]+arr[k-2]+arr[k-3];
    }

    int t;
    scanf("%d",&t);
    for (int i=0;i<t;i++){
        int a;
        scanf("%d",&a);
        printf("%d\n",arr[a]);
    }
}

