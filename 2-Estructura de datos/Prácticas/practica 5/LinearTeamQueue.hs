-------------------------------------------------------------------------------
-- Linear implementation of Team Queues
-- Sergio Camacho Marín
-- Data Structures. Grado en Informática. UMA.
-------------------------------------------------------------------------------

module DataStructures.TeamQueue.LinearTeamQueue
  ( TQueue
-- interfaz basica
  , empty        -- 0.25
  , isEmpty      -- 0.25
  , first        -- 0.25
  , dequeue      -- 0.25
  , enqueue      -- 1.00
-- extras
  , mkTQ         -- 1.00 con plegado, 0.75 en otro caso
  , filterTQ     -- 1.00
  , foldrTQ      -- 1.00
  , firstTeam    -- 1.00 recursiva, 0.75 en otro caso
  , dequeueTeam  -- 1.00 recursiva, 0.75 en otro caso
  , getTeam      -- 1.00 recursiva, 0.75 en otro caso
  , toList       -- 1.00 con plegado, 0.75 en otro caso
  ) where

import Data.List(intercalate)



data TQueue = Empty | Node Integer TQueue
type Equipos = Integer

-- empty. Crea una cola de equipos vacia.
-- 0.25 
empty ::TQueue
empty = Empty

-- isEmpty. Comprueba si una cola de equipos esta vacía.
-- 0.25
isEmpty ::TQueue -> Bool
isEmpty Empty = True
isEmpty _ = False

-- first. Devuelve el primer elemento de una cola de equipos.
-- Si la cola está vacía lanza un error
-- 0.25
first :: TQueue -> Integer
first Empty = error "Cola vacia"
first (Node x q) = x

-- dequeue. Desencola el primer elemento de una cola de equipos.
-- Si la cola está vacía lanza un error.
-- 0.25
dequeue :: TQueue -> TQueue
dequeue Empty = error "Cola vacia"
dequeue (Node x q) = q

-- enqueue. Encola un elemento en una cola de n equipos, numerados del 0 a n-1
-- Si el elemento es el primero de su equipo, se añade la final de la cola.
-- En otro caso, se inserta después del primer elemento de su equipo.
-- 1.00
enqueue ::Integer -> Equipos -> TQueue -> TQueue
enqueue x n Empty = Node x Empty
enqueue x n (Node y q) 
  | (mod x n) == (mod y n) = Node y (Node x q)
  | otherwise = Node y (enqueue x n q)


-- mkTQ. Crea una cola de n equipos con los elementos de la lista.
-- 1.00 con plegado, 0.75 en otro caso
mkTQ :: Equipos -> [Integer] -> TQueue
mkTQ e xs = foldr (\x q -> enqueue x e q) empty (reverse xs)
--e [] = Empty
--mkTQ e x = aux e (reverse x)
 -- where 
    --aux e [] = empty
    --aux e (x:xs) = enqueue x e (aux e xs)

-- foldrTQ. Realiza un plegado por la derecha de la cola de equipos
-- usando la funcion y el caso base dados.
-- 1.00
foldrTQ :: (Integer -> b -> b) -> b -> TQueue -> b
foldrTQ f x Empty = x
foldrTQ f x (Node y q)= y `f` (foldrTQ f x q)

-- filterTQ. Crea una cola de equipos con los elementos de la cola 
-- de equipos dada que cumplen el predicado.
-- 1.00
filterTQ :: (Integer -> Bool) -> TQueue -> TQueue 
filterTQ  p Empty = Empty
filterTQ p (Node y q)
  | p y = Node y (filterTQ p q)
  | otherwise = (filterTQ p q)

-- firstTeam. Devuelve una lista con el primer equipo de la cola
-- 1.00 Implementación recursiva, 0.75 en otro caso
firstTeam ::Equipos -> TQueue -> [Integer]
firstTeam n Empty = []
firstTeam n (Node x q) 
  | (mod x n) == 0 = [x] ++ firstTeam n q
  | otherwise = [] ++ firstTeam n q 


-- dequeueTeam. Desencola el primer equipo de la cola de equipos
-- 1.00 Implementación recursiva, 0.75 en otro caso
dequeueTeam :: Equipos -> TQueue -> TQueue
dequeueTeam n Empty = Empty
dequeueTeam n e@(Node x q)
  | (mod x n == 0) = dequeueTeam n (dequeue q)
  | otherwise = e

-- getTeam. Devuelve una lista con los elementos de un equipo t que están en la cola de n equipos 
-- El primer argumento es el equipo que se busca (t) y el segundo el número de equipos de la cola (n)
-- 1.00 Implementación recursiva, 0.75 en otro caso
getTeam :: Equipos -> Equipos -> TQueue -> [Integer]
getTeam t e Empty = []
getTeam t e n@(Node x q)
  | mod x e == t = [x] ++ getTeam t e q
  | otherwise  = [] ++ getTeam t e q

-- toList. Devuelve una lista con todos los elementos de la cola de equipos
-- 1.00 con plegado. 0.75 en otro caso
toList :: TQueue -> [Integer]
toList q@(Node x p) =  foldrTQ (:) [] q

--quitar estos comentarios para probar

-- ===============
-- Ejemplos de uso
-- ===============

s1 = empty
--LinearTQueue()

s2 = isEmpty s1
-- True

s3 = enqueue 11 3 (enqueue 15 3 (enqueue 0 3 s1))
-- LinearTQueue(0,15,11)

s4 = dequeue s3
-- LinearTQueue(15,11)

s5 = mkTQ 3 [1..10]
-- LinearTQueue(1,10,7,4,2,8,5,3,9,6)

s6 = filterTQ even s5
-- LinearTQueue(10,4,2,8,6)

s7 = foldrTQ (+) 0 s6
-- 30

s8 = firstTeam 3 s6
-- [10,4]

s9 = dequeueTeam 3 s6
-- LinearTQueue(2,8,6)

s10 = getTeam 0 3 s6
-- [6]

s11 = toList s6
-- [10,4,2,8,6]












-- ===============================================
--   NO TOCAR ESTA PARTE
-- ===============================================

-- Showing a team TQueue
instance Show TQueue where
  show q = "LinearTQueue(" ++ intercalate "," (aux q) ++ ")"
    where
     aux Empty      =  []
     aux (Node x q) =  show x : aux q

-- Team Queue equality
instance Eq TQueue where
  Empty      == Empty           =  True
  (Node x q) == (Node x' q')    =  x==x' && q==q'
  _          == _               =  False

