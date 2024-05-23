-------------------------------------------------------------------------------
-- Estructuras de Datos. 2º Curso. ETSI Informática. UMA
--
-- (completa y sustituye los siguientes datos)
-- Titulación: Grado en Ingeniería …………………………………… [Informática | del Software | de Computadores].
-- Alumno: Camacho Marín, Sergio
-- Fecha de entrega:  DIA | MES | AÑO
--
-- Relación de Ejercicios 1. Ejercicios resueltos: ..........
--
-------------------------------------------------------------------------------
import Test.QuickCheck

-------------------------------------------------------------------------------
-- Ejercicio 1
-------------------------------------------------------------------------------



esTerna :: Integer -> Integer -> Integer -> Bool
esTerna x y z = ((x^2)+(y^2))== (z^2)

terna :: Integer -> Integer -> (Integer,Integer,Integer)
terna x y = (x^2 - y^2, 2 * x * y, x^2 + y^2 )

p_ternas x y = x>0 && y>0 && x>y ==> esTerna l1 l2 h
  where
    (l1,l2,h) = terna x y

-- *Main> quickCheck p_ternas
-- *** Gave up! Passed only 77 tests.



-------------------------------------------------------------------------------
-- Ejercicio 5
-------------------------------------------------------------------------------



entre :: Ord a => a -> (a, a) -> Bool
entre x (p,q) = (x>=p && x<=q)



-------------------------------------------------------------------------------
-- Ejercicio 7
-------------------------------------------------------------------------------

-- Para este ejercicio nos interesa utilizar la función predefinida en Prelude:
--              divMod :: Integral a => a -> a -> (a, a)
-- que calcula simultáneamente el cociente y el resto:
--
--   *Main> divMod 30 7
--   (4,2)

type TotalSegundos = Integer
type Horas         = Integer
type Minutos       = Integer
type Segundos      = Integer



descomponer :: TotalSegundos -> (Horas,Minutos,Segundos)
descomponer x = (horas, minutos, segundos)
   where
     horas = div x 3600
     minutos = div (mod x 3600) 60
     segundos = mod (mod x 3600) 60

p_descomponer x = x>=0 ==> h*3600 + m*60 + s == x
                           && m `entre` (0,59)
                           && s `entre` (0,59)
     where (h,m,s) = descomponer x
-- *Main> quickCheck p_descomponer
-- +++ OK, passed 100 tests.



-------------------------------------------------------------------------------
-- Ejercicio 10
-------------------------------------------------------------------------------


-- Usaremos el operador ~= visto en clase (Tema 1, transparencia 31)
infix 0 ~=
(~=) :: (Ord a, Fractional a) => a -> a -> Bool
x ~= y = abs (x-y) < epsilon
  where epsilon = 1e-5



-- Primera solución
-- no consideramos el estudio de las raices para a=0,
raíces :: (Ord a, Floating a) => a -> a -> a -> (a, a)
raíces a b c
  | dis < 0     = error "Raíces no reales"
  | otherwise   = (x1,x2)
 where  dis     = b^2 - 4*a*c
        x1 = ((-b + raiz)/2*a )
        x2 =((-b - raiz)/2*a )
        raiz = sqrt (b^2 - 4*a*c)



-------------------------------------------------------------------------------
-- Ejercicio 14
-------------------------------------------------------------------------------



-- potencia con base un número arbitrario
potencia :: (Num b, Integral n) => b -> n -> b
potencia b n | n == 0     = 1
             | n > 0      = b * potencia b (n-1)

{-
potencia' :: (Num b, Integral n) => b -> n -> b
potencia' b 0           = ...
potencia' b n | ...     = ...
                 ...

-- con esta propiedad (BASE un entero) no hay problemas
p_pot :: Integer -> Integer -> Property
p_pot b n  = n>=0 ==> (potencia b n == sol)-- && (potencia' b n == sol)
   where sol = b^n
-- *Main> quickCheck p_pot
-- +++ OK, passed 100 tests.

-}


{-

-- SEGUNDA OPCION: si consideramos una base arbitraria hay muchos problemas
p_pot' :: (Ord b, Fractional b, Integral n) => b -> n -> Property
p_pot' b n  = n>=0 ==> (potencia b n ~= sol) && (potencia' b n ~= sol)
   where sol = b^n
-- *Main> quickCheck p_pot'
-- *** Failed! Falsifiable (after 7 tests and 1 shrink):
-- 4.374147831506856
-- 4

-- Main> potencia 850.1 5 - 850.1^5
-- 6.25e-2

-- Debemos ~= por un concepto de error relativo

-}


-------------------------------------------------------------------------------
-- Ejercicio 17
-------------------------------------------------------------------------------



mediana :: Ord a => (a, a, a, a, a) -> a
mediana (x,y,z,t,u)
 | x > z 		= mediana (z,y,x,t,u)
 | y > z   	= mediana (x,z,y,t,u)
 | t < z    = mediana (x,y,t,z,u) 
 | u < z    = mediana (x,y,u,t,z)
 |otherwise = z


