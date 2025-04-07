import Test.QuickCheck

instance Show (a -> b) where -- in case we need a show instance for functions
    show a = "function"

-- consider the following

myFun1 :: Char -> String -> String
myFun1 c [] = []
myFun1 c (x:xs) | x == c = myFun1 c xs
                | otherwise = x:myFun1 c xs

-- Above function removes character from string

prop_1 c xs = filter (/=c) xs == myFun1 c xs 
prop_2 c xs = not (c `elem` xs) ==> myFun1 c xs == xs

myFun2 :: [(a -> b)] -> a -> [b]
myFun2 [] x = []
myFun2 (f:fs) x = (f x):myFun2 fs x

-- Above function 

prop_3 fs x = length fs > 1 ==> head (myFun2 fs x) == (head fs) x
prop_4 fs x = map ($ x) fs == myFun2 fs x