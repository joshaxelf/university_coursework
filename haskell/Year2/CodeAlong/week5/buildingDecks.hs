
data Suit = Diamonds | Clubs | Hearts | Spades
    deriving (Eq, Show, Ord, Enum)

data Rank = Two | Three | Four | Five | Six | Seven | Eight | Nine | Ten | Jack | Queen | King | Ace
    deriving (Eq, Show, Ord, Enum)

data Card = Card Rank Suit
    deriving (Eq, Ord, Show)

type Deck = [Card]

makeDeck :: Deck
makeDeck = [Card x y | x <- [Two ..Ace], y <- [Diamonds ..Spades]]
