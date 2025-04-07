{-
A Binary Tree is either a Leaf containing no value or a Node containing a value and two subtrees
e.g. Node (Node Leaf 5 Leaf) 5 (Node (Node Leaf 6 Leaf) 7 Leaf
-}

-- 1)   Define the type Btree

data Btree a = Leaf | Node (Btree a) a (Btree a)
    deriving Show


-- 2)   Define sumTree for a numerical tree

sumTree :: Num a => Btree a -> a
sumTree Leaf = 0
sumTree (Node lt x rt) = x + sumTree lt + sumTree rt

-- 3)   Define insertTree which inserts a value into a tree. 
--      Assume Smaller values should be stored on the left, larger on the right

insertTree :: Ord a => a -> Btree a -> Btree a
insertTree x Leaf = Node Leaf x Leaf
insertTree x (Node lt y rt) | x <= y = Node (insertTree x lt) y rt
                            | x > y = Node lt y (insertTree x rt) -- could be otherwise instead of (x > y)