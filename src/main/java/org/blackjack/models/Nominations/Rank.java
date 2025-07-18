package org.blackjack.models.Nominations;

import lombok.Getter;

@Getter
public enum Rank {
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    seven(7),
    eight(8),
    nine(9),
    ten(10),
    jack(10),
    queen(10),
    king(10),
    ace(11);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getRank() {
        return value;
    }
}
