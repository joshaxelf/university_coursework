{-
Given the following functions which aims to remove any occurrence of two 
characters, x and y, why will this function not work correctly? 
-}

rem2::Char -> Char -> String -> String
rem2 x y [] = []
rem2 x y (z:zs) | x == z = rem2 x y zs
                | y == z = rem2 x y zs
                | otherwise = x : (rem2 x y zs)

-- X in otherwise needs to be changed to Z

{-
Consider the following generator. 
What would it's output be when x is called in GHCI? 
-}

x :: [(Integer, Integer)]
x = [(x,y) | x <- [1..3], y <- [x..3]]

-- (1,1),(1,2)(1,3)(2,2)(2,3)(3,3)

{-
Consider the following function which checks three characters 
at a time to see if they are the same. 

This function will cause a runtime error on certain input, why is this?
-}

check3::String -> Bool
check3 [] = False
check3 (x:y:z:zs) | x == y && y == z = True
                  | otherwise = check3 zs
