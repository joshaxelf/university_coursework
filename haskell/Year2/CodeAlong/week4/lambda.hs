{-
Lambdas are anonymous functions, ones which dont need to be named to be used.

In the form \variable -> *function definition*
-}

a = [1..10]

b = [(x,y) | x <- a, y <- a]


{-
to get sqrt of our numbers we could do  
map (\x -> x*x) a

to get divisble bt 2 we could do 
map (\x -> mod x 2 == 0) a

-}

f x y = x * y 
f' y = \x -> y * x
f'' = \x y -> y * x

-- these are all the same