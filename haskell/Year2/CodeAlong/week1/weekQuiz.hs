myFunction :: Int -> Int
myFunction x | x < 0 = 1
             | otherwise = x * myFunction (x - 3)

{-
10 -> 1
10 * myFunction (10 -3) 
10 * myFunction 7 -> 2
10 * (7 * myFunction (7 - 3)) 
10 * (7 * myFunction 4) -> 3
10 * (7 * 4 * myFunction (4 - 3)) 
10 * (7 * 4 * myFunction 1) -> 4
10 * (7 * 4 * 1 * myFunction (1 - 3)) 
10 * (7 * 4 * 1 * myFunction (-2) <- Stops here) -> 5

Calls 5 times

-}