{-
What should we do if we know a function might misbehave?

    Partiral functions f::x -> Y + 1
-}

func :: [a] -> (Maybe a, Maybe [a])
func [] = (Nothing, Nothing)
func xs = (Just (head xs), Just (tail xs))

toMaybe :: a -> Maybe a
toMaybe x = Just x

apply :: Maybe a -> (a -> Maybe b) -> Maybe b
apply Nothing f = Nothing
apply (Just x) f = f x 
