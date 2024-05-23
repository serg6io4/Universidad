-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º Curso. ETSI Informática. UMA
--
-- PRACTICA 2ª (Características de la Programación Funcional)
--
-- (completa y sustituye los siguientes datos)
-- Titulación: Grado en Ingeniería Informática
-- Alumno: Camacho Marín, Sergio
-- Fecha de entrega:  09/10/2023
--
-- Ejercicios resueltos de la Relación : ..........
--
-------------------------------------------------------------------------------
module Practica2 where

import Test.QuickCheck
import Data.List (sort)

-------------------------------------------------------------------------------
-- Ejercicio 2
-------------------------------------------------------------------------------
--a)
máximoYresto :: Ord a => [a] -> (a, [a])
máximoYresto [] = error "La lista está vacía"
máximoYresto [x] = (x, [])
máximoYresto (x:xs)
  | x >= maxResto = (x, xs)
  |otherwise = (maxResto, x:restoSinMax)
  where (maxResto, restoSinMax) = máximoYresto xs
--b)
máximoYrestoOrdenados :: Ord a => [a] -> (a, [a])
máximoYrestoOrdenados [] = error "La lista está vacía"
máximoYrestoOrdenados [x] = (x, [])
máximoYrestoOrdenados xs = (maximo, sort resto)
  where
    maximo = maximum xs
    resto = filter (/= maximo) xs

-------------------------------------------------------------------------------
-- Ejercicio 3
-------------------------------------------------------------------------------
reparte :: [a] -> ([a], [a])
reparte [] = ([],[])
reparte [x] = ([x], [])
reparte (x:y:xs) = (x:primero, y:segundo)
  where (primero, segundo) = reparte xs

-------------------------------------------------------------------------------
-- Ejercicio 4
-------------------------------------------------------------------------------

distintos :: Eq a => [a] -> Bool
distintos [] = True
distintos (x:xs) = not (elem x xs) && (distintos xs)

-------------------------------------------------------------------------------
-- Ejercicio 5
-------------------------------------------------------------------------------
---a)
replicate' :: Int -> a -> [a]
replicate' n x
  | n <= 0 = []
  | otherwise = [x | _ <-[1..n]]

-------------------------------------------------------------------------------
-- Ejercicio 6
-------------------------------------------------------------------------------
---a)
divideA :: Integral a => a -> a -> Bool
divideA x y = x `mod` y == 0 || y `mod` x == 0


divisores :: Integral a => a -> [a]
divisores x = [y | y <- [1..x] , divideA x y]

negarLista :: Num a => [a] -> [a]
negarLista lista = map (\x -> -x) lista

divisores' :: Integral a => a -> [a]
divisores' x
  | x < 0 = [y | y <- [x.. abs x], y /= 0, divideA x y]
  |otherwise = [y | y <- [1..x] , divideA x y]

-------------------------------------------------------------------------------
-- Ejercicio 7
-------------------------------------------------------------------------------
mcd :: Integral a => a -> a -> a
mcd a b
  | a == 0 || b == 0 = 0 
  | otherwise = maximum (intersect (divisores' a) (divisores' b))
  where
    intersect [] _ = []
    intersect _ [] = []
    intersect (x:xs) ys
      | x `elem` ys = x : intersect xs ys
      | otherwise = intersect xs ys

-------------------------------------------------------------------------------
-- Ejercicio 8
-------------------------------------------------------------------------------
esPrimo :: Integral a => a -> Bool
esPrimo x
  | x <= 1    = False 
  | otherwise = not (any (\y -> x `mod` y == 0) [2..isqrt x])
  where
    isqrt = floor . sqrt . fromIntegral

primosHasta :: Integral a => a -> [a]
primosHasta x = [y | y <-[1..x], esPrimo y]

primosHasta' :: Integral a => a -> [a]
primosHasta' x = filter (esPrimo) [1..x]

-------------------------------------------------------------------------------
-- Ejercicio 10
-------------------------------------------------------------------------------
esPerfecto :: Integral a => a -> Bool
esPerfecto x = x == sum (init (divisores x))
-------------------------------------------------------------------------------
-- Ejercicio 11
-------------------------------------------------------------------------------
take' :: Int -> [a] -> [a]
take' n xs = [x | (p,x) <- zip[0..n] xs]

drop' :: Int ->  [a]->[a]
drop' n xs = [x | (p,x) <- zip[0..(length (xs))] xs, p >= n]

-------------------------------------------------------------------------------
-- Ejercicio 13
-------------------------------------------------------------------------------
desconocida :: (Ord a) => [a] -> Bool
desconocida xs = and [ x<=y | (x,y) <- zip xs (tail xs) ]
-- Qué hace?
--Primero coge dos listas el xs y un menos de xs para ir haciendo tuplas del primero con el segundo,
--el segundo con el tercero,... Luego esas tuplas se comparan y se ven si todas son ciertas y cumplen la condición.
--Con esto se comprueba si ese array está ordenado ascendentemente
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
  | x < y = x : (y:ys)
  | x > y = y : inserta' x ys

-- e)

ordena :: (Ord a) => [a] -> [a]
ordena xs = foldr (inserta) [] xs

-- f)  Utiliza para ello la función sorted definida en las transarencias

-------------------------------------------------------------------------------
-- Ejercicio 15
-------------------------------------------------------------------------------
--a)
geometrica :: Integral a => a -> a -> [a]
geometrica x y = (iterate (* y) x)
--c)
multiplosDe :: Integral a => a -> [a]
multiplosDe x = (iterate (+ x) 0)
--d)
potenciaDe :: Integral a => a -> [a]
potenciaDe x =  (iterate (* x) 1)
-------------------------------------------------------------------------------
-- Ejercicio 16
-------------------------------------------------------------------------------
--multiplosDe :: Integral a => a -> [a]
--multiplosDe x = (iterate (+ x) 0)

primeroComun ::  (Ord a) => [a] -> [a] -> Maybe a
primeroComun _ ys = Nothing
primeroComun xs _ = Nothing
primeroComun (x:xs) (y:ys)
  | x < y = primeroComun xs (y:ys)
  | x > y = primeroComun (x:xs) ys
  | otherwise = Just x

-------------------------------------------------------------------------------
-- Ejercicio 17
-------------------------------------------------------------------------------
--Lo mismo que el 16 pero con más cláusulas
-------------------------------------------------------------------------------
-- Ejercicio 18
-------------------------------------------------------------------------------

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