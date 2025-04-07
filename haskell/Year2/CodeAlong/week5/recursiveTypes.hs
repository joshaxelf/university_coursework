
{-
Natural numbers, either zero or a successor of a natural number
-}

data Nat = Zero | Succ Nat 
    deriving Show

toInt :: Nat -> Int
toInt Zero = 0
toInt (Succ x) = 1 + toInt x

add :: Nat -> Nat -> Nat
add x Zero = x
add x (Succ y) = Succ(add x y)

mult :: Nat -> Nat -> Nat
mult x Zero = Zero
mult x (Succ y) = add(mult x y) x