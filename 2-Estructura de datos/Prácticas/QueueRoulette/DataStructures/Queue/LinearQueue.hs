module DataStructures.Queue.LinearQueue (
    Queue,
    empty,
    isEmpty,
    enqueue,
    dequeue,
    first
    ) where

import Test.QuickCheck
import Data.List(intercalate)

data Queue a = Empty | Node a (Queue a) deriving Eq

empty:: Queue a
empty = Empty

isEmpty:: Queue a -> Bool
isEmpty Empty = True
isEmpty _ = False

first :: Queue a -> a
first Empty = error "Empty Queue"
first (Node x c) = x

enqueue:: a -> Queue a -> Queue a
enqueue x Empty = Node x Empty
enqueue x (Node y c) = Node y (enqueue x c)

dequeue :: Queue a -> Queue a
dequeue Empty = error "Empty Queue"
dequeue (Node _ c) = c

-- Showing a queue
instance (Show a) => Show (Queue a) where
  show q = "LinearQueue(" ++ intercalate "," (aux q) ++ ")"
    where
    aux Empty      =  []
    aux (Node x q) =  show x : aux q

-- This instance is used by QuickCheck to generate random queues
instance (Arbitrary a) => Arbitrary (Queue a) where
    arbitrary = do
      xs <- listOf arbitrary
      return (foldr enqueue empty xs)