{-}
Haskell is a lazy language. In general this means Haskell will only 
evaluate things when it has to, this allows us to work with infinite lists
-}

first x y = x

list2n n = take n [1..]

test x y = (x < y) && (foldr (&&) True (repeat True))