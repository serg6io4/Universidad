library(tidyverse)


###############
#Apartado 1   #
###############
#Cargamos el CSV como tibble, esto
datos <- read_csv('C:/Users/sergi/Desktop/TrabajoR/15312.csv',col_types =
                       cols(
                         .default = col_double(),
                         sexo= col_factor(),
                         dietaEsp= col_factor(),
                         nivEstPad =col_factor(),
                         nivEstudios =col_factor(),
                         nivIngresos = col_factor()
                       ))
str(datos)

###############
#Apartado 2   #
###############
#Calculamos la columna IMC mediante la fórmula nueva del apartdo y se añade al
#final de la tabla
datos$IMC <- datos$peso / (datos$altura ^ 2)
datos

###############
#Apartado 3   #
###############
#Eliminamos las filas que tengan algún valor NA
datos <-na.omit(datos)
datos

###############
#Apartado 4   #
###############
#Calculamos las medias y desviaciones típicas de cada una de las variables
#numéricas, y para no mezclar usaremos keep, para que mantenga lo que queremos
#en este caso numericos, no factores  luego con map se aplica a toda los datos,
#la función
medias <- datos %>%  keep(is.numeric) %>% map_dbl(mean) 
medias
#DesvTipicas
desvtip <- function(x){
  return(sqrt(mean(x^2)-mean(x)^2))
}
desv <- datos %>%  keep(is.numeric) %>% map_dbl(desvtip)
desv

###############
#Apartado 5   #
###############
#Hay que realizar la regresión lineal a las 12 variables
#Calculamos los coeficientes de regresión para cada uno de los valores con respecto al IMC
#Creamos un función que haga la regresión con lm y nos quedamos los coeficientes
#de regresión y de determinación y se tiene que quitar peso y altura, ya que
#ahora está IMC
reg <- function(dt, x, y) {
  temp <- lm(y ~ x, dt)
  list(coeficientes_regresion=coef(temp),
       R2=summary(temp)$r.squared)
}
#Quitamos peso y altura y aplicamos reg a los datos
regresiones <- datos[c(-1:-2)] %>% map(reg,dt=datos, y=datos$IMC)
regresiones <- regresiones[c(-13)]#Quitar IMC~IMC, que no tiene sentido
regresiones

###############
#Apartado 6   #
###############
#Mirando en el campus en el archivo de R, "Purr.R", encontré esta manera de
#realizar los gráficos de dispersión y bowplots, que es una función que 
#hace imágenes de los gráficos y los deja en la carpeta de trabajo.
dibujarGraficos <- function(nombre) {
  png(file=str_c("IMC~",nombre,".png"))
  plot(y=datos$IMC,datos[[nombre]],xlab=nombre , ylab="IMC")
  abline(lm(datos$IMC ~ datos[[nombre]]), col="yellow")
  dev.off()
}
#Con esto generamos las gráficas
datos %>% colnames() %>% walk(dibujarGraficos)


###############
#Apartado 7   #
###############
#Función auxilar para separar conjuntos, usando la función 
#sample de R junto con setdiff para calcular la diferencia
#de conjuntos
separarSets <- function(df, p) {
  rDf <- 1:nrow(df)
  n1 <- sample(rDf, p * length(rDf))
  n2 <- setdiff(rDf, n1)
  list(n1=df[n1,], n2=df[n2,])  
}
#Separamos en 60%, 40% y lo almacenamos en conjunto
conjunto <- separarSets(datos, .6)
#El primer valor será de entrenamiento, por lo tanto lo guardamos ahí
entrenamiento <- conjunto$n1
#El segundo valor tendrá el 40% restante, por lo que si separamos a la mitad
#Tendremos 20% y 20%
conjunto <- separarSets(conjunto$n2,.5)
#El primero será de test y el último de validación
test <- conjunto$n1
validación <- conjunto$n2 

###############
#Apartado 8   #
###############
#Para analizar cual de las 12 variables explica mejor la variable IMC en los conjuntos de entrenamiento
#y test, podemos usar la función reg previamente definida
regresionesEntrenamiento <- entrenamiento[c(-1:-2)] %>% map(reg,dt=entrenamiento, y=entrenamiento$IMC)
regresionesTest <- test[c(-1:-2)] %>% map(reg,dt=test, y=test$IMC)

#Ordenamos la lista por los valores de R2 de forma creciente
regresionesEntrenamiento <- regresionesEntrenamiento[order(sapply(regresionesEntrenamiento, `[[`, i = "R2"))]
regresionesTest <-regresionesTest[order(sapply(regresionesTest, `[[`, i = "R2"))]
#Con los conjuntos que hemos creado, obtenemos que el tabaco presentan la mayor correlación
#linear con el IMC dentro del conjunto Entrenamiento, con un 0.3092068 como coeficiente de determinación
#Asi mismo, el tabaco es el que presentan la mayor correlación dentro del conjunto de test
#con 0.280177 como coeficiente de determinación


###############
#Apartado 9   #
###############

#Por último, utilizando el último script del campus tenemos que seleccinar
#el modelo más óptimo lineal de regresión, entrenando en el conjunto de
#entrenamiento, testeando en el conjunto de test el coeficiente de determinación
#ajustado y utilizando una técnica progresiva de ir añadiendo la mejor variable
#Utilizamos las funciones del script
#
#Función para realizar ajustes lineales múltiples
linearAdjust <- function(df, y, x) {
  lm(str_c(y, "~", str_c(x, collapse="+")), df)
}
#Y esto es una función que nos devuelve el coeficiente de determinación calculado sobre un data frame, 
#  que no tiene porque ser el mismo sobre el que se ha entrenado el modelo que contiene mod
calcR2A <- function(df, mod) {
  R2 <- summary(mod)$r.squared
  1 - (1- R2) * (nrow(df) - 1) / (nrow(df) - mod$rank)
}

# Nuestra función de ajuste lineal, pero devolviendo el coeficiente de determinación directamente, no el modelo.
calcModR2 <- function(dfTrain, dfTest, y, x) {
  mod <- linearAdjust(dfTrain, y, x)
  calcR2A(dfTest, mod)
}

#Función para buscar el mejor ajuste lineal
MejorAjuste <- function(dfTrain, dfTest, varPos) {
  #Inicializamos las variables para el bucle
  bestVars <- character(0)
  aR2      <- 0
  
  repeat {
    #Bloque de código a repetir hasta que se produzca el break,
    #puesto que no queremos empeorar el modelo actual
    
    aR2v <- map_dbl(varPos, ~calcModR2(dfTrain, dfTest, "IMC", c(bestVars, .)))
    i    <- which.max(aR2v)
    aR2M <- aR2v[i]
    
    if (aR2M <= aR2) break 
    
    aR2 <- aR2M
    bestVars <- c(bestVars, varPos[i])
    varPos   <- varPos[-i]
  }
  
  mod <- linearAdjust(dfTrain, "IMC", bestVars)
  
  list(vars=bestVars, mod=mod)
}


#Calculamos el mejor ajuste
mAjuste <-MejorAjuste(entrenamiento,test,names(datos)[-1:-2])

###############
#Apartado 10  #
###############
#Obtenemos que las variables de tabaco, ubes, verduras, carneRoja, deporte,
#nivIngresos, edad, drogas componen el mejor ajuste(8 variables)
#comprobamos los resultados obtenidos con el conjunto de validación
modFinal <- lm(str_c("IMC", " ~ ", str_c(mAjuste$vars,collapse = " + ")) , validación)
calcR2A(validación,modFinal)

#Con el conjunto de validación obtenemos que el conjunto tiene un coeficiente de determinación 
#de 0.6941491, mejor que la previsión anterior

###############
#Apartado 11  #
###############
#Cargamos el CSV como tibble, esto
datosEval <- read_csv('C:/Users/sergi/Desktop/TrabajoR/eval.csv',col_types =
                    cols(
                      .default = col_double(),
                      sexo= col_factor(),
                      dietaEsp= col_factor(),
                      nivEstPad =col_factor(),
                      nivEstudios =col_factor(),
                      nivIngresos = col_factor()
                    ))
str(datosEval)
datosEval<- na.omit(datosEval)
#Le calculo la columna IMC con los datos que tiene el eval.csv
datosEval$IMC <- predict(object = modFinal, newdata = datosEval)
datosEval
#Para meter peso, lo suyo es hacer la conversión con IMC*(altura^2) = peso
datosEval$peso <- datosEval$IMC * (datosEval$altura^2)
datosEval
#Y ahora falta guardar el nuevo eval como evalX.csv
write.csv(datosEval, file = "evalX.csv")
