#include <iostream>
#include <array>
using namespace std;

const int N=4;
const int M=3;

typedef array<int,M> TFila;
typedef array<TFila,N> TImagen;

void leer_imagen(TImagen& img){

    cout << "Introduce la matriz de " << N << "x" << M << ":" << endl;

    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){

            cin >> img[i][j];
        }
    }
}

bool celda_ok(int f, int c){

    return f<N && c<M && f>=0 && c>=0;
}

int media(const TImagen& img, int f, int c){

    int suma=0, num_vec=0;

    for(int i=f-1;i<=f+1;i++){
        for(int j=c-1;j<=c+1;j++){
            if(celda_ok(i,j)){
                num_vec++;
                suma+=img[i][j];
            }
        }
    }

    return suma/num_vec;

}

void suavizado(const TImagen& img, TImagen& img_fin){

    for(int i=0;i<N;i++){
        for (int j=0;j<M;j++){
            img_fin[i][j]=media(img,i,j);
        }
    }
}

void muestra_resultado(const TImagen& img){

    cout << "La matriz tras el suavizado es:" << endl;

    for (int i=0;i<N;i++){
        for(int j=0;j<M;j++){

            cout << img[i][j] << " ";
        }
        cout << endl;
    }
}

int main(){

    TImagen img, img_fin;

    leer_imagen(img);
    suavizado(img,img_fin);
    muestra_resultado(img_fin);

    return 0;
}
