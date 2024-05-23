#include <iostream>
#include <math.h>
using namespace std;

void leerDatos(int& n, int& s){

    cout<<"Introduce el numero:";
    cin>>n;
    cout<<"Introduce el valor de n: ";
    cin>>s;
}

int multiplica(int n, int s){
    int i=2;
    int m=0;
    while(i<n){
        if(n>pow(i,s)){
            m=i;
        }

        i++;
    }
    return m;
}

int main(){
    int n, s;
    leerDatos(n, s);
    cout<<"La raiz n-esima de "<<n<<" es "multiplica(n ,s);

return 0;
}
