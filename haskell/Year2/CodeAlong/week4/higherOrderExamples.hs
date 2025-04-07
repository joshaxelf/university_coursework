
-- 1) Define repeatApply which applies a function to a given input a given number of times

repeatApply :: Int -> a -> (a -> a )-> a
repeatApply 0 x f = x
repeatApply n x f = repeatApply (n - 1) (f x) f

-- 2) Define compose which takes two functions and evaluates their composition

compose :: a -> (a -> b) -> (b -> c) -> c
compose x f g = g (f x)

-- 3) Define higherMap which uses compose to apply two transformations to a list

higherMap :: (a -> b) -> (b -> c) -> [a] -> [c]
higherMap f g [] = []
higherMap f g (x:xs) = (compose x f g):(higherMap f g xs)