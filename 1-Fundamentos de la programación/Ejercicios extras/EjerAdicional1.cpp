#include <iostream>
#include <math.h>
using namespace std;

void leerDatos(int& n){
    do{
    cout<<"Introduce un numero: ";
    cin>>n;
    }while(n==0);
}
void calculos(int n){
    float res;
    for(int i=1; i<=n;i++){
        res+=i/pow(2, i);
    }
    cout<<res;
}

int main(){
    int n;
    leerDatos(n);
    calculos(n);

return 0;
}
