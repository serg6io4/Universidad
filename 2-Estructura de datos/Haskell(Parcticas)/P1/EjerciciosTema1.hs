-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º Curso. ETSI Informática. UMA
--
-- (completa y sustituye los siguientes datos)
-- Titulación: Grado en Ingeniería Informática
-- Alumno: Camacho Marín, Sergio
-- Fecha de entrega: 16/09/2023
--
-- Relación de Ejercicios 1. Ejercicios resueltos: ..........
--
-------------------------------------------------------------------------------
import Test.QuickCheck


--1
--a)
esTerna :: Integer -> Integer -> Integer -> Bool
esTerna x y z = x^2 + y^2 == z^2
--b)
terna :: Integer -> Integer -> (Integer, Integer, Integer)
terna x y = (x^2-y^2, 2*x*y,x^2+y^2)
--c)
p_ternas x y = x>0 && y>0 && x>y ==> esTerna l1 l2 h
    where
        (l1,l2,h) = terna x y
--d)
--Main> quickCheck p_ternas

------------------------------------------------------------
--2
intercambia :: (a,b) -> (b,a)
intercambia (x,y) = (y,x)

-----------------------------------------------------------
--3
--a)
ordena2 :: Ord a => (a,a) -> (a,a)
ordena2 (x, y)
    | x > y = (y, x)
    | otherwise = (x, y)

p1_ordena2 x y = enOrden (ordena2 (x,y))
    where 
        enOrden (x,y) = x<=y

p2_ordena2 x y = mismosElementos (x,y) (ordena2 (x,y))
    where 
        mismosElementos (x,y) (z,v) = (x==z && y==v) || (x==v && y==z)
--b)
ordena3 :: Ord a => (a,a,a) -> (a,a,a)
ordena3 (x, y, z)
    | x > y = ordena3 (y, x, z)
    | y > z = ordena3 (x, z, y)
    | x > z = ordena3 (z, y, x)
    | otherwise = (x, y, z)
----------------------------------------------------------------------

--4
--a)
max2 :: Ord a => a -> a -> a 
max2 x y
    | x > y = x
    | y > x = y
----------------------------------------------------------------------

--5
entre :: Ord a => a -> (a,a) -> Bool
entre x (y,z) =  (x >= y) && (x <= z)
----------------------------------------------------------------------

--6
iguales3 :: Eq a => (a,a,a) -> Bool
iguales3 (x, y, z) = (x==y) && (x==z)
----------------------------------------------------------------------

--7

----------------------------------------------------------------------

--8
unEuro :: Double
unEuro = 166.386
---a
pesetasAEuros :: Double -> Double
pesetasAEuros x = x/unEuro
--b
eurosAPesetas :: Double -> Double
eurosAPesetas x = x*unEuro
--------------------------------------------------------------------

--10
raices :: Double -> Double -> Double -> (Double, Double)
raices a b c
    | (b^2 - 4*a*c)<0 = error "Raíces No reales"
    | otherwise = (x, y)
        where x = (-b + sqrt (b^2 - 4*a*c))/ (2*a)
              y = (-b - sqrt (b^2 - 4*a*c))/ (2*a)
--------------------------------------------------------------------
--11
esMúltiplo :: Integer -> Integer -> Bool
esMúltiplo x y = (x `mod` y) == 0

--------------------------------------------------------------------
--12
--------------------------------------------------------------------

--13
esBisiesto :: Integer -> Bool
esBisiesto x
    | (esMúltiplo x 4) && (x `mod` 100 /=0) = True
    | (esMúltiplo x 400) = True
    | otherwise = False
--------------------------------------------------------------------

--14

potencia :: Integer -> Integer -> Integer
potencia x y 
    | y == 1 = x
    | otherwise = x * potencia (x) (y-1)

potencia' :: Integer -> Integer -> Integer
potencia' x n 
    | (mod n 2 == 0) = potencia (potencia x (div n 2)) 2
    | otherwise = x * (potencia (potencia x (div (n-1) 2)) 2)

--------------------------------------------------------------------
--15
factorial :: Integer -> Integer
factorial 0 = 1
factorial n = n * factorial (n - 1)

-------------------------------------------------------------------
--16
divideA :: Integer -> Integer -> Bool
divideA x y = (mod y x == 0)

-------------------------------------------------------------------
--17

mediana :: Ord a => (a, a, a, a, a) -> a
mediana (x, y, z, t, u)
    | x > y = mediana (y, x, z, t, u)
    | y > z = mediana (x, z, y, t, u)
    | z > t = mediana (x, y, t, z, u)
    | t > u = mediana (x, y, z, u, t)
    | otherwise = z
