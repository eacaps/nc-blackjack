# nc-blackjack

This is an implementation of a simple version of blackjack in java.

## Running
Running this sample requires git, a recent version of java and gradle.

    $ git clone git@github.com:eacaps/nc-blackjack.git
    $ cd nc-blackjack
    $ ./run.sh
    
The game will proceed in rounds.
During each round you can [h]it or [s]tand until you bust or stand.
Your hand will be compared against the house and the results will be printed.
Once a round ends you have the option to play again: [y]es or [n]o.

## Sample output

    eacaps$ java -version
    java version "1.8.0_144"
    Java(TM) SE Runtime Environment (build 1.8.0_144-b01)
    Java HotSpot(TM) 64-Bit Server VM (build 25.144-b01, mixed mode)
    eacaps$ ./gradlew -version
    
    ------------------------------------------------------------
    Gradle 3.5-rc-2
    ------------------------------------------------------------
    
    Build time:   2017-03-27 15:56:23 UTC
    Revision:     ec63970cd167993d3dcda346a1d00a286a23b1c9
    
    Groovy:       2.4.10
    Ant:          Apache Ant(TM) version 1.9.6 compiled on June 29 2015
    JVM:          1.8.0_144 (Oracle Corporation 25.144-b01)
    OS:           Mac OS X 10.11.6 x86_64
    
    eacaps$ ./run.sh
    :compileJava UP-TO-DATE
    :processResources NO-SOURCE
    :classes UP-TO-DATE
    :jar UP-TO-DATE
    
    BUILD SUCCESSFUL
    
    Total time: 1.984 secs
    welcome to nc-blackjack
    you  have: [[TC], [AS]]
    house has: [[7H], [??]]
    you have blackjack
    play again: [y]es or [n]o?
    y
    you  have: [[5C], [7D]]
    house has: [[3C], [??]]
    what do you want to do: [h]it or [s]tand?
    h
    you  have: [[5C], [7D], [4H]]
    your  result: 16
    what do you want to do: [h]it or [s]tand?
    s
    house has: [[3C], [7S]]
    house has: [[3C], [7S], [AD]]
    house result: 21
    you  have: [[5C], [7D], [4H]]
    your  result: 16
    the house wins.
    play again: [y]es or [n]o?
    n
    your score was: 0
    good bye.
    
## Testing
I wrote some significant JUnit tests to ensure handling the scoring and display was correct.
You can run the tests with:

    $ ./gradlew test
    
The testing is fine, but more thorough testing would likely use method spies in some place but I didn't want to complicate the project further.

## Questions
I wasn't sure if I should code the dealer hitting on a soft 17 or not, so I left it out for now.
I also wasn't sure if 'the deck should be shuffled before each game' meant I was supposed to shuffle in between each round or not.