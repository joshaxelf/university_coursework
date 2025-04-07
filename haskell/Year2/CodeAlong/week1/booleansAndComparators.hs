{-
Only seen integer types. We can see more like Boolean and Floats etc
We can make our own types in haskell
We also have operators you would expect
&& = AND
|| = OR
not = NOT

also mathematical operators >,<,=> etc

-}

mux :: Bool -> Bool -> Bool -> Bool
mux x y z = (not x && y) || (x && z) 
-- If X is 0, AND Y is 1 OR X is 1 and Z is 1

{- 
If we input mux False True False, this sets 
x = 0
y = 1
z = 0

then the first condition is satisfied and we should get
True as the 4th Boolean output

If we input mux False False False, this sets 
x = 0
y = 0
z = 0

then no condition is satisfied and we should get
False as the 4th Boolean output
-}

moreThan5 :: Int -> Bool -- (>) returns Boolean so super easy outpur
moreThan5 x = x > 5  

divisibleBy5 :: Int -> Bool
divisibleBy5 x = mod x 5 == 0 -- If the remainder is 0 when divided by 5 return Bool