import Test.QuickCheck-- Need this 

-- quickCheck :: Testable prop => prop -> IO ()

factorial :: Int -> Int
factorial n | n < 1 = 1
            | otherwise = n * factorial (n - 1)

myRev :: [a] -> [a]
myRev [] = []
myRev (x:xs) = myRev xs ++ [x]

prop_factorial n = factorial n == product [1..n]

prop_rev xs = myRev (myRev xs) == xs