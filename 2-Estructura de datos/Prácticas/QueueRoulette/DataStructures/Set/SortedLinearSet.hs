module DataStructures.Set.SortedLinearSet(
    Set,
    empty,
    isEmpty,
    insert,
    delete,
    isElem,
    size, 
    foldSet,
    isSubSetOf,
    intersection
--    union,
--    difference
) where

data Set a = Empty | Node a (Set a) deriving (Eq, Show)

empty :: Set a
empty = Empty

isEmpty :: Set a -> Bool
isEmpty Empty = True
isEmpty _ = False

insert :: Ord a => a -> Set a -> Set a
insert x Empty = Node x Empty
insert x t@(Node y s) 
    | x < y = Node x t
    | x == y = t
    | otherwise = Node y (insert x s)

isElem :: Ord a => a -> Set a -> Bool
isElem x Empty = False
isElem x (Node y s)
    | x < y = False
    | otherwise = x == y || isElem x s

delete :: Ord a => a -> Set a -> Set a
delete x Empty = Empty
delete x (Node y s)
    | x < y = Node y s
    | x == y = s
    | otherwise = Node y (delete x s)

size :: Set a -> Int
size Empty = 0
size (Node _ s) = 1 + size s

listToSet :: Ord a => [a] -> Set a
listToSet = foldr insert empty

foldSet :: (a -> b -> b) -> b -> Set a -> b
foldSet f z Empty = z
foldSet f z (Node x s) = f x (foldSet f z s)

isSubSetOf :: Ord a => Set a -> Set a -> Bool
isSubSetOf Empty _ = True
isSubSetOf (Node x s) ys =  isElem x ys && isSubSetOf s ys

intersection:: Ord a => Set a -> Set a -> Set a
{-
intersection Empty _ = Empty
intersection (Node x s) ys
    | isElem x ys = Node x (intersection s ys)
    | otherwise   = intersection s ys
-}

intersection xs ys = foldSet f empty xs
    where 
        f e s 
            | isElem e ys = Node e s
            | otherwise = s