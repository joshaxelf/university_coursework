{-
What should we do if we know a function might misbehabe?

    Partial Functions f :: X -> Y + 1
-}

func :: [a] -> (Either String a , Either String [a])
func [] = (Left "Error", Left "Erorr")
func xs = (Right (head xs), Right (tail xs))

toEither :: b -> Either a b 
toEither x = Right x

apply :: Either a b -> (b -> Either a c) -> Either a c 
apply (Left x) f = Left x
apply (Right x) f = f x

newIf :: Bool -> a -> (a -> b) -> (a -> c) -> Either b c 
newIf True x f g = Left (f x)
newIf False x f g = Right (g x)
