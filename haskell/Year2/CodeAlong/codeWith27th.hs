
main :: IO ()
main = putStrLn "Hello World"

data Expression a = Constant a
                | Plus (Expression a) (Expression a)
                | Times (Expression a) (Expression a)

evaluate :: Expression Int -> Int
evaluate (Constant x) = x
evaluate (Plus e1 e2) = evaluate e1 + evaluate e2
evaluate (Times e1 e2) = evaluate e1 * evaluate e2

data MyException = DivByZero | Imaginary
    deriving Show

reciprocal :: Double -> Either MyException Double
reciprocal x | x == 0.0 = Left DivByZero
             | otherwise = Right (1/x)

mySqrt :: Double -> Either MyException Double
mySqrt x | x < 0 = Left Imaginary
         | otherwise = Right (sqrt x)

sqrtReciprocal :: Double -> Either MyException Double
sqrtReciprocal x = do recipx <- reciprocal x
                      mySqrt recipx

sqrtReciprocal' x = reciprocal x >>= mySqrt

-- foo x = do  y <- bar x
--             z <- quux y 
--             return z

-- foo x = bar x
--         >>= (\y -> quux y)
--         >>= (\z -> return z)


data MyMaybe a = Null1 | My a 

myFoldr f base Null1 = base
myFoldr f base (My x) = f x base

data NullList a = Cons a (NullList a) | Null (NullList a) | End

newFold f base End = base
newFold f base (Null xs) = newFold f base xs
newFold f base (Cons a xs) = f a (newFold f base xs)

lefty f base End = base 
lefty f base (Null xs) = lefty f base xs
lefty f base (Cons a xs) = lefty f (f base a) xs


