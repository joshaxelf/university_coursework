
{-
Zip Function allows us to combine two lists by pairing elements together position by position.Applicative
zip [1..3][3..5] = [(1,2)(2,4)(3,5)]

the higher order zipWith :: (a -> b -> c) -> [a] -> [b] -> [c] combines two lists by function application
-}


myZipWith :: (a -> b -> c) -> [a] -> [b] -> [c]
myZipWith f [] _  = []
myZipWith f _ []  = []
myZipWith f (a:as) (b:bs) = f a b : myZipWith f as bs

{-
ghci> :l definingHigherOrder.hs 
[1 of 2] Compiling Main             ( definingHigherOrder.hs, interpreted )
Ok, one module loaded.
ghci> myZipWith (\x y -> (x, y)) [1..5][1..100]
[(1,1),(2,2),(3,3),(4,4),(5,5)]

ghci> myZipWith (\x y -> (x)) [1..5][1..100]
[1,2,3,4,5]

ghci> myZipWith (\x y -> (mod x y)) [1..5][1..100]
[0,0,0,0,0]

ghci> myZipWith (\x y -> [x,y]) [1..5][1..100]
[[1,1],[2,2],[3,3],[4,4],[5,5]]
-}