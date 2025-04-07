{-
Lists are of the shape x1:x2:x3:...xn:[] Common recursion scheme 
to replace (:) witha  function and [] with a value
-}

lengthList :: [a] -> Int
lengthList [] = 0
lengthList (x:xs) = 1 + lengthList xs

{-
ghci> foldr (\x acc -> acc + 1) 0 [1..5]
5
-}

productList :: Num a => [a] -> a
productList [] = 1
productList (x:xs) = x * productList xs

{-
ghci> foldr (*) 1 [1..5]
120
-}

sumList :: Num a => [a] -> a
sumList [] = 0
sumList (x:xs) = x + sumList xs

{-
Foldr does this for us

foldr (ss) acc xs = x1 'ss' x2 'ss' x3 .. xn 'ss' acc
-}