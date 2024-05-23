module DataStructures.Stack.LinearStack (
                            Stack,
                            empty,
                            isEmpty,
                            push,
                            pop,
                            top,
                            size
) where

import Data.List(intercalate)
import Test.QuickCheck

data Stack a = Empty | Node a (Stack a) deriving Eq

empty:: Stack a
empty = Empty

isEmpty :: Stack a -> Bool
isEmpty Empty = True
isEmpty _ = False

push :: a -> Stack a -> Stack a
push x s = Node x s

top:: Stack a -> a
top Empty = error "Empty Stack"
top (Node x s) = x

pop:: Stack a -> Stack a
pop Empty = error "Empty Stack"
pop (Node x s) = s

size Empty = 0
size (Node x s) = 1 + size s

instance (Show a) => Show (Stack a) where
  show s ="LinearStack(" ++ intercalate "," (stackToList s) ++ ")"
    
stackToList :: (Show a) => Stack a -> [String]
stackToList Empty      =  []
stackToList (Node x s) =  show x : stackToList s

instance (Arbitrary a) => Arbitrary (Stack a) where
    arbitrary =  do
      xs <- listOf arbitrary
      return (foldr push empty xs)