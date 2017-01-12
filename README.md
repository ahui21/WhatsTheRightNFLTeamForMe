What's the Right NFL Team For Me?
==================================

This is a tool meant to help new NFL fans figure out what the right NFL Team is
for them, based on their own weighted interests and factors. It was created by
a disillusioned San Diego Chargers fan,
[Alwin Hui (ahui21)](https://github.com/ahui21), who after the devastating
betrayal of Dean Spanos, decided to search for a new NFL team to support.

This was inspired by Blythe Terrell, from FiveThirtyEight, who did a similar
weighting system to determine her new NFL team. More information about her
project and data can be found at:
[http://fivethirtyeight.com/features/the-rams-are-dead-to-me-so-i-answered-3352-questions-to-find-a-new-team/](http://fivethirtyeight.com/features/the-rams-are-dead-to-me-so-i-answered-3352-questions-to-find-a-new-team/)


## Overview

### Project structure

- `README.md`
    This file.
- `code/`
    The code for the preference scraper and tracker.
- `data/`
    Data used for the weighting scheme. Taken from
    [https://github.com/fivethirtyeight/data/tree/master/nfl-favorite-team](https://github.com/fivethirtyeight/data/tree/master/nfl-favorite-team)


### How does this work?

The software consists of two major components:

- The client poses a series of questions, which will ask the user to choose
  between two factors. Based on which one the user chooses, it will then
  weight that chosen factor more heavily than the non-chosen factor. Over time,
  with more and more choices being used, it will be able to more accurately
  determine which factors are more valued by a user and which factors are
  less valued.
- The backend will calculate the weighting of factors for each individual user.
  Then, based on how each NFL team is scored for each factor, it will then
  output which NFL team most accurately correlates with the factors that the
  user values most.
- The data is an accumulation of the data based on outside sources. Data was
  sourced by Blythe Terrell at:
  [https://github.com/fivethirtyeight/data/tree/master/nfl-favorite-team](https://github.com/fivethirtyeight/data/tree/master/nfl-favorite-team)


## Client Details

TBA.


## Backend Details

TBA


## Data Details

All data was taken from Bylthe Terrell at FiveThirtyEight. It can be found at:
[https://github.com/fivethirtyeight/data/tree/master/nfl-favorite-team](https://github.com/fivethirtyeight/data/tree/master/nfl-favorite-team)
