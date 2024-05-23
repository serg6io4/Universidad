-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º Curso. ETSI Informática. UMA
--
-- PRACTICA 2ª (Características de la Programación Funcional)
--
-- (completa y sustituye los siguientes datos)
-- Titulación: Grado en Ingeniería …………………………………… [Informática | del Software | de Computadores].
-- Alumno: APELLIDOS, NOMBRE
-- Fecha de entrega:  DIA | MES | AÑO
--
-- Ejercicios resueltos de la Relación : ..........
--
-------------------------------------------------------------------------------
module Practica2 where

import Test.QuickCheck



-------------------------------------------------------------------------------
-- Ejercicio 4
-------------------------------------------------------------------------------
distintos :: Eq a => [a] -> Bool
distintos [] = True
distintos (x:xs) = not(elem x xs) && distintos xs

-------------------------------------------------------------------------------
-- Ejercicio 11
-------------------------------------------------------------------------------
-- take'
take' :: Int -> [a] -> [a]
take' n xs = [ x |(p,x)<-zip [0.. n] xs, n < p]
-- drop'
drop' :: Int -> [a] -> [a]
drop' n xs = [ x |(p,x)<-zip [0.. length(xs)] xs, p>= n]
--Representación del quickCheck
--p_take_drop :: Eq a => Int -> [a] -> property
--p_take_drop x xs = x >= 0 ==> (take' x xs)++(drop' x xs) == xs

-------------------------------------------------------------------------------
-- Ejercicio 13
-------------------------------------------------------------------------------
desconocida :: (Ord a) => [a] -> Bool
desconocida xs = and [ x<=y | (x,y) <- zip xs (tail xs) ]
-- Qué hace?
--La función comprueba que los números están de forma ascendente dentro del array
--Compara de forma descendente que los números del principio no son mayor que los de la cola
-------------------------------------------------------------------------------
-- Ejercicio 14
-------------------------------------------------------------------------------
-- apartados a, b, e y f
-- a)
inserta :: (Ord a) => a -> [a] -> [a]
inserta x xs = takeWhile (<x) xs ++ [x] ++ dropWhile (<x) xs


-- b)
inserta' :: (Ord a ) => a -> [a] -> [a]
inserta' x [] = [x]
inserta' x (y:ys)
  |x <= y = [x] ++ [y] ++ ys
  |otherwise = [y] ++ inserta' x ys

-- e)

ordena :: (Ord a) => [a] -> [a]
ordena xs = foldr (inserta) [] xs 

-- f)  Utiliza para ello la función sorted definida en las transarencias
p_ordena :: (Ord a) => [a] -> Bool
p_ordena xs = resultado (ordena xs)
  where 
    resultado [] = True
    resultado [x] = True
    resultado (x:y:xs) = x <= y && resultado xs


-------------------------------------------------------------------------------
-- Ejercicio 22
-------------------------------------------------------------------------------
binarios ::Integer -> [String]
binarios 0 = [""]
binarios x | x > 0 = result x
  where 
    result 1 = ["1","0"]
    result x = (map (++"0") (result (x-1))) ++ (map (++"1") (result (x-1)))

-------------------------------------------------------------------------------
-- Ejercicio 34
-------------------------------------------------------------------------------

type Izdo = Double
type Dcho = Double
type Epsilon = Double
type Función = Double -> Double
biparticion :: Función -> Izdo -> Dcho -> Epsilon -> Double

biparticion f a b epsilon
  | long < epsilon    = c
  | (f c) < epsilon   = c
  | a < 0             = biparticion f a c epsilon
  | b < 0             = biparticion f b c epsilon
  | otherwise = error "no hay cambio de signo en el intervalo"
  where
      long = b - a
      c = (a+b)/2


-------------------------------------------------------------------------------
-- Lista de ejercicios extra. Ejercicio [lista de pares] 
-------------------------------------------------------------------------------

cotizacion :: [(String, Double)]
cotizacion = [("apple", 116), ("intel", 35), ("google", 824), ("nvidia", 67)]

-- buscarRec
-- buscarC
-- buscarP
-- valorCartera. DIFICIL

-------------------------------------------------------------------------------
-- Lista de ejercicios extra. Ejercicio [mezcla]
-------------------------------------------------------------------------------
-- mezcla

-------------------------------------------------------------------------------
-- Lista de ejercicios extra. Ejercicio [agrupar]
-------------------------------------------------------------------------------
-- agrupar. DIFICIL