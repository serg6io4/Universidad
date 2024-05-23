import DataStructures.Stack.LinearStack

s1 :: Stack Int
s1 = push 3 (push 2 (push 1 empty))

size :: Stack a -> Int
size s
  | isEmpty s =  0
  | otherwise =  1 + size (pop s)

Node 1 (Node 2 (Node 3 Empty))
Node 1 q 
enqueue 4 (Node 1 (Node 2 (Node 3 Empty)))
Node 1 (enqueue 4 (Node 2 (Node 3 Empty)))
Node 1 (Node 2 (enqueue 4 (Node 3 Empty)))
Node 1 (Node 2 (Node 3 (enqueue 4 Empty)))
Node 1 (Node 2 (Node 3 (Node 4 Empty)))