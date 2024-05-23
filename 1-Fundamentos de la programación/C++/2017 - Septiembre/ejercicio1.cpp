#include <iostream>
using namespace std;

const unsigned FIL = 3;
const unsigned COL = 4;

typedef unsigned TFila[COL];
typedef TFila TMatriz[FIL];

bool esImpar(const TMatriz& m, int f, int c){

    bool impar=false;

    if(m[f][c]%2==1){
        impar=true;
    }

    return impar;

}

int MayorImpar(const TMatriz& m, int f){

    int mayorImpar=0;

    for (int i=0;i<(int)COL;i++){

        if(esImpar(m,f,i)&&(int)m[f][i]>=mayorImpar){

            mayorImpar=m[f][i];
        }
    }

    return mayorImpar;
}

/*  devuelve la suma de los mayores impares de cada
 *  fila de la matriz m
 */
unsigned sumaMayoresImpares(const TMatriz& m) {

    int suma=0;

    for (int i=0;i<(int)FIL;i++){
        suma+=MayorImpar(m,i);
    }

    return suma;
}

// muestra por pantalla el contenido de la matriz m
void escribir(const TMatriz& m) {
    for (unsigned f = 0; f < FIL; f++) {
        for (unsigned c = 0; c < COL; c++) {
            cout << m[f][c] << " ";
        }
		cout << endl;
	}
	cout << endl;

}

int main() {
	TMatriz m = { {6,4,12,2},
                  {5,2,7,3},
                  {4,9,5,11}
                };
	unsigned suma;

	/* Mostramos la matriz */
	cout << "El contenido de la matriz de prueba es: \n";
	escribir(m);

	/* Probamos nuestra función sumaMayoresImpares */
	suma = sumaMayoresImpares(m);

    cout << "La suma de los mayores impares de las filas es: " << suma << endl;


	return 0;
}
