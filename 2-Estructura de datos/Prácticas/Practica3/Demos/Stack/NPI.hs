import DataStructures.Stack.LinearStack

-- 3*(12-(2*4-1))
-- 3 12 2 4 * 1 - - *

ex :: Num a => [Either a (a->a->a)]
ex = [Left 3, Left 12, Left 2, Left 4, Right (*), Left 1, Right (-), Right (-), Right (*)] 

evalua :: Num a => [Either a (a->a->a)] -> a
evalua xs = evalua' xs empty
    where
        evalua' [] st = top st
        evalua' (Left n:xs) st = evalua' xs (push n st)
        evalua' (Right op:xs) st = evalua' xs (push (op a1 a2) st'')
            where
                a2 = top st
                st' = pop st
                a1 = top st'
                st'' = pop st' 