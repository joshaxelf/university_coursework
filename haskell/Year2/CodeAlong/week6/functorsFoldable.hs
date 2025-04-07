data List a = Empty | Cons a (List a) -- Shape of Cons x1 Cons x2 
    deriving Show

instance Functor List where 
    fmap f Empty = Empty
    fmap f (Cons x xs) = Cons (f x) (fmap f xs)

instance Foldable List where
    foldr f acc Empty = acc
    foldr f acc (Cons x xs) = f x (foldr f acc xs)


data BTree a = Leaf | Node (BTree a) a (BTree a)
    deriving Show

instance Functor BTree where
    fmap f Leaf = Leaf
    fmap f (Node lt x rt) = Node (fmap f lt) (f x) (fmap f rt)

instance Foldable BTree where 
    foldr f acc Leaf = acc
    foldr f acc (Node lt x rt) = foldr f (f x (foldr f acc lt)) rt