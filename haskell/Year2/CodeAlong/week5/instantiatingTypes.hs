data Suit = Diamonds | Clubs | Hearts | Spades


instance Eq Suit where 
    Diamonds == Diamonds = True
    Clubs == Clubs = True
    Hearts == Hearts = True
    Spades == Spades = True
    _ == _ = False

instance Show Suit where
    show Diamonds = "Diamonds"
    show Clubs = "Clubs"
    show Hearts = "Hearts"
    show Spades = "Spades"


-- This can be cheated with by using deriving (Eq, Show) and thats it