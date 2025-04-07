data Dir = U | D | L | R

go :: Dir -> (Int, Int) -> (Int, Int)
go U (x, y) = (x, y + 1)
go D (x, y) = (x, y - 1)
go L (x, y) = (x - 1, y)
go R (x, y) = (x + 1, y)

-- Defining what our function does, Direction with UP - Down - Left - Right

try = foldr go (0,0) [R,R,D,D,R,D,D,R,D,D,R,D,D]