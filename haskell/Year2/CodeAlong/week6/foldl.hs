
{-
Similar to Foldr but associates the other way around
-}

lengthList :: Num t => [a] -> t
lengthList xs = helperLength 0 xs

helperLength :: Num t => t -> [a] -> t
helperLength n [] = n
helperLength n (x:xs) = helperLength (n + 1) xs

productList :: Num t => [t] -> t
productList xs = productHelper 1 xs

productHelper :: Num t => t -> [t] -> t
productHelper n [] = n
productHelper n (x:xs) = productHelper (n * x) xs

sumList :: Num t => [t] -> t
sumList xs = sumHelp 0 xs

sumHelp :: Num t => t -> [t] -> t
sumHelp n [] = n
sumHelp n (x:xs) = sumHelp (n + x) xs
