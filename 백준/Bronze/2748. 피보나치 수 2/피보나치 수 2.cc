#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

int main(){
    long long int arr[92]={0};
    arr[0]=0;
    arr[1]=1;
    int i;
    for (i=2;i<91;i++){
        arr[i]=arr[i-1]+arr[i-2];
    }
    int n;
    scanf("%d",&n);
    printf("%lld",arr[n]);
}
