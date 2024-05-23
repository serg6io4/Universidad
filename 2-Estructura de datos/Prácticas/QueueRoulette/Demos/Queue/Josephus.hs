import DataStructures.Queue.LinearQueue

-- n personas
-- m salto

createQueue :: Int -> Queue Int
createQueue n = foldl (flip enqueue) empty [1..n] -- foldr enqueue empty [n,n-1..1]

skip:: Int -> Queue a -> Queue a
skip 0 q = q
skip m q = skip (m - 1) (enqueue x q')
    where
        x = first q
        q' = dequeue q

josephus :: Int -> Int -> [Int]
josephus n m = josephus' n m (createQueue n)

josephus' n m q
    | isEmpty q = []
    | otherwise = x:josephus' n m q''
        where
            q' = skip m q
            x = first q'
            q'' = dequeue q'